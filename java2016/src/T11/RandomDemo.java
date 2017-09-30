package T11;

import java.util.Random;

public class RandomDemo {
	public static void main(String[] args) {
		Random ran = new Random();
		System.out.println("随机整形数："+Math.abs(ran.nextInt())% 100);
		//控制随机数的范围在100以内
		System.out.println("随机整形数："+ran.nextInt(100));
		
		System.out.println("随机double："+ran.nextDouble());
		System.out.println("随机long："+ran.nextLong());
		System.out.println("随机boolean："+ran.nextBoolean());
		
		System.out.println("正弦30度："+Math.sin(Math.PI/6));
		System.out.println("余弦30度："+Math.cos(Math.PI/6));
		System.out.println("2的10次方："+Math.pow(2, 10));
		System.out.println("e="+Math.E);
		System.out.println("对数函数log100："+Math.log10(100));
		System.out.println("对数函数Ine平方："+Math.log(Math.E*Math.E));
	}
}
