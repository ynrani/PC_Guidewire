/*---------------------------------------------------------------------------------------
 * Object Name: TDMProviderSearchController.Java
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMProvSearchResultListDTO;
import com.tdm.service.TDMProviserSearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
@Scope("session")
public class TDMProviderSearchController
{
	private static Logger logger = Logger.getLogger(TDMProviderSearchController.class);
	private int noOfRecPerPage = 5;
	private TDMProvSearchDTO tDMProvSearchDTO1 = null;

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;

	/**
	 * 
	 * @param tDMProvSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_PROV, method = RequestMethod.GET)
	public String findTestDataGet(
			@ModelAttribute(MessageConstant.TDM_PROV_SEARCH_DTO) TDMProvSearchDTO tDMProvSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tDMProvSearchDTO = searchManagementService.dropdownValues(tDMProvSearchDTO);
			model.addAttribute(MessageConstant.TDM_PROV_SEARCH_DTO, tDMProvSearchDTO);
			logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_GET
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_PROV_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_GET
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_PROV_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(MessageConstant.TDM_PROV_SEARCH_DTO, tDMProvSearchDTO);
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_PROV_VIEW;
		}
	}

	/**
	 * 
	 * @param tDMProvSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_PROV_BACK, method = RequestMethod.GET)
	public String findTestDataBack(
			@ModelAttribute(MessageConstant.TDM_PROV_SEARCH_DTO) TDMProvSearchDTO tDMProvSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_BACK
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != tDMProvSearchDTO1) {
				tDMProvSearchDTO = tDMProvSearchDTO1;
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
				}
				Long totalRecords = 0L;
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = Integer.parseInt(tDMProvSearchDTO.getSearchRecordsNo());
				noOfRecPerPage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tDMProvSearchDTO = searchManagementService.searchProviderRecords(tDMProvSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchProviderRecordsCount(tDMProvSearchDTO,
						userName);
				pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
				if (StringUtils.isNotEmpty(tDMProvSearchDTO.getMedicareId())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTin())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTaxonomyCode())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTermDate())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getNip())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getEffectiveDate())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getContractCode())
						|| StringUtils.isNotEmpty(tDMProvSearchDTO.getGender())) {
					tDMProvSearchDTO.setShowHideFlag(true);
				}
				tDMProvSearchDTO.setProvSpecType(tDMProvSearchDTO.getProvSpecType());
				request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
				model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
				model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
				model.addAttribute(AppConstant.COUNT, tDMProvSearchDTO.getCount());
				model.addAttribute(MessageConstant.TDM_PROV_SEARCH_DTO, tDMProvSearchDTO);
				model.addAttribute(AppConstant.TOT_RECS, totalRecords);
				model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
						tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
				logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_BACK
						+ MessageConstant.LOG_INFO_RETURN);
				return AppConstant.TDM_FTD_PROV_VIEW;
			} else {
				return AppConstant.TDM_FTD_PROV_REDIRECT;
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_BACK
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_PROV_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMProvSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_PROV_SEARCH_DTO, tDMProvSearchDTO);
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_PROV_VIEW;
		}
	}

	/**
	 * 
	 * @param search
	 * @param reserve
	 * @param tDMProvSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_PROV, method = RequestMethod.POST)
	public String findTestDataPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_PROV_SEARCH_DTO) TDMProvSearchDTO tDMProvSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_POST
				+ MessageConstant.LOG_INFO_SEARCH + search);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tDMProvSearchDTO.getSearchRecordsNo());
			noOfRecPerPage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tDMProvSearchDTO = searchManagementService.searchProviderRecords(tDMProvSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchProviderRecordsCount(tDMProvSearchDTO,
						userName);
			} else if (null != reserve) {
				int cntRec = searchManagementService.saveReservedData(tDMProvSearchDTO, userName);
				tDMProvSearchDTO = searchManagementService.searchProviderRecords(tDMProvSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchProviderRecordsCount(tDMProvSearchDTO,
						userName);
				reserveFlag = cntRec + AppConstant.TDM_FTD_REC_SUCCESS1
						+ tDMProvSearchDTO.getTestCaseId() + AppConstant.TDM_FTD_REC_SUCCESS2
						+ tDMProvSearchDTO.getTestCaseName();
				tDMProvSearchDTO.setTestCaseId(null);
				tDMProvSearchDTO.setTestCaseName(null);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getMedicareId())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTin())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTaxonomyCode())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTermDate())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getNip())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getEffectiveDate())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getContractCode())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getGender())) {
				tDMProvSearchDTO.setShowHideFlag(true);
			}
			tDMProvSearchDTO = searchManagementService.dropdownValues(tDMProvSearchDTO);
			tDMProvSearchDTO.setProvSpecType(tDMProvSearchDTO.getProvSpecType());
			tDMProvSearchDTO1 = tDMProvSearchDTO;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
			model.addAttribute(AppConstant.COUNT, tDMProvSearchDTO.getCount());
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_PROV_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_PROV_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMProvSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_PROV_VIEW;
		}
	}

	/**
	 * 
	 * @param tDMProvSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = AppConstant.TDM_FTD_PROV, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestDataExport(
			@ModelAttribute(MessageConstant.TDM_PROV_SEARCH_DTO) TDMProvSearchDTO tDMProvSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_EXPORT
				+ MessageConstant.LOG_INFO_EXPORT);
		String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		List<TDMProvSearchResultListDTO> list = null;
		int count = 0;
		try {
			if (null != tDMProvSearchDTO.gettDMProvSearchResultListDTOs()
					&& 0 < tDMProvSearchDTO.gettDMProvSearchResultListDTOs().size()) {
				list = new ArrayList<TDMProvSearchResultListDTO>();
				for (int i = 0; i < tDMProvSearchDTO.gettDMProvSearchResultListDTOs().size(); i++) {
					if (null != tDMProvSearchDTO.gettDMProvSearchResultListDTOs().get(i)
							.getReservedYN()) {
						tDMProvSearchDTO.gettDMProvSearchResultListDTOs().get(i).setUserId(UserId);
						list.add(tDMProvSearchDTO.gettDMProvSearchResultListDTOs().get(i));
						count++;
					}
				}
			}
			tDMProvSearchDTO = searchManagementService.dropdownValues(tDMProvSearchDTO);
			tDMProvSearchDTO.setProvSpecType(tDMProvSearchDTO.getProvSpecType());
			model.addAttribute(AppConstant.COUNT, count);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_EXPORT
					+ MessageConstant.LOG_INFO_RETURN);
			return new ModelAndView(MessageConstant.TDM_PROV_EXPO_XLS,
					MessageConstant.TDM_PROV_RESULT_EXPO_DTOS, list);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(MessageConstant.TDM_PROV_FTD_POST,
							MessageConstant.TDM_PROV_RESULT_EXPO_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.COUNT, count);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return new ModelAndView(MessageConstant.TDM_PROV_EXPO_XLS,
					MessageConstant.TDM_PROV_RESULT_EXPO_DTOS, list);
		}
	}

	/**
	 * 
	 * @param tDMProvSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_PROV, method = RequestMethod.GET, params = AppConstant.PAGE)
	public String findTestDataPagiNation(
			@ModelAttribute(MessageConstant.TDM_PROV_SEARCH_DTO) TDMProvSearchDTO tDMProvSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_PAGENATION
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			String userName = null;
			tDMProvSearchDTO = tDMProvSearchDTO1;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecPerPage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tDMProvSearchDTO = searchManagementService.searchProviderRecords(tDMProvSearchDTO,
					offSet, recordsperpage, true, userName);
			totalRecords = searchManagementService.searchProviderRecordsCount(tDMProvSearchDTO,
					userName);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getMedicareId())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTin())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTaxonomyCode())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getTermDate())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getNip())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getEffectiveDate())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getContractCode())
					|| StringUtils.isNotEmpty(tDMProvSearchDTO.getGender())) {
				tDMProvSearchDTO.setShowHideFlag(true);
			}
			tDMProvSearchDTO.setProvSpecType(tDMProvSearchDTO.getProvSpecType());
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_PROV_SEARCH_DTO, tDMProvSearchDTO);
			logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_PAGENATION
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_PROV_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_PAGENATION
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_PROV_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMProvSearchDTO));
			model.addAttribute(MessageConstant.TDM_PROV_RESULT_EXPO_DTOS,
					tDMProvSearchDTO.gettDMProvSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_PROV_SEARCH_DTO, tDMProvSearchDTO);
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_PROV_VIEW;
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
	@RequestMapping(value = AppConstant.TDM_FTD_PROV_DROPDOWN, method = RequestMethod.GET)
	public @ResponseBody List<String> dropdownSpecialty(
			@RequestParam(value = AppConstant.VALUE) String value, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_DROPDOWN
				+ MessageConstant.LOG_INFO_PARAMS_YES + value);
		List<String> list = null;
		try {
			if (null != value) {
				list = searchManagementService.dropdownSpecialty(value);
			}
			logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_DROPDOWN
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_PROV_FTD_PAGENATION
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
	 * @param tDMProvSearchDTO
	 * @return
	 */
	public String getSearchCriteria(TDMProvSearchDTO tDMProvSearchDTO) {

		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String searchCriteria = "";
		if (null != tDMProvSearchDTO) {
			searchCriteria += "Search Result for: ";
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getEnvType())) {
				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tDMProvSearchDTO.getEnvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvType())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.type", null, null)
						+ " : " + tDMProvSearchDTO.getProvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvCatgType())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.cat", null, null)
						+ " : " + tDMProvSearchDTO.getProvCatgType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvSpecType())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.spec", null, null)
						+ " : " + tDMProvSearchDTO.getProvSpecType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvTypicalYn())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.prov.atypical", null, null) + " : "
						+ tDMProvSearchDTO.getProvTypicalYn() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvState())) {
				searchCriteria += " + " + messageSource.getMessage("label.state", null, null)
						+ " : " + tDMProvSearchDTO.getProvState() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getCoverage())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.prov.coverage", null, null) + " : "
						+ tDMProvSearchDTO.getCoverage() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvContract())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.prov.contract", null, null) + " : "
						+ tDMProvSearchDTO.getProvContract() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvEFTYn())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.eft", null, null)
						+ " : " + tDMProvSearchDTO.getProvEFTYn() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTaxonomyCode())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.taxo", null, null)
						+ " : " + tDMProvSearchDTO.getTaxonomyCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getEffectiveDate())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.effDt", null, null)
						+ " : " + tDMProvSearchDTO.getEffectiveDate() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTermDate())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.tmDt", null, null)
						+ " : " + tDMProvSearchDTO.getTermDate() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTin())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.tin", null, null)
						+ " : " + tDMProvSearchDTO.getTin() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getNip())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.npi", null, null)
						+ " : " + tDMProvSearchDTO.getNip() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getMedicareId())) {
				searchCriteria += " + " + messageSource.getMessage("label.prov.mdId", null, null)
						+ " : " + tDMProvSearchDTO.getMedicareId() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getContractCode())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.prov.contractCode", null, null) + " : "
						+ tDMProvSearchDTO.getContractCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getGender())) {
				searchCriteria += " + " + messageSource.getMessage("label.gender", null, null)
						+ " : " + tDMProvSearchDTO.getGender() + "  ";
			}
		}
		logger.info(MessageConstant.TDM_PROV_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_RETURN);
		return searchCriteria;
	}
}
