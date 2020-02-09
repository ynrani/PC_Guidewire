/*---------------------------------------------------------------------------------------
 * Object Name: LoginController.Java
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

package com.datacon.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;
import com.datacon.exception.BaseException;
import com.datacon.model.DTO.ForgotPassword;
import com.datacon.util.DownloadUtils;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class LoginController
{

	private static Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * Size of a byte buffer to read/write file
	 */

	/**
	 * Path of the file to be downloaded, relative to application's directory
	 */
	private String filePath = AppConstant.FILE_PATH_USER_MANUAL;

	/**
	 * 
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_LOGIN, method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = AppConstant.ERROR, required = false) String error,
			@RequestParam(value = AppConstant.LOGOUT, required = false) String logout) {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_GET
				+ MessageConstant.LOG_INFO_PARAMS_YES + error);
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject(AppConstant.ERROR, AppConstant.INVALID_UNAME_PASS);
		}
		if (logout != null) {
			model.addObject(AppConstant.MSG, AppConstant.LOGOUT_SUCCESS);
		}
		model.addObject(AppConstant.MSG, AppConstant.SESSION_EXPIRED);
		model.setViewName(AppConstant.TDM_LOGIN_VIEW);
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_GET
				+ MessageConstant.LOG_INFO_RETURN);
		return model;
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_LOGIN_TESDALOGIN)
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_LOGIN_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_ADMIN)
	public String admin() {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_ADMIN
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_ADMIN_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_CMD_CENTER)
	public String indexCmdCtr() {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_INDEX_CMD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_CMD_CENTER_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_403)
	public String accessDenied() {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_ACCESS_DENIED
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_LOGIN_REDIRECT;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_LOGIN_SESSIONEXP)
	public String sessionExp() {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_SESSION_EXP
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_LOGIN_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_LOGIN_AUTHFAIL)
	public String authFail() {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_AUTH_FAIL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_LOGIN_VIEW;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_LOGIN_BACK)
	public String backToLogin() {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_BACK_TO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_LOGIN_VIEW;
	}

	/**
	 * 
	 * @param model
	 * @param principal
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_LOOUT)
	public String logout(ModelMap model, Principal principal, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGOUT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String currentUser = null;
		if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
			currentUser = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		}
		if (null != currentUser) {
			request.getSession().invalidate();
			try {
				request.logout();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGOUT
				+ MessageConstant.LOG_INFO_RETURN);
		return AppConstant.TDM_LOGIN_VIEW;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = AppConstant.TDM_LOGIN_USER_MANUAL, method = RequestMethod.GET)
	public void doDownloadTdm(HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_DONLOAD_USER_M
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DownloadUtils.download(request, response, filePath);

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_FORGOT_PASS
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

	@RequestMapping(value = AppConstant.TDM_LOGIN_FORGOT, method = RequestMethod.GET)
	public String forgotPassL(
			@ModelAttribute(MessageConstant.TDM_LOGIN_FORGOT_DTO) ForgotPassword forgotPasswordDto,
			ModelMap modelmap) {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_FORGOTPASS_L
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_F_PASSWORD_VIEW;
	}
}
