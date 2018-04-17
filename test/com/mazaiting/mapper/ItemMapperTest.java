package com.mazaiting.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mazaiting.Constant;
import com.mazaiting.pojo.Item;

public class ItemMapperTest {
	ApplicationContext context;
	ItemMapper mapper;
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(Constant.PATHS);
		mapper = context.getBean(ItemMapper.class);
	}
	
	@Test
	public void testGetItemList() {
		List<Item> list = mapper.getItemList();
		for (Item item : list) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	public void testGetItemId(){
		Item item = mapper.getItemId(1);
		System.out.println(item.toString());
	}
	
	@Test
	public void testUpdateItem(){
		Item item = new Item();
		item.setId(1);
		item.setName("小米");
		item.setDetail("智能手机");
		item.setPrice(200.0f);
		mapper.updateItem(item);
	}
}
