package dao;

import java.util.List;

import entity.clerk;

public interface clerkDao {
	/**
	 * 更新药品信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateclerk(String sql, Object[] param);
	
	/**
	 * 查询所有药品信息
	 */
	public List<clerk> findclerk();
	
	/**
	 * 根据所给条件查询药品信息
	 * @param sql
	 * @param param
	 */
	public clerk findclerk(String sql, String[] param);
}
