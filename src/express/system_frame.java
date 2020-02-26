/**
 * 信息更改界面
 */
package express;

import entity.*;
import service.*;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

public class system_frame extends JFrame{         //更改信息界面
	    private JTabbedPane tabbedpane=new JTabbedPane(JTabbedPane.NORTH);    //选项卡组件
	  
	    private JPanel  user_panel;      //用户面板
	    int id;       //客户身份证
	    int name;        //姓名
	    SystemService system=new SystemService();
	    /**
	     * 信息更改界面基本属性设置
	     */
	    public system_frame() {
        	setTitle("Message Change");     //界面title
        	setSize(300,300);           //界面大小
       	    setLocationRelativeTo(null);   //界面居中
       	    setResizable(false);       //界面不可调节大小
     
       	 tabbedpane.add("会员",get_client());
       	 tabbedpane.add("药品",get_drug());
       	 tabbedpane.add("药店",get_shop());
       	 tabbedpane.add("员工",get_clerk());
       	 tabbedpane.add("库存",get_inventory());
       	add(tabbedpane,BorderLayout.CENTER);     //选项卡加入界面
       	
        }
	    
	    /**
         * 库存管理面板
         * @return
         */
        private JPanel get_inventory() {       //用户面板
        	user_panel=new JPanel();
        	user_panel.setLayout(null);
        	JLabel label_id=new JLabel("药店编号");
        	label_id.setBounds(50,50,70,20);
        	JTextField field_id=new JTextField();
        
        	field_id.setBounds(120,50,100,20);
        	user_panel.add(label_id);
        	user_panel.add(field_id);
        	JLabel label_ps=new JLabel("药品编号");
        	label_ps.setBounds(45,80,70,20);
        	JTextField field_ps=new JTextField();
        
        	field_ps .setBounds(120,80,100,20);
        	user_panel.add(label_ps);
        	user_panel.add(field_ps);
        	
        	JLabel label_new=new JLabel("库存量");
        	label_new.setBounds(50,110,70,20);
        	JTextField field_new=new JTextField();
        	
        	field_new.setBounds(120,110,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
        	
        	field_new.setBounds(120,110,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
        	
        	JButton button_add=new JButton("Add");
        	button_add.setBounds(105,165,80,30);
        	user_panel.add(button_add);
        	JButton button_delete=new JButton("Update");
        	button_delete.setBounds(200,165,80,30);
        	user_panel.add(button_delete);
        	button_delete.addActionListener(new ActionListener() {        //更新按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s3=field_new.getText();
					if(s1.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[2];
					s[0]=s1;
					s[1]=s2;
					
					Object[] o = new Object[3];
					o[0] = Integer.valueOf(s3);
					o[1]=s1;
					o[2]=s2;
					boolean u=system.updateinventory(s,o);
					if(u==true) {
						JOptionPane.showMessageDialog(null, "更新成功");
					}else {
						throw new Exception("错误");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
					}
				}
			});
        	
        	button_add.addActionListener(new ActionListener() {       //添加按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s4=field_new.getText();
					if(s1.length()==0||s2.length()==0||s4.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[2];
					s[0]=s1;
					s[1]=s2;
					Object[] s3=new Object[3];
					s3[0]=s1;
					s3[1]=s2;
					s3[2]=Integer.valueOf(s4);
					
					boolean u=system.addinventory(s, s3);
						if(u==true) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					else {
						throw new Exception("该账号已存在");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
					}
				}
			});
        	return user_panel;
        }
        
	    
	    
	    /**
         * 药品管理面板
         * @return
         */
        private JPanel get_drug() {       
        	user_panel=new JPanel();
        	user_panel.setLayout(null);
        	
        	JLabel label_id=new JLabel("编号");
        	label_id.setBounds(20,30,40,20);
        	JTextField field_id=new JTextField();
        	field_id.setBounds(60,30,60,20);
        	user_panel.add(label_id);
        	user_panel.add(field_id);
        	
        	JLabel label_ps=new JLabel("名称");
        	label_ps.setBounds(20,60,40,20);
        	JTextField field_ps=new JTextField();
        	field_ps .setBounds(60,60,60,20);
        	user_panel.add(label_ps);
        	user_panel.add(field_ps);
        	
        	JLabel label_new=new JLabel("规格");
        	label_new.setBounds(20,90,40,20);
        	JTextField field_new=new JTextField();
        	field_new.setBounds(60,90,60,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
    
        	JLabel label_tel=new JLabel("种类");
        	label_tel.setBounds(130,30,40,20);
        	JTextField field_tel=new JTextField();
        	field_tel.setBounds(170,30,60,20);
        	user_panel.add(label_tel);
        	user_panel.add(field_tel);
        	
        	JLabel label_price=new JLabel("售价");
        	label_price.setBounds(130,60,40,20);
        	JTextField field_price=new JTextField();
        	field_price.setBounds(170,60,60,20);
        	user_panel.add(label_price);
        	user_panel.add(field_price);
    
        	JLabel label_fac=new JLabel("工厂");
        	label_fac.setBounds(130,90,40,20);
        	JTextField field_fac=new JTextField();
        	field_fac.setBounds(170,90,60,20);
        	user_panel.add(label_fac);
        	user_panel.add(field_fac);
        	
        	JButton button_add=new JButton("Add");
        	button_add.setBounds(105,165,80,30);
        	user_panel.add(button_add);
        	JButton button_delete=new JButton("Delete");
        	button_delete.setBounds(200,165,80,30);
        	user_panel.add(button_delete);
        	button_delete.addActionListener(new ActionListener() {        //删除按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					if(s1.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					
					boolean u=system.deletedrug(s);
					if(u==true) {
						JOptionPane.showMessageDialog(null, "删除成功");
					}else {
						throw new Exception("错误");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
					}
				}
			});
        	
        	button_add.addActionListener(new ActionListener() {       //添加按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s3=field_new.getText();
					String s4=field_tel.getText();
					String s5=field_price.getText();
					String s6=field_fac.getText();
					int num=0;
					if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0||s6.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					Object[] s_=new Object[6];
					s_[0]=s1;
					s_[1]=s2;
					s_[2]=s3;
					s_[3]=s4;
					double x=Double.valueOf(s5);
					s_[4]=(Object)x;
			
					s_[5]=s6;

					if(!s4.equals("CDrug")&&!s4.equals("WDrug")) {
						throw new Exception("药品种类只能是CDrug和WDrug");
					}
					boolean u=system.adddrug(s, s_);
						if(u==true) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					else {
						throw new Exception("该商店已存在");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
						field_fac.setText(null);
						field_tel.setText(null);
						field_price.setText(null);
					}
				}
			});
        	return user_panel;
        }
	    
	    
        /**
	     * 用户面板
	     */
        private JPanel get_client() {       //用户面板
        	user_panel=new JPanel();
        	user_panel.setLayout(null);
        	JLabel label_id=new JLabel("会员卡号");
        	label_id.setBounds(50,50,70,20);
        	JTextField field_id=new JTextField();
        
        	field_id.setBounds(120,50,100,20);
        	user_panel.add(label_id);
        	user_panel.add(field_id);
        	JLabel label_ps=new JLabel("姓名");
        	label_ps.setBounds(45,80,70,20);
        	JTextField field_ps=new JTextField();
        
        	field_ps .setBounds(120,80,100,20);
        	user_panel.add(label_ps);
        	user_panel.add(field_ps);
        	JLabel label_new=new JLabel("telephone");
        	label_new.setBounds(25,110,90,20);
        	JTextField field_new=new JTextField();
        	
        	field_new.setBounds(120,110,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
        	JButton button_add=new JButton("Add");
        	button_add.setBounds(105,165,80,30);
        	user_panel.add(button_add);
        	JButton button_delete=new JButton("Delete");
        	button_delete.setBounds(200,165,80,30);
        	user_panel.add(button_delete);
        	button_delete.addActionListener(new ActionListener() {        //删除按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					if(s1.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					
					boolean u=system.deleteuser(s);
					if(u==true) {
						JOptionPane.showMessageDialog(null, "删除成功");
					}else {
						throw new Exception("错误");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
					}
				}
			});
        	
        	button_add.addActionListener(new ActionListener() {       //添加按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s4=field_new.getText();
					if(s1.length()==0||s2.length()==0||s4.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					String[] s3=new String[3];
					s3[0]=s1;
					s3[1]=s2;
					s3[2]=s4;
					boolean u=system.adduser(s, s3);
						if(u==true) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					else {
						throw new Exception("该账号已存在");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
					}
				}
			});
        	return user_panel;
        }
        
        /**
         * 店员管理面板
         * @return
         */
        private JPanel get_clerk() {       //用户面板
        	user_panel=new JPanel();
        	user_panel.setLayout(null);
        	JLabel label_id=new JLabel("收银编号");
        	label_id.setBounds(50,50,70,20);
        	JTextField field_id=new JTextField();
        
        	field_id.setBounds(120,50,100,20);
        	user_panel.add(label_id);
        	user_panel.add(field_id);
        	JLabel label_ps=new JLabel("药店编号");
        	label_ps.setBounds(45,80,70,20);
        	JTextField field_ps=new JTextField();
        
        	field_ps .setBounds(120,80,100,20);
        	user_panel.add(label_ps);
        	user_panel.add(field_ps);
        	
        	JLabel label_new=new JLabel("姓名");
        	label_new.setBounds(50,110,70,20);
        	JTextField field_new=new JTextField();
        	
        	field_new.setBounds(120,110,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
        	
        	field_new.setBounds(120,110,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
        	
        	JButton button_add=new JButton("Add");
        	button_add.setBounds(105,165,80,30);
        	user_panel.add(button_add);
        	JButton button_delete=new JButton("Delete");
        	button_delete.setBounds(200,165,80,30);
        	user_panel.add(button_delete);
        	button_delete.addActionListener(new ActionListener() {        //删除按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					if(s1.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					
					boolean u=system.deleteclerk(s);
					if(u==true) {
						JOptionPane.showMessageDialog(null, "删除成功");
					}else {
						throw new Exception("错误");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
					}
				}
			});
        	
        	button_add.addActionListener(new ActionListener() {       //添加按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s4=field_new.getText();
					if(s1.length()==0||s2.length()==0||s4.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					String[] s3=new String[4];
					s3[0]=s1;
					s3[1]=s2;
					s3[2]=s4;
					s3[3]=s1;
					
					boolean u=system.addclerk(s, s3);
						if(u==true) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					else {
						throw new Exception("该账号已存在");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
					}
				}
			});
        	return user_panel;
        }
        
        /**
         * 药店管理面板
         * @return
         */
        private JPanel get_shop() {       //用户面板
        	user_panel=new JPanel();
        	user_panel.setLayout(null);
        	JLabel label_id=new JLabel("编号");
        	label_id.setBounds(50,30,70,20);
        	JTextField field_id=new JTextField();
        	field_id.setBounds(120,30,100,20);
        	user_panel.add(label_id);
        	user_panel.add(field_id);
        	
        	JLabel label_ps=new JLabel("名称");
        	label_ps.setBounds(45,60,70,20);
        	JTextField field_ps=new JTextField();
        	field_ps .setBounds(120,60,100,20);
        	user_panel.add(label_ps);
        	user_panel.add(field_ps);
        	
        	JLabel label_new=new JLabel("地址");
        	label_new.setBounds(50,90,70,20);
        	JTextField field_new=new JTextField();
        	field_new.setBounds(120,90,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
    
        	
        	JLabel label_tel=new JLabel("电话");
        	label_tel.setBounds(50,120,70,20);
        	JTextField field_tel=new JTextField();
        	field_tel.setBounds(120,120,100,20);
        	user_panel.add(label_tel);
        	user_panel.add(field_tel);
    
        	
        	JButton button_add=new JButton("Add");
        	button_add.setBounds(105,165,80,30);
        	user_panel.add(button_add);
        	JButton button_delete=new JButton("Delete");
        	button_delete.setBounds(200,165,80,30);
        	user_panel.add(button_delete);
        	button_delete.addActionListener(new ActionListener() {        //删除按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					if(s1.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					
					boolean u=system.deleteshop(s);
					if(u==true) {
						JOptionPane.showMessageDialog(null, "删除成功");
					}else {
						throw new Exception("错误");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
					}
				}
			});
        	
        	button_add.addActionListener(new ActionListener() {       //添加按钮响应
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s4=field_new.getText();
					String s5=field_tel.getText();
					if(s1.length()==0||s2.length()==0||s4.length()==0||s5.length()==0) {
						throw new Exception("请输入");
					}
					String[] s=new String[1];
					s[0]=s1;
					String[] s3=new String[4];
					s3[0]=s1;
					s3[1]=s2;
					s3[2]=s4;
					s3[3]=s5;
					
					boolean u=system.addshop(s, s3);
						if(u==true) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					else {
						throw new Exception("该商店已存在");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
					}
				}
			});
        	return user_panel;
        }
}
