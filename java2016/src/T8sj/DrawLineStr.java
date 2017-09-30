package T8sj;
/*
 * 	创建一个Frame，设置该Frame的背景颜色为黄色Yellow, 设置Title为“画线和字符串示例”
 * */
import java.awt.*;
public class DrawLineStr extends Frame{
	public DrawLineStr(){
		super("画线和字符串实例");
		this.setSize(180,160);
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
	}
	public void paint(Graphics g){
		g.drawString("这是一个字符串",20,40);
		g.drawString("这是一条线段", 20, 150);
		g.drawLine(10,150,150,10);
	}
	public static void main(String[] args) {
		new DrawLineStr();
	}
}
