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
import dao.InventoryDao;

import entity.drug;
import entity.inventory;

public class InventoryDaoImpl extends BaseDao implements InventoryDao{
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����


	public int updateinventory(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public List<inventory> findinventory(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<inventory> inventoryList = new ArrayList<inventory>();
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
				inventory d = new inventory();
				d.setShop_id(rs.getString("shop_id"));
				d.setDrug_id(rs.getString("drug_id"));
				d.setNum(Integer.valueOf(rs.getString("num")));
				inventoryList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return inventoryList;

	}


	public List<inventory> findinventory() {
		// TODO Auto-generated method stub
		List<inventory> inventoryList = new ArrayList<inventory>();
		try {
			String preparedSql = "select * from drug ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

			while (rs.next()) {
				inventory d = new inventory();
				d.setShop_id(rs.getString("shop_id"));
				d.setDrug_id(rs.getString("drug_id"));
				d.setNum(Integer.valueOf(rs.getString("num")));
				inventoryList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return inventoryList;
		
	}



}
