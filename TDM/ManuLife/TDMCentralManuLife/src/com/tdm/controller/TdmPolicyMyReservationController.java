/*---------------------------------------------------------------------------------------
 * Object Name: TdmPolicyMyReservationController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          20/08/15  NA          Created
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.model.DTO.TdmClaimSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyClaimSearchDTO;
import com.tdm.model.DTO.TdmPolicySearchDTO;
import com.tdm.model.DTO.TdmPolicySearchResultDTO;
import com.tdm.service.TdmPolicySearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
@Scope("session")
public class TdmPolicyMyReservationController
{
	private static Logger logger = Logger.getLogger(TdmPolicyMyReservationController.class);

	@Resource(name = MessageConstant.TDM_POLICY_SEARCH_SERVICE)
	TdmPolicySearchService tdmPolicySearchService;

	List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs = null;
	List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs = null;

	/**
	 * 
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_POLICY, method = RequestMethod.GET)
	public String myReservationRecordPolicy(
			@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL + MessageConstant.TDM_RESV_POLICY_REC
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			TdmPolicySearchDTO tdmPolicySearchDTO = tdmPolicySearchService
					.getReservedRecordForUser(UserId, offSet, recordsperpage, true);
			String searchType = AppConstant.POLICY;
			totalRecords = tdmPolicySearchService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			tdmPolicySearchResultDTOs = tdmPolicySearchDTO.getTdmPolicySearchResultDTOs();
			logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL
					+ MessageConstant.TDM_RESV_POLICY_REC + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_POLICY_VIEW;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_POLICY_CTRL
					+ MessageConstant.TDM_RESV_POLICY_REC + MessageConstant.LOG_ERROR_EXCEPTION
					+ baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_POLICY_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_POLICY_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_POLICY_UNREV, method = RequestMethod.GET)
	public String unreserveRecordPolicy(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL
				+ MessageConstant.TDM_RESV_POLICY_UNRESERVE + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmPolicySearchService.unReservedRecordForUser(request.getParameter(AppConstant.ID));
			TdmPolicySearchDTO tdmPolicySearchDTO = tdmPolicySearchService
					.getReservedRecordForUser(UserId, offSet, recordsperpage, true);
			String searchType = AppConstant.PROV;
			totalRecords = tdmPolicySearchService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			tdmPolicySearchResultDTOs = tdmPolicySearchDTO.getTdmPolicySearchResultDTOs();
			logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL
					+ MessageConstant.TDM_RESV_POLICY_UNRESERVE + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_POLICY_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_POLICY_CTRL
					+ MessageConstant.TDM_RESV_POLICY_UNRESERVE
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_POLICY_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_POLICY_VIEW;
		}
	}

	/**
	 * 
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_CLAIM, method = RequestMethod.GET)
	public String myReservationClaim(
			@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL + MessageConstant.TDM_RESV_CLAIM
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			String searchType = AppConstant.SUB;
			TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO = tdmPolicySearchService
					.getReservedRecordForUserClaim(UserId, offSet, recordsperpage, true);
			totalRecords = tdmPolicySearchService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			tdmClaimSearchResultDTOs = tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs();
			logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL + MessageConstant.TDM_RESV_CLAIM
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_CLAIM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_POLICY_CTRL + MessageConstant.TDM_RESV_CLAIM
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_CLAIM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_CLAIM_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_CLAIM_UNREV, method = RequestMethod.GET)
	public String unreserveRecordClaim(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {

		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL
				+ MessageConstant.TDM_RESV_UNRESERVE_CLAIM + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			String searchType = AppConstant.CLAIM;
			tdmPolicySearchService.unReservedRecordForUser(request.getParameter(AppConstant.ID));
			TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO = tdmPolicySearchService
					.getReservedRecordForUserClaim(UserId, offSet, recordsperpage, true);
			totalRecords = tdmPolicySearchService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			tdmClaimSearchResultDTOs = tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs();
			logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL
					+ MessageConstant.TDM_RESV_UNRESERVE_CLAIM + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_CLAIM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_POLICY_CTRL
					+ MessageConstant.TDM_RESV_UNRESERVE_CLAIM
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_CLAIM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_CLAIM_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_POLICY_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestPolicyReservedDataExport(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL
				+ MessageConstant.TDM_RESV_POLICY_EXPORT + MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(MessageConstant.TDM_POLICY_EXPO_XLS,
				MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS, tdmPolicySearchResultDTOs);
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_CLAIM_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestClaimReservedDataExport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL + MessageConstant.TDM_RESV_CLAIM_EXPORT
				+ MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(MessageConstant.TDM_CLAIM_EXPO_XLS,
				MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS, tdmClaimSearchResultDTOs);
	}
}
