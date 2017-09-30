package T8sj;
/*
 * 	使用线程与画图实现字符串自屏幕右向左移动
 * */
import java.awt.*;

import T5Sj.interfaceDemo;

public class TestMove extends Frame{
	int x=160,y=80;
	public TestMove(){
		super("字符串动画");
		this.setBackground(Color.YELLOW);
		this.setSize(180,160);
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawString("This is a test of String move...",x,y);
		try{
			//休眠100毫秒
			Thread.sleep(100);
		}catch(Exception e){
			
		}
		//x坐标减10，即向左移动
		x-=10;
		if(x<-160){
			x = 160;
		}
		//重新绘画
		repaint();
	}
	public static void main(String[] args) {
		new TestMove().setVisible(true);
	}
}
