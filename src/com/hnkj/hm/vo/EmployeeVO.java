package com.hnkj.hm.vo;

/**

 */
public class EmployeeVO {

	/**
	 * 员工Id
	 */
	private String empid = "";

	/**
	 * 密码
	 */
	private String password = "";

	/**
	 * 姓名
	 */
	private String empName = "";

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 权限
	 */
	private String purview = "";

	/**
	 * 电话
	 */
	private String position = "";

	public String getEmpid() {

		return empid;
	}

	/**
	 * 
	 * @param empid
	 */
	public void setEmpid(String empid) {

		this.empid = empid;
	}

	public String getPassword() {

		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmpName() {

		return empName;
	}

	/**
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName) {

		this.empName = empName;
	}

	/**
	 * 
	 * @return
	 */
	public String getSex() {

		return sex;
	}

	/**
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {

		this.sex = sex;
	}

	public String getPurview() {

		return purview;
	}

	/**
	 * 
	 * @param purview
	 */
	public void setPurview(String purview) {

		this.purview = purview;
	}

	public String getPosition() {

		return position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(String position) {

		this.position = position;
	}

}
