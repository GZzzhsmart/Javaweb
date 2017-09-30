package Fuxi;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Caishuzi {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num,count=0;
		int n;
		Random random = new Random();
		num = Math.abs(random.nextInt(100));
		Date date1 = new Date();
		long d1 = date1.getTime();
		System.out.println("��������Ҫ�µ�����");
		do{
			count++;
			n = input.nextInt();
			if(num>n){
				System.out.println("�����������̫С��");
			}else if(num<n){
				System.out.println("�����������̫����");
			}else{
				Date date2 = new Date();
				long d2 = date2.getTime();
				long time = (d2-d1)/1000;
				System.out.println("��ϲ��¶��ˣ�������"+count+"��");
				System.out.println("������"+time+"��");
			}
		}while(num!=n);
	}
}
