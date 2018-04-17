	package com.mazaiting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mazaiting.exception.CustomerException;
import com.mazaiting.pojo.Item;
import com.mazaiting.pojo.QueryVo;
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
		
//		if (true) {
//			throw new CustomerException("异常啦");
//		}
		int i = 1/0;
		
		List<Item> list = service.getItemList();
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据
		modelAndView.addObject("itemList", list);
		// 设置视图名称
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	
	// 设置网络访问路径/itemEdit.action
//	@RequestMapping("/itemEdit")
	public ModelAndView editItem(HttpServletRequest request) {
		// 从request中取出参数
		String strId = request.getParameter("id");
		int id = Integer.valueOf(strId);
		// 调用服务
		Item item = service.getItemById(id);
		// 把结果传递给页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", item);
		// 设置逻辑视图
		modelAndView.setViewName("editItem");
		return modelAndView;
	}
	
	// value表示链接中的参数名，这里必须和连接中的相同
	// defaultValue为默认值
	// required表示此参数不能为空
	@RequestMapping("/itemEdit")
	public String editItem(@RequestParam(value="id",defaultValue="1",required=true) Integer ids,Model model) {
		// 调用服务
		Item item = service.getItemById(ids);
		// 把数据传递给页面，需要用到Model接口
		model.addAttribute("item", item);
		return "editItem";
	}
	
	@RequestMapping("/updateItem")
	public String updateItem(Item item) {
		service.updateItem(item);
		// 重定向
		return "redirect:/itemList.action";
	}
	
	@RequestMapping("/item/queryitem")
	public String queryitem(QueryVo queryVo, String[] ids){
		// 打印绑定结果
		System.out.println(ids.toString());
		System.out.println(queryVo.getIds().toString());
		System.out.println(queryVo.getItem().toString());
		return "success";
	}
}



















