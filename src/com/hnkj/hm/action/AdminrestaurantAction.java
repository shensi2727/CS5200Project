package com.hnkj.hm.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.bean.PageNum;
import com.hnkj.hm.bean.TableSummary;
import com.hnkj.hm.dao.IrestaurantDAO;
import com.hnkj.hm.dao.impl.restaurantDAO;
import com.hnkj.hm.vo.restaurantVO;
import com.opensymphony.xwork2.ActionSupport;

/**

 */
public class AdminrestaurantAction extends ActionSupport {

	private static final long serialVersionUID = -2504220655995717675L;

	private static final int PAGESIZE = 10;

	private static final String SELECT = "select";

	private static final String DELETE = "delete";

	private static final String MODIFY = "modify";

	/**
	 * 综合查询
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String findByCondition() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		String restaurantId = request.getParameter("restaurantId");
		String restaurantName = request.getParameter("restaurantName");
		String address = request.getParameter("address");
		String priceRange = request.getParameter("priceRange");

		restaurantVO restaurantVo = new restaurantVO();
		restaurantVo.setrestaurantId(restaurantId);
		restaurantVo.setrestaurantName(restaurantName);
		restaurantVo.setAddress(address);
		restaurantVo.setPriceRange(priceRange);

		IrestaurantDAO restaurantdao = new restaurantDAO();
		List<restaurantVO> list = restaurantdao.findrestaurantByCondition(restaurantVo);
		request.setAttribute("restaurantVoList", list);

		return SUCCESS;
	}

	/**
	 * 根据酒店类型来查询
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String showrestaurantInfo() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = request.getParameter("star");
		String sql = "";
		int count = 0;
		if (status.equals("1")) {
			sql = "SELECT * FROM T_restaurant WHERE restaurant_star = 1";
			count = TableSummary.getTotalRows(1);

		} else if (status.equals("2")) {
			sql = "SELECT * FROM T_restaurant WHERE restaurant_star = 2";
			count = TableSummary.getTotalRows(2);
		} else {
			sql = "SELECT * FROM T_restaurant WHERE restaurant_star >= 3";
			count = TableSummary.getTotalRows(3);
		}
		int pageNum = PageNum.getCurrentPage(request.getParameter("pageNo"));
		PageBean pagebean = new PageBean(count, pageNum, PAGESIZE);
		IrestaurantDAO restaurantdao = new restaurantDAO();
		List<restaurantVO> list = restaurantdao.findAllrestaurant(sql, pagebean);

		request.setAttribute("pagebean", pagebean);
		request.setAttribute("star", status);
		request.setAttribute("list", list);
		return SUCCESS;
	}

	/**
	 * 查询酒店所有的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findrestaurantInfo() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = request.getParameter("type_id");
		int count = TableSummary.getTotalRows("T_restaurant");
		int pageNum = PageNum.getCurrentPage(request.getParameter("pageNo"));
		PageBean pagebean = new PageBean(count, pageNum, PAGESIZE);
		IrestaurantDAO restaurantdao = new restaurantDAO();
		String sql = "SELECT * FROM T_restaurant";
		List<restaurantVO> list = restaurantdao.findAllrestaurant(sql, pagebean);

		request.getSession().setAttribute("pagebean", pagebean);
		request.getSession().setAttribute("type_id", status);
		request.getSession().setAttribute("list", list);

		if (status.equals("1")) {
			return SELECT;
		} else if (status.equals("2")) {
			return DELETE;
		} else if (status.equals("3")) {
			return MODIFY;
		}
		return SUCCESS;
	}

	/**
	 * 删除酒店的基本信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delrestaurantInfo() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String restaurantId = request.getParameter("id");
		String image = request.getParameter("img");
		IrestaurantDAO restaurantdao = new restaurantDAO();
		restaurantdao.removerestaurant(restaurantId);
		String path = request.getRealPath("/upload");
		// 件
		File file = new File(path, image);
		file.delete();
		return this.findrestaurantInfo();
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modrestaurantInfo() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String price = request.getParameter("jg");
		String quantity = request.getParameter("sl");

		restaurantVO restaurantVo = new restaurantVO();
		restaurantVo.setrestaurantId(id);
		restaurantVo.setPrice(Float.parseFloat(price));
		restaurantVo.setQuantity(Integer.parseInt(quantity));
		IrestaurantDAO restaurantdao = new restaurantDAO();
		restaurantdao.modifyrestaurant("2", restaurantVo);

		return this.findrestaurantInfo();
	}

	/**
	 * 综合查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectInfo() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String address = request.getParameter("address");
		String price = request.getParameter("priceRange");
		restaurantDAO restaurantdao = new restaurantDAO();
		List<restaurantVO> list = restaurantdao.findAllrestaurant(address, price);

		request.setAttribute("list", list);
		return SUCCESS;
	}

	public String execute() throws Exception {

		return SUCCESS;

	}
}
