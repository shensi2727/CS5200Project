package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.vo.restaurantVO;

/**

 */
public interface IrestaurantDAO {

	/**
	 * 增加酒店信息
	 * 
	 * @param restaurantVo
	 * @return
	 */
	public boolean insertrestaurant(restaurantVO restaurantVo);

	/**
	 * 修改酒店信息
	 * 
	 * @param hotleVo
	 * @return
	 */
	public boolean modifyrestaurant(String id, restaurantVO restaurantVo);

	/**
	 * 删除酒店信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean removerestaurant(String id);

	/**
	 * 根据酒店ID查询
	 * 
	 * @param id
	 * @return
	 */
	public List<restaurantVO> findrestaurantByCondition(restaurantVO restaurantVo);

	/**
	 * 查询所有的酒店信息
	 * 
	 * @return
	 */
	public List<restaurantVO> findAllrestaurant(String condition,PageBean pagebean);
}
