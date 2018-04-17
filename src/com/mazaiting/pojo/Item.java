package com.mazaiting.pojo;

import java.sql.Timestamp;

public class Item {
	// 编号
	private Integer id;
	// 商品名称
	private String name;
	// 价格
	private Float price;
	// 图片
	private String pic;
	// 描述
	private String detail;
	// 时间戳
	private Timestamp createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + ", detail=" + detail
				+ ", createtime=" + createtime + "]";
	}
}
