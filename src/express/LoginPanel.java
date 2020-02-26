/**

 * 得到登录面板背景
 */
package express;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class LoginPanel extends JPanel {// 登录面板

	public int width, height;// 面板的宽高
	private Image imag;// 登录面板的背景图片

	public LoginPanel() {// 登录面板的构造方法
		super();// 调用父类JPanel的构造器
		ImageIcon icon=new ImageIcon("image/1-1.JPG");  //设置背景
  	    imag=icon.getImage();
	}

	protected void paintComponent(Graphics g) {// 重写绘制组件方法
		super.paintComponent(g);// 绘制组件
		g.drawImage(imag, 0, 0, this);// 绘制图片
	}

}