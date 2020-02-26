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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	 
	@Override
	public List<Administrator> getAllAdministrator() {
		List<Administrator> AdministratorList = new ArrayList<Administrator>();
		try {
		String preparedSql = "select * from Administrator ";
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
