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

package com.tdm.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.StringTokenizer;

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

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.util.JDBCPreparedStatementSelect;

/**
 * @author Seshadri Chowdary
 *
 */
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	
	private static Logger logger = Logger.getLogger(UserAuthenticationSuccessHandler.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private String role = "";
	JDBCPreparedStatementSelect jd = null;

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
		boolean isTDMUser = false;
		boolean isTDMAdmin = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			role = grantedAuthority.getAuthority();
			if (role.equals(AppConstant.ROLE_USER)) {
				isUser = true;
				break;
			} else if (role.equals(AppConstant.ROLE_ADMIN)) {
				isAdmin = true;
				break;
			} else if (role.equals(AppConstant.ROLE_TDMUSER)) {
				isTDMUser = true;
				break;
			} else if (role.equals(AppConstant.ROLE_TDMADMIN)) {
				isTDMAdmin = true;
				break;
			}
		}
		if (isUser) {
			return AppConstant.TDM_INDEX;
		} else if (isAdmin) {
			return AppConstant.TDM_INDEX;
		} else if (isTDMUser) {
			return AppConstant.TDM_INDEX;
		} else if (isTDMAdmin) {
			return AppConstant.TDM_INDEX;
		} else {
			logger.error(MessageConstant.TDM_AUTH_HANDLER
					+ MessageConstant.TDM_AUTH_DETERMINE_TAR_URL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			return "/login?error=#";			
		}
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request,
			Authentication authentication) {
		String username = "",role_in_id = "";
		logger.info(MessageConstant.TDM_AUTH_HANDLER + MessageConstant.TDM_AUTH__CLEAR_ATTRI
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		User user = (User) authentication.getPrincipal();
		JDBCPreparedStatementSelect jd = new JDBCPreparedStatementSelect();
		try {
			String username_and_role = jd.selectRecordsFromTable(user.getUsername());
			StringTokenizer st = new StringTokenizer(username_and_role, "-");
			while(st.hasMoreTokens()){
				username = st.nextToken();
				role_in_id = st.nextToken();
			}
			
		} catch (SQLException e1) {
					e1.printStackTrace();
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		request.getSession().setAttribute(AppConstant.SESSION_UNAME,username);
		request.getSession().setAttribute(AppConstant.SESSION_UID, user.getUsername());
		request.getSession().setAttribute(AppConstant.ROLE, role);
	}

}
