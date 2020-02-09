/*---------------------------------------------------------------------------------------
 * Object Name: TdmRequestAdminController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/01/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
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

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.model.DTO.TdgDataMaskingDTO;
import com.tdm.service.TDMDataMaskingService;
import com.tdm.util.PaginationUtil;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Controller
public class TdmRequestAdminController
{
	private static Logger logger = Logger.getLogger(TdmRequestAdminController.class);

	@Resource(name = MessageConstant.SERVICE_MSK)
	TDMDataMaskingService tdmDataMaskingService;

	/**
	 * 
	 * @param page
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_DASH_BOARD_ADM, method = RequestMethod.GET)
	public String tdmDtMaskDashboardAdmin(@RequestParam(value = AppConstant.PAGE, required = false) String page,
			@RequestParam(value = AppConstant.FLAG, required = false) String flag,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		String type = AppConstant.FR;
		Long totalRecords = 0L;
		try {
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(AppConstant.SESSION_UID));
			totalRecords = tdmDataMaskingService.getReservedRecordsCount(tdgDataMaskingDTO.getUserId(), type,
					statusBasedOnUser(request));
			tdgDataMaskingDTO = tdmDataMaskingService.getAllDtMaskRequestedRecordForPagination(offSet, recordsperpage,
					true, tdgDataMaskingDTO, type, statusBasedOnUser(request));
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS, tdgDataMaskingDTO.getTdgDataMaskingDTOs());
			model.addAttribute(AppConstant.FLAG, flag);
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW_ADM;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_DTL_CTLR_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW_ADM;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW_ADM;
		}
	}

	/**
	 * 
	 * @param page
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_ONBOARD_CR_ADM, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCRAdmin(@RequestParam(value = AppConstant.PAGE, required = false) String page,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		String type = AppConstant.CR;
		Long totalRecords = 0L;
		try {
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(AppConstant.SESSION_UID));
			totalRecords = tdmDataMaskingService.getReservedRecordsCount(tdgDataMaskingDTO.getUserId(), type,
					statusBasedOnUser(request));
			tdgDataMaskingDTO = tdmDataMaskingService.getAllDtMaskRequestedRecordForPagination(offSet, recordsperpage,
					true, tdgDataMaskingDTO, type, statusBasedOnUser(request));
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS, tdgDataMaskingDTO.getTdgDataMaskingDTOs());
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW_ADM;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW_ADM;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW_ADM;
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_GET_ADM, method = RequestMethod.GET)
	public String tdmDtMaskDashboardAdmin(@RequestParam(value = AppConstant.PAGE, required = false) String page,
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
					.getAttribute(AppConstant.SESSION_UID), type, statusBasedOnUser(request));
			List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOs = tdmDataMaskingService
					.getAllOnBoardRequestedRecordForPagination(offSet, recordsperpage, true, (String) request
							.getSession().getAttribute(AppConstant.SESSION_UID), type, statusBasedOnUser(request));
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS, tdgDtMaskRequestListDTOs);
			logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW_ADM;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW_ADM;
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW_ADM;
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_CR_ADM, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCRAdmin(@RequestParam(value = AppConstant.PAGE, required = false) String page,
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
					.getAttribute(AppConstant.SESSION_UID), type, statusBasedOnUser(request));
			List<TdgDataMaskingDTO> tdgDtMaskRequestListDTOs = tdmDataMaskingService
					.getAllOnBoardRequestedRecordForPagination(offSet, recordsperpage, true, (String) request
							.getSession().getAttribute(AppConstant.SESSION_UID), type, statusBasedOnUser(request));
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS, tdgDtMaskRequestListDTOs);
			logger.info(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_MSK_DASHBOARD_CR
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW_ADM;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_MSK_DASHBOARD_CR
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW_ADM;
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW_ADM;
		}
	}

	@RequestMapping(value = "/popupRequestApprove", method = RequestMethod.GET)
	public String popupRequestApproveGet(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_POPUP
				+ type);

		tdgDataMaskingDTO.setId(id);
		tdgDataMaskingDTO.setType(type);
		tdgDataMaskingDTO.setUrl(url);

		model.addAttribute("tdgDataMaskingDTO", tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_RETURN);

		return "popupRequestApprove";
	}

	@RequestMapping(value = "/popupRequestApprove", method = RequestMethod.POST)
	public String popupRequestApprovePost(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_POPUP
				+ type);

		try {
			tdmDataMaskingService.updateRequestStatus(tdgDataMaskingDTO,
					(String) request.getSession().getAttribute(AppConstant.SESSION_UID), "In-Progress");
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:" + tdgDataMaskingDTO.getUrl();
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return "redirect:" + tdgDataMaskingDTO.getUrl();
		}

		model.addAttribute("tdgDataMaskingDTO", tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_RETURN);

		return "redirect:" + tdgDataMaskingDTO.getUrl();
	}

	@RequestMapping(value = "/popupRequestDecline", method = RequestMethod.GET)
	public String popupRequestDeclineGet(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_POPUP
				+ type);

		tdgDataMaskingDTO.setId(id);
		tdgDataMaskingDTO.setType(type);
		tdgDataMaskingDTO.setUrl(url);
		model.addAttribute("tdgDataMaskingDTO", tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_RETURN);

		return "popupRequestDecline";
	}

	@RequestMapping(value = "/popupRequestDecline", method = RequestMethod.POST)
	public String popupRequestDeclinePost(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_POPUP
				+ type);
		try {
			tdmDataMaskingService.updateRequestStatus(tdgDataMaskingDTO,
					(String) request.getSession().getAttribute(AppConstant.SESSION_UID), "Rejected");
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:" + tdgDataMaskingDTO.getUrl();
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return "redirect:" + tdgDataMaskingDTO.getUrl();
		}
		model.addAttribute("tdgDataMaskingDTO", tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_RETURN);

		return "redirect:" + tdgDataMaskingDTO.getUrl();
	}

	@RequestMapping(value = "/popupRequestComplete", method = RequestMethod.GET)
	public String popupRequestCompleteGet(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_POPUP
				+ type);

		tdgDataMaskingDTO.setId(id);
		tdgDataMaskingDTO.setType(type);
		tdgDataMaskingDTO.setUrl(url);
		model.addAttribute("tdgDataMaskingDTO", tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_RETURN);

		return "popupRequestComplete";
	}

	@RequestMapping(value = "/popupRequestComplete", method = RequestMethod.POST)
	public String popupRequestCompletePost(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO, ModelMap model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_POPUP
				+ type);
		try {
			tdmDataMaskingService.updateRequestStatus(tdgDataMaskingDTO,
					(String) request.getSession().getAttribute(AppConstant.SESSION_UID), "Completed");
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:" + tdgDataMaskingDTO.getUrl();
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return "redirect:" + tdgDataMaskingDTO.getUrl();
		}
		model.addAttribute("tdgDataMaskingDTO", tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_GET_EMAIL + MessageConstant.LOG_INFO_RETURN);

		return "redirect:" + tdgDataMaskingDTO.getUrl();
	}

	private String statusBasedOnUser(HttpServletRequest request) {

		String userRole = (String) request.getSession().getAttribute(AppConstant.ROLE);
		String sts = null;
		if (userRole.equalsIgnoreCase(AppConstant.ROLE_TDMUSER)) {
			sts = "In-Progress";
		} else if (userRole.equalsIgnoreCase(AppConstant.ROLE_TDMADMIN)) {
			sts = "Submitted";
		}
		return sts;
	}

}
