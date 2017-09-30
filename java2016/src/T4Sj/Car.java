package T4Sj;

public class Car  extends Vehicles{
	private int seats;
	public Car(String brand,String color,int seats){
		super(brand,color);
		this.seats=seats;
	}
	public void showCar(){
		super.showInfo();
		System.out.println("座位："+seats);
	}
	
}
