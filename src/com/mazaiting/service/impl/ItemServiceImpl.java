package com.mazaiting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazaiting.mapper.ItemMapper;
import com.mazaiting.pojo.Item;
import com.mazaiting.service.ItemService;

// 标记为Service
@Service
public class ItemServiceImpl implements ItemService {

	// 注入ItemMapper
	@Autowired
	ItemMapper mapper;
	
	@Override
	public List<Item> getItemList() {
		return mapper.getItemList();
	}

	@Override
	public Item getItemById(int id) {
		return mapper.getItemId(id);
	}

	@Override
	public void updateItem(Item item) {
		mapper.updateItem(item);
	}

}
