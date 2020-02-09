/*---------------------------------------------------------------------------------------
 * Object Name: EmailController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.model.DTO.AutoEmailDTO;

/**
 * @author
 * @version 1.0
 * 
 *          This class provides automated email which will send to the
 *          application support team to resolve user queries.
 */

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class EmailController
{

	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	/**
	 * @param autoEmailDTO
	 * @param model
	 * @param result
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_POPEMAIL, method = RequestMethod.GET)
	public String popupEmailL1L2Get(
			@ModelAttribute(TDMConstants.MODEL_AUTOEMAIL_DTO) AutoEmailDTO autoEmailDTO,
			ModelMap model,
			@RequestParam(value = TDMConstants.RESULT, required = false) String result,
			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{
		logger.info(MessageConstants.EMAIL_CNTRL + MessageConstants.L1L2GET + result);
		String tmp = "Dear Team, \n \t Please add Data for the following search scenario \n" + "'"
				+ result + "'" + "\n\nRegards, \n"
				+ (String) request.getSession().getAttribute(TDMConstants.USER_ID);
		autoEmailDTO.setSubject("Data Request For Following Search Criteria");
		autoEmailDTO.setTo(TDMConstants.AUTO_EMAIL_ID);
		autoEmailDTO.setMsg(tmp);

		logger.info(MessageConstants.EMAIL_CNTRL + MessageConstants.L1L2GET
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.EMAIL_POPUP;
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
	@RequestMapping(value = TDMConstants.MAP_POPUPEMAIL_USER, method = RequestMethod.GET)
	public String popupEmailGet(
			@ModelAttribute(TDMConstants.MODEL_AUTOEMAIL_DTO) AutoEmailDTO autoEmailDTO,
			ModelMap model, @RequestParam(value = TDMConstants.USER, required = false) String user,
			@RequestParam(value = TDMConstants.RESERVE_ID, required = false) String reserveId,
			@RequestParam(value = TDMConstants.RESULT, required = false) String result,

			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{
		logger.info(MessageConstants.EMAIL_CNTRL + MessageConstants.POPUPEMAIL + user);
		String tmp = "Dear " + user
				+ ", \n \t Please Un-reserve the record for the following search scenario \n" + "'"
				+ result + "'" + " and Test Case Id: " + reserveId + "\n\nRegards, \n"
				+ (String) request.getSession().getAttribute(TDMConstants.USER_ID);

		autoEmailDTO.setSubject("Data Un-reserve For Following Search Criteria and Test Case ID");
		autoEmailDTO.setTo(user + "@capgemini.com");
		autoEmailDTO.setMsg(tmp);

		logger.info(MessageConstants.EMAIL_CNTRL + MessageConstants.POPUPEMAIL
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.EMAIL_POPUP;
	}

}
