package express;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;
/**
 *

 *   20180714
 */
public class shopcarpanel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image imag;// ��¼���ı���ͼƬ
	/**

	 * �����ʼ������������

	 */
	public shopcarpanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		ImageIcon icon=new ImageIcon("image/2-0.png");  //���ñ���
  	    imag=icon.getImage();
	}
	/**

	 *  ���汳���Ļ���

	 */
	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(imag, 0, 0, this);// ����ͼƬ
	}

}