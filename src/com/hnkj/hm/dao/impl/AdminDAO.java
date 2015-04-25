package com.hnkj.hm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hnkj.hm.dao.IAdminDAO;
import com.hnkj.hm.db.DBConnection;
import com.hnkj.hm.vo.AdminVO;

/**

 */
public class AdminDAO implements IAdminDAO {

	/**
	 * 构造方法
	 */
	public AdminDAO() {

	}

	/**
	 * 删除管理员
	 * 
	 * @param id
	 *            管理员ID
	 */
	public boolean removeAdmin(String id) {

		// TODO Auto-generated method stub
		return false;
	}

	public boolean findAdminById(String id, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_Manager WHERE man_Id='" + id
				+ "' AND man_Password='" + password + "'"; 
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("findAdminById sql=" + sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, pstmt, rs);
		}
		return false;
	}

	public boolean insertAdmin(AdminVO adminVo) {

		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyAdmin(AdminVO adminVo) {

		// TODO Auto-generated method stub
		return false;
	}

}
