/*---------------------------------------------------------------------------------------
 * Object Name: TDMClaimSearchController.Java
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
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMClaimSearchResultListDTO;
import com.tdm.service.TDMProviserSearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class TDMClaimSearchController
{
	private static Logger logger = Logger.getLogger(TDMClaimSearchController.class);
	private int noOfRecPerPage = 5;
	private TDMClaimSearchDTO tDMClaimSearchDTO1 = null;

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;

	/**
	 * 
	 * @param tDMClaimcSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLM, method = RequestMethod.GET)
	public String findTestClaimDataGet(
			@ModelAttribute(MessageConstant.TDM_CLM_SEARCH_DTO) TDMClaimSearchDTO tDMClaimcSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tDMClaimcSearchDTO = searchManagementService.dropdownValuesClaim(tDMClaimcSearchDTO);
			model.addAttribute(MessageConstant.TDM_CLM_SEARCH_DTO, tDMClaimcSearchDTO);
			logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_GET
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_CLM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_GET
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			model.addAttribute(MessageConstant.TDM_CLM_SEARCH_DTO, tDMClaimcSearchDTO);
			return AppConstant.TDM_FTD_CLM_VIEW;
		}
	}

	/**
	 * 
	 * @param tDMClaimcSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLM_BACK, method = RequestMethod.GET)
	public String findTestClaimDataBack(
			@ModelAttribute(MessageConstant.TDM_CLM_SEARCH_DTO) TDMClaimSearchDTO tDMClaimcSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_BACK
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != tDMClaimSearchDTO1) {
				tDMClaimcSearchDTO = tDMClaimSearchDTO1;
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
				}
				Long totalRecords = 0L;
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = Integer.parseInt(tDMClaimcSearchDTO.getSearchRecordsNo());
				noOfRecPerPage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tDMClaimcSearchDTO = searchManagementService.searchClaimRecords(tDMClaimcSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchClaimRecordsCount(tDMClaimcSearchDTO,
						userName);
				if (StringUtils.isNotEmpty(tDMClaimcSearchDTO.getClaimAuthOn())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getClaimWithCOB())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getClaimRefOn())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getClaimIntOn())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getSubscriberId())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getRcptdt())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getTypeOfBill())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getStatusCode())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getAdmissiondt())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getDischargedt())
						|| StringUtils.isNotEmpty(tDMClaimcSearchDTO.getClaimId())) {
					tDMClaimcSearchDTO.setShowHideFlag(true);
				}
				pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
						recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
				request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
				model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
				model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimcSearchDTO));
				model.addAttribute(AppConstant.COUNT, tDMClaimcSearchDTO.getCount());
				model.addAttribute(AppConstant.COUNT, tDMClaimcSearchDTO);
				model.addAttribute(AppConstant.TOT_RECS, totalRecords);
				model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
						tDMClaimcSearchDTO.gettDMClaimSearchResultListDTOs());
				logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_BACK
						+ MessageConstant.LOG_INFO_RETURN);
				return AppConstant.TDM_FTD_CLM_VIEW;
			} else {
				return AppConstant.TDM_FTD_CLM_REDIRECT;
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_BACK
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimcSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMClaimcSearchDTO.getCount());
			model.addAttribute(AppConstant.COUNT, tDMClaimcSearchDTO);
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimcSearchDTO.gettDMClaimSearchResultListDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_CLM_VIEW;
		}
	}

	/**
	 * 
	 * @param search
	 * @param reserve
	 * @param tDMClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLM, method = RequestMethod.POST)
	public String findTestClaimDataPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_CLM_SEARCH_DTO) TDMClaimSearchDTO tDMClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tDMClaimSearchDTO.getSearchRecordsNo());
			noOfRecPerPage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tDMClaimSearchDTO = searchManagementService.searchClaimRecords(tDMClaimSearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = searchManagementService.searchClaimRecordsCount(tDMClaimSearchDTO,
						userName);
			} else if (null != reserve) {
				if (null != userName) {
					tDMClaimSearchDTO.setUserId(userName);
				}
				int cntRec = searchManagementService.saveReservedData(tDMClaimSearchDTO);
				totalRecords = searchManagementService.searchClaimRecordsCount(tDMClaimSearchDTO,
						userName);
				tDMClaimSearchDTO = searchManagementService.searchClaimRecords(tDMClaimSearchDTO,
						offSet, recordsperpage, true, userName);
				reserveFlag = cntRec + AppConstant.TDM_FTD_REC_SUCCESS1
						+ tDMClaimSearchDTO.getTestCaseId() + AppConstant.TDM_FTD_REC_SUCCESS2
						+ tDMClaimSearchDTO.getTestCaseName();
				tDMClaimSearchDTO.setTestCaseId(null);
				tDMClaimSearchDTO.setTestCaseName(null);
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimAuthOn())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimWithCOB())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimRefOn())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimIntOn())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getSubscriberId())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getRcptdt())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getTypeOfBill())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getStatusCode())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getAdmissiondt())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getDischargedt())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimId())) {
				tDMClaimSearchDTO.setShowHideFlag(true);
			}
			tDMClaimSearchDTO = searchManagementService.dropdownValuesClaim(tDMClaimSearchDTO);
			tDMClaimSearchDTO1 = tDMClaimSearchDTO;
			pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMClaimSearchDTO.getCount());
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs());
			logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_CLM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimSearchDTO));
			model.addAttribute(AppConstant.COUNT, tDMClaimSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs());
			return AppConstant.TDM_FTD_CLM_VIEW;
		}
	}

	/**
	 * 
	 * @param tDMClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLM, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestClaimDataExport(
			@ModelAttribute(MessageConstant.TDM_CLM_SEARCH_DTO) TDMClaimSearchDTO tDMClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_EXPORT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TDMClaimSearchResultListDTO> list = null;
		int count = 0;
		try {
			if (null != tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs()
					&& 0 < tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs().size()) {
				list = new ArrayList<TDMClaimSearchResultListDTO>();
				for (int i = 0; i < tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs().size(); i++) {
					if (null != tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs().get(i)
							.getReservedYN()) {
						list.add(tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs().get(i));
						count++;
					}
				}
			}
			tDMClaimSearchDTO = searchManagementService.dropdownValuesClaim(tDMClaimSearchDTO);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimSearchDTO));
			model.addAttribute(AppConstant.COUNT, count);
			logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_EXPORT
					+ MessageConstant.LOG_INFO_RETURN);
			return new ModelAndView(MessageConstant.TDM_CLAIM_EXPO_XLS,
					MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS, list);
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_EXPORT
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return new ModelAndView(MessageConstant.TDM_CLAIM_EXPO_XLS,
							MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimSearchDTO));
			model.addAttribute(AppConstant.COUNT, count);
			return new ModelAndView(MessageConstant.TDM_CLAIM_EXPO_XLS,
					MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS, list);
		}
	}

	/**
	 * 
	 * @param tDMClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLM, method = RequestMethod.GET, params = AppConstant.PAGE)
	public String findTestClaimDataPagiNation(
			@ModelAttribute(MessageConstant.TDM_CLM_SEARCH_DTO) TDMClaimSearchDTO tDMClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_PAGENATION
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			tDMClaimSearchDTO = tDMClaimSearchDTO1;
			System.out.println("TDMClaimSearchController class findTestClaimDataPagiNation page");
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecPerPage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tDMClaimSearchDTO = searchManagementService.searchClaimRecords(tDMClaimSearchDTO,
					offSet, recordsperpage, true, userName);
			totalRecords = searchManagementService.searchClaimRecordsCount(tDMClaimSearchDTO,
					userName);
			pagenation.paginate(totalRecords, request, (Double.valueOf(recordsperpage)),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimAuthOn())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimWithCOB())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimRefOn())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimIntOn())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getSubscriberId())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getRcptdt())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getTypeOfBill())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getStatusCode())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getAdmissiondt())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getDischargedt())
					|| StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimId())) {
				tDMClaimSearchDTO.setShowHideFlag(true);
			}
			model.addAttribute(AppConstant.COUNT, tDMClaimSearchDTO.getCount());
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimSearchDTO));
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs());
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_CLM_SEARCH_DTO, tDMClaimSearchDTO);
			logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_PAGENATION
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_CLM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_CLM_FTD_EXPORT
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.COUNT, tDMClaimSearchDTO.getCount());
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tDMClaimSearchDTO));
			model.addAttribute(MessageConstant.TDM_CLM_RESULT_DTOS,
					tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs());
			model.addAttribute(MessageConstant.TDM_CLM_SEARCH_DTO, tDMClaimSearchDTO);
			return AppConstant.TDM_FTD_CLM_VIEW;
		}
	}

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param tDMClaimSearchDTO
	 * @return
	 */
	public String getSearchCriteria(TDMClaimSearchDTO tDMClaimSearchDTO) {
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String searchCriteria = "";
		if (null != tDMClaimSearchDTO) {
			searchCriteria += "Search Result for: ";
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getEnvType())) {
				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tDMClaimSearchDTO.getEnvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimType())) {
				searchCriteria += " + " + messageSource.getMessage("label.claim.type", null, null)
						+ " : " + tDMClaimSearchDTO.getClaimType() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimSource())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.source", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimSource() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimDXCode())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.claimdxCode", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimDXCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimProcCode())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.proc.code", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimProcCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimRevCode())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.revenueCode", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimRevCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimModifier())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.modifier", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimModifier() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimProviderTIN())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.claimProviderTIN", null, null)
						+ " : " + tDMClaimSearchDTO.getClaimProviderTIN() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimProviderNPI())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.provider.NPI", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimProviderNPI() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimPOS())) {
				searchCriteria += " + " + messageSource.getMessage("label.claim.pos", null, null)
						+ " : " + tDMClaimSearchDTO.getClaimPOS() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimStatus())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.status", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimStatus() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimGrpNum())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.groupnum", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimGrpNum() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimGender())) {
				searchCriteria += " + " + messageSource.getMessage("label.gender", null, null)
						+ " : " + tDMClaimSearchDTO.getClaimGender() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getSubscriberId())) {
				searchCriteria += " + " + messageSource.getMessage("label.subc.subcId", null, null)
						+ " : " + tDMClaimSearchDTO.getSubscriberId() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getRcptdt())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.rcptdt", null, null) + " : "
						+ tDMClaimSearchDTO.getRcptdt() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getTypeOfBill())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.typeOfBill", null, null) + " : "
						+ tDMClaimSearchDTO.getTypeOfBill() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getAdmissiondt())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.admissiondt", null, null) + " : "
						+ tDMClaimSearchDTO.getAdmissiondt() + "  ";
			}
			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getDischargedt())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.dischargedt", null, null) + " : "
						+ tDMClaimSearchDTO.getDischargedt() + "  ";
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimId())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.claimId", null, null) + " : "
						+ tDMClaimSearchDTO.getClaimId() + "  ";
			}
		}
		logger.info(MessageConstant.TDM_CLM_CTLR + MessageConstant.TDM_FTD_SEARCH_CRITERIA
				+ MessageConstant.LOG_INFO_RETURN);
		return searchCriteria;
	}
}
