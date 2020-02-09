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
import com.tdm.model.DTO.TdmClaimSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyClaimSearchDTO;
import com.tdm.service.TdmPolicySearchService;
import com.tdm.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
public class TdmPolicyClaimSearchController
{
	final static Logger logger = Logger.getLogger(TdmPolicyClaimSearchController.class);
	private int noOfRecPerPage = 5;

	private TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO1 = null;

	@Resource(name = MessageConstant.TDM_POLICY_SEARCH_SERVICE)
	TdmPolicySearchService tdmPolicySearchService;

	/**
	 * 
	 * @param tdmPolicyClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLAIM, method = RequestMethod.GET)
	public String findTestDataGet(
			@ModelAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO) TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws BaseException {
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_GET + MessageConstant.LOG_INFO_PARAMS_NO);
		model.addAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO, tdmPolicyClaimSearchDTO);
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_GET + MessageConstant.LOG_INFO_RETURN);
		return AppConstant.TDM_FTD_CLAIM_VIEW;
	}

	/**
	 * 
	 * @param tdmPolicyClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLAIM_BACK, method = RequestMethod.GET)
	public String findTestDataBack(
			@ModelAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO) TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_BACK + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != tdmPolicyClaimSearchDTO1) {
				tdmPolicyClaimSearchDTO = tdmPolicyClaimSearchDTO1;
				if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
					userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
				}
				Long totalRecords = 0L;
				PaginationUtil pagenation = new PaginationUtil();
				int recordsperpage = Integer.parseInt(tdmPolicyClaimSearchDTO.getSearchRecordsNo());
				noOfRecPerPage = recordsperpage;
				int offSet = pagenation.getOffset(request, recordsperpage);
				tdmPolicyClaimSearchDTO = tdmPolicySearchService.searchClaimRecords(
						tdmPolicyClaimSearchDTO, offSet, recordsperpage, true, userName);
				totalRecords = tdmPolicySearchService.searchClaimRecordsCount(
						tdmPolicyClaimSearchDTO, userName);
				pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
				int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

				request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
				model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
				model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
				model.addAttribute(AppConstant.COUNT, tdmPolicyClaimSearchDTO.getCount());
				model.addAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO, tdmPolicyClaimSearchDTO);
				model.addAttribute(AppConstant.TOT_RECS, totalRecords);
				model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
						tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
				logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
						+ MessageConstant.TDM_CLAIM_SEARCH_FTD_BACK
						+ MessageConstant.LOG_INFO_RETURN);
				return AppConstant.TDM_FTD_CLAIM_VIEW;
			} else {
				return AppConstant.TDM_FTD_CLAIM_REDIRECT;
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLAIM_SEARCH_CTLR
					+ MessageConstant.TDM_CLAIM_SEARCH_FTD_BACK
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLAIM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
			model.addAttribute(AppConstant.COUNT, tdmPolicyClaimSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO, tdmPolicyClaimSearchDTO);
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_CLAIM_VIEW;
		}
	}

	/**
	 * 
	 * @param search
	 * @param reserve
	 * @param tdmPolicyClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLAIM, method = RequestMethod.POST)
	public String findTestDataPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO) TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_POST + MessageConstant.LOG_INFO_SEARCH
				+ search);
		try {
			String userName = null;
			String reserveFlag = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tdmPolicyClaimSearchDTO.getSearchRecordsNo());
			noOfRecPerPage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tdmPolicyClaimSearchDTO = tdmPolicySearchService.searchClaimRecords(
						tdmPolicyClaimSearchDTO, offSet, recordsperpage, true, userName);
				totalRecords = tdmPolicySearchService.searchClaimRecordsCount(
						tdmPolicyClaimSearchDTO, userName);
			} else if (null != reserve) {
				int cntRec = tdmPolicySearchService.saveReservedData(tdmPolicyClaimSearchDTO,
						userName);
				tdmPolicyClaimSearchDTO = tdmPolicySearchService.searchClaimRecords(
						tdmPolicyClaimSearchDTO, offSet, recordsperpage, true, userName);
				totalRecords = tdmPolicySearchService.searchClaimRecordsCount(
						tdmPolicyClaimSearchDTO, userName);
				reserveFlag = cntRec + AppConstant.TDM_FTD_REC_SUCCESS1
						+ tdmPolicyClaimSearchDTO.getTestCaseId()
						+ AppConstant.TDM_FTD_REC_SUCCESS2
						+ tdmPolicyClaimSearchDTO.getTestCaseName();
				tdmPolicyClaimSearchDTO.setTestCaseId(null);
				tdmPolicyClaimSearchDTO.setTestCaseName(null);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			tdmPolicyClaimSearchDTO1 = tdmPolicyClaimSearchDTO;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
			model.addAttribute(AppConstant.RESERVE_FLAG, reserveFlag);
			model.addAttribute(AppConstant.COUNT, tdmPolicyClaimSearchDTO.getCount());
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
					+ MessageConstant.TDM_CLAIM_SEARCH_FTD_POST + MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_CLAIM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLAIM_SEARCH_CTLR
					+ MessageConstant.TDM_CLAIM_SEARCH_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLAIM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
			model.addAttribute(AppConstant.COUNT, tdmPolicyClaimSearchDTO.getCount());
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_CLAIM_VIEW;
		}
	}

	/**
	 * 
	 * @param tdmPolicyClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = AppConstant.TDM_FTD_CLAIM, method = RequestMethod.POST, params = AppConstant.EXPORT)
	public ModelAndView findTestDataExport(
			@ModelAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO) TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_EXPORT + MessageConstant.LOG_INFO_EXPORT);
		String UserId = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
		List<TdmClaimSearchResultDTO> list = null;
		int count = 0;
		if (null != tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs()
				&& 0 < tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs().size()) {
			list = new ArrayList<TdmClaimSearchResultDTO>();
			for (int i = 0; i < tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs().size(); i++) {
				if (null != tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs().get(i)
						.getReservedYN()) {
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs().get(i).setUserId(UserId);
					list.add(tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs().get(i));
					count++;
				}
			}
		}

		model.addAttribute(AppConstant.COUNT, count);
		model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_EXPORT + MessageConstant.LOG_INFO_RETURN);
		return new ModelAndView(MessageConstant.TDM_CLAIM_EXPO_XLS,
				MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS, list);
	}

	/**
	 * 
	 * @param tdmPolicyClaimSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_CLAIM, method = RequestMethod.GET, params = AppConstant.PAGE)
	public String findTestDataPagiNation(
			@ModelAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO) TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_FTD_PAGENATION
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			String userName = null;
			tdmPolicyClaimSearchDTO = tdmPolicyClaimSearchDTO1;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecPerPage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmPolicyClaimSearchDTO = tdmPolicySearchService.searchClaimRecords(
					tdmPolicyClaimSearchDTO, offSet, recordsperpage, true, userName);
			totalRecords = tdmPolicySearchService.searchClaimRecordsCount(tdmPolicyClaimSearchDTO,
					userName);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			model.addAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO, tdmPolicyClaimSearchDTO);
			logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
					+ MessageConstant.TDM_CLAIM_SEARCH_FTD_PAGENATION
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_FTD_CLAIM_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLAIM_SEARCH_CTLR
					+ MessageConstant.TDM_CLAIM_SEARCH_FTD_PAGENATION
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_FTD_CLAIM_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(tdmPolicyClaimSearchDTO));
			model.addAttribute(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS,
					tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs());
			model.addAttribute(MessageConstant.TDM_CLAIM_SEARCH_DTO, tdmPolicyClaimSearchDTO);
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return AppConstant.TDM_FTD_CLAIM_VIEW;
		}

	}

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param tdmPolicyClaimSearchDTO
	 * @return
	 */
	public String getSearchCriteria(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO) {

		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_CRITERIA + MessageConstant.LOG_INFO_PARAMS_NO);
		String searchCriteria = "";
		if (null != tdmPolicyClaimSearchDTO) {
			searchCriteria += "Search Result for: ";
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getEnvType())) {
				searchCriteria += messageSource.getMessage("label.env", null, null) + " : "
						+ tdmPolicyClaimSearchDTO.getEnvType() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getDataSource())) {
				searchCriteria += " + " + messageSource.getMessage("label.claim.ds", null, null)
						+ " : " + tdmPolicyClaimSearchDTO.getDataSource() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getSourceSystem())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.srcSys", null, null) + " : "
						+ tdmPolicyClaimSearchDTO.getSourceSystem() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getLob())) {
				searchCriteria += " + " + messageSource.getMessage("label.claim.lob", null, null)
						+ " : " + tdmPolicyClaimSearchDTO.getLob() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getClaimStatus())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.ClaimSts", null, null) + " : "
						+ tdmPolicyClaimSearchDTO.getClaimStatus() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getClaimState())) {
				searchCriteria += " + " + messageSource.getMessage("label.claim.state", null, null)
						+ " : " + tdmPolicyClaimSearchDTO.getClaimState() + "  ";
			}

			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getNamedInsu())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.namedInsu", null, null) + " : "
						+ tdmPolicyClaimSearchDTO.getNamedInsu() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicyNo())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.policyNo", null, null) + " : "
						+ tdmPolicyClaimSearchDTO.getPolicyNo() + "  ";
			}
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getLossDt())) {
				searchCriteria += " + "
						+ messageSource.getMessage("label.claim.lossDt", null, null) + " : "
						+ tdmPolicyClaimSearchDTO.getLossDt() + "  ";
			}

		}
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR
				+ MessageConstant.TDM_CLAIM_SEARCH_CRITERIA + MessageConstant.LOG_INFO_RETURN);
		return searchCriteria;
	}

}
