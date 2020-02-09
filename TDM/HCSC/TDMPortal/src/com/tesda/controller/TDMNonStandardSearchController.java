/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonStandardSearchController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. 		Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          		Created
 * 2	 Sikandar Shaikh		18/06/15  Logging changes	Updated
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TDMNonStandSearchFieldsDTO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;
import com.tesda.service.TDMNonStandSearchService;
import com.tesda.util.PaginationUtil;

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMNonStandardSearchController
{

	private static final Logger logger = LoggerFactory
			.getLogger(TDMNonStandardSearchController.class);

	private int noOfRecForpage = 5;

	private TDMNonStandSearchFieldsDTO nonStandSearchFieldsDTO = null;

	@Resource(name = TDMConstants.NONSTAND_SEARCH_MGMT_SERVICE)
	TDMNonStandSearchService searchManagementService;
	
	TDMNonStandardSearchDTO tdmNonStandardSearch;

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_RESERVATIONNS, method = RequestMethod.GET)
	public String tdmGetNonStandReserve(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, Principal principal)
	{
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSATND_RESRVE
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.RESERVATION_NS;
	}

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMNS_SEARCH, method = RequestMethod.GET)
	public String tdmGetNonStandFields(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS);
			nonStandSearchFieldsDTO = searchManagementService.getSearchFields();
			model.addAttribute("defaultValues", false);
			model.addAttribute(TDMConstants.SHOW, false);
			tdmNonStandSearchDTO.setNonStandSrchFldsDTO(nonStandSearchFieldsDTO);
			logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
		catch (ServiceException ex)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(ex));
			if (ex.getErrorCode() != null)
			{
				logger.error(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS,
						TDMExceptionCode.getExceptionMsg(ex));
			}
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
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
	 * @param principal
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMNS_SEARCH, method = RequestMethod.POST)
	public String tdmGetNonStandSearchRecords(
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "reserve", required = false) String reserve,
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		String userName = null;
		try
		{
			logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS);
			if (null != (String) request.getSession().getAttribute(TDMConstants.USER_ID))
			{
				userName = (String) request.getSession().getAttribute(TDMConstants.USER_ID);
			}
			Long totalRecords = 5L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.parseInt(tdmNonStandSearchDTO.getSearchRecordsNo());
			recordsperpage = noOfRecForpage;// recordsperpage / 2;
			// noOfRecForpage = recordsperpage;
			int offSet = pagenation.getOffset(request, recordsperpage);
			model.addAttribute(TDMConstants.SHOW, true);
			if (null != search)
			{
				logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS
						+ search);
				tdmNonStandSearchDTO = searchManagementService.getNonStandSearchRecords(
						tdmNonStandSearchDTO, offSet, recordsperpage);
				searchManagementService.getNonStandardSearchRecordCount(tdmNonStandSearchDTO,
						userName);
			}
			else if (null != reserve)
			{
				logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS
						+ reserve);
				int recordCount = searchManagementService.saveReservedData(tdmNonStandSearchDTO,
						userName);
				String msg = recordCount + " records reserved successfully.";
				model.addAttribute(TDMConstants.RESERVE_FLAG, msg);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			request.setAttribute(TDMConstants.START_PAGE, 1);
			request.setAttribute(TDMConstants.CURRENT_PAGE, 1);
			request.setAttribute(TDMConstants.LAST_PAGE, noOfPages);
			// model.addAttribute(TDMConstants.TOTAL_RECORDS, totalRecords);
			tdmNonStandSearchDTO.setNonStandSrchFldsDTO(nonStandSearchFieldsDTO);
			request.setAttribute(TDMConstants.RESULT, getSearchCriteria(tdmNonStandSearchDTO));
			if (tdmNonStandSearchDTO.getTdmNonStandardSrchResultListDTOs() != null)
			{
				model.addAttribute(TDMConstants.TOTAL_RECORDS, tdmNonStandSearchDTO
						.getTdmNonStandardSrchResultListDTOs().size());
			}

			model.addAttribute(TDMConstants.TDM_NONSTAND_RESULTDTOLIST,
					tdmNonStandSearchDTO.getTdmNonStandardSrchResultListDTOs());
			model.addAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO, tdmNonStandSearchDTO);
			logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS
					+ MessageConstants.LOG_INFO_RETURN);
			
			tdmNonStandardSearch =tdmNonStandSearchDTO;
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
		catch (NullPointerException se)
		{
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode
					.getExceptionMsg(new ServiceException(TDMExceptionCode.NULL_POINTR, se)));
			logger.error(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS,
					se.getMessage());
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
		catch (ServiceException se)
		{
			logger.error(MessageConstants.NONSTAND_CNTRL + MessageConstants.NONSTAND_FIELDS,
					TDMExceptionCode.getExceptionMsg(se));
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.TDM_NONSTANDARD_SEARCH;
		}
	}

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMNONSTANDARD_SEARCH, method = RequestMethod.GET)
	public String tdmResetNonStand(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.RESET_NONSTAND);
		model.addAttribute(TDMConstants.SHOW, false);
		tdmNonStandSearchDTO.setNonStandSrchFldsDTO(nonStandSearchFieldsDTO);
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.RESET_NONSTAND
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.TDM_NONSTANDARD_SEARCH;
	}

	@RequestMapping(value = TDMConstants.MAP_TDMNONSTAND_AUTO, method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public Set<String> getAccountNamesList(
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "term", required = false) String reqToken, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws TDMException
	{
		Set<String> list = null;
		try
		{
			logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.RESET_NONSTAND + type);
			list = searchManagementService.getAccountNameNumberList(type, reqToken);
			logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.RESET_NONSTAND
					+ MessageConstants.LOG_INFO_RETURN);
			return list;
		}
		catch (ServiceException se)
		{
			logger.error(MessageConstants.NONSTAND_CNTRL + MessageConstants.RESET_NONSTAND,
					TDMExceptionCode.getExceptionMsg(se));
			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			return list;
		}
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
	@RequestMapping(value = TDMConstants.MAP_TDMNS_SEARCH, method = RequestMethod.POST, params = "export")
	public ModelAndView tdmNonStandResultExport(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.EXPORT_NONSTAND
				+ MessageConstants.LOG_INFO_RETURN);
		return new ModelAndView(TDMConstants.TDM_NONSTAND_SERCHRESULT_XLS,
				TDMConstants.TDM_NONSTAND_SEARCHDTOLIST,
				tdmNonStandSearchDTO.getTdmNonStandardSrchResultListDTOs());
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
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/x12Format", method = RequestMethod.GET)
	public String tdmGenerateX12(
			@RequestParam(value = "subId", required = false) String subId,
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.EXPORT_NONSTAND
				+ MessageConstants.LOG_INFO_RETURN);
		List<TdmNonStandardSearchResultListDTO> dtosList= tdmNonStandardSearch.getTdmNonStandardSrchResultListDTOs();
		subId = subId.replaceAll(",", "");
		if(dtosList!= null && dtosList.size() >0)
		{
			for(TdmNonStandardSearchResultListDTO tdmNonDTo: dtosList)
			{
				if(tdmNonDTo.getSubscId().equalsIgnoreCase(subId))
				{
					tdmNonStandSearchDTO = new TDMNonStandardSearchDTO();					
					tdmNonStandSearchDTO.setFirstName(tdmNonDTo.getFirstName());
					tdmNonStandSearchDTO.setLastName(tdmNonDTo.getLastName());
					if(tdmNonDTo.getDob() !=null)
					{
						tdmNonStandSearchDTO.setDob(tdmNonDTo.getDob());
					}
					
					tdmNonStandSearchDTO.setHomeZipCode(tdmNonDTo.getHomeZipCode());
					tdmNonStandSearchDTO.setGroupNum(tdmNonDTo.getGroupNum());
				}
			}
		}
		model.addAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO, tdmNonStandSearchDTO);
		return "x12Format";
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
	@RequestMapping(value = "/generateX12File", method = RequestMethod.POST, params = "generateX12File")
	public ModelAndView tdmGenerateX12File(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.EXPORT_NONSTAND
				+ MessageConstants.LOG_INFO_RETURN);
		return new ModelAndView(TDMConstants.TDM_GENERATE_X12FORMAT_CSV,
				TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO,
				tdmNonStandSearchDTO);
	}
	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param tdmNonStandSearchDTO
	 * @return
	 */
	public String getSearchCriteria(TDMNonStandardSearchDTO tdmNonStandSearchDTO)
	{
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.SEARCH_CRITERIA);
		StringBuffer searchCriteria = new StringBuffer();
		if (null != tdmNonStandSearchDTO)
		{
			searchCriteria.append("Search Result for: ");
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getMemCat()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.memCatt", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getMemCat()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getAgeGroup()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.ageGrp", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getAgeGroup()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSubscRelation()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.subRep", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getSubscRelation()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getProvState()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.state", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getProvState()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getAccountName()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.acName", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getAccountName()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getAcNum()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.acNum", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getAcNum()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getPlanType()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.plnType", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getPlanType()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSubscId()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.subId", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getSubscId()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getCoverageCode()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.cov", null, null)).append(
						" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getCoverageCode()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getSubscStatus()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.sts", null, null)).append(
						" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getSubscStatus()).append("; ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandSearchDTO.getExtClaim()))
			{
				searchCriteria.append(messageSource.getMessage("label.ns.extClm", null, null))
						.append(" = ");
				searchCriteria.append(tdmNonStandSearchDTO.getExtClaim()).append(" ");
			}
		}
		else
		{
			searchCriteria.append("No Records found");
		}
		logger.info(MessageConstants.NONSTAND_CNTRL + MessageConstants.SEARCH_CRITERIA
				+ MessageConstants.LOG_INFO_RETURN);
		logger.info("Create search criteria");
		return searchCriteria.toString();
	}
}
