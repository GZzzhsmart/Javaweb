package Fuxi;
/**
 * 当相加的数字大于500以后自动停止
 * */
public class Jia {
	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i<100;i++){
			sum+=i;
			if(sum>=500){
				System.out.println(sum);
				break;
			}
		}
	}
}
