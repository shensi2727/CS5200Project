package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.vo.UserVO;

/**

 */

public interface IUserDAO {

	/**
	 * 添加用户
	 * 
	 * @param userVo
	 *            用户信息BEAN
	 * @return
	 * @throws Exception
	 */
	public boolean insertUser(UserVO userVo);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 *            用户信息ID
	 * @return
	 * @throws Exception
	 */
	public boolean removeUser(String userId);

	/**
	 * 修改用户基本信息
	 * 
	 * @param userVo
	 *            用户信息BEAN
	 * @return
	 * @throws Exception
	 */
	public boolean modifyUser(String id, UserVO userVo);

	/**
	 * 查询所有用户
	 * 
	 * @return List<UserVO> 用户记录信息BEAN
	 * @throws Exception
	 */
	public List<UserVO> findAllUser();

	/**
	 * 根据用户ID和条件查询
	 * 
	 * @param userId
	 *            用户ID
	 * @param condition
	 *            查询条件
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> findUserByCondition(String userId, String condition);

}
