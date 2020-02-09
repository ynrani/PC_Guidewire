package com.tesda.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
public class RefreshController
{

	final static Logger logger = Logger.getLogger(RefreshController.class);

	@Resource(name = "refreshService")
	RefreshService refreshService;

	@RequestMapping(value = "/policySumRefresh", method = RequestMethod.GET)
	@ResponseBody
	public String getPolicysummaryData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		boolean refreshFlag = false;
		long elapsedTime = 0;
		try {
			long startTime = System.currentTimeMillis();
			refreshFlag = refreshService.getPolicysummaryData(request, response);
			long stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;

			return refreshFlag + ", Total Time taken to dump data from PAS and FASTLANE is :  "
					+ getDurationBreakdown(elapsedTime);
		} catch (BaseException baseEx) {
			baseEx.printStackTrace();
			logger.error("Sorry, something wrong in auto search controller!", baseEx);

			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return baseEx.getRootCause().toString();
			}
		}
		return refreshFlag + ", Total Time taken to dump data from PAS and FASTLANE is :  "
				+ getDurationBreakdown(elapsedTime);
	}

	@RequestMapping(value = "/policyCovRefresh", method = RequestMethod.GET)
	@ResponseBody
	public String getPolicyCoverageData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		boolean refreshFlag = false;
		long elapsedTime = 0;
		try {
			long startTime = System.currentTimeMillis();
			refreshFlag = refreshService.getPolicyCoverageData();
			long stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			return refreshFlag + " Time : " + getDurationBreakdown(elapsedTime);
		} catch (BaseException baseEx) {
			logger.error("Sorry, something wrong in auto search controller!", baseEx);
			baseEx.printStackTrace();
			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return baseEx.getRootCause().toString();
			}
		}
		return refreshFlag + " Time :  " + getDurationBreakdown(elapsedTime);
	}

	@RequestMapping(value = "/policyDerivedRefresh", method = RequestMethod.GET)
	@ResponseBody
	public String getPolicyDerivedData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		boolean refreshFlag = false;
		try {
			refreshFlag = refreshService.getPolicyDerivedData();
			return String.valueOf(refreshFlag);
		} catch (BaseException baseEx) {
			logger.error("Sorry, something wrong in auto search controller!", baseEx);
			baseEx.printStackTrace();
			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return baseEx.getRootCause().toString();
			}
		}
		return String.valueOf(refreshFlag);
	}

	/**
	 * Convert a millisecond duration to a string format
	 * 
	 * @param millis
	 *            A duration to convert to a string form
	 * @return A string of the form "X Minutes A Seconds".
	 */
	public static String getDurationBreakdown(long millis) {
		if (millis < 0) {
			throw new IllegalArgumentException("Duration must be greater than zero!");
		}

		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

		StringBuilder sb = new StringBuilder(64);

		sb.append(minutes);
		sb.append(" Minutes ");
		sb.append(seconds);
		sb.append(" Seconds");

		return (sb.toString());
	}
}
