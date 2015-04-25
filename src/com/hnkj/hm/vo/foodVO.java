package com.hnkj.hm.vo;

/**

 */
public class foodVO {

	/**
	 * 房间ID
	 */
	private String foodId;

	/**
	 * 房间名称名称
	 */
	private String foodName;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 是否可用
	 */
	private String available;

	/**
	 * 价格
	 */
	private float price;

	/**
	 * 折扣价格
	 */
	private float discountPrice;

	/**
	 * 酒店ID
	 */
	private String restaurantId;

	public String getfoodId() {

		return foodId;
	}

	/**
	 * 
	 * @param foodId
	 */
	public void setfoodId(String foodId) {

		this.foodId = foodId;
	}

	public String getfoodName() {

		return foodName;
	}

	/**
	 * 
	 * @param foodName
	 */
	public void setfoodName(String foodName) {

		this.foodName = foodName;
	}

	public String getStatus() {

		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {

		this.status = status;
	}

	public String getAvailable() {

		return available;
	}

	/**
	 * 
	 * @param available
	 */
	public void setAvailable(String available) {

		this.available = available;
	}

	public float getPrice() {

		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {

		this.price = price;
	}

	public float getDiscountPrice() {

		return discountPrice;
	}

	/**
	 * 
	 * @param discountPrice
	 */
	public void setDiscountPrice(float discountPrice) {

		this.discountPrice = discountPrice;
	}

	public String getrestaurantId() {

		return restaurantId;
	}

	/**
	 * 
	 * @param restaurantId
	 */
	public void setrestaurantId(String restaurantId) {

		this.restaurantId = restaurantId;
	}

}
