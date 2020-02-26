package dao;

import java.util.List;

import entity.inventory;

public interface InventoryDao {
	/**
	 * ���¿����Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateinventory(String sql, Object[] param);
	
	/**
	 * ��ѯ���п����Ϣ
	 */
	public List<inventory> findinventory();
	
	/**
	 * ��������������ѯ�����Ϣ
	 * @param sql
	 * @param param
	 */
	public List<inventory> findinventory(String sql, String[] param);
}
