package T7;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class MouseDemo extends JFrame implements MouseListener,MouseMotionListener{
	JLabel lblStatus;
	public MouseDemo(){
		super("鼠标事件");
		lblStatus = new JLabel("当前鼠标位置：",JLabel.CENTER);
		add(lblStatus,BorderLayout.SOUTH);
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new MouseDemo();
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1){
			if(e.getButton()==1){
				lblStatus.setText("单击鼠标左键事件");
			}else if(e.getButton()==3){
				lblStatus.setText("单击鼠标右键事件");
			}
		}else if(e.getClickCount()==2){
			lblStatus.setText("双击事件");
		}
		
	}
	//鼠标进入某个控件区域
	public void mouseEntered(MouseEvent e) {
		lblStatus.setText("鼠标进入");
	}
	//鼠标退出某个控件区域
	public void mouseExited(MouseEvent e) {
		lblStatus.setText("鼠标退出某个控件区域");
	}
	//按住鼠标
	public void mousePressed(MouseEvent e) {
		lblStatus.setText("按下鼠标");
	}
	//放开鼠标
	public void mouseReleased(MouseEvent e) {
		lblStatus.setText("放开鼠标");
	}
	//鼠标拖动
	public void mouseDragged(MouseEvent e) {
		lblStatus.setText("鼠标拖动");
	}
	//鼠标移动
	public void mouseMoved(MouseEvent e) {
		
	}
	
}
