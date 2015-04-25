package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.vo.restaurantVO;

/**

 */
public interface IrestaurantDAO {

	/**
	 * ���ӾƵ���Ϣ
	 * 
	 * @param restaurantVo
	 * @return
	 */
	public boolean insertrestaurant(restaurantVO restaurantVo);

	/**
	 * �޸ľƵ���Ϣ
	 * 
	 * @param hotleVo
	 * @return
	 */
	public boolean modifyrestaurant(String id, restaurantVO restaurantVo);

	/**
	 * ɾ���Ƶ���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public boolean removerestaurant(String id);

	/**
	 * ���ݾƵ�ID��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public List<restaurantVO> findrestaurantByCondition(restaurantVO restaurantVo);

	/**
	 * ��ѯ���еľƵ���Ϣ
	 * 
	 * @return
	 */
	public List<restaurantVO> findAllrestaurant(String condition,PageBean pagebean);
}
