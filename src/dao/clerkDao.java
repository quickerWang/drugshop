package dao;

import java.util.List;

import entity.clerk;

public interface clerkDao {
	/**
	 * ����ҩƷ��Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateclerk(String sql, Object[] param);
	
	/**
	 * ��ѯ����ҩƷ��Ϣ
	 */
	public List<clerk> findclerk();
	
	/**
	 * ��������������ѯҩƷ��Ϣ
	 * @param sql
	 * @param param
	 */
	public clerk findclerk(String sql, String[] param);
}
