/**
 * 主界面实现
 */

package express;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;




public class mainFrame extends JFrame{

	JButton button_message; //显示信息按钮
	JButton button_system;  //修改信息按钮
	
	
	   public mainFrame()
     {
    	 setTitle("Drug Shop");  //设置界面标题
    	
    	 setSize(815,600);   //设置界面尺寸
    	 setLayout(null);  //绝对布局
    	 getContentPane().setBackground(Color.WHITE);  //设置背景白色
    	 setLocationRelativeTo(null);   //设界面居中
    	
    	 mainFramePanel framepanel=new mainFramePanel();  //新建mainFramePanel
    	 framepanel.setLayout(null);   //设置该面板布局为绝对布局
    	
    	 framepanel.add(getMessageButton());//信息按钮加入面板
    	 framepanel.add(getSystemButton());//修改信息按钮加入面板
    	 
    	 setContentPane(framepanel);  //设置该面板为主面板
     }
	  
	   /**

	    * 得到信息更改按钮
	    */
	   public JButton getSystemButton() {
		  button_system=new JButton(); //新建按钮
	    	 button_system.setBounds(456,248,97,106); //设置按钮大小，位置
	    	 button_system.setBorderPainted(false);  //无边界
	    	 button_system.setIcon(new ImageIcon("image/2-4.png"));  //设置按钮图片
    	 button_system.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				system_frame System=new system_frame();  //新建界面
				System.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式
				System.setVisible(true);//设置可见
			}
		});
    	 return button_system;
	   }
	   /**
	    * 得到信息按钮
	    */
	   public JButton getMessageButton(){
			 button_message=new JButton();  //新建按钮
	    	 button_message.setBounds(312,248,100,85);  //设置按钮大小，位置
	    	 button_message.setBorderPainted(false);//设置按钮无边界
	    	 button_message.setIcon(new ImageIcon("image/2-3.png")); //设置按钮图片
    	     button_message.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				message_frame message=new message_frame();  //新建页面
				message.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //关闭方式
				message.setVisible(true); //可见
			}
		});
    	 return button_message;
	   }
}
