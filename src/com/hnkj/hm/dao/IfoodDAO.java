package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.vo.foodVO;

/**
 * <p>

 */
public interface IfoodDAO {

	/**
	 * ���ӷ�����Ϣ
	 * 
	 * @param foodVo
	 * @return
	 */
	public boolean insertfood(foodVO foodVo);

	/**
	 * �޸ķ�����Ϣ
	 * 
	 * @param foodVo
	 * @return
	 */
	public boolean modifyfood(String id, foodVO foodVo);

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public boolean removefood(String id);

	/**
	 * ���ݷ���ID��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public List<foodVO> findfoodById(String id);

	/**
	 * ��ѯ���еķ�����Ϣ
	 * 
	 * @return
	 */
	public List<foodVO> findAllfood(String sql, PageBean pagebean);
}
