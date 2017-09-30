package T3;
import java.util.Scanner;
public class cai {
	public void display(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入姓名和年龄：");
		String name="胡歌";
		String age="40";
		String str="";
		str=input.next();
		String sr="";
		sr=input.next();
		if(str.equals("胡歌") && sr.equals("40"))
		{
			System.out.println("恭喜您，你猜对了！");
		}
		else
		{
			System.out.println("您猜错了，请继续！");
		}
		while(str!="胡歌"){
			String st="";
			String a="";
			st=input.next();
			a=input.next();
			if(st.equals("胡歌") && a.equals("40"))
			{
				System.out.println("恭喜您，猜对了！");
				
			}else{
				System.out.println("您猜错了，请继续！");
			}
		}
	}
	public static void main(String[] args){
		cai s1=new cai();
		s1.display();
	}
}
