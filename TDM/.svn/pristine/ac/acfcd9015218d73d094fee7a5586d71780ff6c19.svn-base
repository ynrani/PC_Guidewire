package com.tdm.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.TDMBankReservationDTO;
import com.tdm.service.TdmBankSearchService;

@Controller
@Scope("session")
public class AccountController
{

	@Autowired
	private MessageSource messageSource;

	@Resource(name = MessageConstant.TDM_BANK_SEARCH_SERVICE)
	TdmBankSearchService tdmBankSearchService;

	@RequestMapping(value = AppConstant.TDM_FTD_ACCOUNT, method = RequestMethod.GET)
	public String findTestDataGet(
			@ModelAttribute(MessageConstant.TDM_ACCOUNT_DTO) AccountDTO accountDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal) {
		return AppConstant.TDM_ACCOUNTSEARCH_VIEW;
	}

	@RequestMapping(value = AppConstant.TDM_FTD_ACCOUNT, method = RequestMethod.POST)
	public String findTestDataNonStandPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(MessageConstant.TDM_ACCOUNT_DTO) AccountDTO accountDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			String userName = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			if (search != null) {

				accountDTO = tdmBankSearchService.searchAccoutnDetails(accountDTO);
			} else if (reserve != null) {
				int recordCount = tdmBankSearchService.reserveBankRecords(accountDTO, userName);
				String msg = recordCount + " records reserved successfully.";
				model.addAttribute("reserveFlag", msg);
			}
			int totalRecords = 0;

			if (accountDTO.getAccountDTosList() != null)
				totalRecords = accountDTO.getAccountDTosList().size();

			model.addAttribute(MessageConstant.TDM_ACCOUNT_DTO, accountDTO);
			request.setAttribute(AppConstant.NO_OF_PAGES, 1);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(accountDTO));
			model.addAttribute(AppConstant.COUNT, 3);
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);

			return AppConstant.TDM_ACCOUNTSEARCH_VIEW;
		} catch (Exception baseEx) {
			baseEx.printStackTrace();
			return AppConstant.TDM_ACCOUNTSEARCH_VIEW;
		}
	}

	@RequestMapping(value = "/myReservationRecords", method = RequestMethod.GET)
	public String myReservationRecords(
			@ModelAttribute(MessageConstant.TDM_ACCOUNT_DTO) AccountDTO accountDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal)

	{
		String userName = null;
		try {

			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			List<TDMBankReservationDTO> resrvationDTOsList = tdmBankSearchService
					.getReservedRecords(userName);
			request.setAttribute(AppConstant.NO_OF_PAGES, 2);
			request.setAttribute(AppConstant.START_PAGE, 1);
			request.setAttribute(AppConstant.LAST_PAGE, 2);
			accountDTO.setResrvationDTOsList(resrvationDTOsList);
			model.addAttribute(MessageConstant.TDM_ACCOUNT_DTO, accountDTO);
			return "myReservations";
		} catch (NullPointerException ex) {
			return "myReservations";
		} catch (ServiceException se) {
			return "myReservations";
		}
	}

	@RequestMapping(value = "/unReserveRecords", method = RequestMethod.POST)
	public String unResrveReservedRecords(
			@ModelAttribute(MessageConstant.TDM_ACCOUNT_DTO) AccountDTO accountDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal)

	{
		String userName = null;
		try {
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			int unResCount = tdmBankSearchService.unReserveReservedRecords(accountDTO, userName);
			request.setAttribute(AppConstant.CURRENT_PAGE, 1);
			request.setAttribute(AppConstant.NO_OF_PAGES, 2);
			request.setAttribute(AppConstant.START_PAGE, 1);
			request.setAttribute(AppConstant.LAST_PAGE, 2);
			model.addAttribute(MessageConstant.TDM_ACCOUNT_DTO, accountDTO);
			model.addAttribute("unResCount", unResCount);
			return "myReservations";
		} catch (NullPointerException ex) {
			return "myReservations";
		} catch (ServiceException se) {
			return "myReservations";
		}
	}

	/**
	 * 
	 * @param AccountDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = AppConstant.TDM_FTD_ACCOUNT, method = RequestMethod.POST, params = "export")
	public ModelAndView tdmNonStandResultExport(
			@ModelAttribute(MessageConstant.TDM_ACCOUNT_DTO) AccountDTO accountDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("dataSerachBankExcel", "accountDtosList",
				accountDTO.getAccountDTosList());
	}

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = "/unReserveRecords", method = RequestMethod.POST, params = "export")
	public ModelAndView myReservationDAshboardExport(
			@ModelAttribute(MessageConstant.TDM_ACCOUNT_DTO) AccountDTO accountDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("myReservationDashboardExcel", "reservationDtosList",
				accountDTO.getResrvationDTOsList());
	}

	public String getSearchCriteria(AccountDTO accountDTO) {
		StringBuffer searchCriteria = new StringBuffer();
		if (null != accountDTO) {
			searchCriteria.append("Search Result for: ");
			if (StringUtils.isNotEmpty(accountDTO.getAccoutnType())) {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.actype", null, null))
						.append(" = ");
				searchCriteria.append(accountDTO.getAccoutnType()).append("; ");
			}
			if (StringUtils.isNotEmpty(accountDTO.getBalFrom())) {
				searchCriteria.append(messageSource.getMessage("Blanace From ", null, null))
						.append(" = ");
				searchCriteria.append(accountDTO.getBalFrom()).append("; ");
			}
			if (StringUtils.isNotEmpty(accountDTO.getBalTo())) {
				searchCriteria.append(messageSource.getMessage("Blanace TO ", null, null)).append(
						" = ");
				searchCriteria.append(accountDTO.getBalTo()).append("; ");
			}
			if (StringUtils.isNotEmpty(accountDTO.getAccountStatus())) {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.acStat", null, null))
						.append(" = ");
				searchCriteria.append(accountDTO.getAccountStatus()).append("; ");
			}
			if (accountDTO.isOverDraftEnabled()) {
				searchCriteria
						.append(messageSource.getMessage("label.ns.ac.overDraft", null, null))
						.append(" = ");
				searchCriteria.append("True;");
			} else {
				searchCriteria
						.append(messageSource.getMessage("label.ns.ac.overDraft", null, null))
						.append(" = ");
				searchCriteria.append("False;");
			}
			if (StringUtils.isNotEmpty(accountDTO.getBranchCode())) {
				searchCriteria
						.append(messageSource.getMessage("label.ns.ac.brnchcode", null, null))
						.append(" = ");
				searchCriteria.append(accountDTO.getBranchCode()).append("; ");
			}
			if (StringUtils.isNotEmpty(accountDTO.getCustmerType())) {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.custtype", null, null))
						.append(" = ");
				searchCriteria.append(accountDTO.getCustmerType()).append("; ");
			}
			if (accountDTO.isGender()) {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.gender", null, null))
						.append(" = ");
				searchCriteria.append("Male; ");
			} else {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.gender", null, null))
						.append(" = ");
				searchCriteria.append("Female; ");
			}
			if (StringUtils.isNotEmpty(accountDTO.getDobFrom())) {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.dob", null, null))
						.append(" = ");
				searchCriteria.append(accountDTO.getDobFrom()).append("; ");
			}
			if (accountDTO.isCreditCard()) {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.ccCard", null, null))
						.append(" = ");
				searchCriteria.append("True; ");
				if (StringUtils.isNotEmpty(accountDTO.getCrditCardType())) {
					searchCriteria.append(
							messageSource.getMessage("label.ns.ac.ccType", null, null)).append(
							" = ");
					searchCriteria.append(accountDTO.getCrditCardType()).append(" ");
				}

				if (StringUtils.isNotEmpty(accountDTO.getCcExpdateFrom())) {
					searchCriteria.append(
							messageSource.getMessage("label.ns.ac.ccExpdate", null, null)).append(
							" = ");
					searchCriteria.append(accountDTO.getCcExpdateFrom()).append(" ");
				}

				if (StringUtils.isNotEmpty(accountDTO.getCcAvailablelimit())) {
					searchCriteria.append(
							messageSource.getMessage("label.ns.ac.cclimit", null, null)).append(
							" = ");
					searchCriteria.append(accountDTO.getCcAvailablelimit()).append(" ");
				}
			} else {
				searchCriteria.append(messageSource.getMessage("label.ns.ac.ccCard", null, null))
						.append(" = ");
				searchCriteria.append("False; ");
			}
		} else {
			searchCriteria.append("No Records found");
		}
		return searchCriteria.toString();
	}
}
