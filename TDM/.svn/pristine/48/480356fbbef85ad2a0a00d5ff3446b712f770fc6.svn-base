/*---------------------------------------------------------------------------------------
 * Object Name: TDMAdminController.Java
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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import com.tdm.model.DTO.TdmUserDTO;
import com.tdm.model.DTO.ValidationResponse;
import com.tdm.service.TDMAdminService;
import com.tdm.util.PaginationUtil;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Controller
public class TDMAdminController
{
	private static Logger logger = Logger.getLogger(TDMAdminController.class);

	@Resource(name = MessageConstant.SERVICE_ADMIN)
	TDMAdminService tDMAdminService;

	/**
	 * 
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_ADMIN_CREATE_GET, method = RequestMethod.POST)
	public String userDetails(@ModelAttribute(MessageConstant.USER_DO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String strReturnPage = AppConstant.TDM_ADMIN_REDIRECT;
		try {
			boolean bEdit = userdo.isCreated();
			String strMessage = tDMAdminService.saveUserDetails(userdo, bEdit);
			if (!AppConstant.SUCCESS_SMALL.equals(strMessage)) {
				model.addAttribute(AppConstant.ERRORS, MessageConstant.TDM_USER_ID_EXIST);
				model.addAttribute(MessageConstant.USER_DO, userdo);
				model.addAttribute(AppConstant.BUTTON, MessageConstant.TDM_ADMIN_CREATE_USER);
				strReturnPage = AppConstant.TDM_ADMIN_CREATE_VIEW;
			}
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
					+ MessageConstant.LOG_INFO_RETURN);
			return strReturnPage;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_USER_DRL
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return strReturnPage;
		}

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_ADMIN_DISPLAY_GET, method = RequestMethod.GET)
	public String displayAdmin() {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		return AppConstant.TDM_ADMIN_VIEW;
	}

	/**
	 * 
	 * @param search
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_ADMIN_ADM_GET, method = RequestMethod.GET)
	public String displayUser(
			@RequestParam(value = AppConstant.PAGE, required = false) String search,
			@ModelAttribute(MessageConstant.USER_DO) TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			User user = (User) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			userdo.setUserId(user.getUsername());
			totalRecords = tDMAdminService.searchUserRecordsCount(userdo);
			List<TdmUserDTO> DiaplayUser = tDMAdminService.getAllUser(userdo, offSet,
					recordsperpage, true);
			pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(AppConstant.NO_OF_PAGES, noOfPages);
			model.addAttribute(AppConstant.TDM_ADMIN_DISPLAY_USER, DiaplayUser);
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ADMIN_USERS_VIEW;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DISPLAY_USER
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {

					return AppConstant.TDM_ADMIN_USERS_VIEW;
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ADMIN_USERS_VIEW;
		}

	}

	/**
	 * 
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_ADMIN_EDIT_USER_GET, method = RequestMethod.GET)
	public String editUser(@ModelAttribute(MessageConstant.USER_DO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_EDIT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String userId = request.getParameter(AppConstant.USER_ID);
			userdo = tDMAdminService.getEditUser(userId);
			// System.out.println("$$$$$$$$ Role "+userdo.getTdmUserAuthDTO().getRole());
			model.addAttribute(MessageConstant.USER_DO, userdo);
			model.addAttribute(AppConstant.BUTTON, MessageConstant.TDM_ADMIN_CREATE_USER);
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_EDIT
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ADMIN_CREATE_VIEW;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_EDIT
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {

					return AppConstant.TDM_ADMIN_CREATE_VIEW;
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ADMIN_CREATE_VIEW;
		}
	}

	/**
	 * 
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(AppConstant.TDM_ADMIN_CREATE_NEW_GET)
	public String createNewUser(@ModelAttribute(MessageConstant.USER_DO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_NEW_USER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		userdo.setCreated(true);
		model.addAttribute(MessageConstant.USER_DO, userdo);
		model.addAttribute(AppConstant.BUTTON, MessageConstant.TDM_ADMIN_CREATE_USER);
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_NEW_USER
				+ MessageConstant.LOG_INFO_RETURN);
		return AppConstant.TDM_ADMIN_CREATE_VIEW;
	}

	/**
	 * 
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_ADMIN_DELETE_GET)
	public String daleteUser(@ModelAttribute(MessageConstant.USER_DO) TdmUserDTO userdo,
			@RequestParam(value = AppConstant.USER_ID, required = false) String delUserId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DELETE_USER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tDMAdminService.deleteUserByUserId(delUserId);
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DELETE_USER
					+ MessageConstant.LOG_INFO_RETURN);
			return AppConstant.TDM_ADMIN_REDIRECT;
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_DELETE_USER
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.TDM_ADMIN_REDIRECT;
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			return AppConstant.TDM_ADMIN_REDIRECT;
		}
	}

	/**
	 * 
	 * @param userid
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_ADMIN_VALIDATE_GET, method = RequestMethod.POST)
	public @ResponseBody ValidationResponse validateUserId(
			@RequestParam(value = "userid", required = false) String userid, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_VALIDATE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		ValidationResponse validationResponse = new ValidationResponse();
		try {
			List<String> listResult = new ArrayList<String>();
			boolean bCheck = tDMAdminService.validateUserId(userid);
			if (!bCheck) {
				validationResponse.setStatus(AppConstant.FAILED);
				listResult.add(userid + MessageConstant.TDM_USER_ID_EXIST);
				validationResponse.setResult(listResult);
			} else {
				validationResponse.setStatus(AppConstant.SUCCESS);
			}
			logger.info(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_VALIDATE
					+ MessageConstant.LOG_INFO_RETURN);
			return validationResponse;

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.TDM_ADMIN_CTRL + MessageConstant.TDM_ADMIN_VALIDATE
					+ MessageConstant.LOG_ERROR_EXCEPTION + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return validationResponse;
				}
			}
			model.addAttribute(AppConstant.ERROR, MessageConstant.EXCEPTION_ADMIN);
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			validationResponse.setStatus(AppConstant.FAILED);
			return validationResponse;
		}
	}
}
