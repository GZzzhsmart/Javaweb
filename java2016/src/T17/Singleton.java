package T17;

import javax.swing.JFrame;

public class Singleton extends JFrame {
	//定义一个类本身的静态变量
	private static Singleton singleton = null;
	private String name;
	
	//默认构造函数
	public Singleton(){
		super("单例模式，该程序只能启动一个实例");
		setSize(300,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Singleton getInstance(){

		if(singleton==null){
			singleton = new Singleton();
		}
		return singleton;
	}
}
