package T17;

public class TestA {
	TestA testa;
	public TestA(){
		System.out.println("TestA....");
	}
	public void display(){
		System.out.println("TestA");
	}
	public static void main(String[] args) {
		try {
			TestA t = (TestA)Class.forName("T17.TestA").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}