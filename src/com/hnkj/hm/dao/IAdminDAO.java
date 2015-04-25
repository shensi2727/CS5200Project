package com.hnkj.hm.dao;

import com.hnkj.hm.vo.AdminVO;

/**


 */
public interface IAdminDAO {

	/**
	 * ��ӹ���Ա��Ϣ
	 * 
	 * @param adminVo
	 * @return boolean
	 */
	public boolean insertAdmin(AdminVO adminVo);

	/**
	 * ��ѯ����Ա
	 * 
	 * @param String
	 *            id
	 * @param String
	 *            password
	 * @return boolean
	 */

	public boolean findAdminById(String id, String password);

	/**
	 * ɾ������Ա
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean removeAdmin(String id);

	/**
	 * ���¹���Ա
	 * 
	 * @param adminVo
	 * @return boolean
	 */
	public boolean modifyAdmin(AdminVO adminVo);

}
