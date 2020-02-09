package com.tesda.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	// private static final Logger logger =
	// LoggerFactory.getLogger(EmailController.class);

	@RequestMapping(value = TDMConstants.MAP_POPEMAIL, method = RequestMethod.GET)
	public String popupEmailL1L2Get(
			@ModelAttribute(TDMConstants.MODEL_AUTOEMAIL_DTO) AutoEmailDTO autoEmailDTO,
			ModelMap model,
			@RequestParam(value = TDMConstants.RESULT, required = false) String result,
			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{
		String tmp = "Dear Team, \n \t Please add Data for the following search scenario \n" + "'"
				+ result + "'" + "\n\nRegards, \n"
				+ (String) request.getSession().getAttribute(TDMConstants.USER_ID);

		autoEmailDTO.setSubject("Data Request For Following Search Criteria");
		autoEmailDTO.setTo(TDMConstants.AUTO_EMAIL_ID);
		autoEmailDTO.setMsg(tmp);

		return TDMConstants.EMAIL_POPUP;
	}

	@RequestMapping(value = TDMConstants.MAP_POPUPEMAIL_USER, method = RequestMethod.GET)
	public String popupEmailGet(
			@ModelAttribute(TDMConstants.MODEL_AUTOEMAIL_DTO) AutoEmailDTO autoEmailDTO,
			ModelMap model, @RequestParam(value = TDMConstants.USER, required = false) String user,
			@RequestParam(value = TDMConstants.RESERVE_ID, required = false) String reserveId,
			@RequestParam(value = TDMConstants.RESULT, required = false) String result,

			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{
		String tmp = "Dear " + user
				+ ", \n \t Please Un-reserve the record for the following search scenario \n" + "'"
				+ result + "'" + " and Test Case Id: " + reserveId + "\n\nRegards, \n"
				+ (String) request.getSession().getAttribute(TDMConstants.USER_ID);

		autoEmailDTO.setSubject("Data Un-reserve For Following Search Criteria and Test Case ID");
		autoEmailDTO.setTo(user + "@capgemini.com");
		autoEmailDTO.setMsg(tmp);

		return TDMConstants.EMAIL_POPUP;
	}

}
