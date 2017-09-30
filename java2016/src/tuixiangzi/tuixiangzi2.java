package tuixiangzi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Stack;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.Border;

public class tuixiangzi2 {
	public static void main(String[] args) {
		new TxzGame();

	}
}
//界面类
class TxzGame extends JFrame implements ActionListener,ItemListener{
	JButton btnBack,btnFirst,btnNext,btnPrev;
	JButton btnLast,btnSelect,btnMusic,btnReset;
	JComboBox cbMusic;
	JMenuBar menuBar;
	JMenu mnuOption,mnuSet,mnuHelp;
	JMenuItem miReset,miPrev,miNext,miSelect,miExit,miBack;
	JRadioButtonMenuItem miMusic1,miMusic2,miMusic3,miMusic4,miMusic5;
	 
	JMenuItem miHelp;
	final int MAXLEVEL=50;
	//音乐文件
	String sMusicFile[]={
		"nor.mid",
		"qin.mid",
		"popo.mid",
		"guang.mid",
		"eyes on me.mid"
	};
	String sMusic[]={
			"默认",
			"琴箫合奏",
			"泡泡堂",
			"灌篮高手",
			"eyes on me"
	};
	//创建MyPanel类
	MyPanel mainPanel;
	//定义播放背景音乐的类
	Sound sound;
	
	public TxzGame() {
		super("推箱子游戏2016版");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("pic/3.gif");
		//设置图标
		setIconImage(image);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		JLabel lblTitle = new JLabel("推箱子2016，制作者：曾志湖,QQ:1729340612",JLabel.CENTER);
		lblTitle.setFont( new Font("宋体",Font.BOLD,16));
		lblTitle.setBounds(100, 20,500, 30);
		c.add(lblTitle);
		//调用创建按钮的函数
		createButton(c);
		//调用创建菜单的函数
		createMenus();
		
		mainPanel = new MyPanel();
		mainPanel.setBounds(0, 60, 600, 600);
		c.add(mainPanel);
		setSize(720,720);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//启动背景音乐
		sound = new Sound();
		//设置默认焦点
		mainPanel.requestFocus();
	}
	//创建按钮函数
	public void createButton(Container c){
		//右边放一排按钮
		btnReset = new JButton("重来");
		btnBack = new JButton("悔一步");
		btnFirst = new JButton("第一关");
		btnNext = new JButton("下一关");
		btnPrev = new JButton("上一关");
		btnLast = new JButton("最终关");
		btnSelect = new JButton("选关");
		btnMusic = new JButton("音乐关");
		JLabel lblMusic = new JLabel("选择音乐");
		cbMusic = new JComboBox(sMusic);
		
		btnReset.setBounds(610,80, 80, 30);
		btnBack.setBounds(610,130, 80, 30);
		btnFirst.setBounds(610,180, 80, 30);
		btnNext.setBounds(610,230, 80, 30);
		btnPrev.setBounds(610,280, 80, 30);
		btnLast.setBounds(610,330, 80, 30);
		btnSelect.setBounds(610,380, 80, 30);
		btnMusic.setBounds(610,430, 80, 30);
		lblMusic.setBounds(610,480, 80, 20);
		cbMusic.setBounds(610,500, 80, 30);
		//监听
		btnReset.addActionListener(this);
		btnBack.addActionListener(this);
		btnFirst.addActionListener(this);
		btnNext.addActionListener(this);
		btnPrev.addActionListener(this);
		btnLast.addActionListener(this);
		btnSelect.addActionListener(this);
		btnMusic.addActionListener(this);

		//监听下拉框
		cbMusic.addItemListener(this);
		
		c.add(btnReset);
		c.add(btnBack);
		c.add(btnFirst);
		c.add(btnNext);
		c.add(btnPrev);
		c.add(btnLast);
		c.add(btnSelect);
		c.add(btnMusic);
		c.add(lblMusic);
		c.add(cbMusic);
	}
	//创建菜单函数
	public void createMenus(){
		//创建选项子菜单
		mnuOption = new JMenu("选项");
		miBack = new JMenuItem("悔一步");
		miReset = new JMenuItem("重置");
		miPrev = new JMenuItem("上一关");
		miNext = new JMenuItem("下一关");
		miSelect = new JMenuItem("选关");
		miExit = new JMenuItem("退出");
		
		mnuOption.add(miBack);
		mnuOption.add(miReset);
		mnuOption.add(miPrev);
		mnuOption.add(miNext);
		mnuOption.add(miSelect);
		mnuOption.addSeparator();
		mnuOption.add(miExit);
		//设置子菜单
		mnuSet = new JMenu("设置");
		miMusic1 = new JRadioButtonMenuItem(sMusic[0]);
		miMusic2 = new JRadioButtonMenuItem(sMusic[1]);
		miMusic3 = new JRadioButtonMenuItem(sMusic[2]);
		miMusic4 = new JRadioButtonMenuItem(sMusic[3]);
		miMusic5 = new JRadioButtonMenuItem(sMusic[4]);
		//单选菜单分组
		ButtonGroup bg = new ButtonGroup();
		bg.add(miMusic1);
		bg.add(miMusic2);
		bg.add(miMusic3);
		bg.add(miMusic4);
		bg.add(miMusic5);
		//默认选择第一首歌
		setMenuState(0);
		mnuSet.add(miMusic1);
		mnuSet.add(miMusic2);
		mnuSet.add(miMusic3);
		mnuSet.add(miMusic4);
		mnuSet.add(miMusic5);
		//帮助子菜单
		mnuHelp = new JMenu("帮助(H)");
		mnuHelp.setMnemonic('H');
		
		miHelp = new JMenuItem("关于我们...");
		mnuHelp.add(miHelp);
		
		//监听
		miBack.addActionListener(this);
		miReset.addActionListener(this);
		miNext.addActionListener(this);
		miPrev.addActionListener(this);
		miExit.addActionListener(this);
		miSelect.addActionListener(this);
		miMusic1.addActionListener(this);
		miMusic2.addActionListener(this);
		miMusic3.addActionListener(this);
		miMusic4.addActionListener(this);
		miMusic5.addActionListener(this);
		miHelp.addActionListener(this);
		
		menuBar = new JMenuBar();
		menuBar.add(mnuOption);
		menuBar.add(mnuSet);
		menuBar.add(mnuHelp);
		setJMenuBar(menuBar);
		
	}
	//设置选择背景音乐的菜单状态，并保持与下拉框的选项同步
	public void setMenuState(int index){
		switch(index){
		case 0:
			miMusic1.setSelected(true);
			miMusic1.setEnabled(false);
			miMusic2.setEnabled(true);
			miMusic3.setEnabled(true);
			miMusic4.setEnabled(true);
			miMusic5.setEnabled(true);
			break;
		case 1:
			miMusic2.setSelected(true);
			miMusic2.setEnabled(false);
			miMusic1.setEnabled(true);
			miMusic3.setEnabled(true);
			miMusic4.setEnabled(true);
			miMusic5.setEnabled(true);
			break;
		case 2:
			miMusic3.setSelected(true);
			miMusic3.setEnabled(false);
			miMusic2.setEnabled(true);
			miMusic1.setEnabled(true);
			miMusic4.setEnabled(true);
			miMusic5.setEnabled(true);
			break;
		case 3:
			miMusic4.setSelected(true);
			miMusic4.setEnabled(false);
			miMusic2.setEnabled(true);
			miMusic3.setEnabled(true);
			miMusic1.setEnabled(true);
			miMusic5.setEnabled(true);
			break;
		case 4:
			miMusic5.setSelected(true);
			miMusic5.setEnabled(true);
			miMusic2.setEnabled(true);
			miMusic3.setEnabled(true);
			miMusic4.setEnabled(true);
			miMusic1.setEnabled(true);
			break;
		}
		//下拉框的选项与菜单选项同步
//			cbMusic.setSelectedIndex(index);		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==miHelp){
			String str = "作者:曾志湖\n";
			str += "Q Q:1729340612\n";
			str += "网址:http://www.huge.cn/\n";
			str += "版本:推箱子2016最新版";
			JOptionPane.showMessageDialog(this, str,"帮助",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==miExit){
			System.exit(0);
		}else if(e.getSource()==btnFirst){
			mainPanel.setLevel(0);
		}else if(e.getSource()==btnNext || e.getSource()==miNext){
			mainPanel.setLevel(1);
		}else if(e.getSource()==btnPrev || e.getSource()==miPrev){
			mainPanel.setLevel(-1);
		}else if(e.getSource()==btnLast){
			mainPanel.setLevel(MAXLEVEL);
		}else if(e.getSource()==btnSelect || e.getSource()==miSelect){
			String slevel = JOptionPane.showInputDialog(this,"请输入1~50之间的关卡编号","选关",JOptionPane.OK_CANCEL_OPTION);
			if(slevel !=null){
				try{
					int level = Integer.parseInt(slevel);
					if(level<=0 || level>=50){
						JOptionPane.showMessageDialog(this, "关卡不存在，请输入1~50之间的数字");
						return;
					}
					mainPanel.setLevel(level);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(this, "非法字符，请输入1~50之间的数字");
					return;
				}
			}
			System.out.println(slevel);
		}else if(e.getSource()==btnBack || e.getSource()==miBack){//悔一步
			mainPanel.goBack();
			mainPanel.requestFocus();
		}else if(e.getSource()==btnMusic){
			//获取按钮文字
			String title = btnMusic.getText();
			if(title.equals("音乐关")){
				if(sound.isplay()){
					sound.mystop();
				}
				//设置按钮标题
				btnMusic.setText("音乐开");
			}else{
				btnMusic.setText("音乐关");
				sound.loadSound();
			}
			mainPanel.requestFocus();
		}else if(e.getSource()==btnReset || e.getSource()==miReset){//重来
			mainPanel.setLevel();
		}else if(e.getSource()==miMusic1){
			cbMusic.setSelectedIndex(0);
		}else if(e.getSource()==miMusic2){
			cbMusic.setSelectedIndex(1);
		}else if(e.getSource()==miMusic3){
			cbMusic.setSelectedIndex(2);
		}else if(e.getSource()==miMusic4){
			cbMusic.setSelectedIndex(3);
		}else if(e.getSource()==miMusic5){
			//调用该函数时系统会自发触动itemStateChanged事件
			cbMusic.setSelectedIndex(4);
		}
	}
	public void itemStateChanged(ItemEvent e) {
		//获取在下拉框中选中的索引
		int index = cbMusic.getSelectedIndex();
		setMenuState(index);
		//利用索引，从数组中获取背景音乐文件名称
		String sfilename = sMusicFile[index];
		sound.setMusic(sfilename);
		//如果已经在播放背景音乐，则先停止播放
		if(sound.isplay()){
			sound.mystop();
		}
		//播放音乐
		sound.loadSound();
		mainPanel.requestFocus();
	}
	
	//游戏面板
	class MyPanel extends JPanel implements KeyListener{
		private int level=1;
		private int mx;
		private int my;
		//原始数据
		private int map[][]; 
		//临时数据
		private int tempMap[][];
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image mapimg[]={
			kit.getImage("pic/0.gif"),
			kit.getImage("pic/1.jpg"),
			kit.getImage("pic/2.jpg"),
			kit.getImage("pic/3.jpg"),
			kit.getImage("pic/4.gif"),
			kit.getImage("pic/5.gif"),
			kit.getImage("pic/6.gif"),
			kit.getImage("pic/7.gif"),
			kit.getImage("pic/8.gif"),
			kit.getImage("pic/9.jpg"),
		};
		
		/*
		 * 堆栈，保存推箱子过程中的每一个步骤
		 * 向左：
		 * 	没有推箱子 1
		 * 	推了箱子	 11
		 * 向上：
		 * 	没有推箱子 2
		 * 	推了箱子	 22
		 * 向右：
		 * 	没有推箱子 3
		 * 	推了箱子	 33
		 * 向下：
		 * 	没有推箱子 4
		 * 	推了箱子	 44
		 * 
		 *  
		 *  	
		 * 
		 * */
		Stack<Integer> step = new Stack<Integer>();
		//读取地图；
		public void readFile(int level){
			
			ReadMap readMap = new ReadMap(level);
			//原始数据
			this.map = readMap.getMap();
			this.mx  = readMap.getMx();
			this.my  = readMap.getMy();
			//临时数据，推箱子的过程中，该数组的值会发生变化
			this.tempMap = new ReadMap(level).getMap();
			//重画
			repaint();
		}
		public MyPanel() {
			//监听键盘事件
			this.addKeyListener(this);
			setSize(600, 600);
			readFile(level);
		}
		@Override
		public void paint(Graphics g) {
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					g.drawImage(mapimg[tempMap[j][i]], i*30, j*30, 30, 30,this);
				}
			}
			//白色RGB;255*255*255
			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("楷体_2312", Font.BOLD, 30));
			g.drawString("现在是第" +level + "关", 210, 60);
		}
		//判断箱子是否已经全部推到位了
		public boolean isWin(){
			boolean isok=true;
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					if((map[i][j]==4 || map[i][j]==9) && tempMap[i][j]!=9){
						isok=false;
						break;
					}
				}
				if(!isok)
					break;
			}
			return isok;
		}
		//设置关卡
		public void setLevel(int level) {
			if(level == 0){//第一关
				this.level=1;
			}else if(level==50){//最后一关
				this.level=50;
			}else if(level>1){//选关
				this.level = level;
			}else{
				this.level = this.level +level;
			}
			if(this.level<=0 ){
				this.level =1;	
			}else if( this.level>=50){
				this.level =50;
			}
			readFile(this.level);
			//清空上一关保存在堆栈中的所有步骤
			step.clear();
			//设置焦点
			requestFocus();
		}
		//重来
		public void setLevel() {
			readFile(this.level);
			//清空上一关保存在堆栈中的所有步骤
			step.clear();
			//设置焦点
			requestFocus();
		}
		public void keyPressed(KeyEvent e) {
			//方向键左键的值
			if(e.getKeyCode()==37){
				goLeft();
			}else if(e.getKeyCode()==38){//方向键向上键的值
				goUp();
			}else if(e.getKeyCode()==39){//方向键向右键的值
				goRight();
			}else if(e.getKeyCode()==40){//方向键向下键的值
				goDown();
			}
			if(isWin()){
				JOptionPane.showMessageDialog(null,"恭喜您过关了，进入下一关");
				setLevel(1);
			}
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
		public void goLeft(){
			//人的左边有箱子
			if(tempMap[mx][my-1]==3 || tempMap[mx][my-1]==9){
				//箱子的左边是草地2或者4就可以左边推箱子
				if(tempMap[mx][my-2]==2 || tempMap[mx][my-2]==4){
					if(tempMap[mx][my-2]==2){
						tempMap[mx][my-2]=3;
						tempMap[mx][my-1]=6;
					}else{
						tempMap[mx][my-2]=9;
						tempMap[mx][my-1]=6;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					my--;
					step.push(11);
				}
				//前面是草地
			}else if(tempMap[mx][my-1]==2 || tempMap[mx][my-1]==4 || tempMap[mx][my-1]==5){
				tempMap[mx][my-1]=6;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				my--;
				step.push(1);
			}
			repaint();

		}
		public void goUp(){
			//人的上面有箱子
			if(tempMap[mx-1][my]==3 || tempMap[mx-1][my]==9){
				//箱子的上面是草地2或者4就可以向上推箱子
				if(tempMap[mx-2][my]==2 || tempMap[mx-2][my]==4){
					if(tempMap[mx-2][my]==2){
						tempMap[mx-2][my]=3;
						tempMap[mx-1][my]=8;
					}else{
						tempMap[mx-2][my]=9;
						tempMap[mx-1][my]=8;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					mx--;
					step.push(22);
				}
				//前面是草地
			}else if(tempMap[mx-1][my]==2 || tempMap[mx-1][my]==4 || tempMap[mx-1][my]==5){
				tempMap[mx-1][my]=8;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				mx--;
				step.push(2);
			}
			repaint();
		}
		public void goRight(){
			//人的右边有箱子
			if(tempMap[mx][my+1]==3 || tempMap[mx][my+1]==9){
				//箱子的右边是草地2或者4就可以右边推箱子
				if(tempMap[mx][my+2]==2 || tempMap[mx][my+2]==4){
					if(tempMap[mx][my+2]==2){
						tempMap[mx][my+2]=3;
						tempMap[mx][my+1]=7;
					}else{
						tempMap[mx][my+2]=9;
						tempMap[mx][my+1]=7;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					my++;
					step.push(33);
				}
				//右面是草地
			}else if(tempMap[mx][my+1]==2 || tempMap[mx][my+1]==4 || tempMap[mx][my+1]==5){
				tempMap[mx][my+1]=7;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				my++;
				step.push(3);
			}
			repaint();

		}
		public void goDown(){
			//人的下面有箱子
			if(tempMap[mx+1][my]==3 || tempMap[mx+1][my]==9){
				//箱子的下面是草地2或者4就可以向下推箱子
				if(tempMap[mx+2][my]==2 || tempMap[mx+2][my]==4){
					if(tempMap[mx+2][my]==2){
						tempMap[mx+2][my]=3;
						tempMap[mx+1][my]=5;
					}else{
						tempMap[mx+2][my]=9;
						tempMap[mx+1][my]=5;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					mx++;
					step.push(44);
				}
				//前面是草地
			}else if(tempMap[mx+1][my]==2 || tempMap[mx+1][my]==4 || tempMap[mx+1][my]==5){
				tempMap[mx+1][my]=5;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				mx++;
				step.push(4);
				System.out.println("mx"+mx+";my="+my);
			}
			repaint();
		}
//		点击悔一步的按钮时调用的函数
		public void goBack(){
			//判断堆栈是否为空
			if(step.isEmpty()){
				JOptionPane.showMessageDialog(null, "已经是初始状态，不能再悔一步。");
				return;
			}
			int n = step.pop();//取出栈顶元素
			switch(n){
			case 1:
			case 11:
				backLeft(n);
				break;
			case 2:
			case 22:
				backUp(n);
				break;
			case 3:
			case 33:
				backRight(n);
				break;
			case 4:
			case 44:
				backDown(n);
				break;
			}
			requestFocus();
		}
		//悔一步的函数
		public void backLeft(int step){
			if(step==1){ //没有推箱子
				tempMap[mx][my+1]=6;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				my++;
			}else{//推了箱子
				tempMap[mx][my+1]=6;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx][my-1]==4 || map[mx][my-1]==9){
					tempMap[mx][my-1]=4;
				}else{
					tempMap[mx][my-1]=2;
				}
				my++;
			}
			//重画界面
			repaint();
		}
		public void backUp(int step){
			if(step==2){ //没有推箱子
				tempMap[mx+1][my]=8;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				mx++;
			}else{//推了箱子
				tempMap[mx+1][my]=8;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx-1][my]==4 || map[mx-1][my]==9){
					tempMap[mx-1][my]=4;
				}else{
					tempMap[mx-1][my]=2;
				}
				mx++;
			}
			//重画界面
			repaint();
		}
		public void backRight(int step){
			if(step==3){ //没有推箱子
				tempMap[mx][my-1]=7;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				my--;
			}else{//推了箱子
				tempMap[mx][my-1]=7;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx][my+1]==4 || map[mx][my+1]==9){
					tempMap[mx][my+1]=4;
				}else{
					tempMap[mx][my+1]=2;
				}
				my--;
			}
			//重画界面
			repaint();
		}
		public void backDown(int step){
			if(step==4){ //没有推箱子
				tempMap[mx-1][my]=5;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				mx--;
			}else{//推了箱子
				tempMap[mx-1][my]=5;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx+1][my]==4 || map[mx+1][my]==9){
					tempMap[mx+1][my]=4;
				}else{
					tempMap[mx+1][my]=2;
				}
				mx--;
			}
			//重画界面
			repaint();
		}
	}
}

//读取地图文件
class ReadMap{
	private int map[][];
	private int mx,my;
	//保存游戏关卡编号
	private int level;
	
	public ReadMap(int level) {
		this.level = level;
		String sfilename = "maps/"+level+".map";
		String content="";
		//用字符流读取文件中的地图数据
		try {
			FileReader fr = new FileReader(sfilename);
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			//一行一行的读取文件的内容，如果读到文件的末尾，则返回null值
			while((temp = br.readLine())!=null){
				content += temp;
			}
//			System.out.println(content);
			//转换成字节数组,共有400个元素
			byte b[] = content.getBytes();
//			for (byte c : b) {
//				System.out.print(c +"\t");
//			}
			map = new int[20][20];
			int c=0;
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					map[i][j]=b[c]-48;
//					System.out.println(map[i][j]);
					c++;
					if(map[i][j]==5){
						mx=i;
						my=j;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[][] getMap() {
		return map;
	}

	public int getMx() {
		return mx;
	}

	public int getMy() {
		return my;
	}
}
//播放背景音乐
class Sound {
	
	String path = new String("musics\\");

	//默认背景音乐
	String file = new String("nor.mid");

	
	Sequence seq;

	Sequencer midi;

	//判断是否在播放音乐
	boolean sign;

	public Sound() {
		loadSound();
	}
	//播放背景音乐的函数
	void loadSound() {
		try {
			//读取音频文件
			seq = MidiSystem.getSequence(new File(path + file));
			//获取一个音频设备
			midi = MidiSystem.getSequencer();
			//打开音频设备
			midi.open();
			//把音频文件设置到播放设备中
			midi.setSequence(seq);
			//开始播放音乐
			midi.start();
			//循环播放
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}
		catch ( Exception ex ) {
			ex.printStackTrace();
		}
		//代表正在播放背景音乐
		sign = true;
	}
	//停止播放背景音乐
	void mystop() {
		midi.stop();
		midi.close();
		sign = false;
	}

	//判断是否在播放背景音乐
	boolean isplay() {
		return sign;
	}
	//设置在下拉框中选择的背景音乐文件名称
	void setMusic(String e) {
		file = e;
	}
}




