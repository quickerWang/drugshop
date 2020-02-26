package dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/**
 * ���ݿ��������
 */
public class BaseDao {
	public static String DRIVER; // ���ݿ�����

	public static String URL ; // url

	public static String DBNAME; // ���ݿ��û���

	public static String DBPASS; // ���ݿ�����
	
	Connection conn = null;// �������Ӷ���
	
	static{//��̬�����,������ص�ʱ��ִ��
		init();
	}
	
	/**
	 * ��ʼ�����Ӳ���,�������ļ�����
	 */
		public static void init(){
			Properties params=new Properties();
			String configFile = "database.properties";//�����ļ�·��
			//���������ļ�����������
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
			
			try {
				//���������ж�ȡ�����б�
				params.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//����ָ���Ļ�ȡ��Ӧ��ֵ
			DRIVER=params.getProperty("driver");
			URL=params.getProperty("url");
			DBNAME=params.getProperty("user");
			DBPASS=params.getProperty("password");
		}   

	/**
	 * �õ����ݿ�����
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return ���ݿ�����
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVER); // ע������
			conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // ������ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // ��������
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* ���rs���գ��ر�rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���pstmt���գ��ر�pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���conn���գ��ر�conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            Ԥ����� SQL ����еġ������������ַ�������
	 * @return Ӱ�������
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			// System.out.println(preparedSql);
			num = pstmt.executeUpdate(); // ִ��SQL���
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
	public static void main(String []args) {
		String sql="insert into list(id,name,address,telephone) values(?,?,?,?)";  //list�в�������
		
	}
}
