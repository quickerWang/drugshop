package dao;

import java.util.List;

import entity.inventory;

public interface InventoryDao {
	/**
	 * 更新库存信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateinventory(String sql, Object[] param);
	
	/**
	 * 查询所有库存信息
	 */
	public List<inventory> findinventory();
	
	/**
	 * 根据所给条件查询库存信息
	 * @param sql
	 * @param param
	 */
	public List<inventory> findinventory(String sql, String[] param);
}
