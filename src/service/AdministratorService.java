/**
 * 用户服务
 */

package service;
import java.util.ArrayList;
import java.util.List;

import dao.AdministratorDao;
import dao.clerkDao;
import dao.Impl.AdministratorDaoImpl;
import dao.Impl.clerkDaoImpl;
import entity.Administrator;
import entity.clerk;
import service.*;
public class AdministratorService{
	public static String sd = null;
	/**
	 * 确定能否登录
	 */
	public int login(String id, String password) {
	
		// TODO Auto-generated method stub
		int b=0;
    	
    	List<Administrator> list=new ArrayList<Administrator>();  //新建存储Administrator的集合
	    	AdministratorDao user=new AdministratorDaoImpl();  //得到AdministratorDao
			list=user.getAllAdministrator(); 
			for(Administrator u:list) {  //遍历集合
			
			String pass_d=u.getPassword();  //得到密码
			String id_d=u.getId();  //得到账号
			if(pass_d.equals(password)&&id_d.equals(id)) {//与想登录的用户信息相符
				return 1;
			}
		}
		
		List<clerk> list1=new ArrayList<clerk>();  //新建存储Administrator的集合
	    	clerkDao c=new clerkDaoImpl();  //得到AdministratorDao
			list1=c.findclerk(); 
			for(clerk u:list1) {  //遍历集合
			
			String pass_d=u.getPassword();  //得到密码
			String id_d=u.getId();  //得到账号
			if(pass_d.equals(password)&&id_d.equals(id)) {//与想登录的用户信息相符
				sd = u.getShop_id();
				return 2;
			}
		}
		return 0;
	}
	
}
