package T4Sj;
/*建立一个汽车Auto类，包括轮胎tires个数，汽车颜色color，车身重量load、速度speed等成员变量。
 * 并通过不同的构造方法创建实例。至少要求：  汽车能够加速，减速，停车。 
 * 再定义一个小汽车类Car，继承Auto，并添加空调、CD等成员变量，覆盖加速，减速的方法  
 * */
public class Auto {
	int tires;
	String color;
	int load;
	int speed;
	public Auto(int tires,String color,int load,int speed){
		this.tires=tires;
		this.color=color;
		this.load=load;
		this.speed=speed;
	}
	public void speedUp(){
		System.out.println("加速了");
	}
	public void speedDown(){
		System.out.println("减速了");
	}
	public void stop(){
		System.out.println("停止了");
	}
	public void getInfo(){
		System.out.println("轮胎数："+tires+"\n 颜色："+color+"\n 车身重量："+load+"\n 速度："+speed);
	}
	
}
