package T5;

public class MyException {
	public static void main(String[] args){
		int a,b,c;
		a=10;
		b=10;
		int aa[]={1,2,3,4};
		try{
			c=a/b;
			for(int i=0;i<aa.length;i++){
				System.out.println(aa[i]);
			}
			MyException myException = new MyException();
			myException.test2();
			MyException myException1 = null;
			myException.display(myException1);
		}catch(ArithmeticException e1){
			System.out.println("分母不能为0");
			return;
		}catch(ArrayIndexOutOfBoundsException e2){
			System.out.println("数组越界，超出最小或者最大下标");
			return;
		}catch(NullPointerException e3){
			System.out.println("对象为空，使用前对象首先必须初始化...");
			return;
		}catch(Exception e){
			e.printStackTrace();
			return;
		}finally{
			System.out.println("End......");
		}
	}
	public void test(){
		System.out.println("test");
	}
	public void test2(){
		System.out.println(10/0);
	}
	public void display(MyException myExc){
		myExc.test();
	}
}
