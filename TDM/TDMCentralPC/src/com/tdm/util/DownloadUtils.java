/*---------------------------------------------------------------------------------------
 * Object Name: DownloadUtils.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name               		 Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          17/06/15   NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.ServiceException;

public class DownloadUtils
{
	private static Logger logger = Logger.getLogger(DownloadUtils.class);
	/**
	 * Size of a byte buffer to read/write file
	 */
	private static final int BUFFER_SIZE = 4096;

	public static void download(HttpServletRequest request, HttpServletResponse response,
			String filePath) throws ServiceException {

		logger.info(MessageConstant.TDM_DOWNLOAD_UTIL + MessageConstant.DOWNLOAD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			// get absolute path of the application
			ServletContext context = request.getServletContext();
			String appPath = context.getRealPath("");

			// construct the complete absolute path of the file
			String fullPath = appPath + filePath;
			File downloadFile = new File(fullPath);
			FileInputStream inputStream = new FileInputStream(downloadFile);
			// get MIME type of the file
			String mimeType = context.getMimeType(fullPath);
			if (mimeType == null) {
				// set to binary type if MIME mapping not found
				mimeType = AppConstant.APP_STREAM;
			}
			logger.info(MessageConstant.TDM_DOWNLOAD_UTIL + MessageConstant.DOWNLOAD
					+ MessageConstant.MIME_TYPE + mimeType);
			// set content attributes for the response
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());
			// set headers for the response
			String headerKey = AppConstant.HEADER_DISP;
			String headerValue = String.format(AppConstant.ATTACHMENT, downloadFile.getName());
			response.setHeader(headerKey, headerValue);
			// get output stream of the response
			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			// write bytes read from the input stream into the output stream
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			logger.info(MessageConstant.TDM_DOWNLOAD_UTIL + MessageConstant.DOWNLOAD
					+ MessageConstant.LOG_INFO_RETURN);
			inputStream.close();
			outStream.close();
		} catch (IOException ie) {
			logger.error(MessageConstant.TDM_DOWNLOAD_UTIL + MessageConstant.DOWNLOAD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.IE_EXCEPTION, ie);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_DOWNLOAD_UTIL + MessageConstant.DOWNLOAD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_DOWNLOAD_UTIL + MessageConstant.DOWNLOAD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
