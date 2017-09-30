package T8sj;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.Vector;
public class GameApp extends Frame implements MouseListener{
	/**
	 * vector集合(向量):
	 * 1.动态数组
	 * 2.元素的个数可以无限增加（没有大小限制）
	 * 3.元素可以是任意类型
	 * 增加元素用add函数
	 * 删除元素用remove函数
	 * */
	
	Vector v=new Vector();	
	public GameApp(){
		super("五子棋游戏");
		this.addMouseListener(this);
		this.setSize(435,465);
	}
	public void paint(Graphics g){
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		//棋盘
		Image img1=toolkit.getImage("images/Board.gif");
		//黑子
		Image imgBlack=toolkit.getImage("images/black.gif");	
		//白子
		Image imgWhite=toolkit.getImage("images/white.gif");	
		/**
		 * 标题栏的高度是20
		 * drawImage函数：画图
		 * 1.Image类型的图片
		 * 2.左上角的x坐标
		 * 3.左上角的y坐标
		 * 4.图片所在的控件
		 * */
		g.drawImage(img1,0,20,this);
		//size函数获取vector对象中的元素总数
		for(int i=0;i<v.size();i++){
			//get函数：取元素的值，i表示第i个元素
			//把取出来的object类型的元素强制转换为字符串类型
			String str=(String)v.get(i);
			//split函数：把字符串分隔成字符串数组，通过"-"进行分隔
			String tmp[]=str.split("-");			
			int a=Integer.parseInt(tmp[0]);
			int b=Integer.parseInt(tmp[1]);						
			int x=b*25+18-12;
			int y=a*25+39-12;
			//如果是奇数画白子，如果是偶数画黑子
			if(i%2==0)
				g.drawImage(imgBlack,x,y,this);
			else
				g.drawImage(imgWhite,x,y,this);
		}
	}
	public void update(Graphics g){
		this.paint(g);
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO: Add your code here
		int x=e.getX();
		int y=e.getY();
		//x方向图片到边框的距离18
		//y方向图片到边框的距离39
		//每个格子的大小25*25的矩形
		int gridy=(x-18)/25+((x-18)%25>12?1:0);//第几列
		int gridx=(y-39)/25+((y-39)%25>12?1:0);//第几行
		
		System.out.println(gridx+"-"+gridy);
		//contains函数:判断添加的元素在集合中是否存在
		if(!v.contains(gridx+"-"+gridy)){
			//把行和列拼接成字符串添加到向量(vector)里面
			v.add(gridx+"-"+gridy);
		}
		this.repaint();
		//repaint函数:重画，调用paint函数,update函数调用paint函数
	}
	public void mousePressed(MouseEvent e) {	}
	public void mouseReleased(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {	}
	
	public static void main(String args[]){
		//show函数显示窗口
		//setVisible(true);
		new GameApp().show();
	}
}