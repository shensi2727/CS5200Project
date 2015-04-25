package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.vo.ReserveVO;

/**

 */
public interface IReserveDAO {

	/**
	 * �ͷ�Ԥ��
	 * 
	 * @param reserveVo
	 * @return
	 */
	public boolean insertReserve(ReserveVO reserveVo);

	/**
	 * ���¿ͷ�Ԥ��
	 * 
	 * @param reserveVo
	 * @return
	 */
	public boolean modifyReserve(ReserveVO reserveVo);

	/**
	 * ����reserveId��ɾ���ͷ�Ԥ����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeReserve(String id);

	/**
	 * ����reserveId����ѯ
	 * 
	 * @param id
	 * @return
	 */
	public List<ReserveVO> findReserveById(String id);

	/**
	 * ��ѯ���е�Ԥ����Ϣ
	 * 
	 * @return
	 */
	public List<ReserveVO> findAllReserve(PageBean pagebean);
}
