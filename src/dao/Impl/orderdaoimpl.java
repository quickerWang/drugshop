package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.clientDao;
import dao.orderDao;
import entity.order1;

public class orderdaoimpl extends BaseDao implements orderDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	
	public int updateorder(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public order1 findorder(String sql, String[] param) {
		// TODO Auto-generated method stub
		order1 order1List = null;
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
				order1 c = new order1();
				c.setId(rs.getString("id"));
				c.setClerk_id(rs.getString("clerk_id"));
				c.setClient_id(rs.getString("client_id"));
				c.setShop_id(rs.getString("shop_id"));
				c.setSum(rs.getInt("sum"));
				c.setTime(rs.getDate("time"));
				order1List=c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return order1List;

	}

	
	public List<order1> findorder() {
		// TODO Auto-generated method stub
		List<order1> order1List = new ArrayList<order1>();
		try {
			String preparedSql = "select * from client";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
				order1 c = new order1();
				c.setId(rs.getString("id"));
				c.setClerk_id(rs.getString("clerk_id"));
				c.setClient_id(rs.getString("client_id"));
				c.setShop_id(rs.getString("shop_id"));
				c.setSum(rs.getInt("sum"));
				c.setTime(rs.getDate("time"));
				order1List.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return order1List;
		
	}
}
