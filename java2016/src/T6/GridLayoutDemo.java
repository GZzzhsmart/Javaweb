package T6;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class GridLayoutDemo extends Frame {

	//定义控件
	Label lblUsername,lblPassword;
	TextField txtUsername,txtPassword;
	Button btnOk,btnClose;
	Panel panel;
	public GridLayoutDemo() {
		super("网格布局");
		panel = new Panel(new GridLayout(3,2,10,10));
		lblUsername = new Label("用户名称",Label.RIGHT);
		lblPassword = new Label("登陆密码",Label.RIGHT);
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
		
		setSize(400,200);
		setVisible(true);
	}
	public static void main(String[] args){
		new GridLayoutDemo();
	}
}
