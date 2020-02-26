/**

 * ���������ʵ��
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
	JTextField field_3=new JTextField();      //����ı���
	JTextField field_2=new JTextField();      //�ն�
	JTextField field_1=new JTextField();     //���ѽ���ı���
	int days;         //��������
	
	 JButton button=new JButton();         //���˰�ť

	 
	 String[] s={ "ҩƷ���", "����", "���", "����",   //�����������
			"�۸�", "���ұ��","���"};
	 String[] str= {"ҩƷ���","ҩƷ����","���","�Ż�"};     //������Ϣ��������
	 
	 JLabel topLabel;            //ͷ��ͼƬ
	 JSplitPane splitpane=new JSplitPane();     //�м�ָ����
	 JPanel leftPane;               // �м�ָ������߱��
	 JPanel rightPane;               //�м�ָ�����ұ߱��
	 JPanel bottomPane;              //�ײ����
	 DefaultTableModel lefttablemodel;         //���������
	 DefaultTableModel righttablemodel;        //���������
	 Vector<String> foodcolumnNames=new Vector<String>();     //��¼����������
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //��¼��������Ϣ
	 JButton button_3=new JButton();       //ǩ��
	 
	 ArrayList<drug> a_drug=new ArrayList<drug>();    //���淿����Ϣ�ļ���
	 ArrayList<order_detail> a_consumer=new ArrayList<order_detail>();     //����ͻ���Ϣ�ļ���
	 Vector<String> peoplecolumnNames=new Vector<String>();        //��������
	 Vector<Vector<Object>> peoplevalues=new Vector<Vector<Object>>();  //����ֵ
	 JTable lefttabel;
	 JTextField namefield=new JTextField();      //ҩƷ����ı���
	 JTextField numberfield=new JTextField();      //ҩƷ�����ı���
	 JTextField idfield=new JTextField();   //�ͻ���Ա����
	
	
	 JTable righttabel;            //������
	 /**

	  * ����Ļ�����������
	  */
     public shopcar() {
    	 setSize(880,700);    //����ҳ���С   
    	 setLocationRelativeTo(null);    //����ҳ�����
    	 setResizable(false);     //����ҳ���޷����ڴ�лŶ
    	 setLayout(new BorderLayout());   //����ҳ�沼��Ϊ�߽粼��
    
    	 getContentPane().add(getTopLabel(),BorderLayout.NORTH);   //��ҳ���м��������ڱ���          
    	 getContentPane().add(getSplitPane(),BorderLayout.CENTER);  //��ҳ���м����������м�
    	 getContentPane().add(getBottomPanel(),BorderLayout.SOUTH);  //��ҳ���м����������Ϸ�
    	 
     }

     /**

	  * �õ��ײ������
	  */
     
	private JPanel getBottomPanel(){
		// TODO Auto-generated method stub
		
		bottomPane=new JPanel();       //�õ����Ķ���
		bottomPane.setLayout(new BorderLayout());    //���ø����Ĳ���Ϊ�߽粼��
		JPanel uppanel=new JPanel();    //�õ����
		bottomPane.add(uppanel,BorderLayout.NORTH);   //���������ڵײ����ı���
		uppanel.setLayout(new GridLayout(1, 4));   //���ø����Ĳ���Ϊ���񲼾�
		
		uppanel.add(namefield);        //�����ı���������
		JLabel table_number=new JLabel("ҩƷ���");  //������ǩ
		uppanel.add(table_number);   //������ǩ��������
		
		  
		uppanel.add(numberfield);    //�Ա��ı���������
		JLabel name=new JLabel("ҩƷ����"); //�Ա��ǩ
		uppanel.add(name);      //�Ա��ǩ��������
		
	
		uppanel.add(idfield);   //���֤���ı���������
		JLabel number=new JLabel("��Ա����"); //���֤�ű�ǩ
		uppanel.add(number);   //���֤�ű�ǩ��������
		
		
		JPanel downpanel=new JPanel();   //�õ����
		downpanel.setLayout(new GridLayout(1,3));    //���ø����Ĳ���Ϊ���񲼾�
		bottomPane.add(downpanel,BorderLayout.SOUTH);    //�������ӵ��ײ������м�
		
		
		downpanel.add(get_calculate());    //�����˰�ť���뵽lefpanel��
		downpanel.add(start_paper());  //��leftpanel�����뵽downpanel��
		
		JPanel centerpanel=new JPanel();    //�õ����centerpanel
		centerpanel.setLayout(null);    //����centerpanel����Ϊ���Բ���
		centerpanel.add(start_paper());   //�����˰�ť����centerpanel
		
		Login.label_time_1.setBounds(100,25,250,20);   //����label_time_1�Ĵ�Сλ��
		Login.label_time_1.setFont(new Font("������κ",Font.BOLD, 18));   //����label����
		
	
		Login.label_time_2.setBounds(100,50,250,20);  //����label_time_2�Ĵ�Сλ��
		Login.label_time_2.setFont(new Font("������κ",Font.BOLD, 18));  //����label����
		
		JLabel label_user=new JLabel(Login.user);   //label_user�ı�ΪLogin.user
		label_user.setBounds(100,75,250,20);    //����label_user�Ĵ�С��λ��
		label_user.setFont(new Font("������κ",Font.BOLD, 18));   //����label����
		
		
		JPanel rightpanel=new JPanel();    //�õ����rightpanel
		rightpanel.add(Login.label_time_1);   //Login.label_time_1���뵽rightpanel��
		rightpanel.add(Login.label_time_2);   //Login.label_time_2���뵽rightpanel��
		rightpanel.add(label_user);       //label_user����rightpanel
		rightpanel.setLayout(null);   //����rightpanel����Ϊ���Բ���
		downpanel.add(rightpanel);   //rightpanel���뵽downpanel��
		return bottomPane;
	}
//----------------------------------------------------------------
	private JButton get_calculate(){         //����
		button.setText("����");
        Random random = new Random();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//���ɶ�����
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
					double sum =0 ; //Ӧ�ս��
					//�õ��̵����Ϣ
					shopDaoImpl sh = new shopDaoImpl();
					String sql1="select * from shop where id=?";
					String s1[] = {Login.shop_id};
					ArrayList<shop> shop1 =(ArrayList) sh.findshop(sql1,s1);
					
					InventoryDaoImpl in = new InventoryDaoImpl();
					drugDaoImpl dr = new drugDaoImpl();
					//��ҩƷ��Ϣ
					ArrayList<drug> drug1 = new ArrayList<>();
					//����ϸ��
					ArrayList<order_detail> od1 = new ArrayList<>();
					for(int i=0;i<righttablemodel.getRowCount();i++) {
						String drugid =(String) righttablemodel.getValueAt(i,0);
						String [] s2 = new String[1];
						s2[0] = drugid;
						ArrayList<drug> d1 =(ArrayList) dr.finddrug("select * from drug where id=?", s2);
						if(d1.isEmpty()) {
							throw new Exception(drugid+"��ҩƷ������");
						}
						String []s=new String[2];
						s[0] = Login.shop_id;
						s[1]=drugid;
						int number = Integer.valueOf((String)righttablemodel.getValueAt(i, 1));
						ArrayList<inventory> x = (ArrayList)in.findinventory("select * from inventory where shop_id=? and drug_id=?",s);
						if(x.get(0).getNum()<number) {
							throw new Exception(drugid+"��ҩƷ��治��");
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
					System.out.println("�ŵ���"+shop1.get(0).getName());
					System.out.println("�ܼƼ�����"+righttablemodel.getRowCount());
					System.out.println("--------------------------------------");
					System.out.println("  ҩ��       ���        ������       �۸�       ����        �ۿ�");
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
					System.out.println("Ӧ�ս�"+sum+"     ���㣺0\n");
					String u =null;
					if(idfield.getText().length()==0) {
						System.out.println("δʹ�û�Ա��");

					}else {
						String huiyuan = idfield.getText();
						String[] s4 =new String[1];
						s4[0] = huiyuan;
						client c = cd.findclient("select * from client where id=?",s4);
						if(c==null) {
							throw new Exception("û�������Ա");
						}else {
							u=c.getId();
							System.out.println("��Ա���ţ�"+c.getId()+"\n ");
							System.out.println("��Ա������"+c.getName()+"\n ");
							System.out.println("��Ա�绰���룺"+c.getTelephone()+"\n ");
						}
						
					}

					System.out.println("----------------------------------\n");
					System.out.println("���۵��ţ�"+rio+"\n");
					Date date = new Date();
					System.out.println("����ʱ�䣺"+date.toString()+"\n");
					
					System.out.println("----------------------------------\n");
					System.out.println("�ŵ��ַ:"+shop1.get(0).getAddress());
					System.out.println("��ϵ��ʽ"+shop1.get(0).getTelephone());
					System.out.println("----------------------------------\n");
					System.out.println("������Ƹ����λ��Ա�������������ǰ�");
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
						 * ����
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
	  * �õ��������
	  */

	private JLabel getTopLabel() {
		//TODO Auto-generated method stub
		topLabel=new JLabel();//�õ�topLabel
		topLabel.setBounds(0,0,880,128);   //����label�Ĵ�С��λ��
		topLabel.setIcon(new ImageIcon("image/4-0.JPG"));  //����label��ͼƬ
		return topLabel;
	}
	
	public JPanel getLeftPane() {
		leftPane=new JPanel();   //�õ�leftPane
		leftPane.setLayout(new BorderLayout());   //����leftpane����ΪleftPane
		leftPane.add(new JLabel("ҩƷ"),BorderLayout.NORTH);   //������label���뵽leftpane�ı���
		for(int i=0;i<s.length;i++) {       //�������
			foodcolumnNames.add(s[i]);
		}
		SystemService sys = new SystemService();
		
		a_drug=(ArrayList)sys.getdrug();  
		
		InventoryDaoImpl in = new InventoryDaoImpl();
		
		Iterator it=a_drug.iterator();     //�õ�ArrayList�ĵ�����
		while(it.hasNext()) {      //ѭ����ȡdrug���ݵ������
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
				v.add(i.get(0).getNum());   //���           
			foodtablevalues.add(v);     //���������ŵ����������
			
		}
		lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);  //����foodcolumnNamesΪ������foodtablevaluesΪ������ݽ������ģ��
		lefttabel=new JTable(lefttablemodel);//���øñ��ģ�ͽ������
		
		lefttabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {   //������¼�
				// TODO Auto-generated method stub
				int select=lefttabel.getSelectedRow();  //�õ���ѡ��ı����
				
			}
		});
		JScrollPane scrollpane=new JScrollPane();    //�õ�scrollpane����
		scrollpane.setViewportView(lefttabel);   //��lefttable����scrollpane
		leftPane.add(scrollpane);   //scrollpane����leftpane
		return leftPane;
	
	}
	/**
	  * �õ��Ҳ����
	  */
	public JPanel getRightPane() {
		rightPane=new JPanel();  //�õ�rightPane���
		rightPane.setLayout(new BorderLayout());  //���ò���Ϊ�߽粼��
		rightPane.add(new JLabel("���ﳵ"),BorderLayout.NORTH);  //���˱�ǩ�ӵ�rightpane�ı���
		for(int i=0;i<str.length;i++) {  //�����������
			peoplecolumnNames.add(str[i]);  
		}
	    
		righttablemodel=new DefaultTableModel(peoplevalues,peoplecolumnNames); //����peoplecolumnNames��peoplevalues�Ķ����ģ��
		righttabel=new JTable(righttablemodel);  //���øñ��ģ�彨�����
	
		JScrollPane scrollpane=new JScrollPane();    //�õ�scrollpane����
		scrollpane.setViewportView(righttabel);  //����righttabel���뵽scrollpane
		rightPane.add(scrollpane);   //scrollpane����rightpane
		return rightPane;
	}
	public JSplitPane getSplitPane(){
		splitpane=new JSplitPane();   //�½��ָ����
		splitpane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  //ˮƽ�ָ�
		splitpane.setDividerLocation(700);// �������Ĭ�ϵķָ�λ��
		splitpane.setDividerSize(10);// ���÷ָ����Ŀ��
		splitpane.setLeftComponent(getLeftPane());   //�������
		splitpane.setRightComponent(getRightPane());//�������
		return splitpane;
	}  
  
    
	/**
	  * �õ����빺�ﳵ��ť
	  */
    public JButton start_paper() {
   	 JButton button_1=new JButton("���빺�ﳵ");  //���˰�ť
   	 button_1.setBounds(50,30,80,60);   //���ð�ť��Сλ��
   	 button_1.addActionListener(new ActionListener() {   //���������¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				String input_name = namefield.getText().trim();// �����������
				String input_id=numberfield.getText().trim(); // �����������
				try{
					 if (input_name.length()==0||input_id.length()==0 ){    //�������ݲ�ȫ
						 throw new Exception("��Ϣ��ȫ������������");   //�׳��쳣
					 }
				 
					Vector<Object> v=new Vector<Object>	();   //����
					v.add(input_name);     //��������
					v.add(input_id);     //����id
					for(int i=0;i<lefttablemodel.getRowCount();i++) {
						if(lefttablemodel.getValueAt(i, 0).equals(input_name)) {
							v.add(Double.valueOf((String)lefttablemodel.getValueAt(i,4))*Integer.valueOf(input_id));
							break;
						}
					}
					peoplevalues.add(v);    //�ù˿ͼ��뵽���������
					righttablemodel.setDataVector(peoplevalues, peoplecolumnNames);  //����peoplecolumnNames��peoplevalues�������ģ��
								
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, (ex.getMessage()));  //��ʾ�쳣��Ϣ
				}finally {
					namefield.setText(null);  //�����ı����ÿ�
					numberfield.setText(null);   //ҩƷ��Ʒ�������Ŀ����
					idfield.setText(null);  //��Ա�����ı����ÿ�
				}
			}
		});
   	 return button_1;
    }
}

