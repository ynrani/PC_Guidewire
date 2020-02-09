package com.tesda.controller;

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

import com.tesda.exception.BaseException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.service.TdmPolicyAutoPropSearchService;
import com.tesda.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope("session")
public class TdmPolicyAutoSearchController
{

	final static Logger logger = Logger.getLogger(TdmPolicyAutoSearchController.class);

	private int noOfRecForpage = 25;
	private TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO1 = null;

	@Resource(name = "tdmPolicyAutoPropSearchService")
	TdmPolicyAutoPropSearchService tdmPolicyAutoSearchService;

	@RequestMapping(value = "/policyAuto", method = RequestMethod.GET)
	public String policyAutoGet(
			@ModelAttribute("tdmPolicyAutoSearchDTO") TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws BaseException {
		if (logger.isInfoEnabled()) {
			logger.info("Auto search controller init  : ");
		}
		return "autoPolicySearch";
	}

	@RequestMapping(value = "/policyAuto", method = RequestMethod.POST)
	public String policyAutoPost(
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "reserve", required = false) String reserve,
			@ModelAttribute("tdmPolicyAutoSearchDTO") TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		String userName = null;
		String reserveFlag = null;
		int countPerPage = 0;
		try {
			if (null != (String) request.getSession().getAttribute("UserId")) {
				userName = (String) request.getSession().getAttribute("UserId");
			}
			Long totalRecords = 0L;
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				tdmPolicyAutoSearchDTO.setShowHideFlag(true);
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocType())) {
				tdmPolicyAutoSearchDTO.setShowHideFlagDoc(true);
			}
			model.addAttribute("result", getSearchCriteria(tdmPolicyAutoSearchDTO));
			tdmPolicyAutoSearchDTO.setSearchCriti(getSearchCriteria(tdmPolicyAutoSearchDTO));
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 25;// Integer.valueOf(tdmPolicyAutoSearchDTO.getSearchRecordsNo());
			noOfRecForpage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				logger.info("Auto search controller function policyAutoPost  : ");
				tdmPolicyAutoSearchDTO = tdmPolicyAutoSearchService
						.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet,
								recordsperpage, true, userName);
			} else if (null != reserve) {
				logger.info("Auto search controller reserving records  : ");
				int cntRec = tdmPolicyAutoSearchService.saveReservedData(tdmPolicyAutoSearchDTO,
						userName, tdmPolicyAutoSearchDTO.getEnvType());
				tdmPolicyAutoSearchDTO = tdmPolicyAutoSearchService
						.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet,
								recordsperpage, true, userName);
				reserveFlag = cntRec + " Record(s) successfully reserved for Test Case Id : "
						+ tdmPolicyAutoSearchDTO.getTestCaseId() + " and Test Case Name : "
						+ tdmPolicyAutoSearchDTO.getTestCaseName();
				tdmPolicyAutoSearchDTO.setTestCaseId(null);
				tdmPolicyAutoSearchDTO.setTestCaseName(null);
			}
			if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()) {
				if (tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size() >= 25) {
					totalRecords = 50L;
				} else {
					totalRecords = 25L;
				}
			}
			// set the size to no of records variable
			if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
					&& tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size() > 0) {
				countPerPage = tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size();
			}
			pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			tdmPolicyAutoSearchDTO1 = tdmPolicyAutoSearchDTO;
			request.setAttribute("noOfPages", noOfPages);
			model.addAttribute("reserveFlag", reserveFlag);
			model.addAttribute("totalRecords", countPerPage);
			model.addAttribute("count", tdmPolicyAutoSearchDTO.getCount());
			model.addAttribute("tdmPolicyAutoSearchResultDTOList",
					tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList());
			return "autoPolicySearch";
		} catch (BaseException baseEx) {
			logger.error("Sorry, something wrong in auto search controller!", baseEx);

			if (baseEx.getErrorCode() != null) {
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "autoPolicySearch";
			}
		}
		return "autoPolicySearch";
	}

	@RequestMapping(value = "/policyAuto", method = RequestMethod.GET, params = "page")
	public String policyAutoPagiNation(
			@ModelAttribute("tdmPolicyAutoSearchDTO") TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		logger.info("In auto search controller  policyAutoPagiNation methos: ");
		String userName = null;
		int countPerPage = 0;
		try {
			tdmPolicyAutoSearchDTO = tdmPolicyAutoSearchDTO1;
			if (null != (String) request.getSession().getAttribute("UserId")) {
				userName = (String) request.getSession().getAttribute("UserId");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				tdmPolicyAutoSearchDTO.setShowHideFlag(true);
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocType())) {
				tdmPolicyAutoSearchDTO.setShowHideFlagDoc(true);
			}
			model.addAttribute("result", getSearchCriteria(tdmPolicyAutoSearchDTO));
			Long totalRecords = 50L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecForpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmPolicyAutoSearchDTO = tdmPolicyAutoSearchService
					.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet,
							recordsperpage, true, userName);
			// set the size to no of records variable
			if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
					&& tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size() > 0) {
				countPerPage = tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size();
			}
			pagenation.paginate(totalRecords, request, (Double.valueOf(recordsperpage)),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute("noOfPages", noOfPages);
			model.addAttribute("totalRecords", countPerPage);
			model.addAttribute("tdmPolicyAutoSearchResultDTOList",
					tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList());
			model.addAttribute("tdmPolicyAutoSearchDTO", tdmPolicyAutoSearchDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			return "autoPolicySearch";
		}
		logger.info("In auto search controller  policyAutoPagiNation methos return to UI: ");
		return "autoPolicySearch";

	}

	@RequestMapping(value = "/policyAutoBack", method = RequestMethod.GET)
	public String findTestDataBack(
			@ModelAttribute("tdmPolicyAutoSearchDTO") TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info("In auto search controller  findTestDataBack methos: ");
		String userName = null;
		String reserveFlag = null;
		String returnPage = null;
		int countPerPage = 0;
		try {
			if (null != tdmPolicyAutoSearchDTO1) {
				tdmPolicyAutoSearchDTO = tdmPolicyAutoSearchDTO1;
				if (null != (String) request.getSession().getAttribute("UserId")) {
					userName = (String) request.getSession().getAttribute("UserId");
				}
				Long totalRecords = 50L;
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())
						|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())
						|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())
						|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
					tdmPolicyAutoSearchDTO.setShowHideFlag(true);
				}
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocType())) {
					tdmPolicyAutoSearchDTO.setShowHideFlagDoc(true);
				}
				model.addAttribute("result", getSearchCriteria(tdmPolicyAutoSearchDTO));
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = 25;// Integer.valueOf(tdmPolicyAutoSearchDTO.getSearchRecordsNo());
				noOfRecForpage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tdmPolicyAutoSearchDTO = tdmPolicyAutoSearchService
						.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet,
								recordsperpage, true, userName);
				// set the size to no of records variable
				if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
						&& tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size() > 0) {
					countPerPage = tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
							.size();
				}
				if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
						&& tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size() >= 25) {
					totalRecords = 50L;
				} else {
					totalRecords = 25L;
				}
				pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
						recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
				request.setAttribute("noOfPages", noOfPages);
				model.addAttribute("reserveFlag", reserveFlag);
				model.addAttribute("count", tdmPolicyAutoSearchDTO.getCount());
				model.addAttribute("tdmPolicyAutoSearchDTO", tdmPolicyAutoSearchDTO);
				model.addAttribute("totalRecords", countPerPage);
				model.addAttribute("tdmPolicyAutoSearchResultDTOList",
						tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList());
				returnPage = "autoPolicySearch";
			} else {
				returnPage = "redirect:policyAuto";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return returnPage;

	}

	@RequestMapping(value = "/policyAuto", method = RequestMethod.POST, params = "export")
	public ModelAndView policyPropExport(
			@ModelAttribute("tdmPolicyAutoSearchDTO") TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("In auto search controller  policyPropExport methos: ");
		String UserId = (String) request.getSession().getAttribute("UserId");
		List<TdmPolicyAutoSearchResultDTO> list = null;
		if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
				&& 0 < tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size()) {
			list = new ArrayList<TdmPolicyAutoSearchResultDTO>();
			for (int i = 0; i < tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size(); i++) {
				if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().get(i)
						.getReservedYN()) {
					tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().get(i)
							.setUserId(UserId);
					list.add(tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().get(i));
				}
			}
		}
		model.addAttribute("result", getSearchCriteria(tdmPolicyAutoSearchDTO));
		return new ModelAndView("searchPolicyAutoListExcelView", "tdmPolicyAutoSearchResultDTOs",
				list);
	}

	@Autowired
	private MessageSource messageSource;

	public String getSearchCriteria(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO) {

		String searchCriteria = "";
		logger.info("In auto search controller  getSearchCriteria methos: ");

		if (null != tdmPolicyAutoSearchDTO) {
			searchCriteria += "Search Result for: ";

			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getEnvType())) {
				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getEnvType() + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.stage", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getPolicyStage() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyTerm())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.term", null, null)
						+ " : " + tdmPolicyAutoSearchDTO.getPolicyTerm() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyState())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.state", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getPolicyState() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.coverage", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getPolicyCovge() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPayMethod())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.payType", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getPayMethod() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoPayReq())) {

				String yorn = null;
				if (tdmPolicyAutoSearchDTO.getAssoPayReq().equalsIgnoreCase("Y")) {
					yorn = "Yes";
				} else if (tdmPolicyAutoSearchDTO.getAssoPayReq().equalsIgnoreCase("N")) {
					yorn = "No";
				} else {
					yorn = "Any";
				}

				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.assoPayReq", null, null) + " : "
						+ yorn + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocReq())) {

				String yorn = null;
				if (tdmPolicyAutoSearchDTO.getAssoDocReq().equalsIgnoreCase("Y")) {
					yorn = "Yes";
				} else if (tdmPolicyAutoSearchDTO.getAssoDocReq().equalsIgnoreCase("N")) {
					yorn = "No";
				} else {
					yorn = "Any";
				}

				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.assoDoc", null, null) + " : "
						+ yorn + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoBillPlanType())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.planType", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getAssoBillPlanType() + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocType())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.docType", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getAssoDocType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.noDrivers", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getNoOfDrivers() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.noVehi", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getNoOfVehi() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.noInsu", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getNoOfNamedInsu() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.noViola", null, null) + " : "
						+ tdmPolicyAutoSearchDTO.getNoOfViola() + "  ";
			}

		} else {
			searchCriteria = "No Search Records Found";
		}
		logger.info("In auto search controller return search criteria : ");
		return searchCriteria;
	}

}
