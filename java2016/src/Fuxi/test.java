package Fuxi;

public class test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int sum=0;
		int  t=0,num=0;
//		һ��������������100����һ����ȫƽ�������ټ���168����һ����ȫƽ���������ʸ����Ƕ��٣�
		for(int n=1;n<=10000;n++){
			for (int j = 1; j <=1000; j++) {
				for (int k = 1; k <1000; k++) {
					if (Math.sqrt(n+100)==k && Math.sqrt(n+268)==j) {
						System.out.println(n);
					}
				}
				
			}
		}
		
	}


}
