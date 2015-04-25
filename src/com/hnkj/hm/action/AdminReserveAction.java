package com.hnkj.hm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.bean.PageNum;
import com.hnkj.hm.bean.TableSummary;
import com.hnkj.hm.dao.IReserveDAO;
import com.hnkj.hm.dao.impl.ReserveDAO;
import com.hnkj.hm.vo.ReserveVO;
import com.opensymphony.xwork2.ActionSupport;
/**

 */
public class AdminReserveAction extends ActionSupport {

	private static final long serialVersionUID = 2200213745093638386L;

	private static final int PAGESIZE = 6;

	private static final String SELECT = "select";

	private static final String DELETE = "delete";

	private static final String MODIFY = "modify";

	/**
	 * 查询所有预定信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectReserve() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String ydcx = request.getParameter("ydcx");

		int count = TableSummary.getTotalRows("T_Reserve");
		int pageNum = PageNum.getCurrentPage(request.getParameter("pageNo"));
		PageBean pagebean = new PageBean(count, pageNum, PAGESIZE);
		IReserveDAO reservedao = new ReserveDAO();
		List<ReserveVO> list = reservedao.findAllReserve(pagebean);

		request.getSession().setAttribute("pagebean", pagebean);
		request.getSession().setAttribute("ydcx", ydcx);
		request.getSession().setAttribute("list", list);

		if (ydcx.equals("1")) {
			return SELECT;
		} else if (ydcx.equals("2")) {
			return DELETE;
		}
		return SUCCESS;
	}

	/**
	 * 根据预定ID来删除数据
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String deleteReserve() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String reserveId = request.getParameter("id");
		IReserveDAO reservedao = new ReserveDAO();
		reservedao.removeReserve(reserveId);
		return this.selectReserve();
	}

	public String execute() throws Exception {

		return SUCCESS;
	}
}
