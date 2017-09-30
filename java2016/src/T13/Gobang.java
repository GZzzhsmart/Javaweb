package T13;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class Gobang{
	public static void main(String args[]){
		Vector vec=new Vector();//存下棋步骤
		vec.add("8-8");
		vec.add("7-8");
		vec.add("8-9");
		vec.add("8-7");
		vec.add("8-10");
		vec.add("6-7");
		vec.add("8-11");
		vec.add("6-8");
		vec.add("8-12");
		vec.add("6-5");
		MainGame mg=new MainGame();
		mg.show();//打开主窗体

		UserA a=new UserA(vec,mg);//第一人用户
		UserB b=new UserB(vec,mg);//第二个用户
		a.useB(b);//因为第一个人下完一步棋后要通知第二个人下棋，所以要把对像b传入
		b.useA(a);//同上
		a.start();//开启线程
		try{
			Thread.sleep(1000);
		}catch(Exception e){e.printStackTrace();}

		b.start();//开启线程式
	}
}

 class MainGame extends Frame{
	int a=0,b=0;
	Vector rec=new Vector();//存当前下到某一步棋和之前的步骤，因为窗体每次都要从画，
							//所以要重新遍历Vector
	public MainGame(){
		super("五子棋复盘游戏");
		this.setSize(437,460);
	}
	public void paint(Graphics g){
		g.drawImage(new ImageIcon("images/Board.gif").getImage(),0,25,this);//调画布图片
		for(int i=0;i<rec.size();i++){
			String tmp=(String)rec.get(i);
			String aaa[]=tmp.split("-");//下棋行和列之间用"-"分割
			int hang=Integer.parseInt(aaa[0]);
			int lie=Integer.parseInt(aaa[1]);
			a=17+lie*25-12;//将行列转换为真正的坐标
			b=43+hang*25-12;
			System.out.println(a+"  "+b);
			if(i%2==0){//是画黑棋还是画白棋
				g.drawImage(new ImageIcon("images/black.gif").getImage(),a,b,this);
			}
			else
			{
				g.drawImage(new ImageIcon("images/white.gif").getImage(),a,b,this);
			}
		}
	}

	public void update(Graphics g){
		this.paint(g);
	}
	public void goChess(String nowChess){
		rec.add(nowChess);//当前下棋步骤
		this.repaint();//重画
	}

}

class UserA extends Thread{
	Vector vec;//下棋的所有步骤
	UserB b;//玩家B
	MainGame fg;//窗体类
	public UserA(Vector vec,MainGame fg){
		this.vec=vec;
		this.fg=fg;
	}

	public void useB(UserB b){
		this.b=b;
	}
	public void run(){
		for(int i=0;i<10;i=i+2){//只取其中5步
			synchronized(vec){
				fg.goChess((String)vec.get(i));//自已下一步棋
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){e.printStackTrace();}
			b.resume();//启动线程B，让对方下棋
			this.suspend();//把自已挂起
		}
	}
}


class UserB extends Thread{
	Vector vec;//下棋的所有步骤
	UserA a;//玩家A
	MainGame fg;//窗体类
	public UserB(Vector vec,MainGame fg){
		this.vec=vec;
		this.fg=fg;
	}
	public void useA(UserA a){
		this.a=a;
	}
	public void run(){
		for(int i=1;i<10;i=i+2){//只取其中5步
			synchronized(vec){
				fg.goChess((String)vec.get(i));//自已下一步棋
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){e.printStackTrace();}
			a.resume();//启动线程B，让对方下棋
			this.suspend();//把自已挂起
		}
	}
}
