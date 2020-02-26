/**
 * �������ݿ����Ա��ӿ�

 */
package dao;

import java.util.List;

import entity.Administrator;


public interface AdministratorDao {
	/**
	 * ��ѯ���й���Ա��Ϣ
	 */
	public abstract List<Administrator> getAllAdministrator();

	/**
	 * ���¹���Ա��Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	public abstract int updateAdministrator(String sql, String[] param);

	/**
	 * ����������ѯ����Ա��Ϣ
	 * @param sql
	 * @param param
	 */
	public abstract Administrator selectAdministrator(String sql, String[] param);

}
