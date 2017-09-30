package T4Sj;

import java.awt.Point;

public class Circle extends Graph{
	private int radius;
	public Circle(Point center,int radius){
		super(center);
		this.radius=radius;
	}
	public void getInfo(){
		System.out.println("圆形：\n"+"校准点："+center+"\n 圆形半径："+radius);
	}
	public static void main(String[] args){
		Graph a = new Rectangle(new Point(8,8),4,7);
		a.getInfo();
		Graph b = new Rectangle(new Point(8,8),5,10);
		b.getInfo();
	}
}
