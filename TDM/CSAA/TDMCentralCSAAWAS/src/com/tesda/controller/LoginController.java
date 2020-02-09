package com.tesda.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.model.DTO.ForgotPassword;

/**
 * @author
 * @version 1.0
 */

@Controller
public class LoginController
{
	final static Logger logger = Logger.getLogger(LoginController.class);
	/*
	 * @Autowired SessionRegistry sessionRegistry;
	 * 
	 * public SessionRegistry getSessionRegistry() { return sessionRegistry; }
	 * 
	 * public void setSessionRegistry(SessionRegistry sessionRegistry) {
	 * this.sessionRegistry = sessionRegistry; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
	{
		logger.info("Logging in application : " );
		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null)
		{
			model.addObject("msg", "You've been logged out successfully.");

		}
		model.addObject("msg",
				"You are not allowed to perform 'Back' or You have not logged in or Session Expired.");
		model.setViewName("login");

		return model;

	}

	@RequestMapping("/tesdaLogin")
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return "login";
	}
	@RequestMapping("/")
	public String login2(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{
		return "login";
	}

	@RequestMapping("/testdaAdmin")
	public String admin()
	{
		return "admin";
	}

	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}

	@RequestMapping("/indexCmdCtr")
	public String indexCmdCtr()
	{
		return "indexCommandCenter";
	}

	@RequestMapping("/403page")
	public String accessDenied()
	{
		return "login:redirect?accessDenied=true";
	}

	@RequestMapping("/sessionExp")
	public String sessionExp()
	{
		return "login";
	}

	@RequestMapping("/authFail")
	public String authFail()
	{
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model, Principal principal, HttpServletRequest request,
			HttpServletResponse response)
	{

		String currentUser = null;

		if (null != (String) request.getSession().getAttribute("UserId"))
		{
			currentUser = (String) request.getSession().getAttribute("UserId");
		}
		if (null != currentUser)
		{

			request.getSession().invalidate();
			try
			{
				request.logout();
			} catch (ServletException e)
			{

				e.printStackTrace();
			}
			/*
			 * for (Object principalObj : sessionRegistry.getAllPrincipals()) {
			 * for (SessionInformation session :
			 * sessionRegistry.getAllSessions(principalObj, false)) {
			 * 
			 * if (principal.getName().equalsIgnoreCase(currentUser)) {
			 * session.expireNow();
			 * 
			 * }
			 * 
			 * } }
			 */
		}

		return "login";
	}

	@RequestMapping(value = "/fPassword", method = RequestMethod.GET)
	public String forgotPassword()
	{
		return "forgotPassword";
	}

	@RequestMapping(value = "/loginforgotPassword", method = RequestMethod.GET)
	public String forgotPass(@ModelAttribute("forgotPasswordDto") ForgotPassword forgotPasswordDto,
			ModelMap modelmap)
	{
		/*
		 * if (null != forgotPasswordDto)
		 * modelmap.addAttribute("email", "Email sent");
		 * else
		 * modelmap.addAttribute("email", "Email sent failed. Please Try Again");
		 */
//		if (null == forgotPasswordDto)
//		{
//			forgotPasswordDto = new ForgotPassword();
//		}
		return "forgotPassword";
	}

}
