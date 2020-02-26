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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	
	public int updateclient(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public client findclient(String sql, String[] param) {
		// TODO Auto-generated method stub
		client clientList = null;
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
