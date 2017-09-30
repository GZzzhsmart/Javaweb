package T2lianxi;
public class wanshu {
	  /*
		完数：所有的因子相加等于这个数本身
		6=1+2+3
	  */
	public static void main(String[] args) {
		int a;
		for(int i=6;i<1000;i++){
			a=0;
			for(int j=2;j<=i;j++){
				if(i%j==0){
					a+=i/j;
				}
			}
			if(a==i){
				System.out.println(i);
			}
		}
	}
}
