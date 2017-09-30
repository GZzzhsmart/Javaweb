package T12;
/**
 * 4.2.	通过FileReader与FileWriter实现文件的读写并加密解密文件内容
 * */
import java.io.*;
public class EncryptDemo {
	public static void main(String[] args) {
		char a[] = "今天晚上10点发起总攻".toCharArray();
		int n=0;
		try{
			//生成新的文件
			File f = new File("D:\\sercet.txt");
			//将a字符数组进行运算或运算后得到一个新的字符
			for(int i=0;i<a.length;i++){
				a[i]=(char)(a[i]^'R');
			}
			
			//将生成的密文保存到指定的文件夹中
			FileWriter out = new FileWriter(f);
			out.write(a,0,a.length);
			out.close();
			
			//读取加密的文件的内容并直接将密文显示到控制台上
			FileReader in = new FileReader(f);
			char[] tom = new char[10];
			System.out.println("密文：");
			while((n=in.read(tom,0,10))!=-1){
				String s = new String(tom,0,n);
				System.out.print(s);
			}
			in.close();
			//再次读取加密文件的内容
			in=new FileReader(f);
			System.out.println("");
			System.out.println("明文：");
			//对读取的密文按行读取并解密后输出到控制台上
			while((n=in.read(tom,0,10))!=-1){
				for(int i=0;i<n;i++){
					tom[i]=(char)(tom[i]^'R');
				}
				String s = new String(tom,0,n);
				System.out.print(s);
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
