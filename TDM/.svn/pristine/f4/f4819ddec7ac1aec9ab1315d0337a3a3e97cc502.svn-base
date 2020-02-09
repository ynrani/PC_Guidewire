/*---------------------------------------------------------------------------------------
 * Object Name: TDMOnBoardReqController.Java
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

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.servlet.ModelAndView;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmChangeReqDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;
import com.tesda.service.TDMDataMaskingService;
import com.tesda.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMOnBoardReqController
{

	private static final Logger logger = LoggerFactory.getLogger(TDMOnBoardReqController.class);

	List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOfr = null;
	List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOcr = null;

	@Resource(name = TDMConstants.DATAMASKING_SERVICE)
	TDMDataMaskingService dataMaskingService;

	/**
	 * 
	 * @param reqId
	 * @param tdmOnboardReqDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_ONBOARD_REQ, method = RequestMethod.GET)
	public String tdmGetOnboardReq(
			@RequestParam(value = "reqId", required = false) String reqId,
			@ModelAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO) TdmOnBoardReqDTO tdmOnboardReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.GET_ONBRDREQ);
			boolean chngeReqYN = false;
			if (StringUtils.isNotEmpty(reqId))
			{
				tdmOnboardReqDTO = dataMaskingService.getEditableDetails(reqId);
				chngeReqYN = true;
				logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.GET_ONBRDREQ + reqId);
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
			model.addAttribute(TDMConstants.REQ_ID, tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO, tdmOnboardReqDTO);
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.GET_ONBRDREQ
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_ONBOARDING_REQ;
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO, tdmOnboardReqDTO);
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			logger.error(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.GET_ONBRDREQ,
					TDMExceptionCode.getExceptionMsg(ex));
			if (ex.getErrorCode().equals(TDMExceptionCode.NORESULT))
			{
				model.addAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO, new TdmChangeReqDTO());
				return TDMConstants.TDM_CHANGE_REQEXT;
			}
			return TDMConstants.TDM_ONBOARDING_REQ;
		}

	}

	/**
	 * 
	 * @param tdmOnboardReqDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_ONBOARD_REQ, method = RequestMethod.POST)
	@ResponseBody
	public String tdmPostOnboardReq(
			@ModelAttribute(TDMConstants.MODEL_TDM_ONBORAD_REQDTO) TdmOnBoardReqDTO tdmOnboardReqDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.POST_ONBRDREQ);
			boolean chngeReqYN = false;
			tdmOnboardReqDTO = dataMaskingService.getSaveOnboardingReq(tdmOnboardReqDTO);
			if (StringUtils.isNotEmpty(tdmOnboardReqDTO.getChngReqCmmt()))
			{
				chngeReqYN = true;
			}
			model.addAttribute(TDMConstants.REQ_ID, tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(TDMConstants.IS_CHANGE_REQ, chngeReqYN);
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.POST_ONBRDREQ
					+ MessageConstants.LOG_INFO_RETURN);
			return tdmOnboardReqDTO.getOnboardReqId();
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			logger.error(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.POST_ONBRDREQ,
					TDMExceptionCode.getExceptionMsg(ex));
			return TDMConstants.TDM_ONBOARDING_REQ;
		}
	}

	/**
	 * 
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_DASHBOARD, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRD);
			String type = TDMConstants.FR;
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
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASK_REQLISTDTO, tdgDtMaskRequestListDTOs);
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRD
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_ONBOARDING_DASHBOARD;
		}
		catch (ServiceException se)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			logger.error(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRD,
					TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.TDM_ONBOARDING_DASHBOARD;
		}
	}

	/**
	 * 
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_DASHBOARDCR, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRDCR);
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
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASK_REQLISTDTO, tdgDtMaskRequestListDTOs);
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRDCR
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_ONBOARDING_DASHBOARDCR;
		}
		catch (ServiceException se)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			logger.error(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRDCR,
					TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.TDM_ONBOARDING_DASHBOARDCR;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_EXPORTFR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmOnBoardingExportFR(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{
		logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.ONBRD_EXPORTFR
				+ MessageConstants.LOG_INFO_RETURN);
		return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
				TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, tdgDtMaskRequestListDTOfr);
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMONBOARDING_EXPORTCR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmOnBoardingExportCR(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{
		logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.DTMSK_DASHBRDCR
				+ MessageConstants.LOG_INFO_RETURN);
		return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
				TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, tdgDtMaskRequestListDTOcr);
	}

	/**
	 * 
	 * @param reqId
	 * @param request
	 * @param response
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_CANCEL_ONBOARDREQ, method = RequestMethod.POST)
	@ResponseBody
	public String tdmCancelOnboardReq(
			@RequestParam(value = TDMConstants.REQ_ID, required = false) String reqId,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.CANCEL_ONBRDREQ);
			boolean isConcelled = dataMaskingService.cancelOnBoardingRequest(reqId);
			if (isConcelled)
			{
				logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.CANCEL_ONBRDREQ
						+ MessageConstants.LOG_INFO_RETURN + isConcelled);
				return TDMConstants.TRUE;
			}
			else
			{
				logger.info(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.CANCEL_ONBRDREQ
						+ MessageConstants.LOG_INFO_RETURN + isConcelled);
				return TDMConstants.FALSE;
			}
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode().equals(TDMExceptionCode.NORESULT))
			{
				logger.error(MessageConstants.ONBRDREQ_CNTRL + MessageConstants.CANCEL_ONBRDREQ,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.ERROR;
		}
	}
}
