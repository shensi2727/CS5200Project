package com.hnkj.hm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnkj.hm.bean.PageBean;
import com.hnkj.hm.dao.IReserveDAO;
import com.hnkj.hm.db.DBConnection;
import com.hnkj.hm.vo.ReserveVO;

/**

 */
public class ReserveDAO implements IReserveDAO {

	/**
	 * 构造方法
	 */
	public ReserveDAO() {

	}

	/**
	 * 查询所有的预定信息
	 * 
	 * @return List
	 */
	public List<ReserveVO> findAllReserve(PageBean pagebean) {

		ArrayList<ReserveVO> list = new ArrayList<ReserveVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_Reserve";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {

			System.out.println("findAllReserve sql=" + sql);
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			for (int i = pagebean.getStartNum(); i <= pagebean.getEndNum(); i++) {

				rs.absolute(i);
				ReserveVO reserveVo = new ReserveVO();
				reserveVo.setReserveId(rs.getString("reserve_Id"));
				reserveVo.setfoodId(rs.getString("reserve_foodId"));
				reserveVo.setUserId(rs.getString("reserve_UserId"));
				reserveVo.setPrice(rs.getFloat("reserve_Price"));
				reserveVo.setTotal(rs.getFloat("reserve_Total"));
				Date startTime = rs.getDate("reserve_StartTime");
				Date endTime = rs.getDate("reserve_OverTime");
				reserveVo.setStartTime(sdf.format(startTime));
				reserveVo.setOverTime(sdf.format(endTime));
				// reserveVo.setStartTime(rs.getString("reserve_StartTime"));
				// reserveVo.setOverTime(rs.getString("reserve_OverTime"));
				reserveVo.setStatus(rs.getString("reserve_Status"));

				list.add(reserveVo);
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
	 * 根据reserveId来查询
	 * 
	 * @param id
	 * @return boolean
	 */
	public List<ReserveVO> findReserveById(String id) {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 客房预订
	 * 
	 * @param reserveVo
	 * @return boolean
	 */
	public boolean insertReserve(ReserveVO reserveVo) {

		if (null == reserveVo || "".equals(reserveVo)) {
			return false;
		}
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO T_Reserve(reserve_Id,reserve_foodId,reserve_restaurantId,reserve_UserId,reserve_Quantity,reserve_People,reserve_Price,reserve_Total,reserve_StartTime,reserve_OverTime,reserve_Status) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {

			System.out.println("insertReserve sql=" + sql);
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, reserveVo.getReserveId());
			pstm.setString(2, reserveVo.getfoodId());
			pstm.setString(3, reserveVo.getrestaurantId());
			pstm.setString(4, reserveVo.getUserId());
			pstm.setInt(5, reserveVo.getQuantity());
			pstm.setInt(6, reserveVo.getPeople());
			pstm.setFloat(7, reserveVo.getPrice());
			pstm.setFloat(8, reserveVo.getTotal());
			pstm.setString(9, reserveVo.getStartTime());
			pstm.setString(10, reserveVo.getOverTime());
			pstm.setString(11, reserveVo.getStatus());

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
	 * 更新客房预定
	 * 
	 * @param reserveVo
	 * @return boolean
	 */
	public boolean modifyReserve(ReserveVO reserveVo) {

		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 根据reserveId来删除客房预定信息
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean removeReserve(String id) {

		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "DELETE FROM T_Reserve WHERE reserve_id = '" + id + "'";
		try {

			System.out.println("removeReserve sql=" + sql);
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
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
