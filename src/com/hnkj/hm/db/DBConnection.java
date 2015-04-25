package com.hnkj.hm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
database connect
 */
public class DBConnection {

	// 数据库加载驱动
	private static final String driver = "com.mysql.jdbc.Driver";

	// 数据库访问URL
	private static final String URL = "jdbc:mysql://localhost:3306/restaurantdb";

	// 数据库访问用户名
	private static final String username = "root";

	// 数据库访问密码
	private static final String password = "";

	// 数据库连接
	private static Connection conn = null;

	private static DBConnection dbconn = null;

	/**
	 * 获取DBConnection类的一个实例
	 * 
	 * @return DBConnection
	 */
	public static DBConnection getInstatnce() {

		if (dbconn == null) {
			dbconn = new DBConnection();
		}
		return dbconn;
	}

	/**
	 * 获取数据库连接资源
	 * 
	 * @return Connection
	 */
	public static synchronized Connection getConnection() throws Exception {

		try {
			// 获得JNDI初始化上下文
			InitialContext ctx = new InitialContext();
			// 在JNDI命名空间java:comp/env段里获得上下文对象 并通过JNDI名获得数据源对象
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/HMJNDI");

			conn = ds.getConnection();
		} catch (NamingException e) {
			try {
				// 加载数据库驱动程序
				Class.forName(driver).newInstance();
				// 获得数据库连接
				conn = DriverManager.getConnection(URL, username, password);

			} catch (ClassNotFoundException ex) {
				System.out.println("数据库驱动加载异常：" + ex.getMessage());
			}
		}
		return conn;
	}

	/**
	 * 释放数据库连接资源
	 * 
	 * @param conn
	 * @param ps
	 */
	public static void closeConnection(Connection conn, PreparedStatement pstmt) {

		try {

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放数据库连接资源
	 * 
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeConnection(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放数据库连接资源
	 * 
	 * @param conn
	 * @param st
	 */
	public static void closeConnection(Connection conn, Statement st) {

		try {
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放数据库连接资源
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement st,
			ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据库连接测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			conn = DBConnection.getConnection();
			if (conn != null) {
				System.out.println("Connection is OK....");
			} else {
				System.out.println("Connection is NO....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed() || conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
