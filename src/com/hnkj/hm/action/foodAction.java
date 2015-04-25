package com.hnkj.hm.action;

import com.hnkj.hm.dao.IfoodDAO;
import com.hnkj.hm.dao.impl.foodDAO;
import com.hnkj.hm.vo.foodVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**

 */
public class foodAction extends ActionSupport implements ModelDriven<foodVO> {

	private static final long serialVersionUID = 2181756555311177297L;

	private foodVO foodVo = new foodVO();

	public foodVO getModel() {

		return foodVo;
	}

	/**
	 * 增加房间基本信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addfoodInfo() throws Exception {

		IfoodDAO fooddao = new foodDAO();
		boolean isSuccess = fooddao.insertfood(foodVo);
		if (isSuccess) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public String execute() throws Exception {

		return SUCCESS;
	}

}
