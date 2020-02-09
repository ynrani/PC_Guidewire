/*---------------------------------------------------------------------------------------
 * Object Name: TDMChangeReqController.Java
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
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.model.DTO.TdmChangeReqDTO;
import com.tdm.service.TDMDataMaskingService;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class TDMChangeReqController
{
	private static Logger logger = Logger.getLogger(TDMChangeReqController.class);

	@Resource(name = MessageConstant.SERVICE_MSK)
	TDMDataMaskingService tdmDataMaskingService;

	@RequestMapping(value = AppConstant.TDM_CHANGE_REQ, method = RequestMethod.GET)
	public String tdmGetCngReqExt(
			@ModelAttribute(MessageConstant.TDM_CHNG_MGMT_DTO) TdmChangeReqDTO tdmChangeReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_CHNG_MGMT_CTLR + MessageConstant.TDM_CHNG_MGMT_REQ_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_CHANGE_REQ_VIEW;
	}

	@RequestMapping(value = AppConstant.TDM_CHANGE_REQ, method = RequestMethod.POST)
	public String tdmGetCngReqExtPost(
			@ModelAttribute(MessageConstant.TDM_CHNG_MGMT_DTO) TdmChangeReqDTO tdmChangeReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws BaseException {
		logger.info(MessageConstant.TDM_CHNG_MGMT_CTLR + MessageConstant.TDM_CHNG_MGMT_REQ_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);

		if (null != tdmChangeReqDTO) {
			if (tdmChangeReqDTO.getReqId().startsWith(AppConstant.TR)) {
				return AppConstant.TDM_CHANGE_REQ_REDIRECT_ONBOARD + tdmChangeReqDTO.getReqId();
			} else if (tdmChangeReqDTO.getReqId().startsWith(AppConstant.MR)) {
				return AppConstant.TDM_CHANGE_REQ_REDIRECT_MASK + tdmChangeReqDTO.getReqId()
						+ AppConstant.TDM_EDIT_TRUE;
			}
			logger.info(MessageConstant.TDM_CHNG_MGMT_CTLR + MessageConstant.TDM_CHNG_MGMT_REQ_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_CHANGE_REQ_VIEW;
		} else {
			return AppConstant.TDM_CHANGE_REQ_VIEW;
		}

	}

	@RequestMapping(value = AppConstant.TDM_CHANGE_REQ_ID, method = RequestMethod.GET, headers = AppConstant.ACCEPT)
	@ResponseBody
	public List<String> tdmGetCngReqExtID(
			@RequestParam(value = AppConstant.TERM, required = false) String reqIdtoken,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws BaseException {
		logger.info(MessageConstant.TDM_CHNG_MGMT_CTLR + MessageConstant.TDM_CHNG_MGMT_EXT_ID
				+ MessageConstant.LOG_INFO_PARAMS_YES + reqIdtoken);
		List<String> reqIds = null;
		try {
			if (reqIdtoken.toUpperCase().startsWith(AppConstant.MR)
					|| reqIdtoken.toUpperCase().startsWith(AppConstant.TR)) {
				reqIds = tdmDataMaskingService.getReqIdList((String) request.getSession()
						.getAttribute(AppConstant.SESSION_UID), reqIdtoken.toUpperCase());
			}
			logger.info(MessageConstant.TDM_CHNG_MGMT_CTLR + MessageConstant.TDM_CHNG_MGMT_EXT_ID
					+ MessageConstant.LOG_INFO_RETURN);
			return reqIds;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CHNG_MGMT_CTLR + MessageConstant.TDM_CHNG_MGMT_EXT_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return reqIds;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return reqIds;
		}
	}

}
