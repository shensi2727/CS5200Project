package com.hnkj.hm.vo;
/**

 */
public class ReserveVO {

	/**
	 * Ԥ��ID
	 */
	private String reserveId;

	/**
	 * ����ID
	 */
	private String foodId;

	/**
	 * �Ƶ�ID
	 */
	private String restaurantId;

	/**
	 * �û�ID
	 */
	private String userId;

	/**
	 * ��������
	 */
	private int quantity;

	/**
	 * ����
	 */
	private int people;

	/**
	 * ʵ�ʼ۸�
	 */
	private float price;

	/**
	 * �ܼ�
	 */
	private float total;

	/**
	 * ��סʱ��
	 */
	private String startTime;

	/**
	 * ���ʱ��
	 */
	private String overTime;

	/**
	 * ״̬
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
