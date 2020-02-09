/*---------------------------------------------------------------------------------------
 * Object Name: TDMChangeReqController.Java
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

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TdmChangeReqDTO;
import com.tesda.service.TDMDataMaskingService;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMChangeReqController
{

	private static final Logger logger = LoggerFactory.getLogger(TDMChangeReqController.class);

	@Resource(name = TDMConstants.DATAMASKING_SERVICE)
	TDMDataMaskingService dataMaskingService;

	@RequestMapping(value = TDMConstants.MAP_TDM_CHANGEREQEXT, method = RequestMethod.GET)
	public String tdmGetCngReqExt(
			@ModelAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO) TdmChangeReqDTO tdmChangeReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal)
	{
		logger.info(MessageConstants.CHNGREQ_CNTRL + MessageConstants.GETREQEXT
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.TDM_CHANGE_REQEXT;
	}

	/**
	 * @param tdmChangeReqDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_CHANGEREQEXT, method = RequestMethod.POST)
	public String tdmGetCngReqExtPost(
			@ModelAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO) TdmChangeReqDTO tdmChangeReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		logger.info(MessageConstants.CHNGREQ_CNTRL + MessageConstants.POSTREQEXT);
		if (null != tdmChangeReqDTO)
		{
			if (tdmChangeReqDTO.getReqId().startsWith(TDMConstants.TR))
			{
				return TDMConstants.REDIRECT_ONBOARDREQ + tdmChangeReqDTO.getReqId();
			}
			else if (tdmChangeReqDTO.getReqId().startsWith(TDMConstants.MR))
			{
				return TDMConstants.REDIRECT_GETDTMASK_REQDTLS + tdmChangeReqDTO.getReqId()
						+ "&edit=true";
			}
			logger.info(MessageConstants.CHNGREQ_CNTRL + MessageConstants.POSTREQEXT
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_CHANGE_REQEXT;
		}
		else
		{
			logger.info(MessageConstants.CHNGREQ_CNTRL + MessageConstants.POSTREQEXT
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_CHANGE_REQEXT;
		}

	}

	/**
	 * @param reqIdtoken
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_CHANGEREQ_ID, method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public List<String> tdmGetCngReqExtID(
			@RequestParam(value = "term", required = false) String reqIdtoken, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws TDMException
	{
		logger.info(MessageConstants.CHNGREQ_CNTRL + MessageConstants.GETREQEXTID);
		List<String> reqIds = null;
		try
		{
			if (reqIdtoken.toUpperCase().startsWith(TDMConstants.MR)
					|| reqIdtoken.toUpperCase().startsWith(TDMConstants.TR))
			{
				reqIds = dataMaskingService.getReqIdList((String) request.getSession()
						.getAttribute(TDMConstants.USER_ID), reqIdtoken.toUpperCase());
			}

			logger.info(MessageConstants.CHNGREQ_CNTRL + MessageConstants.GETREQEXTID
					+ MessageConstants.LOG_INFO_RETURN);
			return reqIds;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				logger.error(MessageConstants.CHNGREQ_CNTRL + MessageConstants.GETREQEXTID,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return reqIds;
		}
	}
}
