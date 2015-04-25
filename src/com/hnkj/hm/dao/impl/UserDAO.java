package com.hnkj.hm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hnkj.hm.dao.IUserDAO;
import com.hnkj.hm.db.DBConnection;
import com.hnkj.hm.vo.UserVO;

/**

 */
public class UserDAO implements IUserDAO {

	public UserDAO() {

	}

	/**
	 * 查询所有用户信息
	 */
	public List<UserVO> findAllUser() {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户ID和条件查询
	 * 
	 * @return List
	 */
	public List<UserVO> findUserByCondition(String userId, String condition) {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 添加用户基本信息
	 * 
	 * @return boolean
	 */
	public boolean insertUser(UserVO userVo) {

		if (userVo == null || userVo.equals("")) {
			return false;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO T_User(user_id,user_pwd,user_name,user_age,user_sex,user_mobile,user_email,user_certitype,user_certinum,user_address,user_level,user_point,user_birthday) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getUserId());
			pstmt.setString(2, userVo.getUserPassword());
			pstmt.setString(3, userVo.getUserName());
			pstmt.setInt(4, userVo.getAge());
			pstmt.setString(5, userVo.getSex());
			pstmt.setString(6, userVo.getMobile());
			pstmt.setString(7, userVo.getEmail());
			pstmt.setString(8, userVo.getCertiType());
			pstmt.setString(9, userVo.getCertiNum());
			pstmt.setString(10, userVo.getAddress());
			pstmt.setInt(11, 0);
			pstmt.setInt(12, 0);
			pstmt.setString(13, userVo.getBirthday());

			System.out.println("insertUser sql=" + sql);

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 修改用户基本信息
	 * 
	 * @return boolean
	 */
	public boolean modifyUser(String id, UserVO userVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String type = id;
		String sql = "";
		if (type.equals("1")) {
			sql = "UPDATE T_User SET user_Point = user_Point + 1 WHERE user_Id= '"
					+ userVo.getUserId() + "'";
		}
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 删除用户基本信息
	 * 
	 * @return boolean
	 */
	public boolean removeUser(String userId) {

		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 用户登陆
	 * 
	 * @return boolean
	 */
	public boolean login(String userId, String password) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(user_id) FROM T_User WHERE user_id = '"
				+ userId + "' AND user_pwd = '" + password + "'";
		try {
			System.out.println("login sql=" + sql);
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			rs.next();
			int i = rs.getInt(1);
			if (i > 0) {
				System.out.println("i " + i);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return false;
	}
}
