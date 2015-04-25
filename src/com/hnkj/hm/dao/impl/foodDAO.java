package com.hnkj.hm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.dao.IfoodDAO;
import com.hnkj.hm.db.DBConnection;
import com.hnkj.hm.vo.foodVO;

/**

 */
public class foodDAO implements IfoodDAO {

	/**
	 * 构造方法
	 */
	public foodDAO() {

	}

	public List<foodVO> findAllfood(String sql, PageBean pagebean) {

		ArrayList<foodVO> list = new ArrayList<foodVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			for (int i = pagebean.getStartNum(); i <= pagebean.getEndNum(); i++) {
				rs.absolute(i);
				foodVO foodVo = new foodVO();
				foodVo.setfoodId(rs.getString("food_Id"));
				foodVo.setStatus(rs.getString("food_Status"));
				foodVo.setfoodName(rs.getString("food_Name"));
				foodVo.setAvailable(rs.getString("food_Available"));
				foodVo.setPrice(rs.getFloat("food_Price"));
				foodVo.setDiscountPrice(rs.getFloat("food_DiscoutPrice"));
				list.add(foodVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 根据ID的不同来查询
	 * 
	 * @param List
	 *            <foodVO>
	 */
	public List<foodVO> findfoodById(String id) {

		ArrayList<foodVO> list = new ArrayList<foodVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "";
		if (id.equals("1")) {
			sql = "SELECT food_Id,food_Price FROM T_food WHERE food_Available = '"
					+ "Y" + "'";
		} else {
			sql = "SELECT food_Id,food_Price FROM T_food WHERE food_id = '"
					+ id + "'";
		}
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				foodVO foodVo = new foodVO();
				String foodId = rs.getString("food_id");
				Float price = rs.getFloat("food_price");
				foodVo.setfoodId(foodId);
				foodVo.setPrice(price);
				list.add(foodVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 增加房间信息
	 * 
	 * @param foodVo
	 *            food信息BEAN
	 * @return boolean
	 */
	public boolean insertfood(foodVO foodVo) {

		Connection conn = null;
		PreparedStatement pstm = null;

		String sql = "INSERT INTO T_food(food_id,food_status,food_Available,food_name,food_price,food_discoutPrice,food_restaurantId) VALUES(?,?,?,?,?,?,?)";
		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, foodVo.getfoodId());
			pstm.setString(2, foodVo.getStatus());
			pstm.setString(3, "Y"); // 房间是否可以使用 "Y"表示可以 "N"表示不可以
			pstm.setString(4, foodVo.getfoodName());
			pstm.setFloat(5, foodVo.getPrice());
			pstm.setFloat(6, foodVo.getDiscountPrice());
			pstm.setString(7, foodVo.getrestaurantId());

			System.out.println("insertfood sql=" + sql);
			int i = pstm.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 修改房间信息
	 * 
	 * @param boolean
	 */
	public boolean modifyfood(String id, foodVO foodVo) {

		String status = id;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		if (status.equals("1")) {
			sql = "UPDATE T_food SET food_Status = '" + foodVo.getStatus()
					+ "', food_Available = '" + foodVo.getAvailable()
					+ "' WHERE food_Id = '" + foodVo.getfoodId() + "'";
		}
		if (status.equals("2")) {

			sql = "UPDATE T_food SET food_Status = '" + foodVo.getStatus()
					+ "', food_Available = '" + foodVo.getAvailable()
					+ "', food_discoutPrice = '" + foodVo.getDiscountPrice()
					+ "' WHERE food_Id = '" + foodVo.getfoodId() + "'";
		}
		try {
			System.out.println("modifyfood sql=" + sql);
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
	 * 根据ID来删除数据
	 * 
	 * @param boolean
	 */
	public boolean removefood(String id) {

		Connection conn = null;
		PreparedStatement pstm = null;

		String sql = "DELETE FROM T_food WHERE food_Id = '" + id + "'";
		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);

			System.out.println("insertfood sql=" + sql);
			int i = pstm.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
