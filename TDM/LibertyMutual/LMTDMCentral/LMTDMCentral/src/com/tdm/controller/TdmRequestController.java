/*---------------------------------------------------------------------------------------
 * Object Name: TdmRequestController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          30/10/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.BaseException;
import com.tdm.model.DTO.TdmRequestDTO;
import com.tdm.model.DTO.TdmSearchRequestDTO;
import com.tdm.service.TdmRequestService;
import com.tdm.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class TdmRequestController {

	private static Logger logger = Logger.getLogger(TdmRequestController.class);

	@Resource(name = "tdmRequestService")
	TdmRequestService tdmRequestService;

	TdmSearchRequestDTO tdmSearchRequestDTO1 = null;

	@RequestMapping(value = "/tdmRequest", method = RequestMethod.GET)
	public String createReqGet(@ModelAttribute("tdmRequestDTO") TdmRequestDTO tdmRequestDTO,
			@RequestParam(value = AppConstant.REQ_ID, required = false) String reqId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_GET + MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			tdmRequestDTO.setUserId((String) request.getSession().getAttribute(AppConstant.SESSION_UID));
			if (null != reqId) {
				tdmRequestDTO = tdmRequestService.selectRecord(reqId);
			}

			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_INFO_RETURN);

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "tdmRequest";
				}
			}
			modelmap.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by
			// passing key as // baseEx.getErrorCode();
			modelmap.addAttribute("tdmRequestDTO", tdmRequestDTO);
			return "tdmRequest";
		}
		modelmap.addAttribute("tdmRequestDTO", tdmRequestDTO);
		return "tdmRequest";
	}

	@RequestMapping(value = "/tdmRequest", method = RequestMethod.POST)
	public @ResponseBody String createReqPOST(@ModelAttribute("tdmRequestDTO") TdmRequestDTO tdmRequestDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_GET + MessageConstant.LOG_INFO_PARAMS_NO);
		String reqId = "";
		try {

			reqId = tdmRequestService.createReq(tdmRequestDTO);

			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_INFO_RETURN);

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "tdmRequest";
				}
			}
			modelmap.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);

			// responseMsg = passcodes and get msg from properties file by
			// passing key as // baseEx.getErrorCode();
			modelmap.addAttribute("reqId", reqId);
			modelmap.addAttribute("tdmRequestDTO", tdmRequestDTO);
			return "tdmRequest";
		}
		modelmap.addAttribute("reqId", reqId);
		modelmap.addAttribute("tdmRequestDTO", tdmRequestDTO);
		return reqId;

	}

	// TODO

	@RequestMapping(value = "/tdmSearchRequest", method = RequestMethod.GET)
	public String searchReqGet(@ModelAttribute("tdmSearchRequestDTO") TdmSearchRequestDTO tdmSearchRequestDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {

		tdmSearchRequestDTO.setUserId((String) request.getSession().getAttribute(AppConstant.SESSION_UID));

		modelmap.addAttribute("tdmSearchRequestDTO", tdmSearchRequestDTO);
		return "tdmSearchRequest";
	}

	@RequestMapping(value = "/tdmSearchRequest", method = RequestMethod.POST)
	public String searchReqPOST(@ModelAttribute("tdmSearchRequestDTO") TdmSearchRequestDTO tdmSearchRequestDTO,
			@RequestParam(value = "search", required = false) String search, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR + MessageConstant.TDM_CLAIM_SEARCH_FTD_POST
				+ MessageConstant.LOG_INFO_SEARCH + search);
		Long totalRecords = 0L;
		try {
			String userName = null;
			if (null != (String) request.getSession().getAttribute(AppConstant.SESSION_UID)) {
				userName = (String) request.getSession().getAttribute(AppConstant.SESSION_UID);
			}

			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 5;
			int offSet = pagenation.getOffset(request, recordsperpage);
			if (null != search) {
				tdmSearchRequestDTO.setUserId(userName);
				tdmSearchRequestDTO = tdmRequestService.searchReq(tdmSearchRequestDTO, offSet, recordsperpage, true);
				totalRecords = tdmRequestService.searchReqCnt(tdmSearchRequestDTO);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			tdmSearchRequestDTO1 = tdmSearchRequestDTO;
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.COUNT, totalRecords);
			model.addAttribute(AppConstant.TOT_RECS, totalRecords);
			model.addAttribute("tdmSearchRequestDTOs", tdmSearchRequestDTO.getTdmSearchRequestDTOs());
			logger.info(MessageConstant.TDM_CLAIM_SEARCH_CTLR + MessageConstant.TDM_CLAIM_SEARCH_FTD_POST
					+ MessageConstant.LOG_INFO_RETURN);
			return "tdmSearchRequest";
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_CLAIM_SEARCH_CTLR + MessageConstant.TDM_CLAIM_SEARCH_FTD_POST
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "tdmSearchRequest";
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			model.addAttribute(AppConstant.COUNT, totalRecords);
			model.addAttribute("tdmSearchRequestDTOs", tdmSearchRequestDTO.getTdmSearchRequestDTOs());
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			return "tdmSearchRequest";
		}

	}

	@RequestMapping(value = "/tdmSearchRequest", method = RequestMethod.GET, params = "page")
	public String searchReqPage(@ModelAttribute("tdmSearchRequestDTO") TdmSearchRequestDTO tdmSearchRequestDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws BaseException {

		logger.info("In auto search controller  policyAutoPagiNation methos: ");
		String userName = null;
		int countPerPage = 0;
		try {
			tdmSearchRequestDTO = tdmSearchRequestDTO1;
			if (null != (String) request.getSession().getAttribute("UserId")) {
				userName = (String) request.getSession().getAttribute("UserId");
			}

			Long totalRecords = 50L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 5;
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdmSearchRequestDTO.setUserId(userName);
			tdmSearchRequestDTO = tdmRequestService.searchReq(tdmSearchRequestDTO, offSet, recordsperpage, true);
			// set the size to no of records variable

			pagenation.paginate(totalRecords, request, (Double.valueOf(recordsperpage)), recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute("noOfPages", noOfPages);
			model.addAttribute("totalRecords", countPerPage);
			model.addAttribute("tdmSearchRequestDTOs", tdmSearchRequestDTO.getTdmSearchRequestDTOs());
			model.addAttribute("tdmSearchRequestDTO", tdmSearchRequestDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			return "tdmSearchRequest";
		}
		logger.info("In auto search controller  policyAutoPagiNation methos return to UI: ");

		return "tdmSearchRequest";

	}

	@RequestMapping(value = "/tdmSearchRequestList", method = RequestMethod.GET)
	public String reqListing(@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_LOGIN_CTLR + MessageConstant.TDM_LOGIN_GET + MessageConstant.LOG_INFO_PARAMS_NO);
		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = 10;
		try {
			int offSet = pagenation.getOffset(request, recordsperpage);

			totalRecords = tdmRequestService.reqListCount((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
			List<TdmSearchRequestDTO> tdmSearchRequestDTOs = tdmRequestService.reqList(offSet, recordsperpage, true,
					(String) request.getSession().getAttribute(AppConstant.SESSION_UID));

			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);

			modelmap.addAttribute("tdmSearchRequestDTOs", tdmSearchRequestDTOs);
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_INFO_RETURN);
			return "tdmRequestListing";
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return "tdmRequestListing";
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return "tdmRequestListing";

		}
	}

}
