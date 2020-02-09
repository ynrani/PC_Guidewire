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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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
import com.tdm.model.DTO.TdgDataMaskingNoOfAppsDTO;
import com.tdm.service.TDMDataMaskingService;
import com.tdm.util.PaginationUtil;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Controller
public class TDMMaskingController
{
	private static Logger logger = Logger.getLogger(TDMMaskingController.class);

	@Resource(name = MessageConstant.SERVICE_MSK)
	TDMDataMaskingService tdmDataMaskingService;

	/**
	 * 
	 * @param reqId
	 * @param status
	 * @param edit
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_1_NEW, method = RequestMethod.GET)
	public String tdmDataMaskingReqDtlGet(
			@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId,
			@RequestParam(value = AppConstant.STATUS, required = false) String status,
			@RequestParam(value = AppConstant.EDIT, required = false) String edit,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR
				+ MessageConstant.LOG_INFO_PARAMS_YES + reqId);
		boolean reqTypeCR = false;
		boolean checkexistingReq = false;
		try {
			if (null == reqId) {
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
							AppConstant.SESSION_UID));
					checkexistingReq = tdmDataMaskingService
							.getCheckExistingReqYesNo(tdgDataMaskingDTO);
					if (!checkexistingReq) {
						tdgDataMaskingDTO = tdmDataMaskingService.getUserDetails(tdgDataMaskingDTO);
						if (null != (String) request.getSession().getAttribute(
								AppConstant.SESSION_PROJ)) {
							tdgDataMaskingDTO.setProjectId((String) request.getSession()
									.getAttribute(AppConstant.SESSION_PROJ));
						}
					}
				}
			} else {
				if (null == status) {
					reqTypeCR = true;
				}
				if (null != edit) {
					tdgDataMaskingDTO.setEdit(edit);
				}
				tdgDataMaskingDTO.setId(reqId);
				tdgDataMaskingDTO.setReqTypeCR(reqTypeCR);
				tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, true,
						false, false);
			}
			if (null != status) {
				if (status.equalsIgnoreCase(AppConstant.SUBMITTED)) {
					tdgDataMaskingDTO.setStatus(status);
					model.addAttribute(AppConstant.READ_ONLY, true);
				}
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					if (checkexistingReq) {
						return AppConstant.TDM_DATA_MASKING_REDIRECT_DASHBOARD + checkexistingReq;
					} else {
						return AppConstant.TDM_DATA_MASKING_1_NEW_VIEW;
					}
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.TGD_DT_MASK_DTO, tdgDataMaskingDTO);
			if (checkexistingReq) {
				return AppConstant.TDM_DATA_MASKING_REDIRECT_DASHBOARD + checkexistingReq;
			} else {
				return AppConstant.TDM_DATA_MASKING_1_NEW_VIEW;
			}
		}
		model.addAttribute(AppConstant.TGD_DT_MASK_DTO, tdgDataMaskingDTO);
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR
				+ MessageConstant.LOG_INFO_RETURN);
		if (checkexistingReq) {
			return AppConstant.TDM_DATA_MASKING_REDIRECT_DASHBOARD + checkexistingReq;
		} else {
			return AppConstant.TDM_DATA_MASKING_1_NEW_VIEW;
		}
	}

	/**
	 * 
	 * @param submitType
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_1_NEW, method = RequestMethod.POST)
	public String tdmDataMaskingReqDtlPost(
			@RequestParam(value = AppConstant.SUBMIT, required = false) String submitType,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_CTLR_POST
				+ MessageConstant.LOG_INFO_PARAMS_YES + submitType);
		try {
			if (null != submitType) {
				if (submitType.equalsIgnoreCase(AppConstant.SAVE_AND_CONTI)) {
					tdgDataMaskingDTO = tdmDataMaskingService.saveReqDtls(tdgDataMaskingDTO, true,
							false, false);
				} else if (!submitType.equalsIgnoreCase(AppConstant.SAVE_AND_CONTI)) {
					model.addAttribute(AppConstant.READ_ONLY, true);
				}
			}
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_POST + MessageConstant.LOG_INFO_REDIRECT);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_POST + MessageConstant.LOG_INFO_PARAMS_YES
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();

				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_PAGE2_REDIRECT + tdgDataMaskingDTO.getId()
							+ AppConstant.TDM_DATA_MASKING_PARAM_STS
							+ tdgDataMaskingDTO.getStatus();
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_PAGE2_REDIRECT + tdgDataMaskingDTO.getId()
					+ AppConstant.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
		}
		return AppConstant.TDM_DATA_MASKING_PAGE2_REDIRECT + tdgDataMaskingDTO.getId()
				+ AppConstant.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
	}

	/**
	 * 
	 * @param reqId
	 * @param status
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_2_NEW, method = RequestMethod.GET)
	public String tdmDataMaskingPreReqGet(
			@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId,
			@RequestParam(value = AppConstant.STATUS, required = false) String status,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_PRE_CTLR_GET
				+ MessageConstant.LOG_INFO_PARAMS_YES + reqId);
		try {
			tdgDataMaskingDTO.setId(reqId);
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, false, true,
					false);
			if (null != status) {
				if (status.equalsIgnoreCase(AppConstant.SUBMITTED)) {
					tdgDataMaskingDTO.setStatus(status);
					model.addAttribute(AppConstant.READ_ONLY, true);
				}
			}
			model.addAttribute(AppConstant.TGD_DT_MASK_DTO, tdgDataMaskingDTO);
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_PRE_CTLR_GET + MessageConstant.LOG_INFO_RETURN);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_PRE_CTLR_GET + MessageConstant.LOG_INFO_PARAMS_YES
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();

				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_2_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_2_NEW_VIEW;
		}
		return AppConstant.TDM_DATA_MASKING_2_NEW_VIEW;

	}

	/**
	 * 
	 * @param submit
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_2_NEW, method = RequestMethod.POST)
	public String tdmDataMaskingPreReqPost(
			@RequestParam(value = AppConstant.SUBMIT, required = false) String submit,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_PRE_CTLR_POST + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			if (null != submit) {
				if (submit.equalsIgnoreCase(AppConstant.SAVE_AND_CONTI)) {
					tdgDataMaskingDTO = tdmDataMaskingService.saveReqDtls(tdgDataMaskingDTO, false,
							true, false);
				} else if (!submit.equalsIgnoreCase(AppConstant.SAVE_AND_CONTI)) {
					model.addAttribute(AppConstant.READ_ONLY, true);
				}
			}
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_PRE_CTLR_POST + MessageConstant.LOG_INFO_REDIRECT);
			if (null != submit && !submit.equalsIgnoreCase(AppConstant.BACK)) {
				return AppConstant.TDM_DATA_MASKING_PAGE3_REDIRECT + tdgDataMaskingDTO.getId()
						+ AppConstant.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
			} else {
				return AppConstant.TDM_DATA_MASKING_PAGE1_REDIRECT + tdgDataMaskingDTO.getId()
						+ AppConstant.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_PRE_CTLR_POST
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_2_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_2_NEW_VIEW;
		}
	}

	/**
	 * 
	 * @param reqId
	 * @param status
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_3_NEW, method = RequestMethod.GET)
	public String tdmDataMaskingMskDtlGet(
			@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId,
			@RequestParam(value = AppConstant.STATUS, required = false) String status,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER + MessageConstant.TDM_DT_MSK_DTL_CTLR_GET
				+ MessageConstant.LOG_INFO_PARAMS_YES + reqId);
		tdgDataMaskingDTO.setId(reqId);
		try {
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, false, false,
					true);
			if (null != status) {
				if (status.equalsIgnoreCase(AppConstant.SUBMITTED)) {
					tdgDataMaskingDTO.setStatus(status);
					model.addAttribute(AppConstant.READ_ONLY, true);
				}
			}
			if ((StringUtils.isEmpty(status) && reqId.contains(AppConstant.CR))
					|| StringUtils.isNotEmpty(tdgDataMaskingDTO.getChngReqCmmt())) {
				if (null == tdgDataMaskingDTO.getTdgDataMaskingNoOfAppsDTOs()) {
					List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
					TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
					tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
					tdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
				} else {
					tdgDataMaskingDTO.getTdgDataMaskingNoOfAppsDTOs().add(
							new TdgDataMaskingNoOfAppsDTO());
				}
				model.addAttribute(AppConstant.CHANGE_Y_N, true);
			}
			model.addAttribute(AppConstant.TGD_DT_MASK_DTO, tdgDataMaskingDTO);
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_DTL_CTLR_GET + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_DATA_MASKING_3_NEW_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_DTL_CTLR_GET + MessageConstant.LOG_ERROR_EXCEPTION
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_3_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_3_NEW_VIEW;
		}

	}

	/**
	 * 
	 * @param submit
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_3_NEW, method = RequestMethod.POST)
	@ResponseBody
	public String tdmDataMaskingMskDtlPost(
			@RequestParam(value = AppConstant.SUBMIT, required = false) String submit,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_DTL_CTLR_POST + MessageConstant.LOG_INFO_PARAMS_YES
				+ submit);
		try {
			tdgDataMaskingDTO = tdmDataMaskingService.saveReqDtls(tdgDataMaskingDTO, false, false,
					true);
			model.addAttribute(AppConstant.DISABLED, AppConstant.TRUE);
			model.addAttribute(AppConstant.TGD_DT_MASK_DTO, tdgDataMaskingDTO);
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_DTL_CTLR_POST + MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTO.getId();
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_DTL_CTLR_POST
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return tdgDataMaskingDTO.getId();
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return tdgDataMaskingDTO.getId();
		}
	}

	/**
	 * 
	 * @param tdgDataMaskingDTO
	 * @param reqId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_3_NEW_EXPORT, method = RequestMethod.GET)
	public ModelAndView tdmMaskingExportFRGet(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_FR_GET
				+ MessageConstant.LOG_INFO_PARAMS_YES + reqId);
		List<TdgDataMaskingDTO> list = null;
		try {
			tdgDataMaskingDTO.setId(reqId);
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, true, true,
					true);
			if (null == tdgDataMaskingDTO.getTdgDataMaskingDTOs()) {
				list = new ArrayList<TdgDataMaskingDTO>();
				list.add(tdgDataMaskingDTO);
			} else {
				list = tdgDataMaskingDTO.getTdgDataMaskingDTOs();
			}
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_FR_GET
					+ MessageConstant.LOG_INFO_DOWNLOAD);
			return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
					AppConstant.TDM_DATA_MASKING_DTOS, list);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_FR_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
							AppConstant.TDM_DATA_MASKING_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
					AppConstant.TDM_DATA_MASKING_DTOS, list);
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
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_DASH_BOARD, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(
			@RequestParam(value = AppConstant.PAGE, required = false) String page,
			@RequestParam(value = AppConstant.FLAG, required = false) String flag,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD + MessageConstant.LOG_INFO_PARAMS_SEPC
				+ page);
		String type = AppConstant.FR;
		Long totalRecords = 0L;
		try {
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
			totalRecords = tdmDataMaskingService.getReservedRecordsCount(
					tdgDataMaskingDTO.getUserId(), type);
			tdgDataMaskingDTO = tdmDataMaskingService.getAllDtMaskRequestedRecordForPagination(
					offSet, recordsperpage, true, tdgDataMaskingDTO, type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS,
					tdgDataMaskingDTO.getTdgDataMaskingDTOs());
			model.addAttribute(AppConstant.FLAG, flag);
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_DTL_CTLR_GET + MessageConstant.LOG_INFO_PARAMS_YES
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_DASH_BOARD_VIEW;
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
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_ONBOARD_CR, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(
			@RequestParam(value = AppConstant.PAGE, required = false) String page,
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		String type = AppConstant.CR;
		Long totalRecords = 0L;
		try {
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
			totalRecords = tdmDataMaskingService.getReservedRecordsCount(
					tdgDataMaskingDTO.getUserId(), type);
			tdgDataMaskingDTO = tdmDataMaskingService.getAllDtMaskRequestedRecordForPagination(
					offSet, recordsperpage, true, tdgDataMaskingDTO, type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_DATA_MASKING_REQ_DTOS,
					tdgDataMaskingDTO.getTdgDataMaskingDTOs());
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD_CR
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_ONBOARD_CR_VIEW;
		}
	}

	/**
	 * 
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_FR, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView tdmMaskingExportFR(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_FR + MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdgDataMaskingDTO> list = null;
		try {
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
			String type = AppConstant.FR;
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtlsforExport(tdgDataMaskingDTO,
					true, true, true, type);
			if (null == tdgDataMaskingDTO.getTdgDataMaskingDTOs()) {
				list = new ArrayList<TdgDataMaskingDTO>();
				list.add(tdgDataMaskingDTO);
			} else {
				list = tdgDataMaskingDTO.getTdgDataMaskingDTOs();
			}
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_FR + MessageConstant.LOG_INFO_DOWNLOAD);
			return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
					AppConstant.TDM_DATA_MASKING_DTOS, list);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_FR
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
							AppConstant.TDM_DATA_MASKING_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
					AppConstant.TDM_DATA_MASKING_DTOS, list);
		}
	}

	/**
	 * 
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_CR, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView tdmMaskingExportCR(
			@ModelAttribute(AppConstant.TGD_DT_MASK_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_CR + MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdgDataMaskingDTO> list = null;
		try {
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
			String type = AppConstant.CR;
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtlsforExport(tdgDataMaskingDTO,
					true, true, true, type);
			if (null == tdgDataMaskingDTO.getTdgDataMaskingDTOs()) {
				list = new ArrayList<TdgDataMaskingDTO>();
				list.add(tdgDataMaskingDTO);
			} else {
				list = tdgDataMaskingDTO.getTdgDataMaskingDTOs();
			}
			logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_CR + MessageConstant.LOG_INFO_DOWNLOAD);
			return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
					AppConstant.TDM_DATA_MASKING_DTOS, list);

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_CTLR_EXPORT_CR
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
							AppConstant.TDM_DATA_MASKING_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return new ModelAndView(AppConstant.TDM_DATA_MASKING_DASH_BOARD_XLS,
					AppConstant.TDM_DATA_MASKING_DTOS, list);
		}
	}

	@RequestMapping(value = AppConstant.TDM_DATA_MASKING_3_CANCEL, method = RequestMethod.GET)
	public String tdmDtMaskCancelReq(
			@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_DT_MSK_CONTROLLER
				+ MessageConstant.TDM_DT_MSK_CTLR_DASH_BOARD + MessageConstant.LOG_INFO_PARAMS_YES);
		try {
			tdmDataMaskingService.dtMaskCancelReq(reqId);

			return AppConstant.TDM_DATA_MASKING_REDIRECT_DASHBOARD + "T";
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_DT_MSK_CONTROLLER
					+ MessageConstant.TDM_DT_MSK_DTL_CTLR_GET + MessageConstant.LOG_INFO_PARAMS_YES
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_DATA_MASKING_REDIRECT_DASHBOARD + "F";
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_DATA_MASKING_REDIRECT_DASHBOARD + "F";
		}
	}
}
