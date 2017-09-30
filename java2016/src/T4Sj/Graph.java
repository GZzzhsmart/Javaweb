package T4Sj;
/*设计一个能细分为矩形、三角形、圆形和椭圆形的“图形”类。
 * 使用继承将这些图形分类，找出能作为基类部分的共同特征
 * (如校准点)和方法(如画法、初始化)，并看看这些图形是否能进一步划分为子类。 
 * */
import java.awt.Point;
public abstract class Graph {
	public Point center;
	public Graph(Point center){
		this.center=center;
	}
	public abstract void getInfo();
}
