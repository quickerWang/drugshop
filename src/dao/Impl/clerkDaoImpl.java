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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	
	public int updateclerk(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public clerk findclerk(String sql, String[] param) {
		// TODO Auto-generated method stub
		clerk clerkList = null;
		try {
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
