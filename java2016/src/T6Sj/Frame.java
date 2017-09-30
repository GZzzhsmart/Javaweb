package T6Sj;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import com.sun.corba.se.spi.orbutil.fsm.ActionBase;
public class Frame extends JFrame{
	JButton btnLogin,btnCancel;
	JLabel lblUser,lblPass;
	JTextField txtUser;
	JPasswordField txtPass;
	public Frame(){
		lblUser = new JLabel("姓名",JLabel.LEFT);
		lblPass = new JLabel("密码",JLabel.LEFT);
		txtUser = new JTextField();
		txtPass = new JPasswordField();
		btnLogin = new JButton("登录");
		btnCancel = new JButton("取消");
		//设置窗口的GridLayout布局
		Container con = getContentPane();
		con.setLayout(new GridLayout(4,4));
		
		add(lblUser);
		add(txtUser);
		add(lblPass);
		add(txtPass);
		add(btnLogin);
		add(btnCancel);
		//创建Action事件的对象
		ActionHandle actionHandle = new ActionHandle();
		ActionListener actionHandel = null;
		//绑定Action事件
		btnLogin.addActionListener(actionHandel);
		btnCancel.addActionListener(actionHandle);
		setSize(200,160);
		setVisible(true);
		//设置窗口居中
		setLocationRelativeTo(null);
		//点击关闭按钮时退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new Frame();
	}
	class ActionHandle implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//getSource函数获取当前发生事件的控件名称
			if(e.getSource()==btnLogin){
				//getText获取文本框的内容
				//trim函数删除字符串2端的空格
				String txtUseraname=txtUser.getText().trim();
				char[] txtusername = null;
				System.out.println(txtusername);
				String txtPassword=txtPass.getText().trim();
				if(txtusername.equals("admin") && txtPassword.equals("1234")){
					JOptionPane.showMessageDialog(null, "登录成功");
				}else{
					JOptionPane.showMessageDialog(null,"用户名或密码错误，登录失败");
				}
			}else if(e.getSource()==btnCancel){
				JOptionPane.showMessageDialog(null, "窗口马上要关闭");
				//exit函数：关闭窗口，退出程序
				System.exit(0);
			}
			
		}
		
	}
}
