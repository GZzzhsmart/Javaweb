package T7;
/*
 * 通过事件来关闭窗口
 * */
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.awt.event.ActionListener;
public class WindowApp extends Frame implements WindowListener,ActionListener{
	Button close = new Button("退出程序");
	public WindowApp(){
		super("窗体事件");
		this.setLayout(new FlowLayout());
		this.add(close);
		close.addActionListener(this);
		this.setSize(180,160);
		this.addWindowListener(this);
		this.setVisible(true);
	}
	public void windowActivated(WindowEvent e) {
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {
	
	}

	public void windowDeiconified(WindowEvent e) {
		
	}

	public void windowIconified(WindowEvent e) {
		
	}

	public void windowOpened(WindowEvent e) {
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==close){
			System.exit(1);
		}
	}
	public static void main(String[] args){
		new WindowApp();
	}
}
