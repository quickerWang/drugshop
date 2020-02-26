/**
 * 操作数据库管理员表接口

 */
package dao;

import java.util.List;

import entity.Administrator;


public interface AdministratorDao {
	/**
	 * 查询所有管理员信息
	 */
	public abstract List<Administrator> getAllAdministrator();

	/**
	 * 更新管理员信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	public abstract int updateAdministrator(String sql, String[] param);

	/**
	 * 根据条件查询管理员信息
	 * @param sql
	 * @param param
	 */
	public abstract Administrator selectAdministrator(String sql, String[] param);

}
