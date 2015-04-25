package com.hnkj.hm.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hnkj.hm.db.DBConnection;
/**

 */
public class TableSummary {

	public static int getTotalRows(String table) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM " + table;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);

			System.out.println("getTotalRows sql=" + sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstm, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public static int getTotalRows(int i) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "";
		if (i > 0 && i < 3) {
			sql = "SELECT COUNT(*) FROM T_restaurant WHERE restaurant_star = '" + i + "'";
		}
		if (i >= 3) {
			sql = "SELECT COUNT(*) FROM T_restaurant WHERE restaurant_star >= '" + i + "'";
		}
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);

			System.out.println("getTotalRows sql=" + sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstm, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
