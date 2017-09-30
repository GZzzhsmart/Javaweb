package T6;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class FixDemo extends Frame{
	
	Label lblUsername,lblPassword;
	TextField txtUsername,txtPassword;
	Button btnOk,btnClose;
	Panel panel;
	public FixDemo() {
		panel=new Panel(null);
		lblUsername = new Label("用户名称：",Label.RIGHT);
		lblUsername.setSize(80,20);
		lblUsername.setLocation(50,50);
		txtUsername = new TextField(10);
		txtUsername.setSize(200,20);
		txtUsername.setLocation(130,50);
		lblPassword = new Label("登陆密码：",Label.RIGHT);
		lblPassword.setSize(80,20);
		lblPassword.setLocation(50,90);
		txtPassword = new TextField(10);
		txtPassword.setSize(200,20);
		txtPassword.setLocation(130,90);
		btnOk = new Button("确定");
		btnOk.setSize(80,20);
		btnOk.setLocation(100,130);
		btnClose = new Button("关闭");
		btnClose.setSize(80,20);
		btnClose.setLocation(200,130);
		panel.add(lblUsername);
		panel.add(txtUsername);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel.add(btnOk);
		panel.add(btnClose);
		add(panel);
		setSize(400,300);
		setVisible(true);
	}
	public static void main(String[] args){
		new FixDemo();
	}
}
