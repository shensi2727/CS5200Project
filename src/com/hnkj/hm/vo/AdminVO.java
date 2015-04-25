package com.hnkj.hm.vo;

/**

 */
public class AdminVO {

	/**
	 * 用户名
	 */
	private String userName = "";

	/**
	 * 用户密码
	 */
	private String password = "";

	/**
	 * 用户角色
	 */
	private Integer role;

	/**
	 * 备注
	 */
	private String remark = "";

	public String getUserName() {

		return userName;
	}

	/**
	 * 
	 * @param userName
	 *            用户名
	 */
	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getPassword() {

		return password;
	}

	/**
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	public Integer getRole() {

		return role;
	}

	/**
	 * 
	 * @param role
	 *            角色
	 */
	public void setRole(Integer role) {

		this.role = role;
	}

	public String getRemark() {

		return remark;
	}

	/**
	 * 
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {

		this.remark = remark;
	}

}
