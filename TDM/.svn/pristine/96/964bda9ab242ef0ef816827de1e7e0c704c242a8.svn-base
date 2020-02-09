package com.tesda.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.service.TDMNonStandSearchService;
import com.tesda.util.PaginationUtil;

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMNonStandardSearchController
{

	private int noOfRecForpage = 5;

	@Resource(name = TDMConstants.NONSTAND_SEARCH_MGMT_SERVICE)
	TDMNonStandSearchService searchManagementService;

	@RequestMapping(value = TDMConstants.MAP_RESERVATIONNS, method = RequestMethod.GET)
	public String tdmGetNonStandReserve(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, Principal principal)
	{
		return TDMConstants.RESERVATION_NS;
	}

	@RequestMapping(value = TDMConstants.MAP_TDMNS_SEARCH, method = RequestMethod.GET)
	public String tdmGetNonStand(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			Map<String, List<String>> searchFields = searchManagementService.getSearchFields();
			model.addAttribute("show", false);
			model.addAttribute("searchFields", searchFields);
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDMNS_SEARCH, method = RequestMethod.POST)
	public String tdmGetNonStandSearchRecords(
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "reserve", required = false) String reserve,
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		String userName = null;
		String reserveFlag = null;
		try
		{
			if (null != (String) request.getSession().getAttribute("UserId"))
			{
				userName = (String) request.getSession().getAttribute("UserId");
			}
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = noOfRecForpage;
			int offSet = pagenation.getOffset(request, recordsperpage);

			model.addAttribute("show", true);
			Map<String, List<String>> searchFields = searchManagementService.getSearchFields();
			if (null != search)
			{
				tdmNonStandSearchDTO = searchManagementService
						.getNonStandSearchRecords(tdmNonStandSearchDTO);
			}
			else if (null != reserve)
			{
				int recordCount = searchManagementService.saveReservedData(tdmNonStandSearchDTO,
						userName);
				String msg = recordCount + " records reserved successfully.";
				model.addAttribute(TDMConstants.RESERVE_FLAG, msg);
			}
			Long totalRecords = 5L;
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			request.setAttribute("startPage", 1);
			request.setAttribute("currentPage", 1);
			request.setAttribute("lastPage", noOfPages);
			model.addAttribute("searchFields", searchFields);
			model.addAttribute(TDMConstants.TOTAL_RECORDS, totalRecords);
			model.addAttribute("tdmNonStandardSrchResultListDTOs",
					tdmNonStandSearchDTO.getTdmNonStandardSrchResultListDTOs());
			model.addAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO, tdmNonStandSearchDTO);
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
		catch (ServiceException se)
		{
			se.printStackTrace();
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDMNONSTANDARD_SEARCH, method = RequestMethod.GET)
	public String tdmResetNonStand(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			Map<String, List<String>> searchFields = searchManagementService.getSearchFields();
			model.addAttribute("show", false);
			model.addAttribute("searchFields", searchFields);
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
	}
}
