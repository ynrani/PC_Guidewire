package com.tesda.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesda.exception.BaseException;
import com.tesda.service.RefreshService;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope("session")
public class RefreshController
{

	final static Logger logger = Logger.getLogger(RefreshController.class);

	@Resource(name = "refreshService")
	RefreshService refreshService;

	@RequestMapping(value = "/policyRefresh", method = RequestMethod.GET)
	@ResponseBody
	public boolean policyRefresh(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		boolean refreshFlag = false;
		try {
			refreshFlag = refreshService.policyRefresh();
			return refreshFlag;
		} catch (BaseException baseEx) {
			logger.error("Sorry, something wrong in auto search controller!", baseEx);

			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return refreshFlag;
			}
		}
		return refreshFlag;
	}

	@RequestMapping(value = "/policyRefresh1", method = RequestMethod.GET)
	@ResponseBody
	public String getPolicysummaryData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		boolean refreshFlag = false;
		try {
			refreshFlag = refreshService.getPolicysummaryData();
			return String.valueOf(refreshFlag);
		} catch (BaseException baseEx) {
			logger.error("Sorry, something wrong in auto search controller!", baseEx);

			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return baseEx.getErrorCode();
			}
		}
		return String.valueOf(refreshFlag);
	}

}
