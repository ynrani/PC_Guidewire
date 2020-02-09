/*---------------------------------------------------------------------------------------
 * Object Name: TDMMyReservationController.Java
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
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMClaimSearchResultListDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMProvSearchResultListDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchResultListDTO;
import com.tdm.service.TDMProviserSearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
@Scope("session")
public class TDMMyReservationController
{
	private static Logger logger = Logger.getLogger(TDMMyReservationController.class);

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;
	List<TDMProvSearchResultListDTO> tdmProvReservationSearchResultListDTO = null;
	List<TDMSubscSearchResultListDTO> tdmSubscReservationSearchResultListDTO = null;
	List<TDMClaimSearchResultListDTO> tdmClaimReservationSearchResultListDTO = null;

	/**
	 * 
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_PROV, method = RequestMethod.GET)
	public String myReservationRecord(
			@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_REC
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			TDMProvSearchDTO tDMProvSearchDTO = searchManagementService.getReservedRecordForUser(
					UserId, offSet, recordsperpage, true);
			String searchType = AppConstant.PROV;
			totalRecords = searchManagementService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			tdmProvReservationSearchResultListDTO = tDMProvSearchDTO
					.gettDMProvSearchResultListDTOs();
			logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_PROV_VIEW;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_PROV_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_PROV_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_PROV_UNREV, method = RequestMethod.GET)
	public String unreserveRecord(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			searchManagementService.unReservedRecordForUser(Long.valueOf(request
					.getParameter(AppConstant.ID)));
			TDMProvSearchDTO tDMProvSearchDTO = searchManagementService.getReservedRecordForUser(
					UserId, offSet, recordsperpage, true);
			String searchType = AppConstant.PROV;
			totalRecords = searchManagementService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			tdmProvReservationSearchResultListDTO = tDMProvSearchDTO
					.gettDMProvSearchResultListDTOs();
			logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_PROV_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_PROV_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_PROV_VIEW;
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
	@RequestMapping(value = AppConstant.TDM_REV_SUB, method = RequestMethod.GET)
	public String myReservationSubc(
			@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_SUB
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			String searchType = AppConstant.SUB;
			TDMSubscSearchDTO tDMSubscSearchDTO = searchManagementService
					.getReservedRecordForUserSubc(UserId, offSet, recordsperpage, true);
			totalRecords = searchManagementService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			tdmSubscReservationSearchResultListDTO = tDMSubscSearchDTO
					.gettDMSubscSearchResultListDTOs();
			logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_SUB
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_SUB_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_SUB_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_SUB_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_SUB_UNREV, method = RequestMethod.GET)
	public String unreserveRecordSubc(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {

		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE_SUB
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			String searchType = AppConstant.SUB;
			searchManagementService.unReservedRecordForUser(Long.valueOf(request
					.getParameter(AppConstant.ID)));
			TDMSubscSearchDTO tDMSubscSearchDTO = searchManagementService
					.getReservedRecordForUserSubc(UserId, offSet, recordsperpage, true);
			totalRecords = searchManagementService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			tdmSubscReservationSearchResultListDTO = tDMSubscSearchDTO
					.gettDMSubscSearchResultListDTOs();
			logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE_SUB
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_SUB_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_SUB_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_SUB_VIEW;
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
	@RequestMapping(value = AppConstant.TDM_REV_CLM, method = RequestMethod.GET)
	public String myReservationClaim(
			@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_CLM
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			String searchType = AppConstant.CLM;
			TDMClaimSearchDTO tDMClaimSearchDTO = searchManagementService
					.getReservedRecordForUserClaim(UserId, offSet, recordsperpage, true);

			totalRecords = searchManagementService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs());
			tdmClaimReservationSearchResultListDTO = tDMClaimSearchDTO
					.gettDMClaimSearchResultListDTOs();
			logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_CLM
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_CLM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_CLM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_CLM_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_CLM_UNREV, method = RequestMethod.GET)
	public String unreserveRecordClaim(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE_CLM
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			String searchType = AppConstant.CLM;
			searchManagementService.unReservedRecordForUser(Long.valueOf(request
					.getParameter(AppConstant.ID)));
			TDMClaimSearchDTO tDMClaimSearchDTO = searchManagementService
					.getReservedRecordForUserClaim(UserId, offSet, recordsperpage, true);
			totalRecords = searchManagementService.getReservedRecordsCount(searchType, UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs());
			tdmClaimReservationSearchResultListDTO = tDMClaimSearchDTO
					.gettDMClaimSearchResultListDTOs();
			logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE_CLM
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_REV_CLM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_UNRESERVE_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_REV_CLM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_REV_CLM_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_CLM_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestClaimReservedDataExport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_CLM_EXPORT
				+ MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(MessageConstant.TDM_CLM_EXPO_XLS,
				MessageConstant.TDM_CLM_RESULT_DTOS, tdmClaimReservationSearchResultListDTO);
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_SUB_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestSubscReservedDataExport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_SUB_EXPORT
				+ MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(MessageConstant.TDM_SUB_EXPO_XLS,
				MessageConstant.TDM_SUB_RESULT_DTOS, tdmSubscReservationSearchResultListDTO);
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_REV_PROV_EXPO, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestProvReservedDataExport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_CTRL + MessageConstant.TDM_RESV_PROV_EXPORT
				+ MessageConstant.LOG_INFO_EXPORT);
		return new ModelAndView(MessageConstant.TDM_PROV_EXPO_XLS,
				MessageConstant.TDM_PROV_RESULT_EXPO_DTOS, tdmProvReservationSearchResultListDTO);
	}
}
