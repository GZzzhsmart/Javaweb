package T7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.ActionBase;
public class Login extends JFrame{
	JButton btnLogin,btnCancel;
	JLabel lblUser,lblPass;
	JTextField txtUser;
	JPasswordField txtPass;
	public Login(){
		btnLogin = new JButton(" 登 录 ");
		//默认布局BorderLayout
		add(btnLogin);
		//创建Action事件的对象
		ActionHandle actionHandle = new ActionHandle();
		//绑定Action事件
		btnLogin.addActionListener((ActionListener) actionHandle);
		setSize(300,300);
		setVisible(true);
		//设置窗口居中
		setLocationRelativeTo(null);
		//点击关闭按钮时退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new Login();
	}
	//定义一个Action的内部类实现ActionListener的接口
	class ActionHandle implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "Action事件发生了");
			
		}
	}
}
	

