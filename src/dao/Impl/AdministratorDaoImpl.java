package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Administrator;
import dao.BaseDao;
import dao.AdministratorDao;

public class AdministratorDaoImpl extends BaseDao implements AdministratorDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	 
	@Override
	public List<Administrator> getAllAdministrator() {
		List<Administrator> AdministratorList = new ArrayList<Administrator>();
		try {
		String preparedSql = "select * from Administrator ";
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Administrator u = new Administrator();
				u.setId(rs.getString(1));
				u.setPassword(rs.getString(2));
				AdministratorList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return AdministratorList;
		// TODO Auto-generated method stub
	}

	/**(non-Javadoc)
	 */
	@Override
	public int updateAdministrator(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
		// TODO Auto-generated method stub
	}

	/**(non-Javadoc)
	 */
	@Override
	public Administrator selectAdministrator(String sql, String[] param) {
		Administrator u = null;
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
				u = new Administrator();
				u.setId(rs.getString(1));
				u.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return u;
		// TODO Auto-generated method stub
	}
}
