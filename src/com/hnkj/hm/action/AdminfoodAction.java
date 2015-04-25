package com.hnkj.hm.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.bean.PageNum;
import com.hnkj.hm.bean.TableSummary;
import com.hnkj.hm.dao.IfoodDAO;
import com.hnkj.hm.dao.impl.foodDAO;
import com.hnkj.hm.vo.foodVO;
import com.opensymphony.xwork2.ActionSupport;

/**

 */
public class AdminfoodAction extends ActionSupport {

	private static final long serialVersionUID = 7919737623314603643L;

	private static final int PAGESIZE = 10;

	private static final String SELECT = "select";

	private static final String DELETE = "delete";

	private static final String MODIFY = "modify";

	/**
	 * 查询所有客房信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectAllfood() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String kfcx = request.getParameter("kfcx");

		String sql = "SELECT * FROM T_food";
		int count = TableSummary.getTotalRows("T_food");
		int pageNum = PageNum.getCurrentPage(request.getParameter("pageNo"));
		PageBean pagebean = new PageBean(count, pageNum, PAGESIZE);
		IfoodDAO fooddao = new foodDAO();
		List<foodVO> list = fooddao.findAllfood(sql, pagebean);

		request.setAttribute("pagebean", pagebean);
		request.setAttribute("kfcx", kfcx);
		request.setAttribute("list", list);

		if (kfcx.equals("1")) {
			return SELECT;
		} else if (kfcx.equals("2")) {
			return DELETE;
		} else if (kfcx.equals("3")) {
			return MODIFY;
		}
		return SUCCESS;
	}

	/**
	 * 根据客房ID来删除数据
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String deletefood() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String foodId = request.getParameter("id");
		IfoodDAO fooddao = new foodDAO();
		fooddao.removefood(foodId);

		return this.selectAllfood();
	}

	/**
	 * 行更新
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifyfood() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String foodId = request.getParameter("foodId");
		String available = request.getParameter("available");
		String status = request.getParameter("status");
		if(available.equals("Y")){
			status = "空闲";
		}
		float discount = Float.parseFloat(request.getParameter("discount"));
		foodVO foodVo = new foodVO();
		foodVo.setfoodId(foodId);
		foodVo.setDiscountPrice(discount);
		foodVo.setAvailable(available);
		foodVo.setStatus(status);

		IfoodDAO fooddao = new foodDAO();
		fooddao.modifyfood("2", foodVo);
		
		return this.selectAllfood();
	}

	public String execute() throws Exception {

		return SUCCESS;
	}
}
