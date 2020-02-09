/*---------------------------------------------------------------------------------------
 * Object Name: TDMGovernenceController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.util.DownloadUtils;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class TDMGovernenceController
{
	private static Logger logger = Logger.getLogger(EmailController.class);

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_GOV_INDEX)
	public String indexGovnce() {
		logger.info(MessageConstant.TDM_BLUE_BOOK_CTLR + MessageConstant.TDM_BLUE_BOOK_INDEX_GOVN
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_GOV_INDEX_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_GOV_BLUE_BOOK)
	public String blurbookpage() {
		logger.info(MessageConstant.TDM_BLUE_BOOK_CTLR + MessageConstant.TDM_BLUE_BOOK_PAGE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_GOV_BLUE_BOOK_VIEW;
	}

	/**
	 * Path of the file to be downloaded, relative to application's directory
	 */
	private String filePath = AppConstant.FILE_PATH_TDM_BLUE_BOOK;

	/**
	 * 
	 * Method for handling file download request from client
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = AppConstant.TDM_GOV_BLUE_BOOK_DOWNLOAD, method = RequestMethod.GET)
	public void doDownloadBlueBook(HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			logger.info(MessageConstant.TDM_BLUE_BOOK_CTLR + MessageConstant.TDM_BLUE_BOOK_DOWNLOAD
					+ MessageConstant.LOG_INFO_PARAMS_NO);
			DownloadUtils.download(request, response, filePath);
			logger.info(MessageConstant.TDM_BLUE_BOOK_CTLR + MessageConstant.TDM_BLUE_BOOK_DOWNLOAD
					+ MessageConstant.LOG_INFO_RETURN);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_BLUE_BOOK_CTLR
					+ MessageConstant.TDM_BLUE_BOOK_DOWNLOAD + MessageConstant.LOG_ERROR_EXCEPTION
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
		}
	}
}
