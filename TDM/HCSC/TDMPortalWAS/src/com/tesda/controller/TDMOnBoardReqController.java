package com.tesda.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmChangeReqDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;
import com.tesda.service.TDGDataMaskingService;
import com.tesda.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMOnBoardReqController
{

	List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOfr = null;
	List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOcr = null;

	@Resource(name = TDMConstants.DATAMASKING_SERVICE)
	TDGDataMaskingService dataMaskingService;

	@RequestMapping(value = TDMConstants.MAP_TDM_ONBOARD_REQ, method = RequestMethod.GET)
	public String tdmGetOnboardReq(
			@RequestParam(value = "reqId", required = false) String reqId,
			@ModelAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO) TdmOnBoardReqDTO tdmOnboardReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			boolean chngeReqYN = false;
			if (StringUtils.isNotEmpty(reqId))
			{
				tdmOnboardReqDTO = dataMaskingService.getEditableDetails(reqId);
				chngeReqYN = true;

			}
			else
			{

				if (null != (String) request.getSession().getAttribute(TDMConstants.USER_ID))
				{
					tdmOnboardReqDTO.setUserId((String) request.getSession().getAttribute(
							TDMConstants.USER_ID));
					tdmOnboardReqDTO = dataMaskingService.getUserDetails((String) request
							.getSession().getAttribute(TDMConstants.USER_ID), tdmOnboardReqDTO);

					if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
					{
						tdmOnboardReqDTO.setAppName((String) request.getSession().getAttribute(
								TDMConstants.PROJECT_ID));
					}
				}
				chngeReqYN = false;
			}

			model.addAttribute(TDMConstants.IS_CHANGE_REQ, chngeReqYN);
			model.addAttribute("reqId", tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO, tdmOnboardReqDTO);

			return TDMConstants.TDM_ONBOARDING_REQ;
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO, tdmOnboardReqDTO);
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			if (ex.getErrorCode().equals(TDMExceptionCode.NORESULT))
			{
				model.addAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO, new TdmChangeReqDTO());
				return TDMConstants.TDM_CHANGE_REQEXT;
			}
			return TDMConstants.TDM_ONBOARDING_REQ;
		}

	}

	@RequestMapping(value = TDMConstants.MAP_TDM_ONBOARD_REQ, method = RequestMethod.POST)
	@ResponseBody
	public String tdmPostOnboardReq(
			@ModelAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO) TdmOnBoardReqDTO tdmOnboardReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			boolean chngeReqYN = false;
			tdmOnboardReqDTO = dataMaskingService.getSaveOnboardingReq(tdmOnboardReqDTO);
			if (StringUtils.isNotEmpty(tdmOnboardReqDTO.getChngReqCmmt()))
			{
				chngeReqYN = true;
			}
			model.addAttribute("reqId", tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(TDMConstants.IS_CHANGE_REQ, chngeReqYN);
			return tdmOnboardReqDTO.getOnboardReqId();
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			return TDMConstants.TDM_ONBOARDING_REQ;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_DASHBOARD, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		try
		{
			String type = "FR";
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);

			totalRecords = dataMaskingService.getReservedRecordsCountOnBoard((String) request
					.getSession().getAttribute(TDMConstants.USER_ID), type);

			List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOs = dataMaskingService
					.getAllOnBoardRequestedRecordForPagination(offSet, recordsperpage, true,
							(String) request.getSession().getAttribute(TDMConstants.USER_ID), type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			tdgDtMaskRequestListDTOfr = tdgDtMaskRequestListDTOs;
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute("tdgDtMaskRequestListDTOs", tdgDtMaskRequestListDTOs);
			return TDMConstants.TDM_ONBOARDING_DASHBOARD;
		}
		catch (ServiceException se)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.TDM_ONBOARDING_DASHBOARD;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_DASHBOARDCR, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		try
		{
			String type = TDMConstants.CR;
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);

			totalRecords = dataMaskingService.getReservedRecordsCountOnBoard((String) request
					.getSession().getAttribute(TDMConstants.USER_ID), type);

			List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOs = dataMaskingService
					.getAllOnBoardRequestedRecordForPagination(offSet, recordsperpage, true,
							(String) request.getSession().getAttribute(TDMConstants.USER_ID), type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			tdgDtMaskRequestListDTOcr = tdgDtMaskRequestListDTOs;
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute("tdgDtMaskRequestListDTOs", tdgDtMaskRequestListDTOs);
			return TDMConstants.TDM_ONBOARDING_DASHBOARDCR;
		}
		catch (ServiceException se)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.TDM_ONBOARDING_DASHBOARDCR;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_EXPORTFR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmOnBoardingExportFR(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{
		return new ModelAndView("dataMaskingDashBoardExcel", "tdgDataMaskingDTOs",
				tdgDtMaskRequestListDTOfr);
	}

	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_EXPORTCR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmOnBoardingExportCR(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{
		return new ModelAndView("dataMaskingDashBoardExcel", "tdgDataMaskingDTOs",
				tdgDtMaskRequestListDTOcr);
	}
}
