package com.mazaiting.service;

import java.util.List;

import com.mazaiting.pojo.Item;

public interface ItemService {
	/**
	 * 查询商品列表
	 * @return
	 */
	List<Item> getItemList();

	/**
	 * 获取商品信息
	 * @param id id
	 * @return
	 */
	Item getItemById(int id);

	/**
	 * 更新条目
	 * @param item Java Bean
	 */
	void updateItem(Item item);
}
