package T7;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MouseDemo2 extends JFrame{

	JLabel lblStatus;
	public MouseDemo2() {
		super("鼠标事件");
		lblStatus = new JLabel("当前鼠标位置：",JLabel.CENTER);
		add(lblStatus,BorderLayout.SOUTH);
		addMouseListener(new MouseAdapterHandle());
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MouseDemo2();
	}
	
	//定义一个内部类，实现鼠标的单击事件
	class MouseAdapterHandle extends MouseAdapter{
		//重新适配器类的MouseClicked函数
		//鼠标点击（单击，双击，右键，左键）
		
		@Override
		public void mouseClicked(MouseEvent e) {

			//单击
			if(e.getClickCount()==1){
				//左键
				if(e.getButton()==1){
					lblStatus.setText("单击鼠标左键事件");
				//右键
				}else if(e.getButton()==3){
					lblStatus.setText("单击鼠标右键事件");
				}
			//双击
			}else if(e.getClickCount()==2){
				lblStatus.setText("双击事件");
			}
		}

	}
}
