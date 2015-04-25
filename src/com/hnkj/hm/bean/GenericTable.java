package com.hnkj.hm.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hnkj.hm.db.DBConnection;

/**

 */
public class GenericTable {

	private static Connection conn = null;

	// 获取表中主键(Primary Key)
	public static String getMaxPK(String pk, String table, String pkHead)
			throws Exception {

		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(" + pk + ") FROM " + table;
		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				pk = rs.getString(1);
			}
			if (pk != null) {
				pk = GenericTable.newPK(pkHead, pk.substring(1));
			} else {
				pk = pkHead + "001";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, st);
		}
		return pk;
	}

	// 取最大"PK"(主键)加一
	public static String newPK(String pkHead, String id) {

		int y = Integer.parseInt(id);
		String newPK = "";

		if (y >= 1 && y < 9) {
			newPK = pkHead + "00" + (y + 1);
		}
		if (y >= 9 && y < 99) {
			newPK = pkHead + "0" + (y + 1);
		}
		if (y >= 99) {
			newPK = pkHead + (y + 1);
		}
		return newPK;
	}
}
