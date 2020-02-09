/*---------------------------------------------------------------------------------------
 * Object Name: TDMMyReservationController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. 		Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          		Created
 * 2		Sikandar Shaikh		18/06/15  Logging changes	Updated
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TDMNonStandReservationDTO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.service.TDMNonStandSearchService;

@Controller
public class TDMMyReservationController
{
	private static final Logger logger = LoggerFactory.getLogger(TDMMyReservationController.class);

	@Resource(name = TDMConstants.NONSTAND_SEARCH_MGMT_SERVICE)
	TDMNonStandSearchService searchManagementService;

	/**
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_MYRESERVATIONS, method = RequestMethod.GET)
	public String myReservationRecords(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		logger.info(MessageConstants.RESRVTION_CNTRL + MessageConstants.RESVTION_RCRDS);
		String userName = null;
		try
		{
			if (null != (String) request.getSession().getAttribute(TDMConstants.USER_ID))
			{
				userName = (String) request.getSession().getAttribute(TDMConstants.USER_ID);
			}
			List<TDMNonStandReservationDTO> tdmNonStandResevationDto = searchManagementService
					.getReservedRecords(userName);
			request.setAttribute(TDMConstants.CURRENT_PAGE, 1);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, 2);
			request.setAttribute(TDMConstants.START_PAGE, 1);
			request.setAttribute(TDMConstants.LAST_PAGE, 2);
			tdmNonStandSearchDTO.setTdmNonStandReservationDtos(tdmNonStandResevationDto);
			model.addAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO, tdmNonStandSearchDTO);
			logger.info(MessageConstants.RESRVTION_CNTRL + MessageConstants.RESVTION_RCRDS
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.MY_RESERVATIONS;
		}
		catch (NullPointerException ex)
		{
			logger.error(MessageConstants.RESRVTION_CNTRL + MessageConstants.RESVTION_RCRDS,
					ex.getMessage());
			return TDMConstants.MY_RESERVATIONS;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				logger.error(MessageConstants.RESRVTION_CNTRL + MessageConstants.RESVTION_RCRDS,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.MY_RESERVATIONS;
		}
	}

	/**
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_UNRESERVE, method = RequestMethod.POST)
	public String unResrveReservedRecords(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		logger.info(MessageConstants.RESRVTION_CNTRL + MessageConstants.UNRESRVE_RCRDS);
		String userName = null;
		try
		{
			if (null != (String) request.getSession().getAttribute(TDMConstants.USER_ID))
			{
				userName = (String) request.getSession().getAttribute(TDMConstants.USER_ID);
			}
			int unResCount = searchManagementService.unReserveReservedRecords(tdmNonStandSearchDTO,
					userName);
			request.setAttribute(TDMConstants.CURRENT_PAGE, 1);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, 2);
			request.setAttribute(TDMConstants.START_PAGE, 1);
			request.setAttribute(TDMConstants.LAST_PAGE, 2);
			model.addAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO, tdmNonStandSearchDTO);
			model.addAttribute(TDMConstants.UNRESEVVE_COUNT, unResCount);
			logger.info(MessageConstants.RESRVTION_CNTRL + MessageConstants.UNRESRVE_RCRDS
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.MY_RESERVATIONS;
		}
		catch (NullPointerException ex)
		{
			logger.error(MessageConstants.RESRVTION_CNTRL + MessageConstants.UNRESRVE_RCRDS,
					ex.getMessage());
			return TDMConstants.MY_RESERVATIONS;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				logger.error(MessageConstants.RESRVTION_CNTRL + MessageConstants.UNRESRVE_RCRDS,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.MY_RESERVATIONS;
		}
	}

	/**
	 * @param export
	 * @param tdmNonStandSearchDTO
	 * @param model
	 * @param request
	 * @param response
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_UNRESERVE, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView exportReservedRecords(
			@ModelAttribute(TDMConstants.MODEL_TDMNON_STANDARDSEARCH_DTO) TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws TDMException
	{
		logger.info(MessageConstants.RESRVTION_CNTRL + MessageConstants.EXPRT_RESRVE_RCRDS
				+ MessageConstants.LOG_INFO_RETURN);
		return new ModelAndView(TDMConstants.TDM_NONSTAND_RESRVATION_XLS,
				TDMConstants.TDM_NONSTAND_DTOLIST,
				tdmNonStandSearchDTO.getTdmNonStandReservationDtos());
	}
}
