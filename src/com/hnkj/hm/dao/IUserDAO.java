package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.vo.UserVO;

/**

 */

public interface IUserDAO {

	/**
	 * ����û�
	 * 
	 * @param userVo
	 *            �û���ϢBEAN
	 * @return
	 * @throws Exception
	 */
	public boolean insertUser(UserVO userVo);

	/**
	 * ɾ���û�
	 * 
	 * @param userId
	 *            �û���ϢID
	 * @return
	 * @throws Exception
	 */
	public boolean removeUser(String userId);

	/**
	 * �޸��û�������Ϣ
	 * 
	 * @param userVo
	 *            �û���ϢBEAN
	 * @return
	 * @throws Exception
	 */
	public boolean modifyUser(String id, UserVO userVo);

	/**
	 * ��ѯ�����û�
	 * 
	 * @return List<UserVO> �û���¼��ϢBEAN
	 * @throws Exception
	 */
	public List<UserVO> findAllUser();

	/**
	 * �����û�ID��������ѯ
	 * 
	 * @param userId
	 *            �û�ID
	 * @param condition
	 *            ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> findUserByCondition(String userId, String condition);

}
