package com.mazaiting.mapper;

import java.util.List;

import com.mazaiting.pojo.Item;

public interface ItemMapper {
	/**
	 * 获取所有商品信息
	 * @return
	 */
	List<Item> getItemList();

	/**
	 * 根据id获取商品信息
	 * @param id id
	 * @return
	 */
	Item getItemId(int id);

	/**
	 * 更新数据
	 * @param item
	 * @return
	 */
	void updateItem(Item item);
}
