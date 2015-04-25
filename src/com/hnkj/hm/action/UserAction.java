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

	// ʵ����һ��UserVO BEAN����
	private UserVO userVo = new UserVO();

	/**
	 * ͨ��ģ��������ȡUserVO BEAN��Ϣ
	 */
	public UserVO getModel() {

		return userVo;
	}

	/**
	 * �����û�������Ϣ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertUser() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		// ʵ����һ��UserDAO��ʵ��
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
	 * ɾ���û���Ϣ
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
