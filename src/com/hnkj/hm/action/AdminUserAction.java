package com.hnkj.hm.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.hnkj.hm.dao.impl.UserDAO;
/**

 */
public class AdminUserAction extends ActionSupport {

	private static final long serialVersionUID = -8139037577604621185L;

	/**
	 * ÓÃ»§µÇÂ½
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		UserDAO userdao = new UserDAO();
		boolean isSuccess = userdao.login(userId, password);
		if (isSuccess) {
			request.getSession().setAttribute("user", userId);
			return SUCCESS;
		} else {
			request.getSession().setAttribute("user", "");
			return INPUT;
		}
	}

	public String execute() throws Exception {

		return SUCCESS;
	}

}
