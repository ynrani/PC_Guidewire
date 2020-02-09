package com.tesda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tesda.constants.TDMConstants;
import com.tesda.model.DTO.TdgChangeMgmtDTO;
import com.tesda.model.DTO.TdgDataRefreshDTO;
import com.tesda.model.DTO.TdgDataSubsettingDTO;
import com.tesda.model.DTO.TdgTestDataRequestDTO;

/**
 * @author
 * @version 1.0
 */

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMDemandController
{
	@RequestMapping(value = TDMConstants.MAP_TDMDATA_SUBSETTING, method = RequestMethod.GET)
	public String tdmDataSubsettingGet(
			@ModelAttribute(TDMConstants.MODEL_TDGDATA_SUBSETTING_DTO) TdgDataSubsettingDTO tdgDataSubsettingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return TDMConstants.TDM_DATA_SUBSETTING;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_CHNAGEMGMT, method = RequestMethod.GET)
	public String tdmDataChangeMgmtGet(
			@ModelAttribute(TDMConstants.MODEL_TDM_CHANGEMGMT_DTO) TdgChangeMgmtDTO tdgChangeMgmtDTO, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
	{
		return TDMConstants.TDM_CHANGE_MANAGEMENT;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAREFRESH, method = RequestMethod.GET)
	public String tdmDataRefreshGet(
			@ModelAttribute(TDMConstants.MODEL_TDM_DATAREFRESH_DTO) TdgDataRefreshDTO tdgDataRefreshDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return TDMConstants.TDM_DATAREFRESH;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_TESTDATA_REQ, method = RequestMethod.GET)
	public String tdmTestDataRequestGet(
			@ModelAttribute(TDMConstants.MODEL_TDG_TESTDATAREQ_DTO) TdgTestDataRequestDTO tdgTestDataRequestDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return TDMConstants.TDM_TESTDATA_REQ;
	}

}
