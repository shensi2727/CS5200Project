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

	// ���ݿ��������
	private static final String driver = "com.mysql.jdbc.Driver";

	// ���ݿ����URL
	private static final String URL = "jdbc:mysql://localhost:3306/restaurantdb";

	// ���ݿ�����û���
	private static final String username = "root";

	// ���ݿ��������
	private static final String password = "";

	// ���ݿ�����
	private static Connection conn = null;

	private static DBConnection dbconn = null;

	/**
	 * ��ȡDBConnection���һ��ʵ��
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
	 * ��ȡ���ݿ�������Դ
	 * 
	 * @return Connection
	 */
	public static synchronized Connection getConnection() throws Exception {

		try {
			// ���JNDI��ʼ��������
			InitialContext ctx = new InitialContext();
			// ��JNDI�����ռ�java:comp/env�����������Ķ��� ��ͨ��JNDI���������Դ����
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/HMJNDI");

			conn = ds.getConnection();
		} catch (NamingException e) {
			try {
				// �������ݿ���������
				Class.forName(driver).newInstance();
				// ������ݿ�����
				conn = DriverManager.getConnection(URL, username, password);

			} catch (ClassNotFoundException ex) {
				System.out.println("���ݿ����������쳣��" + ex.getMessage());
			}
		}
		return conn;
	}

	/**
	 * �ͷ����ݿ�������Դ
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
	 * �ͷ����ݿ�������Դ
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
	 * �ͷ����ݿ�������Դ
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
	 * �ͷ����ݿ�������Դ
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
	 * ���ݿ����Ӳ���
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
