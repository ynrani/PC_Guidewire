/*---------------------------------------------------------------------------------------
 * Object Name: TDMAdminController.Java
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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmUserDTO;
import com.tesda.model.DTO.ValidationResponse;
import com.tesda.service.TDMAdminService;
import com.tesda.util.PaginationUtil;

@Controller
public class TDMAdminController
{

	private static final Logger logger = LoggerFactory.getLogger(TDMAdminController.class);

	@Resource(name = TDMConstants.TDM_ADMIN_SERVICE)
	TDMAdminService tDMAdminService;

	/**
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TESDA_USERCREATE, method = RequestMethod.POST)
	public String userDetails(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.USRDTLS);
		String strReturnPage = TDMConstants.REDIRECT_TESTDA_ADMIN;
		try
		{
			boolean bEdit = userdo.isCreated();
			String strMessage = tDMAdminService.saveUserDetails(userdo, bEdit);
			if (!"Success".equals(strMessage))
			{
				model.addAttribute("errors", TDMConstants.ID_EXIST);
				String button = TDMConstants.BUTTON_TEXT;
				model.addAttribute(TDMConstants.MODEL_USERDO, userdo);
				model.addAttribute(TDMConstants.BUTTON, button);
				strReturnPage = TDMConstants.CREATE_NEW_USER;
			}
			logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.USRDTLS
					+ MessageConstants.LOG_INFO_RETURN);
			return strReturnPage;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
				logger.error(MessageConstants.ADMIN_CNTRL + MessageConstants.USRDTLS,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return strReturnPage;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TESTDISPLAY_ADMIN, method = RequestMethod.GET)
	public String displayAdmin()
	{
		return TDMConstants.ADMIN;
	}

	/**
	 * @param search
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TEST_DA_ADMIN, method = RequestMethod.GET)
	public String displayUser(
			@RequestParam(value = TDMConstants.PAGE, required = false) String search,
			@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.DISPLYUSR);
		try
		{
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
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);

			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute("displayUser", DiaplayUser);
			logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.DISPLYUSR
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.DISPLAY_USERS;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
				logger.error(MessageConstants.ADMIN_CNTRL + MessageConstants.DISPLYUSR,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.DISPLAY_USERS;
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
	@RequestMapping(value = TDMConstants.MAP_EDITUSER, method = RequestMethod.GET)
	public String editUser(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.EDTUSR);
		try
		{
			String userId = request.getParameter("userId");
			String button = TDMConstants.UPDATE_BTN_TEXT;
			userdo = tDMAdminService.getEditUser(userId);
			model.addAttribute(TDMConstants.MODEL_USERDO, userdo);
			model.addAttribute(TDMConstants.BUTTON, button);
			logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.EDTUSR
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.CREATE_NEW_USER;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
				logger.error(MessageConstants.ADMIN_CNTRL + MessageConstants.EDTUSR,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.CREATE_NEW_USER;
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
	@RequestMapping(TDMConstants.MAP_TESDA_CREATEUSER)
	public String createNewUser(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.CRTNEWUSR);
		String button = TDMConstants.BUTTON_TEXT;
		userdo.setCreated(true);
		model.addAttribute(TDMConstants.MODEL_USERDO, userdo);
		model.addAttribute(TDMConstants.BUTTON, button);
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.CRTNEWUSR
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.CREATE_NEW_USER;
	}

	/**
	 * 
	 * @param userdo
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_DELETEUSER)
	public String daleteUser(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.DELUSR);
		try
		{
			tDMAdminService.deleteUserByUserId(request.getParameter(TDMConstants.USER_ID));
			logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.DELUSR
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.REDIRECT_TESTDA_ADMIN;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
				logger.error(MessageConstants.ADMIN_CNTRL + MessageConstants.DELUSR,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.REDIRECT_TESTDA_ADMIN;
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
	@RequestMapping(value = TDMConstants.MAP_VALIDATE_USERID, method = RequestMethod.POST)
	public @ResponseBody ValidationResponse validateUserId(
			@RequestParam(value = "userid", required = false) String userid, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
	{
		logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.VALUSR);
		ValidationResponse validationResponse = new ValidationResponse();
		try
		{
			List<String> listResult = new ArrayList<String>();
			boolean bCheck = tDMAdminService.validateUserId(userid);
			if (!bCheck)
			{
				validationResponse.setStatus(TDMConstants.STATUS_FAILED);
				listResult.add(userid + TDMConstants.ID_EXIST);
				validationResponse.setResult(listResult);
			}
			else
			{
				validationResponse.setStatus(TDMConstants.STATUS_SUCCESS);
			}
			logger.info(MessageConstants.ADMIN_CNTRL + MessageConstants.VALUSR
					+ MessageConstants.LOG_INFO_RETURN);
			return validationResponse;
		}
		catch (ServiceException se)
		{
			validationResponse.setStatus(TDMConstants.STATUS_FAILED);
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
				logger.error(MessageConstants.ADMIN_CNTRL + MessageConstants.VALUSR,
						TDMExceptionCode.getExceptionMsg(se));
			}
			return validationResponse;
		}
	}
}
