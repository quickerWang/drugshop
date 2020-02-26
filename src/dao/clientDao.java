package dao;

import java.util.List;

import entity.client;

public interface clientDao {
	/**
	 * 更新会员信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateclient(String sql, Object[] param);
	
	/**
	 * 查询所有会员信息
	 */
	public List<client> findclient();
	
	/**
	 * 根据所给条件查询会员信息
	 * @param sql
	 * @param param
	 */
	public client findclient(String sql, String[] param);
}
