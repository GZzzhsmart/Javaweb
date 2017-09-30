package T17;

public class Test1 {
	public static void main(String[] args) {
		AAA aa = AAA.getInstance();
		aa.testA();
	}
}
class AAA{
	private static AAA aaa=null;
	public void testA(){
		System.out.println("Test Function...");
	}
	private AAA(){
		
	}
	public static AAA getInstance(){
		if(aaa==null){
			return new AAA();
		}
		return aaa;
	}
}
