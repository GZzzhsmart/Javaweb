package T6;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class FrameDemo3 extends Frame {

	//定义控件
	Label lblUsername,lblPassword;
	TextField txtUsername,txtPassword;
	Button btnOk,btnClose;
	Panel panel;
	
	public FrameDemo3() {
		super("布局管理器演示");
		panel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		lblUsername = new Label("用户名称：");
		lblPassword = new Label("登陆密码：");
		txtUsername = new TextField(10);
		txtPassword = new TextField(10);
		btnOk = new Button("确定");
		btnClose = new Button("关闭");
		
		panel.add(lblUsername);
		panel.add(txtUsername);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel.add(btnOk);
		panel.add(btnClose);
		add(panel);
		
		setSize(400,500);
		setVisible(true);
	}
	public static void main(String[] args){
		new FrameDemo3();
	}
}
