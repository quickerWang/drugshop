package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.orderdaodetail;
import entity.order_detail;

public class orderdetailDaoImpl extends BaseDao implements orderdaodetail{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	
	public int updateorder_detail(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public order_detail findorder_detail(String sql, String[] param) {
		// TODO Auto-generated method stub
		order_detail order_detailList = null;
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				order_detail c = new order_detail();
				c.setDiscount(rs.getDouble("discount"));
				c.setDrug_id(rs.getString("drug_id"));
				c.setId(rs.getString("id"));
				c.setNumber(rs.getInt("number"));
				c.setOrder_id(rs.getString("order_id"));
				c.setPrice(rs.getDouble("price"));
				order_detailList=c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return order_detailList;

	}

	
	public List<order_detail> findorder_detail() {
		// TODO Auto-generated method stub
		List<order_detail> order_detailList = new ArrayList<order_detail>();
		try {
			String preparedSql = "select * from client";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
				order_detail c = new order_detail();
				c.setDiscount(rs.getDouble("discount"));
				c.setDrug_id(rs.getString("drug_id"));
				c.setId(rs.getString("id"));
				c.setNumber(rs.getInt("number"));
				c.setOrder_id(rs.getString("order_id"));
				c.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return order_detailList;
		
	}
}
