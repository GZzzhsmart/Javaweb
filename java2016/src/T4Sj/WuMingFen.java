package T4Sj;
/**
 * 1.有三个属性：面码:String theMa  粉的分量(两)：int quantity        
 *  是否带汤：boolean likeSoup 
2.写一个构造方法，以便于简化初始化过程，如：  WuMingFen f1 = new WuMingFen("牛肉",3,true);
 3.重载构造方法，
使得初始化过程可以多样化：  WuMingFen f2 = new WuMingFen("牛肉",2); 
4.如何使得下列语句构造出来的粉对象是酸辣面码、2两、带汤的？  WuMingFen f3 = new WuMingFen(); 
5.写一个普通方法：check()，用于查看粉是否符合要求。即：将对象的三个属性打印在控制台上。   
 * 
 * */

public class WuMingFen {
	String theMa;
	int quantitu;
	boolean likesoup;
	public WuMingFen(String theMa,int quantitu){
		this.theMa=theMa;
		this.quantitu=quantitu;
	}
	public WuMingFen(String theMa,int quantitu,boolean likesoup){
		this.theMa=theMa;
		this.quantitu=quantitu;
		this.likesoup=likesoup;
	}
	public void check(){
		System.out.println("面码："+theMa+"\n粉的份量："+quantitu+"\n是否带汤："+likesoup);
	}
	public static void main(String[] args){
		WuMingFen f1 = new WuMingFen("牛肉",3,true);
		WuMingFen f2 = new WuMingFen("牛肉",2,false);
		WuMingFen f3 = new WuMingFen("牛肉",1,true);
		f1.check();
		f2.check();
		f3.check();
	}
}
