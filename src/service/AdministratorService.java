/**
 * �û�����
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
	 * ȷ���ܷ��¼
	 */
	public int login(String id, String password) {
	
		// TODO Auto-generated method stub
		int b=0;
    	
    	List<Administrator> list=new ArrayList<Administrator>();  //�½��洢Administrator�ļ���
	    	AdministratorDao user=new AdministratorDaoImpl();  //�õ�AdministratorDao
			list=user.getAllAdministrator(); 
			for(Administrator u:list) {  //��������
			
			String pass_d=u.getPassword();  //�õ�����
			String id_d=u.getId();  //�õ��˺�
			if(pass_d.equals(password)&&id_d.equals(id)) {//�����¼���û���Ϣ���
				return 1;
			}
		}
		
		List<clerk> list1=new ArrayList<clerk>();  //�½��洢Administrator�ļ���
	    	clerkDao c=new clerkDaoImpl();  //�õ�AdministratorDao
			list1=c.findclerk(); 
			for(clerk u:list1) {  //��������
			
			String pass_d=u.getPassword();  //�õ�����
			String id_d=u.getId();  //�õ��˺�
			if(pass_d.equals(password)&&id_d.equals(id)) {//�����¼���û���Ϣ���
				sd = u.getShop_id();
				return 2;
			}
		}
		return 0;
	}
	
}
