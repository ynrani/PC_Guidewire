/*---------------------------------------------------------------------------------------
 * Object Name: TDMEstiToolController.Java
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.service.TDMProviserSearchService;
import com.tdm.util.DownloadUtils;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class TDMEstiToolController
{
	private static Logger logger = Logger.getLogger(TDMEstiToolController.class);

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_EST_TOOL_GET)
	public String indexGovnce() {

		logger.info(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_GOV_INDEX
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_EST_TOOL_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDP_EST_TOOL_GET)
	public String estiToolPage() {

		logger.info(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_GOV_EST_TOOL_PAGE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDP_EST_TOOL_VIEW;
	}

	/**
	 * Path of the file to be downloaded, relative to application's directory
	 */
	private String filePath1 = AppConstant.FILE_PATH_TDP_EST;
	private String filePath2 = AppConstant.FILE_PATH_TDM_EST;

	/**
	 * 
	 * Method for handling file download request from client
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = AppConstant.TDP_DOWNLOAD_EST_TOOL, method = RequestMethod.GET)
	public void doDownloadTdp(HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			logger.info(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_DONLOAD_TDP
					+ MessageConstant.LOG_INFO_PARAMS_NO);
			DownloadUtils.download(request, response, filePath1);
			logger.info(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_DONLOAD_TDP
					+ MessageConstant.LOG_INFO_RETURN);

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_DONLOAD_TDP
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
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

	/**
	 * 
	 * Method for handling file download request from client
	 * 
	 * @param request
	 * @param response
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.TDM_DOWNLOAD_EST_TOOL, method = RequestMethod.GET)
	public void doDownloadTdm(HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			logger.info(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_DONLOAD_TDM
					+ MessageConstant.LOG_INFO_PARAMS_NO);
			DownloadUtils.download(request, response, filePath2);
			logger.info(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_DONLOAD_TDM
					+ MessageConstant.LOG_INFO_RETURN);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_EXT_TOOL_CTLR + MessageConstant.TDM_DONLOAD_TDM
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
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
