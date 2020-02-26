package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.clerkDao;
import entity.clerk;

public class clerkDaoImpl extends BaseDao implements clerkDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	
	public int updateclerk(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public clerk findclerk(String sql, String[] param) {
		// TODO Auto-generated method stub
		clerk clerkList = null;
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
				clerk c = new clerk();
				c.setShop_id(rs.getString("shop_id"));
				c.setName(rs.getString("name"));
				c.setId(rs.getString("id"));
				c.setPassword(rs.getString("password"));
				clerkList=c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return clerkList;

	}

	
	public List<clerk> findclerk() {
		// TODO Auto-generated method stub
		List<clerk> clerkList = new ArrayList<clerk>();
		try {
			String preparedSql = "select * from clerk";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
				clerk c = new clerk();
				c.setShop_id(rs.getString("shop_id"));
				c.setName(rs.getString("name"));
				c.setId(rs.getString("id"));
				c.setPassword(rs.getString("password"));
				clerkList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return clerkList;
		
	}



}
