package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.vo.ReserveVO;

/**

 */
public interface IReserveDAO {

	/**
	 * 客房预订
	 * 
	 * @param reserveVo
	 * @return
	 */
	public boolean insertReserve(ReserveVO reserveVo);

	/**
	 * 更新客房预定
	 * 
	 * @param reserveVo
	 * @return
	 */
	public boolean modifyReserve(ReserveVO reserveVo);

	/**
	 * 根据reserveId来删除客房预定信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeReserve(String id);

	/**
	 * 根据reserveId来查询
	 * 
	 * @param id
	 * @return
	 */
	public List<ReserveVO> findReserveById(String id);

	/**
	 * 查询所有的预定信息
	 * 
	 * @return
	 */
	public List<ReserveVO> findAllReserve(PageBean pagebean);
}
