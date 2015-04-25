package com.hnkj.hm.vo;

import java.io.File;

/**

 */
public class restaurantVO {

	/**
	 * 酒店ID
	 */
	private String restaurantId;

	/**
	 * 酒店名称
	 */
	private String restaurantName;

	/**
	 * 类型
	 */
	private String star;

	/**
	 * 价格范围
	 */
	private float price;

	/**
	 * 房间数量
	 */
	private int quantity;

	/**
	 * 地点
	 */
	private String address;

	/**
	 * 商品图片、文件类型
	 */
	private File image;

	/**
	 * 图片类型
	 */
	private String imageContentType = "";

	/**
	 * 图片名称
	 */

	private String imageFileName = "";

	/**
	 * 酒店说明
	 */
	private String description;

	/**
	 * 价格范围
	 */
	private String priceRange;

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

	public String getrestaurantName() {

		return restaurantName;
	}

	/**
	 * 
	 * @param restaurantName
	 */
	public void setrestaurantName(String restaurantName) {

		this.restaurantName = restaurantName;
	}

	public String getStar() {

		return star;
	}

	/**
	 * 
	 * @param star
	 */
	public void setStar(String star) {

		this.star = star;
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

	public String getAddress() {

		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {

		this.address = address;
	}

	public File getImage() {

		return image;
	}

	/**
	 * 
	 * @param image
	 */
	public void setImage(File image) {

		this.image = image;
	}

	public String getImageContentType() {

		return imageContentType;
	}

	/**
	 * 
	 * @param imageContentType
	 */
	public void setImageContentType(String imageContentType) {

		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {

		return imageFileName;
	}

	/**
	 * 
	 * @param imageFileName
	 */
	public void setImageFileName(String imageFileName) {

		this.imageFileName = imageFileName;
	}

	public String getDescription() {

		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	public String getPriceRange() {

		return priceRange;
	}

	/**
	 * 
	 * @param priceRange
	 */
	public void setPriceRange(String priceRange) {

		this.priceRange = priceRange;
	}
}
