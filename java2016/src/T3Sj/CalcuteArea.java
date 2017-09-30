package T3Sj;
//求出三角形的面积，并实现方法的重载
public class CalcuteArea {
	public static void main(String[] args){
		int a=10,b=6;
		int area;
		System.out.println("假设该三角形的面积为");
		area=a*b/2;
		System.out.println("area="+area);
		System.out.println("假设该三角形的面积为");
		area=a*b;
		System.out.println("area="+area);
	}
}
