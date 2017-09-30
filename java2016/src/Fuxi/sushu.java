package Fuxi;
/**
 * 求1~100之间的素数
 * */
public class sushu {
	public static void main(String[] args) {
		int count = 0,t;
		for(int i=2;i<100;i++){
			t=0;
			for(int j=2;j<i;j++){
				if(i%j==0){
					t=1;
				}
			}
			if(t==0){
				System.out.println(i+"\t");
				count++;
			}
		}
		System.out.println("1到100之间的素数有"+count+"个");
	}
}
