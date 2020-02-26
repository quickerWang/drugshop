/**

 * 开房界面的实现
 */

package express;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.security.cert.PKIXRevocationChecker.Option;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.ToIntBiFunction;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import dao.Impl.InventoryDaoImpl;
import dao.Impl.clientDaoImpl;
import dao.Impl.drugDaoImpl;
import dao.Impl.orderdaoimpl;
import dao.Impl.orderdetailDaoImpl;
import dao.Impl.shopDaoImpl;
import entity.*;
import service.*;


public class shopcar extends JFrame{
	JTextField field_3=new JTextField();      //余额文本框
	JTextField field_2=new JTextField();      //收额
	JTextField field_1=new JTextField();     //消费金额文本框
	int days;         //租用天数
	
	 JButton button=new JButton();         //结账按钮

	 
	 String[] s={ "药品编号", "名称", "规格", "种类",   //房间表格的列名
			"价格", "厂家编号","库存"};
	 String[] str= {"药品编号","药品件数","金额","优惠"};     //客人信息表格的列名
	 
	 JLabel topLabel;            //头顶图片
	 JSplitPane splitpane=new JSplitPane();     //中间分割面板
	 JPanel leftPane;               // 中间分割面板左边表格
	 JPanel rightPane;               //中间分割面板右边表格
	 JPanel bottomPane;              //底部面板
	 DefaultTableModel lefttablemodel;         //左面表格面板
	 DefaultTableModel righttablemodel;        //右面表格面板
	 Vector<String> foodcolumnNames=new Vector<String>();     //记录房间表格列名
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //记录房间表格信息
	 JButton button_3=new JButton();       //签单
	 
	 ArrayList<drug> a_drug=new ArrayList<drug>();    //保存房间信息的集合
	 ArrayList<order_detail> a_consumer=new ArrayList<order_detail>();     //保存客户信息的集合
	 Vector<String> peoplecolumnNames=new Vector<String>();        //客人列名
	 Vector<Vector<Object>> peoplevalues=new Vector<Vector<Object>>();  //客人值
	 JTable lefttabel;
	 JTextField namefield=new JTextField();      //药品编号文本框
	 JTextField numberfield=new JTextField();      //药品数量文本框
	 JTextField idfield=new JTextField();   //客户会员卡号
	
	
	 JTable righttabel;            //右面表格
	 /**

	  * 界面的基本属性设置
	  */
     public shopcar() {
    	 setSize(880,700);    //设置页面大小   
    	 setLocationRelativeTo(null);    //设置页面居中
    	 setResizable(false);     //设置页面无法调节答谢哦
    	 setLayout(new BorderLayout());   //设置页面布局为边界布局
    
    	 getContentPane().add(getTopLabel(),BorderLayout.NORTH);   //在页面中加入面板放在北方          
    	 getContentPane().add(getSplitPane(),BorderLayout.CENTER);  //在页面中加入面板放在中间
    	 getContentPane().add(getBottomPanel(),BorderLayout.SOUTH);  //在页面中加入面板放在南方
    	 
     }

     /**

	  * 得到底部的面板
	  */
     
	private JPanel getBottomPanel(){
		// TODO Auto-generated method stub
		
		bottomPane=new JPanel();       //得到面板的对象
		bottomPane.setLayout(new BorderLayout());    //设置该面板的布局为边界布局
		JPanel uppanel=new JPanel();    //得到面板
		bottomPane.add(uppanel,BorderLayout.NORTH);   //将该面板放在底部面板的北部
		uppanel.setLayout(new GridLayout(1, 4));   //设置该面板的布局为网格布局
		
		uppanel.add(namefield);        //名字文本框加入面板
		JLabel table_number=new JLabel("药品编号");  //姓名标签
		uppanel.add(table_number);   //姓名标签加入该面板
		
		  
		uppanel.add(numberfield);    //性别文本框加入面板
		JLabel name=new JLabel("药品数量"); //性别标签
		uppanel.add(name);      //性别标签加入该面板
		
	
		uppanel.add(idfield);   //身份证号文本框加入面板
		JLabel number=new JLabel("会员卡号"); //身份证号标签
		uppanel.add(number);   //身份证号标签加入该面板
		
		
		JPanel downpanel=new JPanel();   //得到面板
		downpanel.setLayout(new GridLayout(1,3));    //设置该面板的布局为网格布局
		bottomPane.add(downpanel,BorderLayout.SOUTH);    //将该面板加到底部面板的中间
		
		
		downpanel.add(get_calculate());    //将结账按钮加入到lefpanel中
		downpanel.add(start_paper());  //将leftpanel面板加入到downpanel中
		
		JPanel centerpanel=new JPanel();    //得到面板centerpanel
		centerpanel.setLayout(null);    //设置centerpanel布局为绝对布局
		centerpanel.add(start_paper());   //将加人按钮加入centerpanel
		
		Login.label_time_1.setBounds(100,25,250,20);   //设置label_time_1的大小位置
		Login.label_time_1.setFont(new Font("华文新魏",Font.BOLD, 18));   //设置label字体
		
	
		Login.label_time_2.setBounds(100,50,250,20);  //设置label_time_2的大小位置
		Login.label_time_2.setFont(new Font("华文新魏",Font.BOLD, 18));  //设置label字体
		
		JLabel label_user=new JLabel(Login.user);   //label_user文本为Login.user
		label_user.setBounds(100,75,250,20);    //设置label_user的大小和位置
		label_user.setFont(new Font("华文新魏",Font.BOLD, 18));   //设置label字体
		
		
		JPanel rightpanel=new JPanel();    //得到面板rightpanel
		rightpanel.add(Login.label_time_1);   //Login.label_time_1加入到rightpanel中
		rightpanel.add(Login.label_time_2);   //Login.label_time_2加入到rightpanel中
		rightpanel.add(label_user);       //label_user加入rightpanel
		rightpanel.setLayout(null);   //设置rightpanel布局为绝对布局
		downpanel.add(rightpanel);   //rightpanel加入到downpanel中
		return bottomPane;
	}
//----------------------------------------------------------------
	private JButton get_calculate(){         //结账
		button.setText("结账");
        Random random = new Random();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//生成订单号
					orderdetailDaoImpl oi =new orderdetailDaoImpl();
					orderdaoimpl odi =new orderdaoimpl();
					clientDaoImpl cd = new clientDaoImpl ();
					int rio =0; 
					order1 od = null;
					do {
						rio = random.nextInt();
						String [] s3 =new String[1];
						s3[0] = String.valueOf(rio);
						od = odi.findorder("select * from order1 where id =?", s3);
					}while(od!=null||rio<=0);
					double sum =0 ; //应收金额
					//得到商店的信息
					shopDaoImpl sh = new shopDaoImpl();
					String sql1="select * from shop where id=?";
					String s1[] = {Login.shop_id};
					ArrayList<shop> shop1 =(ArrayList) sh.findshop(sql1,s1);
					
					InventoryDaoImpl in = new InventoryDaoImpl();
					drugDaoImpl dr = new drugDaoImpl();
					//存药品信息
					ArrayList<drug> drug1 = new ArrayList<>();
					//订单细则
					ArrayList<order_detail> od1 = new ArrayList<>();
					for(int i=0;i<righttablemodel.getRowCount();i++) {
						String drugid =(String) righttablemodel.getValueAt(i,0);
						String [] s2 = new String[1];
						s2[0] = drugid;
						ArrayList<drug> d1 =(ArrayList) dr.finddrug("select * from drug where id=?", s2);
						if(d1.isEmpty()) {
							throw new Exception(drugid+"号药品不存在");
						}
						String []s=new String[2];
						s[0] = Login.shop_id;
						s[1]=drugid;
						int number = Integer.valueOf((String)righttablemodel.getValueAt(i, 1));
						ArrayList<inventory> x = (ArrayList)in.findinventory("select * from inventory where shop_id=? and drug_id=?",s);
						if(x.get(0).getNum()<number) {
							throw new Exception(drugid+"号药品库存不足");
						}
						drug1.add(d1.get(0));
						double rp=(double)righttablemodel.getValueAt(i,2);
						double rd=Double.valueOf((String)righttablemodel.getValueAt(i,3));
						sum=sum+rp*rd;
						order_detail it = new order_detail();
						it.setDiscount(rd);
						it.setDrug_id(drugid);
						it.setNumber(number);
						int ri =0; 
						order_detail oda = null;
						do {
							ri = random.nextInt();
							String [] s3 =new String[1];
							s3[0] = String.valueOf(ri);
							oda = oi.findorder_detail("select * from order_detail where id =?", s3);
						}while(oda!=null||ri<=0);

						it.setId(String.valueOf(ri));
						it.setDiscount(rd);
						it.setDrug_id(drugid);
						it.setNumber(number);
						it.setPrice(rp);
						it.setOrder_id(String.valueOf(rio));
						od1.add(it);
					}
					System.out.println("门店名"+shop1.get(0).getName());
					System.out.println("总计件数："+righttablemodel.getRowCount());
					System.out.println("--------------------------------------");
					System.out.println("  药名       规格        工厂号       价格       件数        折扣");
					for(int i=0;i<righttablemodel.getRowCount();i++) {
						System.out.print(drug1.get(i).getName()+"  ");
						System.out.print(drug1.get(i).getNorms()+"  ");
						System.out.print(drug1.get(i).getFactory_id()+"  ");
						System.out.print(drug1.get(i).getPrice()+"  ");
						System.out.print(od1.get(i).getNumber()+"  ");
						System.out.print(od1.get(i).getDiscount()+"");
						System.out.print("\n");
					}
					System.out.println("------------------------------------\n");
					System.out.println("应收金额："+sum+"     找零：0\n");
					String u =null;
					if(idfield.getText().length()==0) {
						System.out.println("未使用会员卡");

					}else {
						String huiyuan = idfield.getText();
						String[] s4 =new String[1];
						s4[0] = huiyuan;
						client c = cd.findclient("select * from client where id=?",s4);
						if(c==null) {
							throw new Exception("没有这个会员");
						}else {
							u=c.getId();
							System.out.println("会员卡号："+c.getId()+"\n ");
							System.out.println("会员姓名："+c.getName()+"\n ");
							System.out.println("会员电话号码："+c.getTelephone()+"\n ");
						}
						
					}

					System.out.println("----------------------------------\n");
					System.out.println("销售单号："+rio+"\n");
					Date date = new Date();
					System.out.println("销售时间："+date.toString()+"\n");
					
					System.out.println("----------------------------------\n");
					System.out.println("门店地址:"+shop1.get(0).getAddress());
					System.out.println("联系方式"+shop1.get(0).getTelephone());
					System.out.println("----------------------------------\n");
					System.out.println("火热招聘各岗位人员，快来加入我们吧");
					InventoryDaoImpl ii =new InventoryDaoImpl();
					for(order_detail od2:od1) {
						Object[] o1 = new Object[6];
						o1[0] = od2.getId();
						o1[1] = od2.getOrder_id();
						o1[2] = od2.getDrug_id();
						o1[3] = od2.getNumber();
						o1[4] = od2.getDiscount();
						o1[5] = od2.getPrice();
						/**
						 * 新增
						 */
						Object[] o2 = new Object[3];
						o2[0] = od2.getNumber();
						o2[1] = Login.shop_id;
						o2[2] = od2.getDrug_id();
						oi.updateorder_detail("update inventory set num=num-? where shop_id=? and drug_id=?",o2);
					}
					Object[] o1 = new Object[6];
					o1[0] = String.valueOf(rio);
					java.text.SimpleDateFormat fmt1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
					o1[1] = fmt1.format(new Date());
					o1[2] = u;
					o1[3] = Login.shop_id;
					o1[4] = Login.user;
					o1[5] = sum;
					odi.updateorder("insert into order1 values(?,?,?,?,?,?)", o1);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		return button;
	}

	/**
	  * 得到顶部面板
	  */

	private JLabel getTopLabel() {
		//TODO Auto-generated method stub
		topLabel=new JLabel();//得到topLabel
		topLabel.setBounds(0,0,880,128);   //设置label的大小，位置
		topLabel.setIcon(new ImageIcon("image/4-0.JPG"));  //设置label的图片
		return topLabel;
	}
	
	public JPanel getLeftPane() {
		leftPane=new JPanel();   //得到leftPane
		leftPane.setLayout(new BorderLayout());   //设置leftpane布局为leftPane
		leftPane.add(new JLabel("药品"),BorderLayout.NORTH);   //将房间label加入到leftpane的北面
		for(int i=0;i<s.length;i++) {       //表格列名
			foodcolumnNames.add(s[i]);
		}
		SystemService sys = new SystemService();
		
		a_drug=(ArrayList)sys.getdrug();  
		
		InventoryDaoImpl in = new InventoryDaoImpl();
		
		Iterator it=a_drug.iterator();     //得到ArrayList的迭代器
		while(it.hasNext()) {      //循环读取drug数据到表格中
			Vector<Object> v = new Vector<>();
			drug r=(drug)it.next();   
			v.add(r.getId());    
			v.add(r.getName());  
			v.add(r.getNorms());  
			v.add(r.getType().toString());
			v.add(String.valueOf(r.getPrice()));               
			v.add(r.getFactory_id());
			String []s=new String[2];
			s[0] = Login.shop_id;
			s[1] = r.getId();
			ArrayList<inventory> i = (ArrayList)in.findinventory("select * from inventory where shop_id=? and drug_id=?",s);
			if(i.isEmpty())
				v.add(0);
			else
				v.add(i.get(0).getNum());   //库存           
			foodtablevalues.add(v);     //将该向量放到表格数据中
			
		}
		lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);  //利用foodcolumnNames为列名，foodtablevalues为表格数据建立表格模型
		lefttabel=new JTable(lefttablemodel);//利用该表格模型建立表格
		
		lefttabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {   //表格点击事件
				// TODO Auto-generated method stub
				int select=lefttabel.getSelectedRow();  //得到被选择的表格行
				
			}
		});
		JScrollPane scrollpane=new JScrollPane();    //得到scrollpane对象
		scrollpane.setViewportView(lefttabel);   //将lefttable加入scrollpane
		leftPane.add(scrollpane);   //scrollpane加入leftpane
		return leftPane;
	
	}
	/**
	  * 得到右侧面板
	  */
	public JPanel getRightPane() {
		rightPane=new JPanel();  //得到rightPane面板
		rightPane.setLayout(new BorderLayout());  //设置布局为边界布局
		rightPane.add(new JLabel("购物车"),BorderLayout.NORTH);  //客人标签加到rightpane的北面
		for(int i=0;i<str.length;i++) {  //载入客人列名
			peoplecolumnNames.add(str[i]);  
		}
	    
		righttablemodel=new DefaultTableModel(peoplevalues,peoplecolumnNames); //利用peoplecolumnNames和peoplevalues的都表格模板
		righttabel=new JTable(righttablemodel);  //利用该表格模板建立表格
	
		JScrollPane scrollpane=new JScrollPane();    //得到scrollpane对象
		scrollpane.setViewportView(righttabel);  //及将righttabel加入到scrollpane
		rightPane.add(scrollpane);   //scrollpane加入rightpane
		return rightPane;
	}
	public JSplitPane getSplitPane(){
		splitpane=new JSplitPane();   //新建分割面板
		splitpane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  //水平分割
		splitpane.setDividerLocation(700);// 设置面版默认的分割位置
		splitpane.setDividerSize(10);// 设置分割条的宽度
		splitpane.setLeftComponent(getLeftPane());   //左面面板
		splitpane.setRightComponent(getRightPane());//右面面板
		return splitpane;
	}  
  
    
	/**
	  * 得到加入购物车按钮
	  */
    public JButton start_paper() {
   	 JButton button_1=new JButton("加入购物车");  //加人按钮
   	 button_1.setBounds(50,30,80,60);   //设置按钮大小位置
   	 button_1.addActionListener(new ActionListener() {   //添加鼠标点击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				String input_name = namefield.getText().trim();// 获得输入内容
				String input_id=numberfield.getText().trim(); // 获得输入内容
				try{
					 if (input_name.length()==0||input_id.length()==0 ){    //输入内容不全
						 throw new Exception("信息不全，请重新输入");   //抛出异常
					 }
				 
					Vector<Object> v=new Vector<Object>	();   //向量
					v.add(input_name);     //加入姓名
					v.add(input_id);     //加入id
					for(int i=0;i<lefttablemodel.getRowCount();i++) {
						if(lefttablemodel.getValueAt(i, 0).equals(input_name)) {
							v.add(Double.valueOf((String)lefttablemodel.getValueAt(i,4))*Integer.valueOf(input_id));
							break;
						}
					}
					peoplevalues.add(v);    //该顾客加入到表格数据中
					righttablemodel.setDataVector(peoplevalues, peoplecolumnNames);  //利用peoplecolumnNames和peoplevalues建立表格模型
								
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, (ex.getMessage()));  //显示异常信息
				}finally {
					namefield.setText(null);  //姓名文本框置空
					numberfield.setText(null);   //药品数品数量本文框清空
					idfield.setText(null);  //会员卡号文本框置空
				}
			}
		});
   	 return button_1;
    }
}

