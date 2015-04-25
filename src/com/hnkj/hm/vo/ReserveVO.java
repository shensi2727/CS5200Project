package com.hnkj.hm.vo;
/**

 */
public class ReserveVO {

	/**
	 * 预定ID
	 */
	private String reserveId;

	/**
	 * 房间ID
	 */
	private String foodId;

	/**
	 * 酒店ID
	 */
	private String restaurantId;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 房间数量
	 */
	private int quantity;

	/**
	 * 人数
	 */
	private int people;

	/**
	 * 实际价格
	 */
	private float price;

	/**
	 * 总计
	 */
	private float total;

	/**
	 * 入住时间
	 */
	private String startTime;

	/**
	 * 里店时间
	 */
	private String overTime;

	/**
	 * 状态
	 */
	private String status;

	public String getReserveId() {

		return reserveId;
	}

	/**
	 * 
	 * @param reserveId
	 */
	public void setReserveId(String reserveId) {

		this.reserveId = reserveId;
	}

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

	public String getUserId() {

		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {

		this.userId = userId;
	}

	public int getQuantity() {

		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public int getPeople() {

		return people;
	}

	/**
	 * 
	 * @param people
	 */
	public void setPeople(int people) {

		this.people = people;
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

	public float getTotal() {

		return total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(float total) {

		this.total = total;
	}

	public String getStartTime() {

		return startTime;
	}

	/**
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {

		this.startTime = startTime;
	}

	public String getOverTime() {

		return overTime;
	}

	/**
	 * 
	 * @param overTime
	 */
	public void setOverTime(String overTime) {

		this.overTime = overTime;
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

}
