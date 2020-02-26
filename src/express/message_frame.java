/**
 * ��Ϣ����
 */

package express;

import entity.*;
import service.SystemService;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;




public class message_frame extends JFrame{
	  
	    private JTabbedPane tabbedpane=new JTabbedPane(JTabbedPane.NORTH); //ѡ�
	  
	    private JPanel  user_panel;  //�û���Ϣ���
		SystemService system=new SystemService();
		/**
		 * ���������������
		 */
		public message_frame() {
        	setTitle("��Ϣ��ѯ");  //title
            setSize(500,500);  //��С
       	    setLocationRelativeTo(null);  //�Ƿ����
       	    setResizable(false);  //�ܷ����
  //����һϵ�е���嵽ѡ���
       	tabbedpane.add("��Ա",get_clerk());
        tabbedpane.add("��Ա",get_client());
       	tabbedpane.add("ҩ��",get_shop());
       	tabbedpane.add("ҩƷ",get_drug());
       	add(tabbedpane,BorderLayout.CENTER);
       	
        }
		/**

		 * ���������
		 */
        private JPanel get_client() {
            JPanel consumer_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	name.add("��Ա��");
        	name.add("����");
        	name.add("����");   //�������
        	name.add("�绰����");
        
   
        
        	 
        	ArrayList<client> client_list=new ArrayList<client>();
        
        	client_list=system.getclient();
        	for(int i=0;i<client_list.size();i++) {   //��ȡ���ݿ���Ϣ�����
        		Vector<Object> v=new Vector<Object>();
        		v.add(client_list.get(i).getId());
        		v.add(client_list.get(i).getName());
        		v.add(client_list.get(i).getPoint());
        		v.add(client_list.get(i).getTelephone());
        		value.add(v);
        	}
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //�������
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //scrolllpane�ӱ��
			pane.setViewportView(table);
			consumer_panel.add(pane,BorderLayout.CENTER);   //scrollpane�������
        	return consumer_panel;
        }
        /**
		 * ҩƷ���
		 */
        private JPanel get_drug() {
            JPanel room_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>(); //�������
        	name.add("ҩƷ���");
        	name.add("����");
        	name.add("���");
        	name.add("����");
        	name.add("���ۼ�");
        	name.add("���ұ��");
        	
        	ArrayList<drug> drug_list=new ArrayList<drug>();
            
        	drug_list=system.getdrug();
        	for(int i=0;i<drug_list.size();i++) {   //��ȡ���ݿ���Ϣ�����
        		Vector<Object> v=new Vector<Object>();
        		v.add(drug_list.get(i).getId());
        		v.add(drug_list.get(i).getName());
        		v.add(drug_list.get(i).getNorms());
        		v.add(drug_list.get(i).getType());
        		v.add(drug_list.get(i).getPrice());
        		v.add(drug_list.get(i).getFactory_id());
        		value.add(v);
        	}
        	
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //�������ģ��
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //����scrollpane������
			pane.setViewportView(table);
			room_panel.add(pane,BorderLayout.CENTER);  //scrollpane�������
        	return room_panel;
        }
        /**
		 * ҩ�����
		 */
        private JPanel get_shop() {
            JPanel list_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();  //list����
        	name.add("ҩ����");
        	name.add("����");
        	name.add("��ַ");
        	name.add("��ϵ�绰");
        	        	
        	ArrayList<shop> li_list=new ArrayList<shop>();
        	li_list=system.getshop();  //���ݿ���Ϣ�������
        	for(int i=0;i<li_list.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(li_list.get(i).getId());
        		v.add(li_list.get(i).getName());
        		v.add(li_list.get(i).getAddress());
        		v.add(li_list.get(i).getTelephone());
        		value.add(v);
        	}
        	
      
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //�����
			JScrollPane pane=new JScrollPane();  
			pane.setViewportView(table);
			list_panel.add(pane,BorderLayout.CENTER);
        	return list_panel;
        }
        /**
		 * ��Ա���
		 */
        private JPanel get_clerk() {
        	user_panel=new JPanel();
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	
        	name.add("�������");  //�������
        	name.add("ҩ����");
        	name.add("����");
        	
        
        	ArrayList<clerk> userlist=new ArrayList<clerk>();
        	userlist=system.getclerk();  //���ݿ���Ϣ�������
        	for(int i=0;i<userlist.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(userlist.get(i).getId());
        		v.add(userlist.get(i).getShop_id());
        		v.add(userlist.get(i).getName());
        		value.add(v);
        	}
        	
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //�����
			JScrollPane pane=new JScrollPane();
			pane.setViewportView(table);
			user_panel.add(pane,BorderLayout.CENTER);
        	return user_panel;
        }
        
       
}
