package T13sj;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class CountApp {
	public static void main(String[] args) {
		new TimeFrame().setVisible(true);
	}
}
class TimeThread implements Runnable{
	Label a;
	
	//构造函数传入Label标签
	public TimeThread(Label lab){
		a=lab;
	}
	public void run(){
		for(int i=1;i<=100;i++){
			a.setText(String.valueOf(i));
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
//创建一个Gui界面
class TimeFrame extends Frame{
	//实例化一个标签
	Label label = new Label("100",1);
	public TimeFrame(){
		//把Label标签添加到窗体上
		this.add(label);
		//设置窗体的大小
		this.setSize(150,50);
		
		//实例化时间线程类
		TimeThread time = new TimeThread(label);
		//把实现了Runnable接口的类放到Thread类里启动线程
		new Thread(time).start();
		
	}
}
