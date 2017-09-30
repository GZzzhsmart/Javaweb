package T8sj;
/**
 * 4.2.	实现一个Applet，在该Applet中有两个按钮，分别为“变圆”、“变方”，
 * 当我们按按钮后，界面中的图形也会随着发生变化
 * 
 * */
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.EventListener;
public class AppletApp extends Applet implements ActionListener{
	String drawing;
	Button button1;
	Button button2;
	public void init(){
		drawing = "";
		button1 = new Button("变圆");
		button2 = new Button("变方");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.CYAN);
		this.add(button1);
		this.add(button2);
		
	}
	private void setColor(Object circle, Color red) {
		
		
	}
	public void start(){
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	//重写paint()方法，实现页面重写
	public void paint(Graphics g){
		if(drawing.equals("circle")){
			g.drawOval(50,50,80,80);
		}
		if(drawing.equals("fang")){
			g.drawRect(50,50,80,80);
		}
	}
	//实现按钮监听
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1){
			drawing = "circle";
			this.repaint();
		}
		if(e.getSource()==button2){
			drawing = "fang";
			this.repaint();
		}
		
	}
}
