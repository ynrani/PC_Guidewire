package com.tesda.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tesda.model.DTO.AutoEmailDTO;
import com.tesda.model.DTO.ForgotPassDTO;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope("session")
public class EmailController
{
	final static Logger logger = Logger.getLogger(EmailController.class);
	
	@RequestMapping(value = "/popupEmail", method = RequestMethod.GET)
	public String popupEmailL1L2Get(@ModelAttribute("autoEmailDTO") AutoEmailDTO autoEmailDTO,
			ModelMap model, @RequestParam(value = "result", required = false) String result,
			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{
		String tmp = "Dear Team, \n \t I am searching with following scenario and facing No records found. Please add Data for the following search scenario \n"
				+ "'"
				+ result
				+ "'"
				+ "\n\nRegards, \n"
				+ (String) request.getSession().getAttribute("UserId");

		autoEmailDTO.setSubject("Data Request For Following Search Criteria");
		autoEmailDTO.setTo("tdm_support@capgemini.com");
		autoEmailDTO.setMsg(tmp);

		return "popupEmail";
	}

	@RequestMapping(value = "/popupEmailUser", method = RequestMethod.GET)
	public String popupEmailGet(@ModelAttribute("autoEmailDTO") AutoEmailDTO autoEmailDTO,
			ModelMap model, @RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "reserveId", required = false) String reserveId,
			@RequestParam(value = "result", required = false) String result,

			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{
		String tmp = "Dear " + user
				+ ", \n \t Please Un-reserve the record for the following search scenario \n" + "'"
				+ result + "'" + " and Test Case Id: " + reserveId + "\n\nRegards, \n"
				+ (String) request.getSession().getAttribute("UserId");

		autoEmailDTO.setSubject("Data Un-reserve For Following Search Criteria and Test Case ID");
		autoEmailDTO.setTo(user + "@capgemini.com");
		autoEmailDTO.setMsg(tmp);

		return "popupEmail";
	}

	@RequestMapping(value = "/popupForgotPassword", method = RequestMethod.GET)
	public String popupForgotPassGet(@ModelAttribute("forgotPassDTO") ForgotPassDTO forgotPassDTO,
			HttpServletRequest request, HttpServletResponse response, Principal principal)
	{

		return "popupForgotPassword";
	}

}
