package dao;

import java.util.List;

import entity.shop;

public interface shopDao {
	/**
	 * 更新药店信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateshop(String sql, Object[] param);
	
	/**
	 * 查询所有药店信息
	 */
	public List<shop> findshop();
	
	/**
	 * 根据所给条件查询药店信息
	 * @param sql
	 * @param param
	 */
	public List<shop> findshop(String sql, String[] param);
}
