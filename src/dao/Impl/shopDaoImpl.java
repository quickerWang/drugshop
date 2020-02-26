/**
 * ҩƷ���ݿ������
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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����


	public int updateshop(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public List<shop> findshop(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<shop> shopList = new ArrayList<shop>();
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
