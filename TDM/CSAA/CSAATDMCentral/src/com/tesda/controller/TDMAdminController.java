package com.tesda.controller;

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

import com.tesda.exception.BaseException;
import com.tesda.model.DTO.TdmUserDTO;
import com.tesda.model.DTO.ValidationResponse;
import com.tesda.service.TDMAdminService;
import com.tesda.util.PaginationUtil;

@Controller
public class TDMAdminController
{
	final static Logger logger = Logger.getLogger(TDMAdminController.class);

	@Resource(name = "tDMAdminService")
	TDMAdminService tDMAdminService;

	@RequestMapping(value = "/tesdaUserCreate", method = RequestMethod.POST)
	public String userDetails(@ModelAttribute("userdo") TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{
		String strReturnPage = "redirect:testdaAdmin";
		try
		{
			boolean bEdit = userdo.isCreated();
			String strMessage = tDMAdminService.saveUserDetails(userdo, bEdit);
			if (!"Success".equals(strMessage))
			{
				model.addAttribute("errors", "User Id is already exist");
				String button = "Create User";
				model.addAttribute("userdo", userdo);
				model.addAttribute("Button", button);
				strReturnPage = "createNewUser";
			}
			return strReturnPage;
		} catch (BaseException baseEx)
		{
			if (baseEx.getErrorCode() != null)
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return strReturnPage;
			}

		}
		return strReturnPage;
	}

	@RequestMapping(value = "/testdisplayAdmin", method = RequestMethod.GET)
	public String displayAdmin()
	{
		return "admin";
	}

	@RequestMapping(value = "/testdaAdmin", method = RequestMethod.GET)
	public String displayUser(@RequestParam(value = "page", required = false) String search,
			@ModelAttribute("userdo") TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{
		try
		{

			Long totalRecords = 0L;

			PaginationUtil pagenation = new PaginationUtil();
			Integer recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			User user = (User) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			userdo.setUserId(user.getUsername());
			totalRecords = tDMAdminService.searchUserRecordsCount(userdo);
			List<TdmUserDTO> DiaplayUser = tDMAdminService.getAllUser(userdo, offSet,
					recordsperpage, true);
			pagenation
			.paginate(totalRecords, request, recordsperpage.doubleValue(), recordsperpage);
	Double noOfPages = Math.ceil(totalRecords.doubleValue() / recordsperpage.doubleValue());
	request.setAttribute("noOfPages", noOfPages.intValue());
			model.addAttribute("displayUser", DiaplayUser);
			return "displayUsers";
		} catch (BaseException baseEx)
		{
			if (null != baseEx.getErrorCode())
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "displayUsers";
			}

		}
		return "displayUsers";

	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editUser(@ModelAttribute("userdo") TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{
		try
		{
			String userId = request.getParameter("userId");
			String button = "Update User";
			userdo = tDMAdminService.getEditUser(userId);
			model.addAttribute("userdo", userdo);
			model.addAttribute("Button", button);
			return "createNewUser";
		} catch (BaseException baseEx)
		{
			if (null != baseEx.getErrorCode())
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "createNewUser";
			}
		}
		return "createNewUser";
	}

	@RequestMapping("/tesdaCreateNewUser")
	public String createNewUser(@ModelAttribute("userdo") TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
	{
		String button = "Create User";
		userdo.setCreated(true);
		model.addAttribute("userdo", userdo);
		model.addAttribute("Button", button);
		return "createNewUser";
	}

	@RequestMapping(value = "/deleteUser")
	public String daleteUser(@ModelAttribute("userdo") TdmUserDTO userdo, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{
		try
		{
			// String userId=request.getParameter("userId");
			tDMAdminService.deleteUserByUserId(request.getParameter("userId"));
			return "redirect:testdaAdmin";
		} catch (BaseException baseEx)
		{
			if (null != baseEx.getErrorCode())
			{
				model.addAttribute("error", baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return "displayUsers";
			}

		}
		return "redirect:testdaAdmin";
	}

	@RequestMapping(value = "/validateUserId", method = RequestMethod.POST)
	public @ResponseBody ValidationResponse validateUserId(
			@RequestParam(value = "userid", required = false) String userid, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException
	{
		ValidationResponse validationResponse = new ValidationResponse();
		try
		{

			List<String> listResult = new ArrayList<String>();
			boolean bCheck = tDMAdminService.validateUserId(userid);
			if (!bCheck)
			{
				validationResponse.setStatus("FAILED");
				listResult.add(userid + " user id is already exist");
				validationResponse.setResult(listResult);
			} else
			{
				validationResponse.setStatus("SUCCESS");
			}
			return validationResponse;
		} catch (BaseException baseEx)
		{
			if (null != baseEx.getErrorCode())
			{
				validationResponse.setStatus("FAILED");
				validationResponse.setResult(baseEx.getErrorCode() + " : " + baseEx.getRootCause());
				return validationResponse;
			}
		}
		return validationResponse;
	}
}
