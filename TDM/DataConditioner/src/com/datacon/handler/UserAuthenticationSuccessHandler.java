/*---------------------------------------------------------------------------------------
 * Object Name: UserAuthenticationSuccessHandler.Java
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

package com.datacon.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;

/**
 * @author Seshadri Chowdary
 *
 */
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	private static Logger logger = Logger.getLogger(UserAuthenticationSuccessHandler.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		logger.info(MessageConstant.TDM_AUTH_HANDLER + MessageConstant.TDM_AUTH_SUCCESS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		handle(request, response, authentication);
		clearAuthenticationAttributes(request, authentication);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		logger.info(MessageConstant.TDM_AUTH_HANDLER + MessageConstant.TDM_AUTH_HANDLE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String targetUrl = determineTargetUrl(authentication);
		request.getSession().setAttribute(AppConstant.SESSION_PROJ,
				request.getParameter(AppConstant.SESSION_PROJ));
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Builds the target URL according to the logic defined in the main class Javadoc.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		logger.info(MessageConstant.TDM_AUTH_HANDLER + MessageConstant.TDM_AUTH_DETERMINE_TAR_URL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		boolean isUser = false;
		boolean isAdmin = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals(AppConstant.ROLE_USER)) {
				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals(AppConstant.ROLE_ADMIN)) {
				isAdmin = true;
				break;
			}
		}
		if (isUser) {
			return AppConstant.TDM_INDEX;
		} else if (isAdmin) {
			return AppConstant.TDM_INDEX;
		} else {
			logger.error(MessageConstant.TDM_AUTH_HANDLER
					+ MessageConstant.TDM_AUTH_DETERMINE_TAR_URL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new IllegalStateException();
		}
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request,
			Authentication authentication) {
		logger.info(MessageConstant.TDM_AUTH_HANDLER + MessageConstant.TDM_AUTH__CLEAR_ATTRI
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		User user = (User) authentication.getPrincipal();
		request.getSession().setAttribute(AppConstant.SESSION_UID, user.getUsername());
	}

}
