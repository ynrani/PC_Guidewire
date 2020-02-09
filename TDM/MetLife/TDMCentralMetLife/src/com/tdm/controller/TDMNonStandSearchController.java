/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonStandSearchController.Java
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import com.tdm.model.DTO.TdmNonStandSearchDTO;
import com.tdm.service.TDMProviserSearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
@Scope("session")
public class TDMNonStandSearchController
{
	private static Logger logger = Logger.getLogger(TDMNonStandSearchController.class);
	private int noOfRecPerPage = 5;
	private TdmNonStandSearchDTO tdmNonStandSearchDTO1 = null;

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_NS, method = RequestMethod.GET)
	public String findTestDataGetNonStand(
			@ModelAttribute(MessageConstant.TDM_NS_SEARCH_DTO) TdmNonStandSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tdmNonStandSearchDTO = searchManagementService
					.getAllDropdownValues(tdmNonStandSearchDTO);
			model.addAttribute(MessageConstant.TDM_NS_SEARCH_DTO, tdmNonStandSearchDTO);
			logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_GET
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_NS_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_GET
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_NS_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(MessageConstant.TDM_NS_SEARCH_DTO, tdmNonStandSearchDTO);
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_NS_VIEW;
		}
	}

	/**
	 * 
	 * @param search
	 * @param reserve
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_NS, method = RequestMethod.POST)
	public String findTestDataNonStandPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_NS_SEARCH_DTO) TdmNonStandSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_POST
				+ MessageConstant.LOG_INFO_SEARCH + search);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tdmNonStandSearchDTO.getSearchRecordsNo());
			recordsperpage = recordsperpage / 2;
			noOfRecPerPage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tdmNonStandSearchDTO = searchManagementService.searcNonStandRecords(
						tdmNonStandSearchDTO, offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchNonStandRecordsCount(
						tdmNonStandSearchDTO, userName);
			} else if (null != reserve) {
				int cntRec = searchManagementService.saveReservedDataNonStand(tdmNonStandSearchDTO,
						userName);
				totalRecords = searchManagementService.searchNonStandRecordsCount(
						tdmNonStandSearchDTO, userName);
				tdmNonStandSearchDTO = searchManagementService.searcNonStandRecords(
						tdmNonStandSearchDTO, offSet, recordsperpage, true, userName);
				reserveFlag = cntRec + AppConstant.TDM_FTD_REC_SUCCESS1
						+ tdmNonStandSearchDTO.getTestCaseId() + AppConstant.TDM_FTD_REC_SUCCESS2
						+ tdmNonStandSearchDTO.getTestCaseName();
				tdmNonStandSearchDTO.setTestCaseId(null);
				tdmNonStandSearchDTO.setTestCaseName(null);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getMedicareId())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTin())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTermDate())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getEffectiveDate())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getContractCode())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getGender())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSubscriberId())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProviderId())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSsn())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTin())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getDob())) {
				tdmNonStandSearchDTO.setShowHideFlag(true);
			}
			tdmNonStandSearchDTO = searchManagementService
					.getAllDropdownValues(tdmNonStandSearchDTO);
			tdmNonStandSearchDTO.setProvSpecType(tdmNonStandSearchDTO.getProvSpecType());
			tdmNonStandSearchDTO1 = tdmNonStandSearchDTO;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			model.addAttribute(AppConstant.COUNT, tdmNonStandSearchDTO.getCount());
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
			logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_NS_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_NS_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			model.addAttribute(AppConstant.COUNT, tdmNonStandSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_NS_VIEW;
		}
	}

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_NS, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestDataNonStandExport(
			@ModelAttribute(MessageConstant.TDM_NS_SEARCH_DTO) TdmNonStandSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_EXPORT
				+ MessageConstant.LOG_INFO_EXPORT);
		int count = 0;
		try {
			tdmNonStandSearchDTO = searchManagementService
					.getAllDropdownValues(tdmNonStandSearchDTO);
			tdmNonStandSearchDTO.setProvSpecType(tdmNonStandSearchDTO.getProvSpecType());
			model.addAttribute(AppConstant.COUNT, count);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_EXPORT
					+ MessageConstant.LOG_INFO_RETURN);
			return new ModelAndView(MessageConstant.TDM_PROV_EXPO_XLS,
					MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_EXPORT
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(MessageConstant.TDM_PROV_EXPO_XLS,
							MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
							tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.COUNT, count);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return new ModelAndView(MessageConstant.TDM_PROV_EXPO_XLS,
					MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
		}
	}

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_NS, method = RequestMethod.GET, params = AppConstant.PAGE)
	public String findTestDataNonStandPagiNation(
			@ModelAttribute(MessageConstant.TDM_NS_SEARCH_DTO) TdmNonStandSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_PAGENATION
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			tdmNonStandSearchDTO = tdmNonStandSearchDTO1;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecPerPage;
			recordsperpage = recordsperpage / 2;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmNonStandSearchDTO = searchManagementService.searcNonStandRecords(
					tdmNonStandSearchDTO, offSet, recordsperpage, true, userName);
			totalRecords = searchManagementService.searchNonStandRecordsCount(tdmNonStandSearchDTO,
					userName);
			pagenation.paginate(totalRecords, request, (double) (recordsperpage), recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getMedicareId())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTin())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTermDate())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getEffectiveDate())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getContractCode())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getGender())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSubscriberId())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProviderId())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSsn())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTin())
					|| StringUtils.isNotEmpty(tdmNonStandSearchDTO.getDob())) {
				tdmNonStandSearchDTO.setShowHideFlag(true);
			}
			tdmNonStandSearchDTO.setProvSpecType(tdmNonStandSearchDTO.getProvSpecType());
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_NS_SEARCH_DTO, tdmNonStandSearchDTO);
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_PAGENATION
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_NS_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_PAGENATION
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_NS_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tdmNonStandSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_NS_SEARCH_DTO, tdmNonStandSearchDTO);
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_NS_VIEW;
		}
	}

	/**
	 * 
	 * @param value
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_NS_DROPDOWN, method = RequestMethod.GET)
	public @ResponseBody List<String> dropdownSpecialtyNonStand(
			@RequestParam(value = AppConstant.VALUE) String value, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_DROPDOWN
				+ MessageConstant.LOG_INFO_PARAMS_YES + value);
		List<String> list = null;
		try {
			if (null != value) {
				list = searchManagementService.dropdownSpecialty(value);
			}
			logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_DROPDOWN
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_NS_FTD_DROPDOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return list;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return list;
		}
	}

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @return
	 */
	public String getSearchCriteria(TdmNonStandSearchDTO tdmNonStandSearchDTO) {
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String searchCriteria = "";
		if (null != tdmNonStandSearchDTO) {
			searchCriteria += "Search Result for: ";
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getEnvType())) {
				searchCriteria += " " + tdmNonStandSearchDTO.getEnvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvType())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getProvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvCatgType())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getProvCatgType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvSpecType())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getProvSpecType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvState())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getProvState() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvContract())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getProvContract() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvZip())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getProvZip() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getEffectiveDate())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getEffectiveDate() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTermDate())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getTermDate() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getTin())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getTin() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getMedicareId())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getMedicareId() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getContractCode())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getContractCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getGender())) {
				searchCriteria += " + " + tdmNonStandSearchDTO.getGender() + "  ";
			}
		}
		logger.info(MessageConstant.TDM_NS_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_RETURN);
		return searchCriteria;
	}
}
