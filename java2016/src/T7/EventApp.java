package T7;
/**
 * 给窗口添加两个按钮，并实现事件的监听
 * 
 * */
import java.awt.*;
import java.awt.event.*;
public class EventApp extends Frame implements ActionListener{
	Panel p1 = new Panel();
	Panel p2  =new Panel();
	Button black = new Button("黑色");
	Button white = new Button("白色");
	public EventApp(){
		super("按钮事件处理");
		this.setLayout(new BorderLayout());
		//添加监听
		black.addActionListener(this);
		white.addActionListener(this);
		p1.add(black);
		p1.add(white);
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.CENTER);
		this.setSize(180,160);
		this.show();
	}
	public static void main(String[] args){
		new EventApp();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==black){
			p2.setBackground(Color.BLACK);
		}
		if(e.getSource()==white){
			p2.setBackground(Color.WHITE);
		}
		
	}
	
}
