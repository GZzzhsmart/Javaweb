package T13;

import java.util.*;
import javax.swing.*;
public class ClockRunnableApp extends JFrame implements Runnable{
	JLabel label = new JLabel("2007-08-21 10:02:32");//实例化一个Label对象
	public ClockRunnableApp(){
		super("电子时钟");
		this.add(label);
		this.setSize(150,50);
		new Thread(this).start();//实例化该线程，并实例化
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//取得当前的时间并不停的刷新时间
	public void run(){
		while(true){
			label.setText(new Date().toLocaleString());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new ClockRunnableApp().setVisible(true);
	}
}
