package dao;

import java.util.List;

import entity.order_detail;

public interface orderdaodetail {
	/**
	 * 更新会员信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateorder_detail(String sql, Object[] param);
	
	/**
	 * 查询所有会员信息
	 */
	public List<order_detail> findorder_detail();
	
	/**
	 * 根据所给条件查询会员信息
	 * @param sql
	 * @param param
	 */
	public order_detail findorder_detail(String sql, String[] param);
}
