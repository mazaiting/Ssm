package com.mazaiting.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

		// if (true) {
		// throw new CustomerException("异常啦");
		// }
		// int i = 1/0;

		List<Item> list = service.getItemList();
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据
		modelAndView.addObject("itemList", list);
		// 设置视图名称
		modelAndView.setViewName("itemList");
		return modelAndView;
	}

	// 设置网络访问路径/itemEdit.action
	// @RequestMapping("/itemEdit")
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
//	@RequestMapping("/itemEdit")
//	public String editItem(@RequestParam(value = "id", defaultValue = "1", required = true) Integer ids, Model model) {
//		// 调用服务
//		Item item = service.getItemById(ids);
//		// 把数据传递给页面，需要用到Model接口
//		model.addAttribute("item", item);
//		return "editItem";
//	}
	
	@RequestMapping("/itemEdit/{id}")
	// 如果id和方法的形参一直，@PathVariable注解中可以不写内容
	public String editItem(@PathVariable("id")Integer ids, Model model){
		// 调用服务
		Item item = service.getItemById(ids);
		// 把数据传递给页面，需要用到Model接口
		model.addAttribute("item", item);
		// 返回逻辑视图
		return "editItem";
	}

	@RequestMapping(value = "/updateItem", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateItem(Item item, MultipartFile picture) throws Exception {
		// 把图片保存到图片目录下
		// 保存图片，这个图片的文件名可能会重复，为每个文件生成一个新的文件名
		String picName = UUID.randomUUID().toString();
		// 截图文件的扩展名
		String oriName = picture.getOriginalFilename();
		String extName = oriName.substring(oriName.lastIndexOf("."));
		// 保存文件
		picture.transferTo(new File("D:\\picture\\" + picName + extName));
		// 包文件名保存到数据库
		item.setPic(picName+extName);
		service.updateItem(item);
		// 重定向
//		return "redirect:/itemList.action";
		// 转向
//		return "forward:/itemEdit.action";
		return "forward:itemList";
	}

	@RequestMapping("/item/queryitem")
	public String queryitem(QueryVo queryVo, String[] ids) {
		// 打印绑定结果
		System.out.println(ids.toString());
		System.out.println(queryVo.getIds().toString());
		System.out.println(queryVo.getItem().toString());
		return "success";
	}
	
	// JSON数据交互
	// @RequestBody: 接收JSON数据并转换为pojo对象
	// @ResponseBody: 相应JSON数据，把POJO对象转换为JSON数据并响应
	@RequestMapping("/jsonTest")
	@ResponseBody
	public Item jsonTest(@RequestBody Item item){
		System.out.println(item.toString());
		return item;
	}
}





















