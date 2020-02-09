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

import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope("session")
public class TdmPolicyClaimSearchController
{
	final static Logger logger = Logger.getLogger(TdmPolicyClaimSearchController.class);

	@RequestMapping(value = "/policyClaim", method = RequestMethod.GET)
	public String policyClaimGet(
			@ModelAttribute("tdmPolicyAutoSearchDTO") TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		System.out.println("TdmPolicyClaimSearchController class policyClaimGet ");
		return "claimPolicySearch";
	}

}
