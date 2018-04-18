package com.mazaiting.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURL().toString();
		// 如果用户未登录，则跳转到登录页面。跳转过程可能被拦截，所以要做判断
		if (uri.contains("login")) {
			return true;
		}
		System.out.println("LoginInterceptor preHandle...");
		// 用户拦截请求，判断用户是否登录
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (!"".equals(username) && null != username) {
			// 已经登录，放行
			return true;
		}
		// 如果用户未登录，则跳转到登录页面
		response.sendRedirect(request.getContextPath() + "/user/showlogin");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor postHandle...");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor afterCompletion...");
	}
}


























