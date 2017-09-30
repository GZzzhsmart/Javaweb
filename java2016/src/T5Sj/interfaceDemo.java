package T5Sj;

public class interfaceDemo {
	public static void main(String[] args){
		Bike m = new Bike();
		System.out.println("Bike \n"+m.start(false)+"\n"+m.stop(true));
		Bus n = new Bus();
		System.out.println("Bus \n"+m.start(true)+"\n"+m.stop(false));
	}
}
