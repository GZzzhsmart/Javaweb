package Fuxi;
/**
 * 百元百鸡
 * */
public class Baiyuanji {
	public static void main(String[] args) {
		int i,j,k;
		for(i=1;i<=100;i++){
			for(j=1;j<=100;j++){
				for(k=1;k<=100;k++){
					if((5*i+3*j+k/3==100)&&(i+j+k==100)&&k%3==0){
						System.out.println("公鸡="+i+"母鸡="+j+"小鸡="+k);
					}
				}
			}
		}
	}
}
