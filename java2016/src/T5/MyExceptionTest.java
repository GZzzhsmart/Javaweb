package T5;

public class MyExceptionTest {
	public static void main(String[] args) throws MyException3{
		int i=2;
		if(i==2){
			throw new MyException3();
		}
	}
}
