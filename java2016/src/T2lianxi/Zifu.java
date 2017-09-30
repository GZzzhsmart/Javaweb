package T2lianxi;
import java.util.Scanner;
public class Zifu {
	public static void main(String[] args) {
		System.out.println("请输入任意字符");
		String str="";
		int space=0,letter=0,num=0,others=0;
		Scanner input=new Scanner(System.in);
		str=input.next();
		System.out.println(str);
		for(int i=0;i<str.length();i++){
			if((str.charAt(i))>='a'&& str.charAt(i)<='z'  || (str.charAt(i)>='A' && str.charAt(i)<='Z')){
				
				letter++;
			}else if(str.charAt(i)==' '){
				space++;
				
			}else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				num++;
			}else {
				others++;
			}
		}
		System.out.println("字母个数是:"+letter+"空格个数是:"+space+"数字个数是:"+num+"其他字符个数是:"+others);
	}
}
