package com.tesda.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.exception.BaseException;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tesda.service.TdmMyReservationService;
import com.tesda.util.PaginationUtil;

/**
 * @author
 * @version 1.0
 */

@Controller
public class TdmMyReservationController
{

	final static Logger logger = Logger.getLogger(TdmMyReservationController.class);
	@Resource(name = "tdmMyReservationService")
	TdmMyReservationService tdmMyReservationService;
	List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTO = null;
	List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTO = null;

	@RequestMapping(value = "/myReservationAuto", method = RequestMethod.GET)
	public String myReservationRecordAuto(
			@RequestParam(value = "page", required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{

		logger.info("In reservation controller: ");
		try
		{
			String UserId = (String) request.getSession().getAttribute("UserId");
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			Integer recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO = tdmMyReservationService
					.getReservedRecordForUser(UserId, offSet, recordsperpage, true);
			String searchType = "CSAA_AU";
			totalRecords = tdmMyReservationService.getReservedRecordsCount(searchType, UserId);
			pagenation
					.paginate(totalRecords, request, recordsperpage.doubleValue(), recordsperpage);
			Double noOfPages = Math.ceil(totalRecords.doubleValue() / recordsperpage.doubleValue());
			request.setAttribute("noOfPages", noOfPages.intValue());
			model.addAttribute("tdmPolicyAutoSearchResultDTOList",
					tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList());
			tdmPolicyAutoSearchResultDTO = tdmPolicyAutoSearchDTO
					.getTdmPolicyAutoSearchResultDTOList();
			return "reservationPolicyAuto";
		} catch (BaseException baseEx)
		{
			logger.error("MyReservationRecordAuto error while reserving records!", baseEx);

			if (baseEx.getErrorCode() != null)
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "reservationPolicyAuto";
			}
		}
		return "reservationPolicyAuto";
	}

	@RequestMapping(value = "/unreserveAuto", method = RequestMethod.GET)
	public String unreserveRecordAuto(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException
	{
		try
		{
			logger.info("In controller to unreserve records : ");
			String UserId = (String) request.getSession().getAttribute("UserId");
			Long totalRecords = 0L;

			PaginationUtil pagenation = new PaginationUtil();
			Integer recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);

			tdmMyReservationService.unReservedRecordForUser(request.getParameter("id"));
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO = tdmMyReservationService
					.getReservedRecordForUser(UserId, offSet, recordsperpage, true);
			String searchType = "CSAA_AU";
			totalRecords = tdmMyReservationService.getReservedRecordsCount(searchType, UserId);
			pagenation
					.paginate(totalRecords, request, recordsperpage.doubleValue(), recordsperpage);
			Double noOfPages = Math.ceil(totalRecords.doubleValue() / recordsperpage.doubleValue());
			request.setAttribute("noOfPages", noOfPages.intValue());
			model.addAttribute("tdmPolicyAutoSearchResultDTOList",
					tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList());
			tdmPolicyAutoSearchResultDTO = tdmPolicyAutoSearchDTO
					.getTdmPolicyAutoSearchResultDTOList();
			return "reservationPolicyAuto";
		} catch (BaseException baseEx)
		{
			logger.error("Error while reserving the records!", baseEx);
			if (baseEx.getErrorCode() != null)
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "reservationPolicyAuto";
			}

		}
		return "reservationPolicyAuto";
	}

	@RequestMapping(value = "/myReservationProp", method = RequestMethod.GET)
	public String myReservationRecordProperty(
			@RequestParam(value = "page", required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{

		try
		{
			logger.info("In My Reservation saving Record for Property : ");

			String UserId = (String) request.getSession().getAttribute("UserId");
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			Integer recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);

			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO = tdmMyReservationService
					.getReservedRecordForUserProperty(UserId, offSet, recordsperpage, true);
			String searchType = "CSAA_PO";
			totalRecords = tdmMyReservationService.getReservedRecordsCount(searchType, UserId);
			pagenation
					.paginate(totalRecords, request, recordsperpage.doubleValue(), recordsperpage);
			Double noOfPages = Math.ceil(totalRecords.doubleValue() / recordsperpage.doubleValue());
			request.setAttribute("noOfPages", noOfPages.intValue());
			model.addAttribute("tdmPolicyPropertySearchResultDTOList",
					tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList());
			tdmPolicyPropertySearchResultDTO = tdmPolicyPropertySearchDTO
					.getTdmPolicyPropertySearchResultDTOList();
			return "reservationPolicyProperty";
		} catch (BaseException baseEx)
		{
			logger.error("Sorry, something wrong while reserving record for property!", baseEx);

			if (baseEx.getErrorCode() != null)
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "reservationPolicyProperty";
			}
		}
		return "reservationPolicyProperty";
	}

	@RequestMapping(value = "/unreserveProp", method = RequestMethod.GET)
	public String unreserveRecordProperty(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException
	{
		try
		{
			logger.info("Unreserve Record for Property : ");
			String UserId = (String) request.getSession().getAttribute("UserId");
			Long totalRecords = 0L;

			PaginationUtil pagenation = new PaginationUtil();
			Integer recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);

			tdmMyReservationService.unReservedRecordForUser(request.getParameter("id"));
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO = tdmMyReservationService
					.getReservedRecordForUserProperty(UserId, offSet, recordsperpage, true);
			String searchType = "CSAA_PO";
			totalRecords = tdmMyReservationService.getReservedRecordsCount(searchType, UserId);
			pagenation
					.paginate(totalRecords, request, recordsperpage.doubleValue(), recordsperpage);
			Double noOfPages = Math.ceil(totalRecords.doubleValue() / recordsperpage.doubleValue());
			request.setAttribute("noOfPages", noOfPages.intValue());
			model.addAttribute("tdmPolicyPropertySearchResultDTOList",
					tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList());
			tdmPolicyPropertySearchResultDTO = tdmPolicyPropertySearchDTO
					.getTdmPolicyPropertySearchResultDTOList();
			return "reservationPolicyProperty";
		} catch (BaseException baseEx)
		{
			logger.error("Sorry, something wrong while Unreserving record for property!", baseEx);
			if (baseEx.getErrorCode() != null)
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "reservationPolicyProperty";
			}

		}
		return "reservationPolicyProperty";
	}

	@RequestMapping(value = "/myReservationProp", method = RequestMethod.POST, params = "export")
	public ModelAndView policyPropertyRevdataExport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws BaseException
	{

		logger.info("TdmMyReservationController class policyPropertyRevdataExport export : ");
		System.out.println("TdmMyReservationController class policyPropertyRevdataExport export");
		return new ModelAndView("searchPolicyPropListExcelView",
				"tdmPolicyPropertySearchResultDTOs", tdmPolicyPropertySearchResultDTO);
	}

	@RequestMapping(value = "/myReservationAuto", method = RequestMethod.POST, params = "export")
	public ModelAndView policyAutoRevdataExport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{

		System.out.println("TdmMyReservationController class findTestProvReservedDataPost export");
		return new ModelAndView("searchPolicyAutoListExcelView", "tdmPolicyAutoSearchResultDTOs",
				tdmPolicyAutoSearchResultDTO);

	}

}
