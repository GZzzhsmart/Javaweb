package T4Sj;

public class Truck extends Vehicles{
	private float load;
	public Truck(String brand,String color,float load){
		super(brand,color);
		this.load=load;
	}
	public void showTruck(){
		super.showInfo();
		System.out.println("载重："+load);
	}
	public static void main(String[] args){
		Vehicles f1=new Vehicles("宝马","白色");
		Car f2=new Car("法拉利","黑色",4);
		Truck f3=new Truck("解放","绿色",5000);
		f1.run();
		f1.showInfo();
		f2.run();
		f2.showCar();
		f3.run();
		f3.showTruck();
	}
}
