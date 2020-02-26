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
import dao.drugDao;
import entity.DrugType;
import entity.drug;

public class drugDaoImpl extends BaseDao implements drugDao{
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	
	@Override
	public int updatedrug(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public List<drug> finddrug(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<drug> drugList = new ArrayList<drug>();
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
				drug d = new drug();
				d.setId(rs.getString("id"));
				d.setName(rs.getString("name"));
				d.setNorms(rs.getString("norms"));
				d.setType(DrugType.valueOf(rs.getString("type")));
				d.setPrice(rs.getDouble("price"));
				d.setFactory_id(rs.getString("factory_id"));
				drugList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return drugList;

	}

	
	@Override
	public List<drug> finddrug() {
		// TODO Auto-generated method stub
		List<drug> drugList = new ArrayList<drug>();
		try {
			String preparedSql = "select * from drug ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

			while (rs.next()) {
				drug d = new drug();
				d.setId(rs.getString("id"));
				d.setName(rs.getString("name"));
				d.setNorms(rs.getString("norms"));
				d.setType(DrugType.valueOf(rs.getString("type")));
				d.setPrice(rs.getDouble("price"));
				d.setFactory_id(rs.getString("factory_id"));
				drugList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return drugList;
		
	}



}
