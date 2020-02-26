/**
 * ������ʵ��
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

	JButton button_message; //��ʾ��Ϣ��ť
	JButton button_system;  //�޸���Ϣ��ť
	
	
	   public mainFrame()
     {
    	 setTitle("Drug Shop");  //���ý������
    	
    	 setSize(815,600);   //���ý���ߴ�
    	 setLayout(null);  //���Բ���
    	 getContentPane().setBackground(Color.WHITE);  //���ñ�����ɫ
    	 setLocationRelativeTo(null);   //��������
    	
    	 mainFramePanel framepanel=new mainFramePanel();  //�½�mainFramePanel
    	 framepanel.setLayout(null);   //���ø���岼��Ϊ���Բ���
    	
    	 framepanel.add(getMessageButton());//��Ϣ��ť�������
    	 framepanel.add(getSystemButton());//�޸���Ϣ��ť�������
    	 
    	 setContentPane(framepanel);  //���ø����Ϊ�����
     }
	  
	   /**

	    * �õ���Ϣ���İ�ť
	    */
	   public JButton getSystemButton() {
		  button_system=new JButton(); //�½���ť
	    	 button_system.setBounds(456,248,97,106); //���ð�ť��С��λ��
	    	 button_system.setBorderPainted(false);  //�ޱ߽�
	    	 button_system.setIcon(new ImageIcon("image/2-4.png"));  //���ð�ťͼƬ
    	 button_system.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				system_frame System=new system_frame();  //�½�����
				System.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ùرշ�ʽ
				System.setVisible(true);//���ÿɼ�
			}
		});
    	 return button_system;
	   }
	   /**
	    * �õ���Ϣ��ť
	    */
	   public JButton getMessageButton(){
			 button_message=new JButton();  //�½���ť
	    	 button_message.setBounds(312,248,100,85);  //���ð�ť��С��λ��
	    	 button_message.setBorderPainted(false);//���ð�ť�ޱ߽�
	    	 button_message.setIcon(new ImageIcon("image/2-3.png")); //���ð�ťͼƬ
    	     button_message.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				message_frame message=new message_frame();  //�½�ҳ��
				message.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //�رշ�ʽ
				message.setVisible(true); //�ɼ�
			}
		});
    	 return button_message;
	   }
}
