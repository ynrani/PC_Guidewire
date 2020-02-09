/*---------------------------------------------------------------------------------------
 * Object Name: EmailController.Java
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

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.model.DTO.AutoEmailDTO;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class EmailController
{
	private static Logger logger = Logger.getLogger(EmailController.class);

	/**
	 * 
	 * @param autoEmailDTO
	 * @param model
	 * @param result
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.POPUP_EMAIL, method = RequestMethod.GET)
	public String popupEmailL1L2Get(
			@ModelAttribute(AppConstant.AUTO_EMAIL_DTO) AutoEmailDTO autoEmailDTO, ModelMap model,
			@RequestParam(value = AppConstant.RESULT, required = false) String result,
			HttpServletRequest request, HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_POPUP_L1L2
				+ MessageConstant.LOG_INFO_POPUP + result);
		String tmp = AppConstant.BODY11 + "'" + result + "'" + AppConstant.BODY3
				+ (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		autoEmailDTO.setSubject(AppConstant.SUBJECT1);
		autoEmailDTO.setTo(AppConstant.TO1);
		autoEmailDTO.setMsg(tmp);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_POPUP_L1L2
				+ MessageConstant.LOG_INFO_RETURN);
		return AppConstant.POPUP_EMAIL_VIEW;
	}

	/**
	 * 
	 * @param autoEmailDTO
	 * @param model
	 * @param user
	 * @param reserveId
	 * @param result
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.POPUP_EMAIL_USER, method = RequestMethod.GET)
	public String popupEmailGet(
			@ModelAttribute(AppConstant.AUTO_EMAIL_DTO) AutoEmailDTO autoEmailDTO, ModelMap model,
			@RequestParam(value = AppConstant.USER, required = false) String user,
			@RequestParam(value = AppConstant.RESERVED, required = false) String reserveId,
			@RequestParam(value = AppConstant.RESULT, required = false) String result,
			HttpServletRequest request, HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL
				+ MessageConstant.LOG_INFO_POPUP + result);
		String tmp = AppConstant.DEAR + user + AppConstant.BODY1 + "'" + result + "'"
				+ AppConstant.BODY2 + reserveId + AppConstant.BODY3
				+ (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		autoEmailDTO.setSubject(AppConstant.SUBJECT);
		autoEmailDTO.setTo(user + AppConstant.TO);
		autoEmailDTO.setMsg(tmp);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL
				+ MessageConstant.LOG_INFO_RETURN);
		return AppConstant.POPUP_EMAIL_VIEW;
	}

}
