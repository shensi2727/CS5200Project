package com.hnkj.hm.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hnkj.hm.dao.IUserDAO;
import com.hnkj.hm.dao.impl.UserDAO;
import com.hnkj.hm.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**

 */
public class UserAction extends ActionSupport implements ModelDriven<UserVO> {

	private static final long serialVersionUID = 1241693991290138412L;

	// 实例化一个UserVO BEAN对象
	private UserVO userVo = new UserVO();

	/**
	 * 通过模型驱动获取UserVO BEAN信息
	 */
	public UserVO getModel() {

		return userVo;
	}

	/**
	 * 插入用户基本信息操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertUser() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		// 实例化一个UserDAO类实例
		IUserDAO userdao = new UserDAO();

		boolean isSuccess = userdao.insertUser(userVo);
		if (isSuccess) {
			request.getSession().setAttribute("uid", userVo.getUserId());
			return SUCCESS;
		} else {

			return INPUT;
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String removeUser() throws Exception {

		return null;
	}


	@Override
	public String execute() throws Exception {

		// TODO Auto-generated method stub
		return super.execute();
	}

}
