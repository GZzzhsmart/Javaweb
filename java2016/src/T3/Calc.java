package T3;

public class Calc {

	//求2个数的最大值；
	int max(int a,int b){
		
		return a>b?a:b;
	}
	double max(double a,double b){
		
		return a>b?a:b;
	}
	float max(float a,float b){
		
		return a>b?a:b;
	}
	byte max(byte a,byte b){
		
		return a>b?a:b;
	}
	long max(long a,long b){
		
		return a>b?a:b;
	}
	public static void main(String[] args) {
		Calc calc = new Calc();
		int a=10,b=20;
		int c=calc.max(a,b);
		//float a1=20,b1=20;
		//float c1 = calc.max(a1, b1);
		System.out.println("max="+c);
	
	}
}
