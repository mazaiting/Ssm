package com.mazaiting.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/showlogin")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String userLogin(String username,String password, HttpSession session) {
		// 判断用户名和密码是否正确
		System.out.println(username + " ： " + password);
		// 正确，向session中写入用户信息
		session.setAttribute("username", username);
		// 返回登录成功页面，或者跳转至商品列表页面
		return "redirect:/itemList.action";
	}
}





























