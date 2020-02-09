/*---------------------------------------------------------------------------------------
 * Object Name: LoginController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. 		Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          		Created
 * 2		Sikandar Shaikh		18/06/15  Logging changes	Updated
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.model.DTO.ForgotPassword;

/**
 * @author
 * @version 1.0
 */

@Controller
public class LoginController
{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_LOGIN, method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = TDMConstants.ERROR, required = false) String error,
			@RequestParam(value = TDMConstants.LOGOUT, required = false) String logout)
	{

		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.LOGIN);

		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject(TDMConstants.ERROR, "Invalid username and password!");
		}

		if (logout != null)
		{
			// logger.info("logout called");
			model.addObject("msg", "You've been logged out successfully.");

		}
		model.addObject("msg",
				"You are not allowed to perform 'Back' or You have not logged in or Session Expired.");
		model.setViewName(TDMConstants.LOGIN);

		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.LOGIN
				+ MessageConstants.LOG_INFO_RETURN);
		return model;

	}

	/**
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(TDMConstants.MAP_TESDA_LOGIN)
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return TDMConstants.LOGIN;
	}
	
	@RequestMapping("/")
	public String login2(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return "login";
	}

	@RequestMapping(TDMConstants.MAP_TESDA_ADMIN)
	public String admin()
	{
		return TDMConstants.ADMIN;
	}

	@RequestMapping(TDMConstants.MAP_INDEX)
	public String index()
	{
		return TDMConstants.INDEX;
	}

	@RequestMapping(TDMConstants.MAP_INDEXCOMMANDOR)
	public String indexCmdCtr()
	{
		return TDMConstants.INDEX_COMMAND_CENTER;
	}

	@RequestMapping(TDMConstants.MAP_403PAGE)
	public String accessDenied()
	{
		return TDMConstants.REDIRCT_ACCESSDENIED;
	}

	@RequestMapping(TDMConstants.MAP_SESSIONEXP)
	public String sessionExp()
	{
		return TDMConstants.LOGIN;
	}

	@RequestMapping(TDMConstants.MAP_AUTHFAIL)
	public String authFail()
	{
		return TDMConstants.LOGIN;
	}

	@RequestMapping(TDMConstants.MAP_BACK)
	public String backToLogin()
	{
		return TDMConstants.LOGIN;
	}

	/**
	 * @param model
	 * @param principal
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(TDMConstants.MAP_LOGOUT)
	public String logout(ModelMap model, Principal principal, HttpServletRequest request,
			HttpServletResponse response)
	{

		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.LOGOUT);

		String currentUser = null;

		if (null != (String) request.getSession().getAttribute(TDMConstants.USER_ID))
		{
			currentUser = (String) request.getSession().getAttribute(TDMConstants.USER_ID);
		}
		if (null != currentUser)
		{

			request.getSession().invalidate();
			try
			{
				request.logout();
			}
			catch (ServletException e)
			{
				logger.error(TDMConstants.TDMP_CONTROLLER_ERROR_1, "Exception occured " + e);
				// e.printStackTrace();
			}
			/*
			 * for (Object principalObj : sessionRegistry.getAllPrincipals()) {
			 * for (SessionInformation session :
			 * sessionRegistry.getAllSessions(principalObj, false)) {
			 * 
			 * if (principal.getName().equalsIgnoreCase(currentUser)) {
			 * session.expireNow();
			 * 
			 * }
			 * 
			 * } }
			 */
		}

		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.LOGOUT
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.LOGIN;
	}

	@RequestMapping(value = TDMConstants.MAP_FORGOT_PASSWORD, method = RequestMethod.GET)
	public String forgotPassword()
	{
		logger.info("forgot password initiated");

		return TDMConstants.FORGOT_PASSWORD;
	}

	@RequestMapping(value = TDMConstants.MAP_LOGINFORGOT_PASSWORD, method = RequestMethod.GET)
	public String forgotPass(
			@ModelAttribute(TDMConstants.MODEL_FORGOTPASSWORD_DTO) ForgotPassword forgotPasswordDto,
			ModelMap modelmap)
	{
		/*
		 * if (null != forgotPasswordDto) modelmap.addAttribute("email",
		 * "Email sent"); else modelmap.addAttribute("email",
		 * "Email sent failed. Please Try Again");
		 */

		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.FORGOTPASS);
		return TDMConstants.FORGOT_PASSWORD;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_DOWNLOAD_USERMANUAL, method = RequestMethod.GET)
	public void doDownloadTdm(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{

		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.USERMANUAL);
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");

		// construct the complete absolute path of the file
		String fullPath = appPath + TDMConstants.FILE_USER_MANUAL;
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null)
		{
			// set to binary type if MIME mapping not found
			mimeType = TDMConstants.MIME_MAPPING;
		}

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(TDMConstants.HEADER_KEY, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[TDMConstants.BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1)
		{
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();
		logger.info(MessageConstants.LOGIN_CNTRL + MessageConstants.USERMANUAL
				+ MessageConstants.LOG_INFO_RETURN);
	}
}
