package com.tesda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Resource(name = TDMConstants.TDM_ADMIN_SERVICE)
	TDMAdminService tDMAdminService;

	@RequestMapping(value = TDMConstants.MAP_TESDA_USERCREATE, method = RequestMethod.POST)
	public String userDetails(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		String strReturnPage = TDMConstants.REDIRECT_TESTDA_ADMIN;
		try
		{
			boolean bEdit = userdo.isCreated();
			String strMessage = tDMAdminService.saveUserDetails(userdo, bEdit);
			if (!"Success".equals(strMessage))
			{
				model.addAttribute("errors", "User Id is already exist");
				String button = "Create User";
				model.addAttribute(TDMConstants.MODEL_USERDO, userdo);
				model.addAttribute("Button", button);
				strReturnPage = TDMConstants.CREATE_NEW_USER;
			}
			return strReturnPage;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			}
			return strReturnPage;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TESTDISPLAY_ADMIN, method = RequestMethod.GET)
	public String displayAdmin()
	{
		return TDMConstants.ADMIN;
	}

	@RequestMapping(value = TDMConstants.MAP_TEST_DA_ADMIN, method = RequestMethod.GET)
	public String displayUser(
			@RequestParam(value = TDMConstants.PAGE, required = false) String search,
			@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
	{
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
			return TDMConstants.DISPLAY_USERS;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));

			}
			return TDMConstants.DISPLAY_USERS;
		}

	}

	@RequestMapping(value = TDMConstants.MAP_EDITUSER, method = RequestMethod.GET)
	public String editUser(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String userId = request.getParameter("userId");
			String button = "Update User";
			userdo = tDMAdminService.getEditUser(userId);
			model.addAttribute(TDMConstants.MODEL_USERDO, userdo);
			model.addAttribute("Button", button);
			return TDMConstants.CREATE_NEW_USER;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.CREATE_NEW_USER;
		}
	}

	@RequestMapping(TDMConstants.MAP_TESDA_CREATEUSER)
	public String createNewUser(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		String button = "Create User";
		userdo.setCreated(true);
		model.addAttribute(TDMConstants.MODEL_USERDO, userdo);
		model.addAttribute("Button", button);
		return TDMConstants.CREATE_NEW_USER;
	}

	@RequestMapping(value = TDMConstants.MAP_DELETEUSER)
	public String daleteUser(@ModelAttribute(TDMConstants.MODEL_USERDO) TdmUserDTO userdo,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			tDMAdminService.deleteUserByUserId(request.getParameter("userId"));
			return TDMConstants.REDIRECT_TESTDA_ADMIN;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.REDIRECT_TESTDA_ADMIN;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_VALIDATE_USERID, method = RequestMethod.POST)
	public @ResponseBody ValidationResponse validateUserId(
			@RequestParam(value = "userid", required = false) String userid, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
	{
		ValidationResponse validationResponse = new ValidationResponse();
		try
		{
			List<String> listResult = new ArrayList<String>();
			boolean bCheck = tDMAdminService.validateUserId(userid);
			if (!bCheck)
			{
				validationResponse.setStatus(TDMConstants.STATUS_FAILED);
				listResult.add(userid + " user id is already exist");
				validationResponse.setResult(listResult);
			}
			else
			{
				validationResponse.setStatus(TDMConstants.STATUS_SUCCESS);
			}
			return validationResponse;
		}
		catch (ServiceException se)
		{
			validationResponse.setStatus(TDMConstants.STATUS_FAILED);
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			}
			return validationResponse;
		}
	}
}
