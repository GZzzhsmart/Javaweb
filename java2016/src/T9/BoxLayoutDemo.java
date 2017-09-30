package T9;

import java.awt.*;
import javax.swing.*;

import T5Sj.interfaceDemo;
public class BoxLayoutDemo {
	public static void main(String[] args) {
		JFrame jF = new JFrame("BoxLayout Demo");
		
		JButton b1 = new JButton("button1");
		JButton b2 = new JButton("button2");
		JButton b3 = new JButton("button3");
		JButton b4 = new JButton("button4");
		JButton b5 = new JButton("button5");
		JButton b6 = new JButton("button6");
		
		Container c = jF.getContentPane();
		ContainerWithBoxLayout yc = new ContainerWithBoxLayout(BoxLayout.Y_AXIS);
		 ContainerWithBoxLayout xc = new ContainerWithBoxLayout(BoxLayout.X_AXIS);
		 c.setLayout(new FlowLayout());
		 
		 xc.add(b1);
		 xc.add(b2);
		 xc.add(b3);
		 yc.add(b4);
		 yc.add(b5);
		 yc.add(b6);
		 c.add(xc);
		 c.add(yc);
		 
		 jF.setSize(300,400);
		 jF.setVisible(true);
	}
	
}

class ContainerWithBoxLayout extends JPanel{
	public ContainerWithBoxLayout(int orientation){
		setLayout(new BoxLayout(this,orientation));
	}
	
}
