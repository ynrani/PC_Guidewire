/*---------------------------------------------------------------------------------------
 * Object Name: TDMOnBoardReqController.Java
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

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.model.DTO.TdgDataMaskingDTO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;
import com.tdm.service.TDMDataMaskingService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */
@Controller
@Scope("session")
public class TDMOnBoardReqController
{

	private static Logger logger = Logger.getLogger(TDMOnBoardReqController.class);

	List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOfr = null;
	List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOcr = null;

	@Resource(name = MessageConstant.SERVICE_MSK)
	TDMDataMaskingService tdmDataMaskingService;

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_GET, method = RequestMethod.GET)
	public String tdmGetOnboardReq(@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId,
			@ModelAttribute(AppConstant.TDM_ONBOARDING_REQ_DTO) TdmOnBoardReqDTO tdmOnboardReqDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal) throws BaseException {
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_REQ_GET
				+ MessageConstant.LOG_INFO_REQ_ID + reqId);
		boolean chngeReqYN = false;
		try {
			if (StringUtils.isNotEmpty(reqId)) {
				tdmOnboardReqDTO = tdmDataMaskingService.getEditableDetails(reqId);
				chngeReqYN = true;
			} else {
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					tdmOnboardReqDTO.setUserId((String) request.getSession().getAttribute(AppConstant.SESSION_UID));
					tdmOnboardReqDTO = tdmDataMaskingService.getUserDetails(
							(String) request.getSession().getAttribute(AppConstant.SESSION_UID), tdmOnboardReqDTO);
					if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_PROJ)) {
						tdmOnboardReqDTO.setAppName((String) request.getSession()
								.getAttribute(AppConstant.SESSION_PROJ));
					}
				}
				chngeReqYN = false;
			}

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_REQ_GET
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.CHANGE_YN, chngeReqYN);
			model.addAttribute(AppConstant.REQ_ID, tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(AppConstant.TDM_ONBOARDING_REQ_DTO, tdmOnboardReqDTO);
			return AppConstant.TDM_ONBOARD_REQ_VIEW;
		}
		model.addAttribute(AppConstant.CHANGE_YN, chngeReqYN);
		model.addAttribute(AppConstant.REQ_ID, tdmOnboardReqDTO.getOnboardReqId());
		model.addAttribute(AppConstant.TDM_ONBOARDING_REQ_DTO, tdmOnboardReqDTO);
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_REQ_GET
				+ MessageConstant.LOG_INFO_RETURN);
		return AppConstant.TDM_ONBOARD_REQ_VIEW;

	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_GET, method = RequestMethod.POST)
	@ResponseBody
	public String tdmPostOnboardReq(
			@ModelAttribute(AppConstant.TDM_ONBOARDING_REQ_DTO) TdmOnBoardReqDTO tdmOnboardReqDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal) throws BaseException {
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_REQ_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		boolean chngeReqYN = false;
		try {
			tdmOnboardReqDTO = tdmDataMaskingService.getSaveOnboardingReq(tdmOnboardReqDTO);
			if (StringUtils.isNotEmpty(tdmOnboardReqDTO.getChngReqCmmt())) {
				chngeReqYN = true;
			}
			model.addAttribute(AppConstant.REQ_ID, tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(AppConstant.CHANGE_YN, chngeReqYN);
			logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_REQ_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnboardReqDTO.getOnboardReqId();
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_REQ_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return tdmOnboardReqDTO.getOnboardReqId();
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.REQ_ID, tdmOnboardReqDTO.getOnboardReqId());
			model.addAttribute(AppConstant.CHANGE_YN, chngeReqYN);
			return tdmOnboardReqDTO.getOnboardReqId();
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_GET, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(@RequestParam(value = AppConstant.PAGE, required = false) String page,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		String type = AppConstant.FR;
		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = 10;
		try {
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = tdmDataMaskingService.getReservedRecordsCountOnBoard((String) request.getSession()
					.getAttribute(AppConstant.SESSION_UID), type, "U");
			List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOs = tdmDataMaskingService
					.getAllOnBoardRequestedRecordForPagination(offSet, recordsperpage, true, (String) request
							.getSession().getAttribute(AppConstant.SESSION_UID), type, "U");
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			tdgDtMaskRequestListDTOfr = tdgDtMaskRequestListDTOs;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS, tdgDtMaskRequestListDTOs);
			logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW;
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW;
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_CR, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(@RequestParam(value = AppConstant.PAGE, required = false) String page,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_MSK_DASHBOARD_CR
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		String type = AppConstant.CR;
		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = 10;
		try {
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = tdmDataMaskingService.getReservedRecordsCountOnBoard((String) request.getSession()
					.getAttribute(AppConstant.SESSION_UID), type, "U");
			List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOs = tdmDataMaskingService
					.getAllOnBoardRequestedRecordForPagination(offSet, recordsperpage, true, (String) request
							.getSession().getAttribute(AppConstant.SESSION_UID), type, "U");
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			tdgDtMaskRequestListDTOcr = tdgDtMaskRequestListDTOs;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS, tdgDtMaskRequestListDTOs);
			logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_MSK_DASHBOARD_CR
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_MSK_DASHBOARD_CR
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW;
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW;
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_FR_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView tdmOnBoardingExportFR(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD_FR
				+ MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS, AppConstant.TDM_DATA_MASKING_DTOS,
				tdgDtMaskRequestListDTOfr);
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_CR_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView tdmOnBoardingExportCR(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD_CR
				+ MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS, AppConstant.TDM_DATA_MASKING_DTOS,
				tdgDtMaskRequestListDTOcr);
	}
}
