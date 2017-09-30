package T5Sj;

public class Water3 extends Water{
	public void Water(){
		System.out.println("水3的制造过程\n");
	}
	public void Filter(){
		System.out.println("水已经过滤\n");
	}
	public static void main(String[] args){
		Water1 a = new Water1();
		Water2 b = new Water2();
		Water3 c = new Water3();
		a.Water();
		a.Buffer();
		a.Filter();
		b.Water();
		b.Buffer();
		c.Water();
		c.Filter();
	}
}
