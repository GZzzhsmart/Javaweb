package T8;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

import T5Sj.interfaceDemo;

public class GraphicsDemo extends JFrame implements MouseListener,
		MouseMotionListener {
	int startx, starty, endx, endy;
	boolean drawing = false;

	public GraphicsDemo() {
		super("绘图演示");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("images/qt.png");
		// 设置图标函数
		setIconImage(image);
		// 监听鼠标事件
		addMouseListener(this);
		// 监听鼠标拖动事件
		addMouseMotionListener(this);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void paint(Graphics g) {
		// 画矩形
		g.drawRect(100, 100, 300, 200);
		// 划线
		g.drawLine(startx, starty, endx, endy);
		System.out.println("paint......");
		g.drawOval(100, 100, 200, 300);
		// 画弧线
		g.drawArc(210, 110, 210, 310, 0, 270);
	}

	public static void main(String[] args) {
		new GraphicsDemo();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	// 按下鼠标
	public void mousePressed(MouseEvent e) {
		this.startx = e.getX();
		this.starty = e.getY();
		this.drawing = true;

	}

	// 释放鼠标
	public void mouseReleased(MouseEvent e) {
		drawing = false;

	}

	// 拖动鼠标
	public void mouseDragged(MouseEvent e) {
		if (drawing) {
			this.endx = e.getX();
			this.endy = e.getY();
			this.startx = e.getX();
			this.starty = e.getY();
			repaint();
		}

	}

	public void mouseMoved(MouseEvent e) {

	}
}
