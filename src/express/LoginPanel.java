/**

 * �õ���¼��屳��
 */
package express;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class LoginPanel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image imag;// ��¼���ı���ͼƬ

	public LoginPanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		ImageIcon icon=new ImageIcon("image/1-1.JPG");  //���ñ���
  	    imag=icon.getImage();
	}

	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(imag, 0, 0, this);// ����ͼƬ
	}

}