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
import com.tdm.model.DTO.TdmPolicySearchDTO;
import com.tdm.model.DTO.TdmPolicySearchResultDTO;
import com.tdm.service.TdmPolicySearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
public class TdmPolicySearchController
{
	final static Logger logger = Logger.getLogger(TdmPolicySearchController.class);
	private int noOfRecPerPage = 5;

	private TdmPolicySearchDTO tdmPolicySearchDTO1 = null;

	@Resource(name = MessageConstant.TDM_POLICY_SEARCH_SERVICE)
	TdmPolicySearchService tdmPolicySearchService;

	/**
	 * 
	 * @param tdmPolicySearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_POLICY, method = RequestMethod.GET)
	public String findTestDataGet(
			@ModelAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO) TdmPolicySearchDTO tdmPolicySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws BaseException {
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_GET + MessageConstant.LOG_INFO_PARAMS_NO);
		model.addAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO, tdmPolicySearchDTO);
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_GET + MessageConstant.LOG_INFO_RETURN);
		return AppConstant.TDM_FTD_POLICY_VIEW;
	}

	/**
	 * 
	 * @param tdmPolicySearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_POLICY_BACK, method = RequestMethod.GET)
	public String findTestDataBack(
			@ModelAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO) TdmPolicySearchDTO tdmPolicySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_BACK + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != tdmPolicySearchDTO1) {
				tdmPolicySearchDTO = tdmPolicySearchDTO1;
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
				}
				Long totalRecords = 0L;
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = Integer.parseInt(tdmPolicySearchDTO.getSearchRecordsNo());
				noOfRecPerPage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tdmPolicySearchDTO = tdmPolicySearchService.searchPolicyRecords(tdmPolicySearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = tdmPolicySearchService.searchPolicyRecordsCount(tdmPolicySearchDTO,
						userName);
				pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

				request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
				model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
				model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
				model.addAttribute(AppConstant.COUNT, tdmPolicySearchDTO.getCount());
				model.addAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO, tdmPolicySearchDTO);
				model.addAttribute(AppConstant.TOT_RECS, totalRecords);
				model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
						tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
				logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
						+ MessageConstant.TDM_POLICY_SEARCH_FTD_BACK
						+ MessageConstant.LOG_INFO_RETURN);
				return AppConstant.TDM_FTD_POLICY_VIEW;
			} else {
				return AppConstant.TDM_FTD_POLICY_REDIRECT;
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_POLICY_SEARCH_CTLR
					+ MessageConstant.TDM_POLICY_SEARCH_FTD_BACK
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_POLICY_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
			model.addAttribute(AppConstant.COUNT, tdmPolicySearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO, tdmPolicySearchDTO);
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_POLICY_VIEW;
		}
	}

	/**
	 * 
	 * @param search
	 * @param reserve
	 * @param tdmPolicySearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_POLICY, method = RequestMethod.POST)
	public String findTestDataPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO) TdmPolicySearchDTO tdmPolicySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_POST + MessageConstant.LOG_INFO_SEARCH
				+ search);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tdmPolicySearchDTO.getSearchRecordsNo());
			noOfRecPerPage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tdmPolicySearchDTO = tdmPolicySearchService.searchPolicyRecords(tdmPolicySearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = tdmPolicySearchService.searchPolicyRecordsCount(tdmPolicySearchDTO,
						userName);
			} else if (null != reserve) {
				int cntRec = tdmPolicySearchService.saveReservedData(tdmPolicySearchDTO, userName);
				tdmPolicySearchDTO = tdmPolicySearchService.searchPolicyRecords(tdmPolicySearchDTO,
						offSet, recordsperpage, true, userName);
				totalRecords = tdmPolicySearchService.searchPolicyRecordsCount(tdmPolicySearchDTO,
						userName);
				reserveFlag = cntRec + AppConstant.TDM_FTD_REC_SUCCESS1
						+ tdmPolicySearchDTO.getTestCaseId() + AppConstant.TDM_FTD_REC_SUCCESS2
						+ tdmPolicySearchDTO.getTestCaseName();
				tdmPolicySearchDTO.setTestCaseId(null);
				tdmPolicySearchDTO.setTestCaseName(null);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			tdmPolicySearchDTO1 = tdmPolicySearchDTO;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
			model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
			model.addAttribute(AppConstant.COUNT, tdmPolicySearchDTO.getCount());
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
					+ MessageConstant.TDM_POLICY_SEARCH_FTD_POST + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_POLICY_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_POLICY_SEARCH_CTLR
					+ MessageConstant.TDM_POLICY_SEARCH_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_POLICY_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
			model.addAttribute(AppConstant.COUNT, tdmPolicySearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_POLICY_VIEW;
		}
	}

	/**
	 * 
	 * @param tdmPolicySearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = AppConstant.TDM_FTD_POLICY, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestDataExport(
			@ModelAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO) TdmPolicySearchDTO tdmPolicySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_EXPORT + MessageConstant.LOG_INFO_EXPORT);
		String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		List<TdmPolicySearchResultDTO> list = null;
		int count = 0;
		if (null != tdmPolicySearchDTO.getTdmPolicySearchResultDTOs()
				&& 0 < tdmPolicySearchDTO.getTdmPolicySearchResultDTOs().size()) {
			list = new ArrayList<TdmPolicySearchResultDTO>();
			for (int i = 0; i < tdmPolicySearchDTO.getTdmPolicySearchResultDTOs().size(); i++) {
				if (null != tdmPolicySearchDTO.getTdmPolicySearchResultDTOs().get(i)
						.getReservedYN()) {
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs().get(i).setUserId(UserId);
					list.add(tdmPolicySearchDTO.getTdmPolicySearchResultDTOs().get(i));
					count++;
				}
			}
		}

		model.addAttribute(AppConstant.COUNT, count);
		model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_EXPORT + MessageConstant.LOG_INFO_RETURN);
		return new ModelAndView(MessageConstant.TDM_POLICY_EXPO_XLS,
				MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS, list);
	}

	/**
	 * 
	 * @param tdmPolicySearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_POLICY, method = RequestMethod.GET, params = AppConstant.PAGE)
	public String findTestDataPagiNation(
			@ModelAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO) TdmPolicySearchDTO tdmPolicySearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_FTD_PAGENATION
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			String userName = null;
			tdmPolicySearchDTO = tdmPolicySearchDTO1;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecPerPage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmPolicySearchDTO = tdmPolicySearchService.searchPolicyRecords(tdmPolicySearchDTO,
					offSet, recordsperpage, true, userName);
			totalRecords = tdmPolicySearchService.searchPolicyRecordsCount(tdmPolicySearchDTO,
					userName);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			model.addAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO, tdmPolicySearchDTO);
			logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
					+ MessageConstant.TDM_POLICY_SEARCH_FTD_PAGENATION
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_POLICY_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_POLICY_SEARCH_CTLR
					+ MessageConstant.TDM_POLICY_SEARCH_FTD_PAGENATION
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_POLICY_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicySearchDTO));
			model.addAttribute(MessageConstant.TDM_POLICY_RESULT_EXPO_DTOS,
					tdmPolicySearchDTO.getTdmPolicySearchResultDTOs());
			model.addAttribute(MessageConstant.TDM_POLICY_SEARCH_DTO, tdmPolicySearchDTO);
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_POLICY_VIEW;
		}

	}

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param tdmPolicySearchDTO
	 * @return
	 */
	public String getSearchCriteria(TdmPolicySearchDTO tdmPolicySearchDTO) {

		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_CRITERIA + MessageConstant.LOG_INFO_PARAMS_NO);
		String searchCriteria = "";
		if (null != tdmPolicySearchDTO) {
			searchCriteria += "Search Result for: ";
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getEnvType())) {
				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tdmPolicySearchDTO.getEnvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getDataSource())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.ds", null, null)
						+ " : " + tdmPolicySearchDTO.getDataSource() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getSourceSystem())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.srcsys", null, null) + " : "
						+ tdmPolicySearchDTO.getSourceSystem() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getLob())) {
				searchCriteria += " + " + messageSource.getMessage("label.policy.lob", null, null)
						+ " : " + tdmPolicySearchDTO.getLob() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyStatus())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.policySts", null, null) + " : "
						+ tdmPolicySearchDTO.getPolicyStatus() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyState())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.state", null, null) + " : "
						+ tdmPolicySearchDTO.getPolicyState() + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getNamedInsu())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.namedInsu", null, null) + " : "
						+ tdmPolicySearchDTO.getNamedInsu() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyNo())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.policyNo", null, null) + " : "
						+ tdmPolicySearchDTO.getPolicyNo() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getAccNo())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.policy.accNo", null, null) + " : "
						+ tdmPolicySearchDTO.getAccNo() + "  ";
			}

		}
		logger.info(MessageConstant.TDM_POLICY_SEARCH_CTLR
				+ MessageConstant.TDM_POLICY_SEARCH_CRITERIA + MessageConstant.LOG_INFO_RETURN);
		return searchCriteria;
	}

}
