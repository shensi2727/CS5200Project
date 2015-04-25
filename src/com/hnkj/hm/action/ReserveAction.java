package com.hnkj.hm.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.hnkj.hm.dao.IrestaurantDAO;
import com.hnkj.hm.dao.IReserveDAO;
import com.hnkj.hm.dao.IfoodDAO;
import com.hnkj.hm.dao.impl.restaurantDAO;
import com.hnkj.hm.dao.impl.ReserveDAO;
import com.hnkj.hm.dao.impl.foodDAO;
import com.hnkj.hm.vo.restaurantVO;
import com.hnkj.hm.vo.ReserveVO;
import com.hnkj.hm.vo.foodVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <p>

 */
public class ReserveAction extends ActionSupport implements
		ModelDriven<ReserveVO> {

	private static final long serialVersionUID = 2363046999898437761L;

	public ReserveVO reserveVo = new ReserveVO();

	/**
	 * 息放在 ReserveVO中
	 * 
	 * @return ReserveVO
	 */
	public ReserveVO getModel() {

		return reserveVo;
	}

	/**
	 * 客房预定
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String reservefood() throws Exception {

		reserveVo.setQuantity(1);
		String id = reserveVo.getfoodId();
		float price = this.getfoodPrice(id);
		reserveVo.setPrice(price);
		String startDate = reserveVo.getStartTime();
		String endDate = reserveVo.getOverTime();
		int day = this.getDaysBetweenDate(startDate, endDate);
		// 付多少费用
		float total = price * 1 * day;
		reserveVo.setTotal(total);
		reserveVo.setStatus("预定");
		//reserveVo.setUserId("张三");

		// 预定房间,往"T_Reserve"表写入数据
		IReserveDAO reservedao = new ReserveDAO();
		boolean isInsertReserve = reservedao.insertReserve(reserveVo);
		// 当会员预定房间后,对"T_restaurant"表中 房间数量进行更新
		IrestaurantDAO restaurantdao = new restaurantDAO();
		restaurantVO restaurantVo = new restaurantVO();
		restaurantVo.setrestaurantId(reserveVo.getrestaurantId());
		boolean isModifyrestaurant = restaurantdao.modifyrestaurant("1", restaurantVo);
		// ,状态和是否可用进行更新
		IfoodDAO fooddao = new foodDAO();
		foodVO foodVo = new foodVO();
		foodVo.setfoodId(reserveVo.getfoodId());
		foodVo.setStatus("预定");
		foodVo.setAvailable("N");
		boolean isModifyfood = fooddao.modifyfood("1", foodVo);
		
		boolean isSuccess = isInsertReserve && isModifyrestaurant && isModifyfood;

		if (isSuccess) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	// 获取房间价格
	public float getfoodPrice(String id) {

		IfoodDAO fooddao = new foodDAO();
		List<foodVO> list = fooddao.findfoodById(id);
		float price = 0;
		for (int i = 0; i < list.size(); i++) {
			foodVO foodVo = list.get(i);
			price = foodVo.getPrice();
		}
		return price;
	}

	// 束时间,一共有多少天
	public int getDaysBetweenDate(String startDate, String endDate)
			throws Exception {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		cal.setTime(sdf.parse(startDate));
		int i = 1;
		int day = 0;
		while (i == 1) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
			if ((cal.getTime()).equals(sdf.parse(endDate))) {
				i = 0;
			}
			day++;
		}

		return day;
	}

	public String execute() throws Exception {

		return SUCCESS;
	}

}
