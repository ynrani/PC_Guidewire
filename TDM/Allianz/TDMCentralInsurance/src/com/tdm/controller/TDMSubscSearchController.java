/*---------------------------------------------------------------------------------------
 * Object Name: TDMSubscSearchController.Java
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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
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
public class TDMSubscSearchController
{
	private static Logger logger = Logger.getLogger(TDMSubscSearchController.class);
	private int noOfRecPerPage = 5;
	private TDMSubscSearchDTO tDMSubscSearchDTO1 = null;

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;

	/**
	 * 
	 * @param tDMSubscSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_SUB, method = RequestMethod.GET)
	public String findTestSubscDataGet(
			@ModelAttribute(MessageConstant.TDM_SUB_SEARCH_DTO) TDMSubscSearchDTO tDMSubscSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tDMSubscSearchDTO = searchManagementService.dropdownValuesSubsc(tDMSubscSearchDTO);
			model.addAttribute(MessageConstant.TDM_SUB_SEARCH_DTO, tDMSubscSearchDTO);
			logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_GET
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_SUB_VIEW;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_GET
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_SUB_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			model.addAttribute(MessageConstant.TDM_SUB_SEARCH_DTO, tDMSubscSearchDTO);
			return AppConstant.TDM_FTD_SUB_VIEW;
		}
	}

	/**
	 * 
	 * @param tDMSubscSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_SUB_BACK, method = RequestMethod.GET)
	public String findTestSubscDataBack(
			@ModelAttribute(MessageConstant.TDM_SUB_SEARCH_DTO) TDMSubscSearchDTO tDMSubscSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_BACK
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != tDMSubscSearchDTO1) {
				tDMSubscSearchDTO = tDMSubscSearchDTO1;
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
				}
				Long totalRecords = 0L;
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = Integer.parseInt(tDMSubscSearchDTO.getSearchRecordsNo());
				noOfRecPerPage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tDMSubscSearchDTO = searchManagementService.searchSubscRecords(tDMSubscSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchSubscrRecordsCount(tDMSubscSearchDTO,
						userName);
				if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscriberId())
						|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getSsn())
						|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getDob())
						|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanID())
						|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanName())
						|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getContractCode())
						|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getTermDate())) {
					tDMSubscSearchDTO.setShowHideFlag(true);
				}
				pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
				request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
				model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
				model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
				model.addAttribute(AppConstant.COUNT, tDMSubscSearchDTO.getCount());
				model.addAttribute(MessageConstant.TDM_SUB_SEARCH_DTO, tDMSubscSearchDTO);
				model.addAttribute(AppConstant.TOT_RECS, totalRecords);
				model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
						tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
				logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_BACK
						+ MessageConstant.LOG_INFO_RETURN);
				return AppConstant.TDM_FTD_SUB_VIEW;
			} else {
				return AppConstant.TDM_FTD_SUB_REDIRECT;
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_BACK
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_SUB_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMSubscSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_SUB_SEARCH_DTO, tDMSubscSearchDTO);
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			return AppConstant.TDM_FTD_SUB_VIEW;
		}
	}

	/**
	 * 
	 * @param search
	 * @param reserve
	 * @param tDMSubscSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_SUB, method = RequestMethod.POST)
	public String findTestSubscDataPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_SUB_SEARCH_DTO) TDMSubscSearchDTO tDMSubscSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tDMSubscSearchDTO.getSearchRecordsNo());
			noOfRecPerPage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tDMSubscSearchDTO = searchManagementService.searchSubscRecords(tDMSubscSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchSubscrRecordsCount(tDMSubscSearchDTO,
						userName);

			} else if (null != reserve) {
				if (null != userName) {
					tDMSubscSearchDTO.setUserId(userName);
				}
				int cntRec = searchManagementService.saveReservedData(tDMSubscSearchDTO);
				totalRecords = searchManagementService.searchSubscrRecordsCount(tDMSubscSearchDTO,
						userName);
				tDMSubscSearchDTO = searchManagementService.searchSubscRecords(tDMSubscSearchDTO,
						offSet, recordsperpage, true, userName);
				reserveFlag = cntRec + AppConstant.TDM_FTD_REC_SUCCESS1
						+ tDMSubscSearchDTO.getTestCaseId() + AppConstant.TDM_FTD_REC_SUCCESS2
						+ tDMSubscSearchDTO.getTestCaseName();
				tDMSubscSearchDTO.setTestCaseId(null);
				tDMSubscSearchDTO.setTestCaseName(null);
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscriberId())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getSsn())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getDob())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanID())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanName())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getContractCode())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getTermDate())) {
				tDMSubscSearchDTO.setShowHideFlag(true);
			}
			tDMSubscSearchDTO = searchManagementService.dropdownValuesSubsc(tDMSubscSearchDTO);
			tDMSubscSearchDTO1 = tDMSubscSearchDTO;
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(AppConstant.COUNT, tDMSubscSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_SUB_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_SUB_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMSubscSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			return AppConstant.TDM_FTD_SUB_VIEW;
		}
	}

	/**
	 * 
	 * @param tDMSubscSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_SUB, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestSubscDataExport(
			@ModelAttribute(MessageConstant.TDM_SUB_SEARCH_DTO) TDMSubscSearchDTO tDMSubscSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_EXPORT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		List<TDMSubscSearchResultListDTO> list = null;
		try {
			if (null != tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs()
					&& 0 < tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs().size()) {
				list = new ArrayList<TDMSubscSearchResultListDTO>();
				for (int i = 0; i < tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs().size(); i++) {
					if (null != tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs().get(i)
							.getReservedYN()) {
						tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs().get(i)
								.setUserId(UserId);
						list.add(tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs().get(i));
					}
				}
			}
			tDMSubscSearchDTO = searchManagementService.dropdownValuesSubsc(tDMSubscSearchDTO);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_EXPORT
					+ MessageConstant.LOG_INFO_RETURN);
			return new ModelAndView(MessageConstant.TDM_SUB_EXPO_XLS,
					MessageConstant.TDM_SUB_RESULT_DTOS, list);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_EXPO_XLS
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(MessageConstant.TDM_SUB_EXPO_XLS,
							MessageConstant.TDM_SUB_RESULT_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			return new ModelAndView(MessageConstant.TDM_SUB_EXPO_XLS,
					MessageConstant.TDM_SUB_RESULT_DTOS, list);
		}
	}

	/**
	 * 
	 * @param tDMSubscSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_SUB, method = RequestMethod.GET, params = AppConstant.PAGE)
	public String findTestSubscDataPagiNation(
			@ModelAttribute(MessageConstant.TDM_SUB_SEARCH_DTO) TDMSubscSearchDTO tDMSubscSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_PAGENATION
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			tDMSubscSearchDTO = tDMSubscSearchDTO1;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecPerPage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tDMSubscSearchDTO = searchManagementService.searchSubscRecords(tDMSubscSearchDTO,
					offSet, recordsperpage, true, userName);
			totalRecords = searchManagementService.searchSubscrRecordsCount(tDMSubscSearchDTO,
					userName);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscriberId())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getSsn())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getDob())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanID())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanName())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getContractCode())
					|| StringUtils.isNotEmpty(tDMSubscSearchDTO.getTermDate())) {
				tDMSubscSearchDTO.setShowHideFlag(true);
			}
			model.addAttribute(AppConstant.COUNT, tDMSubscSearchDTO.getCount());
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_SUB_SEARCH_DTO, tDMSubscSearchDTO);
			logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_PAGENATION
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_SUB_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_SUB_FTD_PAGENATION
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_SUB_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.COUNT, tDMSubscSearchDTO.getCount());
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMSubscSearchDTO));
			model.addAttribute(MessageConstant.TDM_SUB_RESULT_DTOS,
					tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_SUB_SEARCH_DTO, tDMSubscSearchDTO);
			return AppConstant.TDM_FTD_SUB_VIEW;
		}
	}

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param tDMSubscSearchDTO
	 * @return
	 */
	public String getSearchCriteria(TDMSubscSearchDTO tDMSubscSearchDTO) {
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String searchCriteria = "";
		if (null != tDMSubscSearchDTO) {
			searchCriteria += "Search Result for: ";
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getEnvType())) {
				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tDMSubscSearchDTO.getEnvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscType())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.type", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscGender())) {
				searchCriteria += " + " + messageSource.getMessage("label.gender", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscGender() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscStatus())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.status", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscStatus() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscState())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.state", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscState() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscLOB())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.lob", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscLOB() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscZip())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.zip", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscZip() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscAgeStart())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.subc.between", null, null) + " : "
						+ tDMSubscSearchDTO.getSubscAgeStart() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscAgeEnd())) {
				searchCriteria += " to " + tDMSubscSearchDTO.getSubscAgeEnd() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscWithCOB())) {
				searchCriteria += " + With COB ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscriberId())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.subcId", null, null)
						+ " : " + tDMSubscSearchDTO.getSubscriberId() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSsn())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.ssn", null, null)
						+ " : " + tDMSubscSearchDTO.getSsn() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getDob())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.dob", null, null)
						+ " : " + tDMSubscSearchDTO.getDob() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanID())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.planid", null, null)
						+ " : " + tDMSubscSearchDTO.getPlanID() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanName())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.subc.plnname", null, null) + " : "
						+ tDMSubscSearchDTO.getPlanName() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getTermDate())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.trmDt", null, null)
						+ " : " + tDMSubscSearchDTO.getTermDate() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getContractCode())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.subc.contractCode", null, null) + " : "
						+ tDMSubscSearchDTO.getContractCode() + "  ";
			}
		}
		logger.info(MessageConstant.TDM_SUB_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_RETURN);
		return searchCriteria;
	}
}
