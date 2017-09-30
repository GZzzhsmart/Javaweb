package T9;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class LabelDemo extends JFrame{
	JLabel lblbg;
	JLabel image1,image2,image3;
	public LabelDemo(){
		Icon bgIcon = new ImageIcon("images/111.jpg");
		lblbg = new JLabel(bgIcon);
		add(lblbg);
		
		lblbg.setLayout(new FlowLayout());
		Icon imag1 = new ImageIcon("images/white.gif");
		image1 = new JLabel("白子",imag1,JLabel.RIGHT);
		ImageIcon img1 = new ImageIcon("images/black.gif");
		image2 = new JLabel("黑子",img1,JLabel.RIGHT);
		img1 = new ImageIcon("images/Board.gif");
		image3 = new JLabel(img1);
		//image1放在lblbg上面
		lblbg.add(image1);
		lblbg.add(image2);
		lblbg.add(image3);
		
		setSize(800,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new LabelDemo();
	}
}
