package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.vo.foodVO;

/**
 * <p>

 */
public interface IfoodDAO {

	/**
	 * 增加房间信息
	 * 
	 * @param foodVo
	 * @return
	 */
	public boolean insertfood(foodVO foodVo);

	/**
	 * 修改房间信息
	 * 
	 * @param foodVo
	 * @return
	 */
	public boolean modifyfood(String id, foodVO foodVo);

	/**
	 * 删除房间信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean removefood(String id);

	/**
	 * 根据房间ID查询
	 * 
	 * @param id
	 * @return
	 */
	public List<foodVO> findfoodById(String id);

	/**
	 * 查询所有的房间信息
	 * 
	 * @return
	 */
	public List<foodVO> findAllfood(String sql, PageBean pagebean);
}
