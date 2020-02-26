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
import dao.InventoryDao;

import entity.drug;
import entity.inventory;

public class InventoryDaoImpl extends BaseDao implements InventoryDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集


	public int updateinventory(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	
	public List<inventory> findinventory(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<inventory> inventoryList = new ArrayList<inventory>();
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
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

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
