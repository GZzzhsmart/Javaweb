package T17;

import javax.swing.JFrame;

public class TestDemo2 {

	public static void main(String[] args) {
		try {
			JFrame jframe = (JFrame)Class.forName("javax.swing.JFrame").newInstance();
			JFrame jframe2 = new JFrame();
			jframe2.setSize(300,400);
			jframe2.setVisible(true);
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
