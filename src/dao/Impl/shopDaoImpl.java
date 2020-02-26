/**
 * 药品数据库操作类
 */
package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.shopDao;
import entity.DrugType;
import entity.shop;

public class shopDaoImpl extends BaseDao implements shopDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集


	public int updateshop(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public List<shop> findshop(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<shop> shopList = new ArrayList<shop>();
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
				shop d = new shop();
				d.setId(rs.getString("id"));
				d.setName(rs.getString("name"));
				d.setAddress(rs.getString("address"));
				d.setTelephone(rs.getString("telephone"));
				shopList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return shopList;

	}

	
	@Override
	public List<shop> findshop() {
		// TODO Auto-generated method stub
		List<shop> shopList = new ArrayList<shop>();
		try {
			String preparedSql = "select * from shop";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
				shop d = new shop();
				d.setId(rs.getString("id"));
				d.setName(rs.getString("name"));
				d.setAddress(rs.getString("address"));
				d.setTelephone(rs.getString("telephone"));
				shopList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return shopList;
		
	}



}
