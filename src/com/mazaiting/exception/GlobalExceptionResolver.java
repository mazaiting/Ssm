package com.mazaiting.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 * @author mazaiting 
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		// 判断异常的种类
		String msg = null;
		if (exception instanceof CustomerException) {
			// 如果是自定义异常，就从异常里面取出错误消息
			CustomerException customerException = (CustomerException) exception;
			msg = customerException.getMsg();
		} else {
			// 如果是运行时异常，则取出错误的堆栈信息, 向控制台上打印堆栈信息
			exception.printStackTrace();
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			exception.printStackTrace(printWriter);
			msg = writer.toString();
		}
		
		// 写日志，发短信，发邮件。。。
		
		// 返回一个友好的错误页面，并显示错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("error");
		return modelAndView;
	}

}











