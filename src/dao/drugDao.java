package dao;

import java.util.List;

import entity.drug;

public interface drugDao {
	/**
	 * 更新药品信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updatedrug(String sql, Object[] param);
	
	/**
	 * 查询所有药品信息
	 * @return list<drug>
	 */
	public List<drug> finddrug();
	
	/**
	 * 根据所给条件查询药品信息
	 * @param sql
	 * @param param
	 * @return list<drug>
	 */
	public List<drug> finddrug(String sql, String[] param);
}
