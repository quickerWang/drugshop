package dao;

import java.util.List;

import entity.client;

public interface clientDao {
	/**
	 * ���»�Ա��Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateclient(String sql, Object[] param);
	
	/**
	 * ��ѯ���л�Ա��Ϣ
	 */
	public List<client> findclient();
	
	/**
	 * ��������������ѯ��Ա��Ϣ
	 * @param sql
	 * @param param
	 */
	public client findclient(String sql, String[] param);
}
