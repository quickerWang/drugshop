/**

 *�����汳�� 
 */

package express;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class mainFramePanel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image imag;// ��¼���ı���ͼƬ
/**

 * ����ͼƬʵ��
 */
	public mainFramePanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		ImageIcon icon=new ImageIcon("image/2-0.JPG");  //���ñ���
  	    imag=icon.getImage();
	}
	/**

	 * ����ͼƬ����
	 */
	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(imag, 0, 0, this);// ����ͼƬ
	}

}