package T4Sj;

public class Car2 extends Auto{
	boolean Aircondition;
	boolean CD;
	public Car2(int tires,String color,int load,int speed,boolean Aircondition,boolean CD){
		super(tires,color,load,speed);
		this.Aircondition=Aircondition;
		this.CD=CD;
	}
	public void speedUp(){
		System.out.println("汽车开始加速");
	}
	public void speedDown(){
		System.out.println("汽车开始减速");
	}
	public void getInfo(){
		System.out.println("轮胎数："+tires+"\n 颜色："+color+"\n 车身重量："+load+"\n 速度："+speed+"km/h\n 有空调："+Aircondition+"\n 有CD："+CD);
	}
	public static void main(String[] args){
		Car2 m = new Car2(4,"白色",50,100,true,false);
		m.speedDown();
		m.getInfo();
	}
}
