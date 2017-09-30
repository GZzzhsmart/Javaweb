package T2;

import java.util.Scanner;
public class  djx
{
	public static void main(String[] args) 
	{
		//题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
		String str="";
		int letter=0,space=0,num=0,others=0;
		Scanner input = new Scanner(System.in);
		str = input.next();
		System.out.println(str);
		for(int i=0;i<str.length();i++){
			if((str.charAt(i)>='a' && str.charAt(i)<='z') || (str.charAt(i)>='A' && str.charAt(i)<='Z')){
				letter++;
			}else if(str.charAt(i)==' '){
				space++;
			}else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				num++;
			}else{
				others++;
			}
		}
		System.out.println("字母个数："+letter+";空格个数："+space+";数字个数："+num+";其他字符个数:"+others);
	}
}
