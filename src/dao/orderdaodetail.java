package dao;

import java.util.List;

import entity.order_detail;

public interface orderdaodetail {
	/**
	 * ���»�Ա��Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateorder_detail(String sql, Object[] param);
	
	/**
	 * ��ѯ���л�Ա��Ϣ
	 */
	public List<order_detail> findorder_detail();
	
	/**
	 * ��������������ѯ��Ա��Ϣ
	 * @param sql
	 * @param param
	 */
	public order_detail findorder_detail(String sql, String[] param);
}
