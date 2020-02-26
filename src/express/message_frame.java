/**
 * 信息界面
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
	  
	    private JTabbedPane tabbedpane=new JTabbedPane(JTabbedPane.NORTH); //选项卡
	  
	    private JPanel  user_panel;  //用户信息面板
		SystemService system=new SystemService();
		/**
		 * 界面基本属性设置
		 */
		public message_frame() {
        	setTitle("信息查询");  //title
            setSize(500,500);  //大小
       	    setLocationRelativeTo(null);  //是否居中
       	    setResizable(false);  //能否调节
  //加入一系列的面板到选项卡中
       	tabbedpane.add("店员",get_clerk());
        tabbedpane.add("会员",get_client());
       	tabbedpane.add("药店",get_shop());
       	tabbedpane.add("药品",get_drug());
       	add(tabbedpane,BorderLayout.CENTER);
       	
        }
		/**

		 * 消费者面板
		 */
        private JPanel get_client() {
            JPanel consumer_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	name.add("会员号");
        	name.add("姓名");
        	name.add("积分");   //表格列名
        	name.add("电话号码");
        
   
        
        	 
        	ArrayList<client> client_list=new ArrayList<client>();
        
        	client_list=system.getclient();
        	for(int i=0;i<client_list.size();i++) {   //读取数据库信息到表格
        		Vector<Object> v=new Vector<Object>();
        		v.add(client_list.get(i).getId());
        		v.add(client_list.get(i).getName());
        		v.add(client_list.get(i).getPoint());
        		v.add(client_list.get(i).getTelephone());
        		value.add(v);
        	}
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //建立表格
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //scrolllpane加表格
			pane.setViewportView(table);
			consumer_panel.add(pane,BorderLayout.CENTER);   //scrollpane加入面板
        	return consumer_panel;
        }
        /**
		 * 药品面板
		 */
        private JPanel get_drug() {
            JPanel room_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>(); //表格列名
        	name.add("药品编号");
        	name.add("名称");
        	name.add("规格");
        	name.add("种类");
        	name.add("零售价");
        	name.add("厂家编号");
        	
        	ArrayList<drug> drug_list=new ArrayList<drug>();
            
        	drug_list=system.getdrug();
        	for(int i=0;i<drug_list.size();i++) {   //读取数据库信息到表格
        		Vector<Object> v=new Vector<Object>();
        		v.add(drug_list.get(i).getId());
        		v.add(drug_list.get(i).getName());
        		v.add(drug_list.get(i).getNorms());
        		v.add(drug_list.get(i).getType());
        		v.add(drug_list.get(i).getPrice());
        		v.add(drug_list.get(i).getFactory_id());
        		value.add(v);
        	}
        	
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //建立表格模板
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //建立scrollpane加入表格
			pane.setViewportView(table);
			room_panel.add(pane,BorderLayout.CENTER);  //scrollpane加入面板
        	return room_panel;
        }
        /**
		 * 药店面板
		 */
        private JPanel get_shop() {
            JPanel list_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();  //list列名
        	name.add("药店编号");
        	name.add("名称");
        	name.add("地址");
        	name.add("联系电话");
        	        	
        	ArrayList<shop> li_list=new ArrayList<shop>();
        	li_list=system.getshop();  //数据库信息读到表格
        	for(int i=0;i<li_list.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(li_list.get(i).getId());
        		v.add(li_list.get(i).getName());
        		v.add(li_list.get(i).getAddress());
        		v.add(li_list.get(i).getTelephone());
        		value.add(v);
        	}
        	
      
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //表格建立
			JScrollPane pane=new JScrollPane();  
			pane.setViewportView(table);
			list_panel.add(pane,BorderLayout.CENTER);
        	return list_panel;
        }
        /**
		 * 店员面板
		 */
        private JPanel get_clerk() {
        	user_panel=new JPanel();
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	
        	name.add("收银编号");  //表格列名
        	name.add("药店编号");
        	name.add("姓名");
        	
        
        	ArrayList<clerk> userlist=new ArrayList<clerk>();
        	userlist=system.getclerk();  //数据库信息读到表格
        	for(int i=0;i<userlist.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(userlist.get(i).getId());
        		v.add(userlist.get(i).getShop_id());
        		v.add(userlist.get(i).getName());
        		value.add(v);
        	}
        	
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //表格建立
			JScrollPane pane=new JScrollPane();
			pane.setViewportView(table);
			user_panel.add(pane,BorderLayout.CENTER);
        	return user_panel;
        }
        
       
}
