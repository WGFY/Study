package Fxx.test;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ������
 * @author ������
 *
 */
public class GameFram extends Frame {		//GUI��̣�AWT��swing�ȡ�
	Image background = GameUtil.getImage("images/backgroud.jpg");
	Image bullet = GameUtil.getImage("images/bullet.jpg");
	
	/**
	 * ���ش���
	 */
	public void launchFram(){
		setSize(450,300);
		setLocation(100,100);
		setVisible(true);
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);{
					System.exit(0);
				}
			}
		});
	}
	/**
	 * ��дpaint
	 */
	double x=100,y=100;
	
	
	@Override
	public void paint(Graphics g) {
		Color c=g.getColor();
		g.drawImage(background, 0, 0, null);
		g.drawImage(bullet, (int)x, (int)y, null);
		
		
	}
	
	/**
	 * �ػ����ڵ��̣߳��ڲ��ࡣ
	 * @author ������
	 *
	 */
	
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFram gf = new GameFram();
		gf.launchFram();
	}

}