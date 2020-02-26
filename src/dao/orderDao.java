package dao;

import java.util.List;

import entity.order1;

public interface orderDao {
	/**
	 * 更新订单信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateorder(String sql, Object[] param);
	
	/**
	 * 查询所有订单信息
	 */
	public List<order1> findorder();
	
	/**
	 * 根据所给条件查询订单信息
	 * @param sql
	 * @param param
	 */
	public order1 findorder(String sql, String[] param);
}
