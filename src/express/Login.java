/*
 * 登录界面

 */

package express;



import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import entity.*;
import service.AdministratorService;

import javax.swing.*;

public class Login extends JFrame{
	public static JLabel label_time_1=new JLabel();         //显示时间年月日
	public static JLabel label_time_2=new JLabel();         //显示时间时分秒
	public static String user;              //正在使用系统的用户名
	public static String shop_id;      //使用系统的用户所在店
	public static String time_1;        //时间年月日
	public static String time_2;        //时间时分秒   
	private int width=384;           //登陆窗口宽
    private int height=260;          //登陆窗口高
    
    private String name;              //账号
    private JTextField field;          //账号框
    private JPasswordField passwordfield;     //密码框
    private  String password;       //密码
    private JButton loginbutton;    //登陆按钮
    private mainFrame frame;          //系统服务主页面，管理员登陆成功后出现
    private shopcar frame1;          //购物车主页面，用户登陆成功后出现
	
    /**
     * 登录界面基本属性设置
     */
    
    public Login()
    { 
		Calendar c = Calendar.getInstance();        //得到系统时间
		int year=c.get(Calendar.YEAR);              //年
		int month=c.get(Calendar.MONTH);              //月
		month++;
		int day=c.get(Calendar.DATE);            //日
		int hour=c.get(Calendar.HOUR);            //时
		int minute=c.get(Calendar.MINUTE);         //分
		int second=c.get(Calendar.SECOND);         //秒
		time_1=String.valueOf(year)+"年"+String.valueOf(month)+"月"+String.valueOf(day)+"日";   //时间字符串
		time_2=String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);    //时间字符串
		setSize(width,height);  //设置窗口尺寸
		setLocationRelativeTo(null);       //设置窗口在屏幕中间
		setLayout(null);         //没有布局，绝对布局
    	
    	this.setTitle("登陆");   //窗口标题    
        setResizable(false);     //不可调节窗口大小
    	LoginPanel panel=new LoginPanel();   //创建面板
    	panel.setLayout(null);      //面板绝对布局

        panel.add(getPasswordField(),null);    //密码框加入面板
        panel.add(getTextField(),null);       //账号框加入面板
        panel.add(getExitButton(),null);    //退出按钮加入面板
        panel.add(getLoginButton(),null);    //登陆按钮加入面板
        
        setContentPane(panel);    //设置该面板为主面板
        
    }
    /**

     * 20180715

     */
	public JPasswordField getPasswordField(){
		passwordfield=new JPasswordField();  //得到密码框
		passwordfield.setBounds(160, 140, 100, 20);   //设置密码框的大小，位置
        addKeyListener(new KeyListener() {   //设置密码框事件
			
			@Override
			public void keyTyped(KeyEvent e) {    //按下按键时
				// TODO Auto-generated method stub
				int keycode=e.getKeyCode();   //得到按下按键的值
				if(keycode==KeyEvent.VK_ENTER)  //如果是回车
				{
					loginbutton.doClick();  //执行登录按钮的点击事件
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {  //按钮松开时
				// TODO Auto-generated method stub
			}    
			
			@Override
			public void keyPressed(KeyEvent e) {  //按钮按下时
				// TODO Auto-generated method stub	
			}
		});
		return passwordfield;
	}
	/**

	 * 20180715
*/
	public JTextField getTextField() {
		field=new JTextField();  //得到文本框
		field.setBounds(160, 110, 100,20);  //设置文本框的大小，位置

		return field;
	}
	/**

	 * 20180715

	 */
	public JButton getExitButton() {
		JButton button=new JButton("Exit");   //得到文本为Exit的按钮
		button.setBounds(220, 180, 64, 20);   //设置按钮的大小，位置
		button.setIcon(new ImageIcon("image/1-2.png"));  //设置按钮的图片
		button.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);   //退出系统
			}
		});
		return button;
	}
	/**

	 * 20180715

	 */
	public JButton getLoginButton() {
		loginbutton=new JButton();    //得到按钮
        loginbutton.setText("login");  //设置按钮文本为login
        loginbutton.setBounds(120, 180, 64, 20);   //设置按钮大小，位置
        loginbutton.setIcon(new ImageIcon("image/1-3.png"));  //设置按钮图片
        loginbutton.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name=field.getText();   //得到账号框文本
				user=name;
				password=new String(passwordfield.getPassword()); //得到密码框文本
				AdministratorService use=new AdministratorService();  //得到用户服务对象
				int b = use.login(name,password);  //调用login函数
				if(b==1) {  
				    user=name;
					frame=new mainFrame();   //新建主界面对象
					frame.setVisible(true);  //主界面可见
					setVisible(false);  //登录界面不可见
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);   //设置退出方式
				}
				else if(b==2) {
					user=name;
					shop_id = AdministratorService.sd;
					frame1=new shopcar();   //新建主界面对象
					frame1.setVisible(true);  //主界面可见
					setVisible(false);  //登录界面不可见
					frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);   //设置退出方式
				}
				else{
					JOptionPane.showMessageDialog(null,"没有这个用户存在");   //显示登录失败信息
					field.setText(null);   //清空账号文本框
					passwordfield.setText(null);  //清空密码文本框
				}
			}
		});
        
		return  loginbutton;
	}
 /**

  * 20180715

  */
	public static void main(String[] args) {     //创建主窗口
		// TODO Auto-generated method stub
         Login f=new Login();    //新建登录界面       
         f.setVisible(true);                //设置可见
         f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     //设置关闭方式，关闭后退出应用程序
         Thread t=new Thread(new Runnable() {  //新建线程，以便程序执行时同时获取时间
			
			@Override
			public void run() {     //线程运行函数
				// TODO Auto-generated method stub
				while(true) {  //无限循环
					try {
						Thread.sleep(1000);  //睡眠1000ms
						Calendar c = Calendar.getInstance();   //得到Calendar对象
						int year=c.get(Calendar.YEAR);   //得到年份
						int month=c.get(Calendar.MONTH);   //得到月份
						month++;   
						int day=c.get(Calendar.DATE);   //得到天
						int hour=c.get(Calendar.HOUR);   //时
						int minute=c.get(Calendar.MINUTE);  //分
						int second=c.get(Calendar.SECOND);   //秒
						time_1=String.valueOf(year)+"年"+String.valueOf(month)+"月"+String.valueOf(day)+"日"; //时间字符串
						time_2=String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);//时间字符串
						label_time_1.setText(time_1);//设置label文本为时间字符串
						label_time_2.setText(time_2);//设置label文本为时间字符串
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
         t.start();  //线程开始运行
	}
}
