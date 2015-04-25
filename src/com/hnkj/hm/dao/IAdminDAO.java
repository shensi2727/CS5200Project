package com.hnkj.hm.dao;

import com.hnkj.hm.vo.AdminVO;

/**


 */
public interface IAdminDAO {

	/**
	 * 添加管理员信息
	 * 
	 * @param adminVo
	 * @return boolean
	 */
	public boolean insertAdmin(AdminVO adminVo);

	/**
	 * 查询管理员
	 * 
	 * @param String
	 *            id
	 * @param String
	 *            password
	 * @return boolean
	 */

	public boolean findAdminById(String id, String password);

	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean removeAdmin(String id);

	/**
	 * 更新管理员
	 * 
	 * @param adminVo
	 * @return boolean
	 */
	public boolean modifyAdmin(AdminVO adminVo);

}
