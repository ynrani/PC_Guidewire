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
import com.tdm.model.DTO.POLOSearchDTO;
import com.tdm.model.DTO.PoloReservationDTO;
import com.tdm.service.TDMProviserSearchService;

@Controller
@Scope("session")
public class PoloSearchController
{

	@Autowired
	private MessageSource messageSource;

	@Resource(name = MessageConstant.TDM_SEARCH_SERVICE)
	TDMProviserSearchService searchManagementService;

	@RequestMapping(value = AppConstant.TDM_FTD_POLO, method = RequestMethod.GET)
	public String findTestDataGet(
			@ModelAttribute(AppConstant.TDM_POLOSEARCH_DTO) POLOSearchDTO poloSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal)
	{
		return AppConstant.TDM_FTD_NS_POLOVIEW;
	}

	@RequestMapping(value = AppConstant.TDM_FTD_POLO, method = RequestMethod.POST)
	public String findTestDataNonStandPost(
			@RequestParam(value = AppConstant.SEARCH, required = false) String search,
			@RequestParam(value = AppConstant.RESERVE, required = false) String reserve,
			@ModelAttribute(AppConstant.TDM_POLOSEARCH_DTO) POLOSearchDTO poloSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{

		try
		{
			String userName = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID))
			{
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			if (search != null)
			{

				poloSearchDTO = searchManagementService.getPOloSearchRecords(poloSearchDTO);
			}
			else if (reserve != null)
			{
				int recordCount = searchManagementService.reservePoloRecords(poloSearchDTO,
						userName);
				String msg = recordCount + " records reserved successfully.";
				model.addAttribute("reserveFlag", msg);
			}
			int totalRecords = 0;

			if (poloSearchDTO.getPoloSearchResultList() != null)
				totalRecords = poloSearchDTO.getPoloSearchResultList().size();

			model.addAttribute(AppConstant.TDM_POLOSEARCH_DTO, poloSearchDTO);
			request.setAttribute(AppConstant.NO_OF_PAGES, 1);
			model.addAttribute(AppConstant.RESULT, getSearchCriteria(poloSearchDTO));
			model.addAttribute(AppConstant.COUNT, 3);
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);

			return AppConstant.TDM_FTD_NS_POLOVIEW;
		}
		catch (Exception baseEx)
		{
			baseEx.printStackTrace();
			return AppConstant.TDM_FTD_NS_POLOVIEW;
		}
	}

	@RequestMapping(value = "/myReservationRecords", method = RequestMethod.GET)
	public String myReservationRecords(
			@ModelAttribute(AppConstant.TDM_POLOSEARCH_DTO) POLOSearchDTO poloSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal)

	{
		String userName = null;
		try
		{

			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID))
			{
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			List<PoloReservationDTO> resrvationDTOsList = searchManagementService
					.getReservedRecords(userName);
			poloSearchDTO.setPoloResrvationDTOList(resrvationDTOsList);
			request.setAttribute(AppConstant.NO_OF_PAGES, 2);
			request.setAttribute(AppConstant.START_PAGE, 1);
			request.setAttribute(AppConstant.LAST_PAGE, 2);
			model.addAttribute(AppConstant.TDM_POLOSEARCH_DTO, poloSearchDTO);
			return "myReservations";
		}
		catch (NullPointerException ex)
		{
			return "myReservations";
		}
		catch (Exception se)
		{
			return "myReservations";
		}
	}

	@RequestMapping(value = "/unReserveRecords", method = RequestMethod.POST)
	public String unResrveReservedRecords(
			@ModelAttribute(AppConstant.TDM_POLOSEARCH_DTO) POLOSearchDTO poloSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal)

	{
		String userName = null;
		try
		{
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID))
			{
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}
			int unResCount = searchManagementService.unReserveReservedPoloRecords(poloSearchDTO,
					userName);
			request.setAttribute(AppConstant.CURRENT_PAGE, 1);
			request.setAttribute(AppConstant.NO_OF_PAGES, 2);
			request.setAttribute(AppConstant.START_PAGE, 1);
			request.setAttribute(AppConstant.LAST_PAGE, 2);
			model.addAttribute(AppConstant.TDM_POLOSEARCH_DTO, poloSearchDTO);
			model.addAttribute("unResCount", unResCount);
			return "myReservations";
		}
		catch (NullPointerException ex)
		{
			return "myReservations";
		}
		catch (Exception se)
		{
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
	@RequestMapping(value = AppConstant.TDM_FTD_POLO, method = RequestMethod.POST, params = "export")
	public ModelAndView tdmNonStandResultExport(
			@ModelAttribute(AppConstant.TDM_POLOSEARCH_DTO) POLOSearchDTO poloSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("serachPoloResultsToExcel", "poloSearchDtosList",
				poloSearchDTO.getPoloSearchResultList());
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
			@ModelAttribute(AppConstant.TDM_POLOSEARCH_DTO) POLOSearchDTO poloSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("myReservationDashboardExcel", "reservationDtosList",
				poloSearchDTO.getPoloResrvationDTOList());
	}

	public String getSearchCriteria(POLOSearchDTO poloSerachDTO)
	{
		StringBuffer searchCriteria = new StringBuffer();
		if (null != poloSerachDTO)
		{
			searchCriteria.append("Search Result for: ");

			if (StringUtils.isNotEmpty(poloSerachDTO.getDatabase()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.db", null, null))
						.append(" = ");
			}

			if (StringUtils.isNotEmpty(poloSerachDTO.getLineOFBusiness()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.lob", null, null))
						.append(" = ");
			}

			if (StringUtils.isNotEmpty(poloSerachDTO.getStatus()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.stat", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getProdType()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.pType", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getSubsDivision()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.subDiv", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getCovTermStartDate()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.covTSDT", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getCovTermEndDate()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.covTEDT", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getVehicleGrp()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.vGrp", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getPremTypeCode()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.pTypeCode", null, null))
						.append(" = ");
			}
			if (StringUtils.isNotEmpty(poloSerachDTO.getInsurncePolHStatCode()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.ipHStCode", null, null))
						.append(" = ");
			}

			if (StringUtils.isNotEmpty(poloSerachDTO.getPolicyHoldrType()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.ipHStCode", null, null))
						.append(" = ");
			}

			if (StringUtils.isNotEmpty(poloSerachDTO.getPolicyHistoryId()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.phi", null, null))
						.append(" = ");
			}

			if (StringUtils.isNotEmpty(poloSerachDTO.getPolicyHolderRegion()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.phr", null, null))
						.append(" = ");
			}

			if (StringUtils.isNotEmpty(poloSerachDTO.getMfuTypeDSC()))
			{
				searchCriteria.append(messageSource.getMessage("label.polo.mtd", null, null))
						.append(" = ");
			}
		}
		else
		{
			searchCriteria.append("No Records found");
		}
		return searchCriteria.toString();
	}
}
