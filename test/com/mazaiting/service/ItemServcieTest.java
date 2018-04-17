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
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext(Constant.PATHS);
	}
	
	@Test
	public void testGetItemList() {
		ItemService service = context.getBean(ItemService.class);
		List<Item> list = service.getItemList();
		for (Item item : list) {
			System.out.println(item);
		}
	}
}
