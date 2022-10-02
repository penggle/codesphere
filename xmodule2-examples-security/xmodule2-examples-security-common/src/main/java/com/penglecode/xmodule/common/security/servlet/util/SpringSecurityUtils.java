package com.penglecode.xmodule.common.security.servlet.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Web环境下的spring-security工具类
 * 
 * @author 	pengpeng
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class SpringSecurityUtils {

	private SpringSecurityUtils() {}

	/**
	 * 获取认证(登录)异常
	 * @param request
	 * @return
	 */
	public static Exception getAuthenticationException(HttpServletRequest request) {
		String key = WebAttributes.AUTHENTICATION_EXCEPTION;
		Exception exception = (Exception) request.getAttribute(key);
		if(exception == null) {
			exception = (Exception) request.getSession().getAttribute(key);
			if(exception != null) {
				request.getSession().removeAttribute(key);
			}
		}
		return exception;
	}
	
	/**
	 * 获取当前登录身份证明(Authentication)
	 * @param <T>
	 * @return
	 */
	public static <T extends Authentication> T getCurrentAuthentication() {
		return (T) SecurityContextHolder.getContext().getAuthentication();
	}
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public static UserDetails getCurrentAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
			return (UserDetails) authentication.getPrincipal();
		}
		return null;
	}
	
	/**
	 * 执行退出登录
	 * @param request
	 * @param response
	 */
	public static void logout(HttpServletRequest request, HttpServletResponse response) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	}
	
}
