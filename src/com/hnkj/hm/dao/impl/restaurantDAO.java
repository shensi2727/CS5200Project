package com.hnkj.hm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.dao.IrestaurantDAO;
import com.hnkj.hm.db.DBConnection;
import com.hnkj.hm.vo.restaurantVO;

/**

 */
public class restaurantDAO implements IrestaurantDAO {

	/**
	 * 构造方法
	 */
	public restaurantDAO() {

	}

	/**
	 * 查询所有的酒店信息
	 * 
	 * @return
	 */
	public List<restaurantVO> findAllrestaurant(String sql, PageBean pagebean) {

		ArrayList<restaurantVO> list = new ArrayList<restaurantVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			System.out.println("findrestaurantByCondition sql=" + sql);
			rs = pstm.executeQuery();
			for (int i = pagebean.getStartNum(); i <= pagebean.getEndNum(); i++) {
				rs.absolute(i);
				restaurantVO restaurantVo = new restaurantVO();
				restaurantVo.setrestaurantId(rs.getString("restaurant_Id"));
				restaurantVo.setrestaurantName(rs.getString("restaurant_Name"));
				restaurantVo.setAddress(rs.getString("restaurant_Address"));
				restaurantVo.setPrice(rs.getFloat("restaurant_Price"));
				restaurantVo.setQuantity(rs.getInt("restaurant_Quantity"));
				restaurantVo.setStar(rs.getString("restaurant_Star"));
				restaurantVo.setImageFileName(rs.getString("restaurant_Image"));
				restaurantVo.setDescription(rs.getString("restaurant_Description"));

				list.add(restaurantVo);
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
		return list;
	}

	/**
	 * 根据不同条件来查询
	 * 
	 * @param List
	 *            <restaurantVO>
	 */
	public List<restaurantVO> findrestaurantByCondition(restaurantVO restaurantVo) {

		ArrayList<restaurantVO> list = new ArrayList<restaurantVO>();

		String restaurantId = restaurantVo.getrestaurantId();
		String restaurantName = restaurantVo.getrestaurantName();
		String address = restaurantVo.getAddress();
		String priceRange = restaurantVo.getPriceRange();

		if ("".equals(restaurantName)) {
			restaurantName = null;
		}
		if ("0".equals(address)) {
			address = null;
		}
		if ("".equals(priceRange) || null == priceRange) {
			priceRange = "100,600";
		}

		// 和最大价格
		String[] strPrice = null;

		for (int i = 0; i < priceRange.length(); i++) {
			strPrice = priceRange.split(",");
		}
		float minPrice = Float.parseFloat(strPrice[0]);
		float maxPrice = Float.parseFloat(strPrice[1]);

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_restaurant WHERE restaurant_Id = '" + restaurantId
				+ "' OR restaurant_Name LIKE '%" + restaurantName
				+ "%' OR restaurant_Address LIKE '%" + address
				+ "%' OR (restaurant_Price >= '" + minPrice
				+ "' AND restaurant_Price <= '" + maxPrice + "')";

		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);

			System.out.println("findrestaurantByCondition sql=" + sql);
			rs = pstm.executeQuery();
			while (rs.next()) {

				restaurantVO restaurantVos = new restaurantVO();
				restaurantVos.setrestaurantId(rs.getString("restaurant_Id"));
				restaurantVos.setrestaurantName(rs.getString("restaurant_Name"));
				restaurantVos.setAddress(rs.getString("restaurant_Address"));
				restaurantVos.setPrice(rs.getFloat("restaurant_Price"));
				restaurantVos.setQuantity(rs.getInt("restaurant_Quantity"));
				restaurantVos.setStar(rs.getString("restaurant_Star"));

				list.add(restaurantVos);
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
		return list;
	}

	/**
	 * 增加酒店基本信息
	 * 
	 * @param restaurantVO
	 * @return boolean
	 */
	public boolean insertrestaurant(restaurantVO restaurantVo) {

		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO T_restaurant(restaurant_Id,restaurant_Name,restaurant_Star,restaurant_Price,restaurant_Quantity,restaurant_Address,restaurant_Image,restaurant_Description) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, restaurantVo.getrestaurantId());
			pstm.setString(2, restaurantVo.getrestaurantName());
			pstm.setString(3, restaurantVo.getStar());
			pstm.setFloat(4, restaurantVo.getPrice());
			pstm.setInt(5, restaurantVo.getQuantity());
			pstm.setString(6, restaurantVo.getAddress());
			pstm.setString(7, restaurantVo.getImageFileName());
			pstm.setString(8, restaurantVo.getDescription());
			System.out.println("insertrestaurant aql=" + sql);
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
	 * 修改酒店信息
	 * 
	 * @param hotleVo
	 * @return
	 */
	public boolean modifyrestaurant(String id, restaurantVO restaurantVo) {

		String status = id;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		if (status.equals("1")) {
			sql = "UPDATE T_restaurant SET restaurant_Quantity = restaurant_Quantity-1 WHERE restaurant_Id = '"
					+ restaurantVo.getrestaurantId() + "'";
			System.out.println("modifyrestaurant sql=" + sql);
		}
		if (status.equals("2")) {
			sql = "UPDATE T_restaurant SET restaurant_Quantity = '"
					+ restaurantVo.getQuantity() + "',restaurant_Price = '"
					+ restaurantVo.getPrice() + "' WHERE restaurant_Id = '"
					+ restaurantVo.getrestaurantId() + "'";
		}

		try {
			System.out.println("modifyrestaurant sql=" + sql);
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
	 * 删除酒店信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean removerestaurant(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM T_restaurant WHERE restaurant_id = '" + id + "'";

		try {
			System.out.println("removerestaurant sql=" + sql);
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
			DBConnection.closeConnection(conn, pstmt);
		}
		return false;
	}

	/**
	 * 根据关键字来查询
	 * 
	 * @param key
	 * @return
	 */
	public List<String> findrestaurantById(String key) {

		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {

			if (key.equals("1")) {

				sql = "SELECT DISTINCT restaurant_id FROM T_restaurant WHERE restaurant_Quantity > 0";

			} else if (key.equals("2")) {

				sql = "SELECT DISTINCT restaurant_address FROM T_restaurant";
			} else {
				sql = "SELECT restaurant_Name FROM T_restaurant WHERE restaurant_id = '" + key
						+ "'";
			}
			System.out.println("selectrestaurantInfo sql=" + sql);
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String value = rs.getString(1);
				list.add(value);
			}
		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 根据价格范围和地点查询
	 * 
	 * @param address
	 * @param price
	 * @return
	 */
	public List<restaurantVO> findAllrestaurant(String address, String price) {

		ArrayList<restaurantVO> list = new ArrayList<restaurantVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if ("".equals(address)) {
			address = null;
		}
		if ("".equals(price) || null == price) {
			price = "100,600";
		}

		// 和最大价格
		String[] strPrice = null;

		for (int i = 0; i < price.length(); i++) {
			strPrice = price.split(",");
		}
		float minPrice = Float.parseFloat(strPrice[0]);
		float maxPrice = Float.parseFloat(strPrice[1]);
		String sql = "SELECT * FROM T_restaurant WHERE restaurant_Address LIKE '%"
				+ address + "%' OR (restaurant_Price >= '" + minPrice
				+ "' AND restaurant_Price <= '" + maxPrice
				+ "') ORDER BY restaurant_Price DESC LIMIT 10;";

		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);

			System.out.println("findrestaurantByCondition sql=" + sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				restaurantVO restaurantVo = new restaurantVO();
				restaurantVo.setrestaurantId(rs.getString("restaurant_Id"));
				restaurantVo.setrestaurantName(rs.getString("restaurant_Name"));
				restaurantVo.setAddress(rs.getString("restaurant_Address"));
				restaurantVo.setPrice(rs.getFloat("restaurant_Price"));
				restaurantVo.setQuantity(rs.getInt("restaurant_Quantity"));
				restaurantVo.setStar(rs.getString("restaurant_Star"));
				restaurantVo.setImageFileName(rs.getString("restaurant_Image"));
				restaurantVo.setDescription(rs.getString("restaurant_Description"));

				list.add(restaurantVo);
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
		return list;
	}

}
