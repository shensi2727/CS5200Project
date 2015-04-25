package com.hnkj.hm.action;

import com.hnkj.hm.dao.IAdminDAO;
import com.hnkj.hm.dao.impl.AdminDAO;
import com.hnkj.hm.vo.AdminVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 */
public class AdminAction extends ActionSupport implements ModelDriven<AdminVO> {

	private static final long serialVersionUID = 7985088648255987874L;

	private AdminVO adminVo = new AdminVO();

	/**
	 * 获取模型驱动BEAN
	 * 
	 * @return AdminVO
	 */
	public AdminVO getModel() {

		return adminVo;
	}

	/**
	 * 
	 * @return String SUCCESS 表示成功 INPUT 表示失败
	 * @throws Exception
	 */
	public String adminLogin() throws Exception {

		String userName = adminVo.getUserName();
		String password = adminVo.getPassword();
		if (null == userName || "".equals(userName)) {
			return INPUT;
		}
		if (null == password || "".equals(password)) {
			return INPUT;
		}
		IAdminDAO admindao = new AdminDAO();
		boolean isSuccess = admindao.findAdminById(userName, password);
		if (isSuccess) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
}
