package com.tesda.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesda.constants.TDMConstants;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TdmChangeReqDTO;
import com.tesda.service.TDGDataMaskingService;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMChangeReqController
{

	@Resource(name = TDMConstants.DATAMASKING_SERVICE)
	TDGDataMaskingService dataMaskingService;

	@RequestMapping(value = TDMConstants.MAP_TDM_CHANGEREQEXT, method = RequestMethod.GET)
	public String tdmGetCngReqExt(
			@ModelAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO) TdmChangeReqDTO tdmChangeReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal)
	{

		return TDMConstants.TDM_CHANGE_REQEXT;

	}

	@RequestMapping(value = TDMConstants.MAP_TDM_CHANGEREQEXT, method = RequestMethod.POST)
	public String tdmGetCngReqExtPost(
			@ModelAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO) TdmChangeReqDTO tdmChangeReqDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal)  throws TDMException
	{
		if (null != tdmChangeReqDTO)
		{
			if (tdmChangeReqDTO.getReqId().startsWith(TDMConstants.TR))
			{
				return TDMConstants.REDIRECT_ONBOARDREQ + tdmChangeReqDTO.getReqId();
			} else if (tdmChangeReqDTO.getReqId().startsWith(TDMConstants.MR))
			{
				return TDMConstants.REDIRECT_GETDTMASK_REQDTLS + tdmChangeReqDTO.getReqId()
						+ "&edit=true";
			}
			return TDMConstants.TDM_CHANGE_REQEXT;
		} else
		{
			return TDMConstants.TDM_CHANGE_REQEXT;
		}

	}

	@RequestMapping(value = TDMConstants.MAP_TDM_CHANGEREQ_ID, method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public List<String> tdmGetCngReqExtID(
			@RequestParam(value = "term", required = false) String reqIdtoken, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal)  throws TDMException
	{

		List<String> reqIds = null;
		try
		{
		if (reqIdtoken.toUpperCase().startsWith(TDMConstants.MR)
				|| reqIdtoken.toUpperCase().startsWith(TDMConstants.TR))
		{
			reqIds = dataMaskingService.getReqIdList(
					(String) request.getSession().getAttribute(TDMConstants.USER_ID),
					reqIdtoken.toUpperCase());
		}

		return reqIds;
		}
		catch(ServiceException se)
		{
			return reqIds;
		}

	}

}
