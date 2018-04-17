package com.mazaiting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mazaiting.pojo.Item;
import com.mazaiting.service.ItemService;

// 标记为控制器
@Controller
public class ItemController {
	
	// 注入Service
	@Autowired 
	ItemService service;
	
	// 设置网络访问路径/itemList.action
	@RequestMapping("/itemList")
	public ModelAndView itemList() {
		List<Item> list = service.getItemList();
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据
		modelAndView.addObject("itemList", list);
		// 设置视图名称
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
}
