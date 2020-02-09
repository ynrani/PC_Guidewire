/*---------------------------------------------------------------------------------------
 * Object Name: TDMMaskingController.Java
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
public class TdmGrphDashboardController
{
	private static Logger logger = Logger.getLogger(TdmGrphDashboardController.class);

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
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_DASH_BOARD_LST, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(@RequestParam(value = AppConstant.PAGE, required = false) String page,
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
			return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW_LST;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_DTL_CTLR_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW_LST;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW_LST;
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
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_ONBOARD_CR_LST, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(@RequestParam(value = AppConstant.PAGE, required = false) String page,
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
			return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW_LST;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW_LST;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW_LST;
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_GET_LST, method = RequestMethod.GET)
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
			return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW_LST;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_ONBOARDING_DASHBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW_LST;
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ONBOARD_REQ_DASH_VIEW_LST;
		}
	}

	@RequestMapping(value = AppConstant.TDM_ONBOARD_REQ_DASH_CR_LST, method = RequestMethod.GET)
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
			return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW_LST;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ONBOARDING_REQ_CTLR + MessageConstant.TDM_MSK_DASHBOARD_CR
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW_LST;
				}
			}

			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ONBOARD_REQ_DASH_CR_VIEW_LST;
		}
	}

	private String statusBasedOnUser(HttpServletRequest request) {

		String userRole = (String) request.getSession().getAttribute(AppConstant.ROLE);
		String sts = null;
		if (userRole.equalsIgnoreCase(AppConstant.ROLE_TDMADMIN) || userRole.equalsIgnoreCase(AppConstant.ROLE_ADMIN)) {
			sts = "A";
		} else {
			sts = "U";
		}
		return sts;
	}
}
