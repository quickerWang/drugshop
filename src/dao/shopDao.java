package dao;

import java.util.List;

import entity.shop;

public interface shopDao {
	/**
	 * ����ҩ����Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateshop(String sql, Object[] param);
	
	/**
	 * ��ѯ����ҩ����Ϣ
	 */
	public List<shop> findshop();
	
	/**
	 * ��������������ѯҩ����Ϣ
	 * @param sql
	 * @param param
	 */
	public List<shop> findshop(String sql, String[] param);
}
