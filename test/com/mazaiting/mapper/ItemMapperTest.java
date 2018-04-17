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
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(Constant.PATHS);
	}
	
	@Test
	public void testGetItemList() {
		ItemMapper mapper = context.getBean(ItemMapper.class);
		List<Item> list = mapper.getItemList();
		for (Item item : list) {
			System.out.println(item.toString());
		}
	}
}
