package com.mazaiting.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor2 implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Interceptor2 preHandle......");
		// 执行的时机是在Handler执行之前放行此方法
		// 返回值：true，放行不拦截，正常执行Handler进行处理
		// 返回值：false，拦截，Handler不能正常处理
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Handler 执行之后，在返回ModelAndView之前，对modelAndView进行处理
		System.out.println("Interceptor2 postHandle......");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 返回ModelAndView之后
		// Handler执行过程如果出现异常，可以在此处理异常
		System.out.println("Interceptor2 afterCompletion......");
	}
}
