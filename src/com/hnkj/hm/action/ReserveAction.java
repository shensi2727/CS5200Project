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
	 * Ϣ���� ReserveVO��
	 * 
	 * @return ReserveVO
	 */
	public ReserveVO getModel() {

		return reserveVo;
	}

	/**
	 * �ͷ�Ԥ��
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
		// �����ٷ���
		float total = price * 1 * day;
		reserveVo.setTotal(total);
		reserveVo.setStatus("Ԥ��");
		//reserveVo.setUserId("����");

		// Ԥ������,��"T_Reserve"��д������
		IReserveDAO reservedao = new ReserveDAO();
		boolean isInsertReserve = reservedao.insertReserve(reserveVo);
		// ����ԱԤ�������,��"T_restaurant"���� �����������и���
		IrestaurantDAO restaurantdao = new restaurantDAO();
		restaurantVO restaurantVo = new restaurantVO();
		restaurantVo.setrestaurantId(reserveVo.getrestaurantId());
		boolean isModifyrestaurant = restaurantdao.modifyrestaurant("1", restaurantVo);
		// ,״̬���Ƿ���ý��и���
		IfoodDAO fooddao = new foodDAO();
		foodVO foodVo = new foodVO();
		foodVo.setfoodId(reserveVo.getfoodId());
		foodVo.setStatus("Ԥ��");
		foodVo.setAvailable("N");
		boolean isModifyfood = fooddao.modifyfood("1", foodVo);
		
		boolean isSuccess = isInsertReserve && isModifyrestaurant && isModifyfood;

		if (isSuccess) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	// ��ȡ����۸�
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

	// ��ʱ��,һ���ж�����
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
