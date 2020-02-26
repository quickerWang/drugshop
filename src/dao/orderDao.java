package dao;

import java.util.List;

import entity.order1;

public interface orderDao {
	/**
	 * ���¶�����Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateorder(String sql, Object[] param);
	
	/**
	 * ��ѯ���ж�����Ϣ
	 */
	public List<order1> findorder();
	
	/**
	 * ��������������ѯ������Ϣ
	 * @param sql
	 * @param param
	 */
	public order1 findorder(String sql, String[] param);
}
