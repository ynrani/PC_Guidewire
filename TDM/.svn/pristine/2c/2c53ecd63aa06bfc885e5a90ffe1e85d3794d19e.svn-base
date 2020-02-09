/*---------------------------------------------------------------------------------------
 * Object Name: DBConnectionController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          27/07/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.datacon.controller;

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

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;
import com.datacon.exception.BaseException;
import com.datacon.model.DTO.DbConnectionsDTO;
import com.datacon.service.DbConnectionService;
import com.datacon.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class DBConnectionController
{

	private static Logger logger = Logger.getLogger(DBConnectionController.class);

	@Resource(name = MessageConstant.DB_CON_SERVICE)
	DbConnectionService dbConnectionService;

	/**
	 * 
	 * @param id
	 * @param dbConnectionsDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.DB_CON, method = RequestMethod.GET)
	public String conGet(@RequestParam(value = AppConstant.ID, required = false) String id,
			@ModelAttribute(MessageConstant.DB_CON_CTO) DbConnectionsDTO dbConnectionsDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_GET
				+ MessageConstant.LOG_INFO_PARAMS_YES);
		try {
			if (null != id) {
				dbConnectionsDTO = dbConnectionService.savedConnection(id);
				modelmap.addAttribute(AppConstant.BTN, false);
			} else {
				modelmap.addAttribute(AppConstant.BTN, true);
			}

		} catch (BaseException baseEx) {

			logger.error(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {

					modelmap.addAttribute(AppConstant.BTN, true);
					return AppConstant.DB_CON_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			modelmap.addAttribute(AppConstant.BTN, true);
			modelmap.addAttribute(MessageConstant.DB_CON_CTO, dbConnectionsDTO);
			return AppConstant.DB_CON_VIEW;
		}
		modelmap.addAttribute(MessageConstant.DB_CON_CTO, dbConnectionsDTO);
		return AppConstant.DB_CON_VIEW;
	}

	/**
	 * 
	 * @param testCon
	 * @param saveCon
	 * @param dbConnectionsDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.DB_CON, method = RequestMethod.POST)
	public String conPOST(
			@RequestParam(value = AppConstant.TEST_CON, required = false) String testCon,
			@RequestParam(value = AppConstant.CREATE_CON, required = false) String saveCon,
			@ModelAttribute(MessageConstant.DB_CON_CTO) DbConnectionsDTO dbConnectionsDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_POST
				+ MessageConstant.LOG_INFO_PARAMS_YES);
		String pingSuccessMsg = null;
		String saveSuccessMsg = null;
		try {
			dbConnectionsDTO.setUserId((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
			if (null != testCon) {
				pingSuccessMsg = dbConnectionService.testConnection(dbConnectionsDTO);
			} else if (null != saveCon) {
				dbConnectionsDTO = dbConnectionService.saveConnection(dbConnectionsDTO);
				saveSuccessMsg = MessageConstant.SUCCESS_SAVE_MSG;
			}

		} catch (BaseException baseEx) {
			pingSuccessMsg = MessageConstant.PING_FAIL_MSG;
			saveSuccessMsg = MessageConstant.SAVE_FAIL_MSG;
			logger.error(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_POST
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					modelmap.addAttribute(AppConstant.STATUS, pingSuccessMsg);
					modelmap.addAttribute(AppConstant.SAVE_STS, saveSuccessMsg);
					modelmap.addAttribute(AppConstant.BTN, true);
					return AppConstant.DB_CON_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			modelmap.addAttribute(AppConstant.STATUS, pingSuccessMsg);
			modelmap.addAttribute(AppConstant.SAVE_STS, saveSuccessMsg);
			modelmap.addAttribute(AppConstant.BTN, true);
			return AppConstant.DB_CON_VIEW;
		}
		if (null != saveCon) {
			return AppConstant.DB_CON_LIST_RED;
		}
		modelmap.addAttribute(AppConstant.STATUS, pingSuccessMsg);
		modelmap.addAttribute(AppConstant.SAVE_STS, saveSuccessMsg);
		modelmap.addAttribute(AppConstant.BTN, false);
		return AppConstant.DB_CON_VIEW;

	}

	/**
	 * 
	 * @param page
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.DB_CON_LIST, method = RequestMethod.GET)
	public String connectionsDashboard(
			@RequestParam(value = AppConstant.PAGE, required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_DASH
				+ MessageConstant.LOG_INFO_PARAMS_SEPC + page);

		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = 10;
		try {
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = dbConnectionService.connectionsDashboardCount((String) request
					.getSession().getAttribute(AppConstant.SESSION_UID));
			List<DbConnectionsDTO> dbConnectionsDTOs = dbConnectionService.connectionsDashboard(
					offSet, recordsperpage, true,
					(String) request.getSession().getAttribute(AppConstant.SESSION_UID));
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.DB_CONN_DTLS, dbConnectionsDTOs);
			logger.info(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_DASH
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.DB_CON_LIST_VIEW;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_DASH
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.DB_CON_LIST_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.DB_CON_LIST_VIEW;
		}
	}

	@RequestMapping(value = AppConstant.DB_CON_DELETE, method = RequestMethod.GET)
	public String deleteConnection(
			@RequestParam(value = AppConstant.ID, required = false) String conId,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		logger.info(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_DELETE
				+ MessageConstant.LOG_INFO_PARAMS_YES);
		boolean sts = false;
		try {
			if (null != conId) {
				sts = dbConnectionService.deleteConnection(conId);
			}
			logger.info(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_DELETE
					+ MessageConstant.LOG_INFO_RETURN + sts);
		} catch (BaseException baseEx) {

			logger.error(MessageConstant.DB_CON_CTLR + MessageConstant.DB_CON_DELETE
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.DB_CON_LIST_RED;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.DB_CON_LIST_RED;
		}
		return AppConstant.DB_CON_LIST_RED;
	}

}
