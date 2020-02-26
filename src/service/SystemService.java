package service;

import java.util.ArrayList;
import java.util.List;

import dao.Impl.*;
import entity.*;


public class SystemService {
	
	/**
	 * 得到所有会员的信息
	 * @return
	 */
	public ArrayList<client> getclient() {
		// TODO Auto-generated method stub
		clientDaoImpl li=new clientDaoImpl();  
    	ArrayList<client> li_list=new ArrayList<client>();
    	li_list=(ArrayList)li.findclient();  //得到所有会员信息

		return li_list;
	}
	

	/**
	 * 得到所有药店的信息
	 * @return
	 */
	public ArrayList<shop> getshop() {
		// TODO Auto-generated method stub
		shopDaoImpl li=new shopDaoImpl();  
    	ArrayList<shop> li_list=new ArrayList<shop>();
    	li_list=(ArrayList)li.findshop();  //得到所有药店信息

		return li_list;
	}
	
	/**
	 * 得到所有店员的信息
	 * @return
	 */
	public ArrayList<clerk> getclerk() {
		// TODO Auto-generated method stub
		clerkDaoImpl li=new clerkDaoImpl();  
    	ArrayList<clerk> li_list=new ArrayList<clerk>();
    	li_list=(ArrayList)li.findclerk();  //得到所有店员信息

		return li_list;
	}
	
	/**
	 * 得到所有药的信息
	 * @return
	 */
	public ArrayList<drug> getdrug() {
		// TODO Auto-generated method stub
		drugDaoImpl li=new drugDaoImpl();  
    	ArrayList<drug> li_list=new ArrayList<drug>();
    	li_list=(ArrayList)li.finddrug();  //得到所有药店信息

		return li_list;
	}
	
	/**
	 * 删除会员
	 * @param s
	 * @return
	 */
	public boolean deleteuser(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from client where id=?";
		clientDaoImpl userdao=new clientDaoImpl();
		client u=userdao.findclient(sql,s);  //查找符合条件的用户信息
		if(u!=null) {  ///找到了这样的用户
			sql="delete from client where id=?";
			userdao.updateclient(sql,s);  //删除该用户信息
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 添加会员
	 */
	public boolean adduser(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from client where id=?";
		clientDaoImpl userdao=new clientDaoImpl();
		client u=userdao.findclient(sql,s);  //用户表中寻找符合条件的user信息
		if(u==null) {  //没有找到这样的信息
			sql="insert into client values(?,?,0,?)";
			userdao.updateclient(sql,s2);  //插入该用户信息
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}	
	}
	
	/**
	 * 添加库存
	 */
	public boolean addinventory(String[] s,Object[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from inventory where shop_id=? and drug_id=?";
		InventoryDaoImpl userdao=new InventoryDaoImpl();
		List<inventory> u=userdao.findinventory(sql,s);  //用户表中寻找符合条件的user信息
		if(u.isEmpty()) {  //没有找到这样的信息
			sql="insert into inventory values(?,?,?)";
			userdao.updateinventory(sql,s2);  //插入该用户信息
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}	
	}
	
	/**
	 * 更新库存
	 * @param s
	 * @return
	 */
	public boolean updateinventory(String[] s0,Object[] s) {
		// TODO Auto-generated method stub
		String sql="select * from inventory where shop_id=? and drug_id=?";
		InventoryDaoImpl userdao=new InventoryDaoImpl();
		List<inventory> u=userdao.findinventory(sql,s0);  //查找符合条件的用户信息
		if(u!=null) {  ///找到了这样的用户
			sql="update inventory set num=? where shop_id=? and drug_id=?";
			userdao.updateinventory(sql,s);  //删除该用户信息
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 删除店员
	 * @param s
	 * @return
	 */
	public boolean deleteclerk(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from clerk where id=?";
		clerkDaoImpl clerkdao=new clerkDaoImpl();
		clerk u=clerkdao.findclerk(sql,s);  //查找符合条件的用户信息
		if(u!=null) {  ///找到了这样的用户
			sql="delete from clerk where id=?";
			clerkdao.updateclerk(sql,s);  //删除该用户信息
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 添加店员
	 */
	public boolean addclerk(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from clerk where id=?";
		clerkDaoImpl clerkdao=new clerkDaoImpl();
		clerk u=clerkdao.findclerk(sql,s);  //用户表中寻找符合条件的user信息
		if(u==null) {  //没有找到这样的信息
			sql="insert into clerk values(?,?,?,?)";
			clerkdao.updateclerk(sql,s2);  //插入该用户信息
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}	
	}
	
	/**
	 * 删除药店
	 * @param s
	 * @return
	 */
	public boolean deleteshop(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from shop where id=?";
		shopDaoImpl shopdao=new shopDaoImpl();
		List<shop> u=shopdao.findshop(sql,s);  //查找符合条件的用户信息
		if(!u.isEmpty()) {  ///找到了这样的用户
			sql="delete from shop where id=?";
			shopdao.updateshop(sql,s);  //删除该用户信息
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 添加药店
	 */
	public boolean addshop(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from shop where id=?";
		shopDaoImpl shopdao=new shopDaoImpl();
		List<shop> u=shopdao.findshop(sql,s);  //用户表中寻找符合条件的user信息
		if(u.isEmpty()) {  //没有找到这样的信息
			sql="insert into shop values(?,?,?,?)";
			shopdao.updateshop(sql,s2);  //插入该用户信息
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}	
	}
	
	/**
	 * 删除药品
	 * @param s
	 * @return
	 */
	public boolean deletedrug(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from drug where id=?";
		drugDaoImpl drugdao=new drugDaoImpl();
		List<drug> u=drugdao.finddrug(sql,s);  //查找符合条件的用户信息
		if(!u.isEmpty()) {  ///找到了这样的用户
			sql="delete from drug where id=?";
			drugdao.updatedrug(sql,s);  //删除该用户信息
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 添加药品
	 */
	public boolean adddrug(String[] s,Object[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from drug where id=?";
		drugDaoImpl drugdao=new drugDaoImpl();
		List<drug> u=drugdao.finddrug(sql,s);  //用户表中寻找符合条件的user信息
		if(u.isEmpty()) {  //没有找到这样的信息
			sql="insert into drug values(?,?,?,?,?,?)";
			drugdao.updatedrug(sql,s2);  //插入该用户信息
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}	
	}
}
