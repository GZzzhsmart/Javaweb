package Fuxi;
/**
 * 完数(所有的因子相加等于它本身)
 * */
public class Wanshu {
	public static void main(String[] args) {
		int a;
		for(int i=6;i<1000;i++){
			a=0;
			for(int j=2;j<=i;j++){
				if(i%j==0){
					a+=i/j;
				}
			}
			if(i==a){
				System.out.println(i);
			}
		}
	}
}
