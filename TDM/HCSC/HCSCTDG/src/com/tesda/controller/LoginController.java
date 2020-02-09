/*
 * Object Name : LoginController.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tesda.model.DTO.TdgUsersDTO;
import com.tesda.service.TDMAdminService;

/**
 * @author
 * @version 1.0
 */

@Controller
public class LoginController{

	@Resource(name = "tDMAdminService")
	TDMAdminService tDMAdminService;

	/* @Autowired SessionRegistry sessionRegistry;
	 * 
	 * public SessionRegistry getSessionRegistry() { return sessionRegistry; }
	 * 
	 * public void setSessionRegistry(SessionRegistry sessionRegistry) {
	 * this.sessionRegistry = sessionRegistry; } */

	@RequestMapping("/tesdaLogin")
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping("/testdaAdmin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/index")
	public String index() {
		//return "index";
		return "redirect:tdgOperationsDetails";
	}

	@RequestMapping("/indexCmdCtr")
	public String indexCmdCtr() {
		return "indexCommandCenter";
	}

	@RequestMapping("/403page")
	public String accessDenied() {
		return "login:redirect?accessDenied=true";
	}

	@RequestMapping("/sessionExp")
	public String sessionExp() {
		return "login";
	}

	@RequestMapping("/authFail")
	public String authFail() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model, Principal principal, HttpServletRequest request,
			HttpServletResponse response) {

		String currentUser = null;

		if (null != (String) request.getSession().getAttribute("UserId")) {
			currentUser = (String) request.getSession().getAttribute("UserId");
		}
		if (null != currentUser) {

			request.getSession().invalidate();
			/* for (Object principalObj : sessionRegistry.getAllPrincipals()) {
			 * for (SessionInformation session :
			 * sessionRegistry.getAllSessions(principalObj, false)) {
			 * 
			 * if (principal.getName().equalsIgnoreCase(currentUser)) {
			 * session.expireNow();
			 * 
			 * }
			 * 
			 * } } */
		}

		return "login";
	}

	@RequestMapping(value = "/fPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgotPassword";
	}

	@RequestMapping(value = "/dynamicConnectionTest")
	public String getTableGetName(@ModelAttribute TdgUsersDTO tdgUsersDTO) {
		// List<String> listResult = tDMAdminService.getAllTables(databaseConnnectionDTO.getUrl(),
		// databaseConnnectionDTO.getUsername(), databaseConnnectionDTO.getPassword());
		return "dynamicConnection";
	}

	@RequestMapping(value = "/dynamicConnectionTest", method = RequestMethod.POST)
	public void getTablePostName(@ModelAttribute TdgUsersDTO tdgUsersDTO) {
		System.out.println(tdgUsersDTO);

		// generateSequenceOfTables();

		/* if (fileUpload != null && fileUpload.length > 0) {
		 * for (CommonsMultipartFile aFile : fileUpload){
		 * 
		 * System.out.println("Saving file: " + aFile.getOriginalFilename());
		 * 
		 * if (!aFile.getOriginalFilename().equals("")) {
		 * aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
		 * }
		 * }
		 * } */
		// List<String> listResult = tDMAdminService.getAllTables(databaseConnnectionDTO.getUrl(),
		// databaseConnnectionDTO.getUsername(), databaseConnnectionDTO.getPassword());
	}

}
