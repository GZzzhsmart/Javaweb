package T4Sj;

import java.awt.Point;

public class Rectangle extends Graph{
	private int length;
	private int width;
	public Rectangle(Point center,int length,int width){
		super(center);
		this.length=length;
		this.width=width;
	}
	public void getInfo(){
		System.out.println("矩形：\n"+"校准点："+center+"\n 矩形长度："+length+"\n 矩形宽度："+width);
	}
}
