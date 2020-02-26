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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	
	public int updateorder_detail(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public order_detail findorder_detail(String sql, String[] param) {
		// TODO Auto-generated method stub
		order_detail order_detailList = null;
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
