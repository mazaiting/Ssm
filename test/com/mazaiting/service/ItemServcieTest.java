package com.mazaiting.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mazaiting.Constant;
import com.mazaiting.pojo.Item;

public class ItemServcieTest {
	ApplicationContext context;
	ItemService service;
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext(Constant.PATHS);
		service = context.getBean(ItemService.class);
	}
	
	@Test
	public void testGetItemList() {
		List<Item> list = service.getItemList();
		for (Item item : list) {
			System.out.println(item);
		}
	}
	
	@Test 
	public void testGetItemById(){
		Item item = service.getItemById(1);
		System.out.println(item.toString());
	}
	
	@Test
	public void testUpdateItem(){
		Item item = new Item();
		item.setId(1);
		item.setName("小米4c");
		item.setDetail("智能手机");
		item.setPrice(200.0f);
		service.updateItem(item);
	}
}
