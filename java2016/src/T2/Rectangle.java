package T2;
import java.util.Scanner;
public class Rectangle {
	float width,heigth;
	private float height;
	public Rectangle(float width,float height){
		this.width=width;
		this.height=height;
	}
	public float getLength(){
		return (this.width+this.height)*2;
	}
	public float getArea(){
		return this.width*this.height;
	}
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(10,20);
		System.out.println("周长是："+rect.getLength());
		System.out.println("面积是："+rect.getArea());
	}
}
