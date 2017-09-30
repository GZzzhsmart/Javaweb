package T7;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login3 extends JFrame  implements ActionListener{

	JButton btnLogin,btnCancel;
	JLabel lblUser,lblPass;
	JTextField txtUser;
	JPasswordField txtPass;
	public Login3() {
		lblUser = new JLabel("用户名称：",JLabel.RIGHT);
		lblPass = new JLabel("登录密码：",JLabel.RIGHT);
		txtUser = new JTextField();
		txtPass = new JPasswordField();
		btnLogin = new JButton("登录");
		btnCancel = new JButton("关闭");
		//设置窗口的GridLayout布局
		Container con = getContentPane();
		con.setLayout(new GridLayout(3,2,10,20));
		
		add(lblUser);
		add(txtUser);
		add(lblPass);
		add(txtPass);
		add(btnLogin);
		add(btnCancel);
		//监听
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		//创建KeyHandle类的实例
		KeyHandle keyhandle= new KeyHandle();
		//监听键盘事件
		txtUser.addKeyListener(keyhandle);
		txtPass.addKeyListener(keyhandle);
		
		setSize(300, 300);
		setVisible(true);
		//设置窗口居中
		setLocationRelativeTo(null);
		//点击关闭按钮时退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Login3();
	}
	
	//定义一个Action的内部类实现ActionListener接口
	public void actionPerformed(ActionEvent e) {
		
		//getSource函数获取当前发生事件的控件名称
		if(e.getSource()==btnLogin){
			//getText获取文本框的内容
			//trim函数删除字符串2端的空格
			String txtusername = txtUser.getText().trim();
			System.out.println(txtusername);
			String txtpassword = txtPass.getText().trim();
			if(txtusername.equals("admin") && txtpassword.equals("1234")){
				JOptionPane.showMessageDialog(this, "登录成功");
			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误，登录失败");
			}
		}else if(e.getSource()==btnCancel){
			JOptionPane.showMessageDialog(null, "窗口马上要关闭");
			//exit函数：关闭窗口，退出程序
			System.exit(0);
		}
	}
	//键盘事件KeyEvent
	class KeyHandle implements KeyListener{

		//按键down
		public void keyPressed(KeyEvent e) {
			
		}
		//放开按键up
		public void keyReleased(KeyEvent e) {
			if(e.getSource()==txtUser){
				String user = txtUser.getText();
				try{
					Long.parseLong(user);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "用户名称只允许0~9之间的数字");

					return;
				}
			}else if(e.getSource()==txtPass){
				JOptionPane.showMessageDialog(null, "键盘事件发生了:"+txtPass.getText());
			}
		}
		public void keyTyped(KeyEvent e) {
			
		}
	}
}
