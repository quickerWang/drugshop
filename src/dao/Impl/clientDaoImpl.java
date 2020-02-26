package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.clientDao;
import dao.drugDao;
import entity.DrugType;
import entity.client;
import entity.drug;

public class clientDaoImpl extends BaseDao implements clientDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	
	public int updateclient(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public client findclient(String sql, String[] param) {
		// TODO Auto-generated method stub
		client clientList = null;
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
				client c = new client();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPoint(rs.getDouble("point"));
				c.setTelephone(rs.getString("telephone"));
				clientList=c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return clientList;

	}

	
	public List<client> findclient() {
		// TODO Auto-generated method stub
		List<client> clientList = new ArrayList<client>();
		try {
			String preparedSql = "select * from client";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
				client c = new client();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPoint(rs.getDouble("point"));
				c.setTelephone(rs.getString("telephone"));
				clientList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return clientList;
		
	}



}
