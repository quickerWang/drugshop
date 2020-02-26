package dao;

import java.util.List;

import entity.drug;

public interface drugDao {
	/**
	 * ����ҩƷ��Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updatedrug(String sql, Object[] param);
	
	/**
	 * ��ѯ����ҩƷ��Ϣ
	 * @return list<drug>
	 */
	public List<drug> finddrug();
	
	/**
	 * ��������������ѯҩƷ��Ϣ
	 * @param sql
	 * @param param
	 * @return list<drug>
	 */
	public List<drug> finddrug(String sql, String[] param);
}
