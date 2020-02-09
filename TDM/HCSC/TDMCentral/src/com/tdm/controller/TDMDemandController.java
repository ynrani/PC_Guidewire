/*---------------------------------------------------------------------------------------
 * Object Name: TDMDemandController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.model.DTO.TdgChangeMgmtDTO;
import com.tdm.model.DTO.TdgDataRefreshDTO;
import com.tdm.model.DTO.TdgDataSubsettingDTO;
import com.tdm.model.DTO.TdgTestDataRequestDTO;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class TDMDemandController
{
	private static Logger logger = Logger.getLogger(TDMDemandController.class);

	/**
	 * 
	 * @param tdgDataSubsettingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_SUBSET, method = RequestMethod.GET)
	public String tdmDataSubsettingGet(
			@ModelAttribute(MessageConstant.TDM_SUBSETTING_STO) TdgDataSubsettingDTO tdgDataSubsettingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstant.TDM_DEMAND_CTLR + MessageConstant.TDM_SUBSETTING_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_SUBSET_VIEW;
	}

	/**
	 * 
	 * @param tdgChangeMgmtDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_CHANGE_MGMT, method = RequestMethod.GET)
	public String tdmDataChangeMgmtGet(
			@ModelAttribute(MessageConstant.TDM_CHANGE_MGMT_DTO) TdgChangeMgmtDTO tdgChangeMgmtDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstant.TDM_DEMAND_CTLR + MessageConstant.TDM_CHANGE_MGMT_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_CHANGE_MGMT_VIEW;
	}

	/**
	 * 
	 * @param tdgDataRefreshDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_REFRESH, method = RequestMethod.GET)
	public String tdmDataRefreshGet(
			@ModelAttribute(MessageConstant.TDM_DATA_REFRESH_DTO) TdgDataRefreshDTO tdgDataRefreshDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstant.TDM_DEMAND_CTLR + MessageConstant.TDM_DATA_REFRESH_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_DATA_REFRESH_VIEW;
	}

	/**
	 * 
	 * @param tdgTestDataRequestDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_DATA_REQ, method = RequestMethod.GET)
	public String tdmTestDataRequestGet(
			@ModelAttribute(MessageConstant.TDM_DATA_REQ_DTO) TdgTestDataRequestDTO tdgTestDataRequestDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstant.TDM_DEMAND_CTLR + MessageConstant.TDM_DATA_REQ_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_DATA_REQ_VIEW;
	}

}
