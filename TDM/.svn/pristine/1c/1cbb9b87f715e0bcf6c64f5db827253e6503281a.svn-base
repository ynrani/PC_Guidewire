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
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tdm.model.DTO.TdmReqTestDataDTO;
import com.tdm.service.TdmPolicyAutoPropSearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope("session")
public class TdmPolicyPropertySearchController
{

	final static Logger logger = Logger.getLogger(TdmPolicyPropertySearchController.class);
	private int noOfRecForpage = 25;
	private TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO1 = null;

	@Resource(name = "tdmPolicyAutoPropSearchService")
	TdmPolicyAutoPropSearchService tdmPolicyAutoSearchService;

	@RequestMapping(value = "/policyProp", method = RequestMethod.GET)
	public String policyPropGet(
			@ModelAttribute("tdmPolicyPropertySearchDTO") TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws BaseException {
		return "propertyPolicySearch";

	}

	@RequestMapping(value = "/policyProp", method = RequestMethod.POST)
	public String policyAutoPost(@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "reserve", required = false) String reserve,
			@ModelAttribute("tdmPolicyPropertySearchDTO") TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws BaseException {
		String userName = null;
		String reserveFlag = null;
		int countPerPage = 0;
		try {
			if (null != (String) request.getSession().getAttribute("UserId")) {
				userName = (String) request.getSession().getAttribute("UserId");
			}
			Long totalRecords = 0L;
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddYearBuilt())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddConType())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getZipCode())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getLeinIndi())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getOptnlCovge())) {
				tdmPolicyPropertySearchDTO.setShowHideFlag(true);
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocType())) {
				tdmPolicyPropertySearchDTO.setShowHideFlagDoc(true);
			}
			model.addAttribute("result", getSearchCriteria(tdmPolicyPropertySearchDTO));
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 25; // Integer.valueOf(tdmPolicyPropertySearchDTO.getSearchRecordsNo());
			noOfRecForpage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				if (logger.isInfoEnabled()) {
					logger.info("property controller searching records  : ");
				}
				tdmPolicyPropertySearchDTO = tdmPolicyAutoSearchService.searchPolicyPropRecordsByPolicySearchNew(
						tdmPolicyPropertySearchDTO, offSet, recordsperpage, true, userName);

			} else if (null != reserve) {
				if (logger.isInfoEnabled()) {
					logger.info("property controller reserving records  : ");
				}
				tdmPolicyPropertySearchDTO.setSearchCriti(getSearchCriteria(tdmPolicyPropertySearchDTO));
				int cntRec = tdmPolicyAutoSearchService.saveReservedData(tdmPolicyPropertySearchDTO, userName,
						tdmPolicyPropertySearchDTO.getEnvType());
				tdmPolicyPropertySearchDTO = tdmPolicyAutoSearchService.searchPolicyPropRecordsByPolicySearchNew(
						tdmPolicyPropertySearchDTO, offSet, recordsperpage, true, userName);
				reserveFlag = cntRec + " Record(s) successfully reserved for Test Case Id : "
						+ tdmPolicyPropertySearchDTO.getTestCaseId() + " and Test Case Name : "
						+ tdmPolicyPropertySearchDTO.getTestCaseName();
				tdmPolicyPropertySearchDTO.setTestCaseId(null);
				tdmPolicyPropertySearchDTO.setTestCaseName(null);
			}
			if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
					&& tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size() >= 25) {
				totalRecords = 50L;
			} else {
				totalRecords = 25L;
			}
			// set the size to no of records variable
			if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
					&& tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size() > 0) {
				countPerPage = tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size();
			}
			pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage), recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			tdmPolicyPropertySearchDTO1 = tdmPolicyPropertySearchDTO;
			request.setAttribute("noOfPages", noOfPages);
			model.addAttribute("reserveFlag", reserveFlag);
			model.addAttribute("totalRecords", countPerPage);
			model.addAttribute("count", tdmPolicyPropertySearchDTO.getCount());
			model.addAttribute("tdmPolicyPropertySearchResultDTOList",
					tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList());
			return "propertyPolicySearch";
		} catch (BaseException baseEx) {
			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "propertyPolicySearch";
			}
		}
		return "propertyPolicySearch";
	}

	@RequestMapping(value = "/policyProp", method = RequestMethod.GET, params = "page")
	public String policyAutoPagiNation(
			@ModelAttribute("tdmPolicyPropertySearchDTO") TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		if (logger.isInfoEnabled()) {
			logger.info("property controller reserving records  : ");
		}
		int countPerPage = 0;
		String userName = null;
		try {
			if (null != (String) request.getSession().getAttribute("UserId")) {
				userName = (String) request.getSession().getAttribute("UserId");
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddYearBuilt())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddConType())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getZipCode())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getLeinIndi())
					|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getOptnlCovge())) {
				tdmPolicyPropertySearchDTO.setShowHideFlag(true);
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocType())) {
				tdmPolicyPropertySearchDTO.setShowHideFlagDoc(true);
			}
			tdmPolicyPropertySearchDTO = tdmPolicyPropertySearchDTO1;
			model.addAttribute("result", getSearchCriteria(tdmPolicyPropertySearchDTO));
			Long totalRecords = 50L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecForpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmPolicyPropertySearchDTO = tdmPolicyAutoSearchService.searchPolicyPropRecordsByPolicySearchNew(
					tdmPolicyPropertySearchDTO, offSet, recordsperpage, true, userName);

			// set the size to no of records variable
			if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
					&& tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size() > 0) {
				countPerPage = tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size();
			}
			pagenation.paginate(totalRecords, request, (Double.valueOf(recordsperpage)), recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute("noOfPages", noOfPages);
			model.addAttribute("totalRecords", countPerPage);
			model.addAttribute("tdmPolicyPropertySearchResultDTOList",
					tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList());
			model.addAttribute("tdmPolicyPropertySearchDTO", tdmPolicyPropertySearchDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			return "propertyPolicySearch";
		}
		return "propertyPolicySearch";
	}

	@RequestMapping(value = "/policyPropBack", method = RequestMethod.GET)
	public String policyPropBack(
			@ModelAttribute("tdmPolicyPropertySearchDTO") TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, Principal principal) {

		if (logger.isInfoEnabled()) {
			logger.info("property controller click in Back button  : ");
		}
		int countPerPage = 0;
		String reserveFlag = null;
		String userName = null;
		try {
			if (null != tdmPolicyPropertySearchDTO1) {
				if (null != (String) request.getSession().getAttribute("UserId")) {
					userName = (String) request.getSession().getAttribute("UserId");
				}
				if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddYearBuilt())
						|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddConType())
						|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getZipCode())
						|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getLeinIndi())
						|| StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getOptnlCovge())) {
					tdmPolicyPropertySearchDTO.setShowHideFlag(true);
				}
				if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocType())) {
					tdmPolicyPropertySearchDTO.setShowHideFlagDoc(true);
				}
				tdmPolicyPropertySearchDTO = tdmPolicyPropertySearchDTO1;
				model.addAttribute("result", getSearchCriteria(tdmPolicyPropertySearchDTO));
				Long totalRecords = 0L;
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = 25;
				noOfRecForpage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tdmPolicyPropertySearchDTO = tdmPolicyAutoSearchService.searchPolicyPropRecordsByPolicySearchNew(
						tdmPolicyPropertySearchDTO, offSet, recordsperpage, true, userName);
				// set the size to no of records variable
				if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
						&& tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size() > 0) {
					countPerPage = tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size();
				}
				pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage), recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
				request.setAttribute("noOfPages", noOfPages);
				model.addAttribute("reserveFlag", reserveFlag);
				model.addAttribute("count", tdmPolicyPropertySearchDTO.getCount());
				model.addAttribute("totalRecords", countPerPage);
				model.addAttribute("tdmPolicyPropertySearchDTO", tdmPolicyPropertySearchDTO);
				model.addAttribute("tdmPolicyPropertySearchResultDTOList",
						tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList());
				return "propertyPolicySearch";
			} else {
				return "redirect:policyProp";
			}
		} catch (BaseException e) {
			e.printStackTrace();
			return "propertyPolicySearch";
		}
	}

	@RequestMapping(value = "/policyProp", method = RequestMethod.POST, params = "export")
	public ModelAndView policyPropExport(
			@ModelAttribute("tdmPolicyPropertySearchDTO") TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		if (logger.isInfoEnabled()) {
			logger.info("property controller click in Export button  : ");
		}
		String UserId = (String) request.getSession().getAttribute("UserId");
		List<TdmPolicyPropertySearchResultDTO> list = null;
		model.addAttribute("result", getSearchCriteria(tdmPolicyPropertySearchDTO));
		if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
				&& 0 < tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size()) {
			list = new ArrayList<TdmPolicyPropertySearchResultDTO>();
			for (int i = 0; i < tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size(); i++) {
				if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().get(i).getReservedYN()) {
					tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().get(i).setUserId(UserId);
					list.add(tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().get(i));
				}
			}
		}
		return new ModelAndView("searchPolicyPropListExcelView", "tdmPolicyPropertySearchResultDTOs", list);
	}

	@Autowired
	private MessageSource messageSource;

	public String getSearchCriteria(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO) {
		if (logger.isInfoEnabled()) {
			logger.info("property controller getting search criterai  : ");
		}
		String searchCriteria = "";

		if (null != tdmPolicyPropertySearchDTO) {
			searchCriteria += "Search Result for: ";

			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getEnvType())) {

				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getEnvType() + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyStage())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.stage", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getPolicyStage() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyTerm())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.term", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getPolicyTerm() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyState())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.state", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getPolicyState() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddproductType())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.prodType", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getAddproductType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddPolicyCovge())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.poliCov", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getAddPolicyCovge() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddPayMethod())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.payType", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getAddPayMethod() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddPayReq())) {
				String yorn = null;
				if (tdmPolicyPropertySearchDTO.getAddPayReq().equalsIgnoreCase("Y")) {
					yorn = "Yes";
				} else if (tdmPolicyPropertySearchDTO.getAddPayReq().equalsIgnoreCase("N")) {
					yorn = "No";
				} else {
					yorn = "Any";
				}

				searchCriteria += " + " + messageSource.getMessage("label.policy.assoPayReqAdd", null, null) + " : "
						+ yorn + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocReq())) {
				String yorn = null;
				if (tdmPolicyPropertySearchDTO.getAddDocReq().equalsIgnoreCase("Y")) {
					yorn = "Yes";
				} else if (tdmPolicyPropertySearchDTO.getAddDocReq().equalsIgnoreCase("N")) {
					yorn = "No";
				} else {
					yorn = "Any";
				}

				searchCriteria += " + " + messageSource.getMessage("label.policy.assoDoc", null, null) + " : " + yorn
						+ "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocType())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.docTypeAdd", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getAddDocType() + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddYearBuilt())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.year", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getAddYearBuilt() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddConType())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.consType", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getAddConType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getZipCode())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.zipCode", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getZipCode() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getLeinIndi())) {

				String yorn = null;
				if (tdmPolicyPropertySearchDTO.getLeinIndi().equalsIgnoreCase("Y")) {
					yorn = "Yes";
				} else {
					yorn = "No";
				}

				searchCriteria += " + " + messageSource.getMessage("label.policy.leiindi", null, null) + " : " + yorn
						+ "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getOptnlCovge())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.opnlCovg", null, null) + " : "
						+ tdmPolicyPropertySearchDTO.getOptnlCovge() + "  ";
			}

		}

		return searchCriteria;
	}

	@RequestMapping(value = "/tdmReqTestData", method = RequestMethod.GET)
	public String reqTestData(@ModelAttribute("tdmReqTestDataDTO") TdmReqTestDataDTO tdmReqTestDataDTO, ModelMap model,
			@RequestParam(value = "reqId", required = false) String reqId, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		logger.info(MessageConstant.TDM_EMAIL_CTLR + MessageConstant.TDM_POPUP_L1L2 + MessageConstant.LOG_INFO_POPUP
				+ reqId);

		if (null != (String) request.getSession().getAttribute("UserId")) {
			tdmReqTestDataDTO.setReqName((String) request.getSession().getAttribute("UserId"));
		}

		try {

			if (null != reqId) {

				tdmReqTestDataDTO = tdmPolicyAutoSearchService.editReqTestData(reqId);
				model.addAttribute("reqId", reqId);
			}
			model.addAttribute("tdmReqTestDataDTO", tdmReqTestDataDTO);
			model.addAttribute("reqId", reqId);
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
					+ MessageConstant.LOG_INFO_RETURN);
			return "tdmReqTestData";
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "tdmReqTestData";
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute("reqId", reqId);
			model.addAttribute("tdmReqTestDataDTO", tdmReqTestDataDTO);
			return "tdmReqTestData";
		}

	}

	@RequestMapping(value = "/tdmReqTestData", method = RequestMethod.POST)
	@ResponseBody
	public String reqTestDataPost(@ModelAttribute("tdmReqTestDataDTO") TdmReqTestDataDTO tdmReqTestDataDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, Principal principal) {

		String strMessage = null;
		if (null != (String) request.getSession().getAttribute("UserId")) {
			tdmReqTestDataDTO.setReqName((String) request.getSession().getAttribute("UserId"));
		}

		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String strReturnPage = "redirect:tdmReqTestDataList";
		try {

			strMessage = tdmPolicyAutoSearchService.savereqTestData(tdmReqTestDataDTO);

			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
					+ MessageConstant.LOG_INFO_RETURN);
			return strMessage;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return strMessage;
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return strMessage;
		}

	}

	@RequestMapping(value = "/tdmReqTestDataList", method = RequestMethod.GET)
	public String allReqTestData(@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_RESERVE_POLICY_CTRL + MessageConstant.TDM_RESV_POLICY_REC
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);
		try {
			String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			List<TdmReqTestDataDTO> tdmReqTestDataDTOs = tdmPolicyAutoSearchService.allReqTestData(UserId, offSet,
					recordsperpage, true);

			totalRecords = tdmPolicyAutoSearchService.allReqTestDataCount(UserId);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute("tdmReqTestDataDTOs", tdmReqTestDataDTOs);

			return "tdmReqTestDataList";

		} catch (BaseException baseEx) {

			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "tdmReqTestDataList";
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return "tdmReqTestDataList";
		}
	}
}
