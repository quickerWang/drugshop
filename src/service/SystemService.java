package service;

import java.util.ArrayList;
import java.util.List;

import dao.Impl.*;
import entity.*;


public class SystemService {
	
	/**
	 * �õ����л�Ա����Ϣ
	 * @return
	 */
	public ArrayList<client> getclient() {
		// TODO Auto-generated method stub
		clientDaoImpl li=new clientDaoImpl();  
    	ArrayList<client> li_list=new ArrayList<client>();
    	li_list=(ArrayList)li.findclient();  //�õ����л�Ա��Ϣ

		return li_list;
	}
	

	/**
	 * �õ�����ҩ�����Ϣ
	 * @return
	 */
	public ArrayList<shop> getshop() {
		// TODO Auto-generated method stub
		shopDaoImpl li=new shopDaoImpl();  
    	ArrayList<shop> li_list=new ArrayList<shop>();
    	li_list=(ArrayList)li.findshop();  //�õ�����ҩ����Ϣ

		return li_list;
	}
	
	/**
	 * �õ����е�Ա����Ϣ
	 * @return
	 */
	public ArrayList<clerk> getclerk() {
		// TODO Auto-generated method stub
		clerkDaoImpl li=new clerkDaoImpl();  
    	ArrayList<clerk> li_list=new ArrayList<clerk>();
    	li_list=(ArrayList)li.findclerk();  //�õ����е�Ա��Ϣ

		return li_list;
	}
	
	/**
	 * �õ�����ҩ����Ϣ
	 * @return
	 */
	public ArrayList<drug> getdrug() {
		// TODO Auto-generated method stub
		drugDaoImpl li=new drugDaoImpl();  
    	ArrayList<drug> li_list=new ArrayList<drug>();
    	li_list=(ArrayList)li.finddrug();  //�õ�����ҩ����Ϣ

		return li_list;
	}
	
	/**
	 * ɾ����Ա
	 * @param s
	 * @return
	 */
	public boolean deleteuser(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from client where id=?";
		clientDaoImpl userdao=new clientDaoImpl();
		client u=userdao.findclient(sql,s);  //���ҷ����������û���Ϣ
		if(u!=null) {  ///�ҵ����������û�
			sql="delete from client where id=?";
			userdao.updateclient(sql,s);  //ɾ�����û���Ϣ
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ��ӻ�Ա
	 */
	public boolean adduser(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from client where id=?";
		clientDaoImpl userdao=new clientDaoImpl();
		client u=userdao.findclient(sql,s);  //�û�����Ѱ�ҷ���������user��Ϣ
		if(u==null) {  //û���ҵ���������Ϣ
			sql="insert into client values(?,?,0,?)";
			userdao.updateclient(sql,s2);  //������û���Ϣ
			return true;  //����true
		}
		else {
			return false;  //����false
		}	
	}
	
	/**
	 * ��ӿ��
	 */
	public boolean addinventory(String[] s,Object[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from inventory where shop_id=? and drug_id=?";
		InventoryDaoImpl userdao=new InventoryDaoImpl();
		List<inventory> u=userdao.findinventory(sql,s);  //�û�����Ѱ�ҷ���������user��Ϣ
		if(u.isEmpty()) {  //û���ҵ���������Ϣ
			sql="insert into inventory values(?,?,?)";
			userdao.updateinventory(sql,s2);  //������û���Ϣ
			return true;  //����true
		}
		else {
			return false;  //����false
		}	
	}
	
	/**
	 * ���¿��
	 * @param s
	 * @return
	 */
	public boolean updateinventory(String[] s0,Object[] s) {
		// TODO Auto-generated method stub
		String sql="select * from inventory where shop_id=? and drug_id=?";
		InventoryDaoImpl userdao=new InventoryDaoImpl();
		List<inventory> u=userdao.findinventory(sql,s0);  //���ҷ����������û���Ϣ
		if(u!=null) {  ///�ҵ����������û�
			sql="update inventory set num=? where shop_id=? and drug_id=?";
			userdao.updateinventory(sql,s);  //ɾ�����û���Ϣ
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ɾ����Ա
	 * @param s
	 * @return
	 */
	public boolean deleteclerk(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from clerk where id=?";
		clerkDaoImpl clerkdao=new clerkDaoImpl();
		clerk u=clerkdao.findclerk(sql,s);  //���ҷ����������û���Ϣ
		if(u!=null) {  ///�ҵ����������û�
			sql="delete from clerk where id=?";
			clerkdao.updateclerk(sql,s);  //ɾ�����û���Ϣ
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ��ӵ�Ա
	 */
	public boolean addclerk(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from clerk where id=?";
		clerkDaoImpl clerkdao=new clerkDaoImpl();
		clerk u=clerkdao.findclerk(sql,s);  //�û�����Ѱ�ҷ���������user��Ϣ
		if(u==null) {  //û���ҵ���������Ϣ
			sql="insert into clerk values(?,?,?,?)";
			clerkdao.updateclerk(sql,s2);  //������û���Ϣ
			return true;  //����true
		}
		else {
			return false;  //����false
		}	
	}
	
	/**
	 * ɾ��ҩ��
	 * @param s
	 * @return
	 */
	public boolean deleteshop(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from shop where id=?";
		shopDaoImpl shopdao=new shopDaoImpl();
		List<shop> u=shopdao.findshop(sql,s);  //���ҷ����������û���Ϣ
		if(!u.isEmpty()) {  ///�ҵ����������û�
			sql="delete from shop where id=?";
			shopdao.updateshop(sql,s);  //ɾ�����û���Ϣ
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ���ҩ��
	 */
	public boolean addshop(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from shop where id=?";
		shopDaoImpl shopdao=new shopDaoImpl();
		List<shop> u=shopdao.findshop(sql,s);  //�û�����Ѱ�ҷ���������user��Ϣ
		if(u.isEmpty()) {  //û���ҵ���������Ϣ
			sql="insert into shop values(?,?,?,?)";
			shopdao.updateshop(sql,s2);  //������û���Ϣ
			return true;  //����true
		}
		else {
			return false;  //����false
		}	
	}
	
	/**
	 * ɾ��ҩƷ
	 * @param s
	 * @return
	 */
	public boolean deletedrug(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from drug where id=?";
		drugDaoImpl drugdao=new drugDaoImpl();
		List<drug> u=drugdao.finddrug(sql,s);  //���ҷ����������û���Ϣ
		if(!u.isEmpty()) {  ///�ҵ����������û�
			sql="delete from drug where id=?";
			drugdao.updatedrug(sql,s);  //ɾ�����û���Ϣ
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ���ҩƷ
	 */
	public boolean adddrug(String[] s,Object[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from drug where id=?";
		drugDaoImpl drugdao=new drugDaoImpl();
		List<drug> u=drugdao.finddrug(sql,s);  //�û�����Ѱ�ҷ���������user��Ϣ
		if(u.isEmpty()) {  //û���ҵ���������Ϣ
			sql="insert into drug values(?,?,?,?,?,?)";
			drugdao.updatedrug(sql,s2);  //������û���Ϣ
			return true;  //����true
		}
		else {
			return false;  //����false
		}	
	}
}
