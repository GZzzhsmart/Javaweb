package T5Sj;

public class RealDoor extends Door{
	public void openDoor(){
		System.out.println("开门\n");
	}
	public void closeDoor(){
		System.out.println("关门\n");
	}
	public void theftproof(){
		System.out.println("防盗\n");
	}
	public void waterproof(){
		System.out.println("防水\n");
	}
	public void bulletproof(){
		System.out.println("防弹\n");
	}
	public static void main(String[] args){
		RealDoor d = new RealDoor();
		d.openDoor();
		d.closeDoor();
		d.theftproof();
		d.waterproof();
		d.bulletproof();
	}
}
