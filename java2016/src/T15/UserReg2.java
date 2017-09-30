package T15;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * create table QQUsers
(
	userid int identity(1,1) primary key,
	userName varchar(20) not null unique,
	password varchar(20),
	sex char(2) default '男',
	age int ,
	cardno varchar(18),
	qqCode varchar(20),
	email varchar(50),
	remark varchar(500)	
)
 * 
 * 
 * */
public class UserReg2 extends JFrame implements ActionListener{

	JLabel lblUserName,lblPassword,lblCfgPwd,lblAge,lblSex;
	JLabel lblQQ,lblEmail,lblRemark,lblCardno,lblTitle;
	JTextField txtUserName,txtAge,txtqqCode,txtEmail,txtCardno;
	JComboBox cbSex;
	JPasswordField txtPwd,txtCfgPwd;
	JTextArea txtRemark;
	String sSex[] ={"男","女"};
	JButton btnSave,btnExit,btnFind;
	
	public UserReg2() {
		super("用户注册");
		lblTitle = new JLabel("用户注册");
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(lblTitle);
		lblUserName =  new JLabel("用户名称：",JLabel.RIGHT);
		lblPassword =  new JLabel("登录密码：",JLabel.RIGHT);
		lblCfgPwd =  new JLabel("确认密码：",JLabel.RIGHT);
		lblAge =  new JLabel("用户年龄：",JLabel.RIGHT);
		lblSex =  new JLabel("用户性别：",JLabel.RIGHT);
		lblQQ =  new JLabel("QQ号码：",JLabel.RIGHT);
		lblEmail =  new JLabel("邮箱地址：",JLabel.RIGHT);
		lblRemark =  new JLabel("个人说明：",JLabel.RIGHT);
		lblCardno =  new JLabel("身份证号：",JLabel.RIGHT);
		txtUserName = new JTextField();
		txtAge = new JTextField();
		txtqqCode = new JTextField();
		txtEmail = new JTextField();
		txtCardno = new JTextField();
		cbSex = new JComboBox(sSex);
		txtPwd = new JPasswordField();
		txtCfgPwd = new JPasswordField();
		txtRemark = new JTextArea(5,40);
		JPanel centerPanel = new JPanel(new GridLayout(9,2,10,10));
		centerPanel.add(lblUserName);
		centerPanel.add(txtUserName);
		centerPanel.add(lblPassword);
		centerPanel.add(txtPwd);
		centerPanel.add(lblCfgPwd);
		centerPanel.add(txtCfgPwd);
		centerPanel.add(lblSex);
		centerPanel.add(cbSex);
		centerPanel.add(lblAge);
		centerPanel.add(txtAge);
		centerPanel.add(lblCardno);
		centerPanel.add(txtCardno);
		centerPanel.add(lblQQ);
		centerPanel.add(txtqqCode);
		centerPanel.add(lblEmail);
		centerPanel.add(txtEmail);
		centerPanel.add(lblRemark);
//		centerPanel.add(new JScrollPane(txtRemark));
		centerPanel.add(txtRemark);
		//密码符号
		txtPwd.setEchoChar('#');
		txtCfgPwd.setEchoChar('@');
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnExit = new JButton("退出(X)");
		btnExit.setMnemonic('X');
		btnFind = new JButton("查找(F)");
		btnFind.setMnemonic('F');
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
		btnFind.addActionListener(this);
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(btnSave);
		bottomPanel.add(btnExit);
		bottomPanel.add(btnFind);
		
		add(topPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new UserReg2();
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnExit){
			System.exit(0);
		}else if(e.getSource()==btnSave){
			save();
		}else if(e.getSource()==btnFind){
			new UserListUI();
		}
	}
	//保存(用Statement对象实现新增用户资料的功能)
	public void save(){
		if(txtPwd.getText().equals("") || !txtPwd.getText().equals(txtCfgPwd.getText())){
			JOptionPane.showMessageDialog(this, "登录密码与确认密码不一致");
			return;
		}
		try{
			Integer.parseInt(txtAge.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "年龄含有非法字符");
			return;
		}
		String userName = txtUserName.getText().trim();
		IUserDAO userdao = new UserDaoImpl();
		if(userdao.isExists(userName)){
			JOptionPane.showMessageDialog(null, "用户名已经存在，请输入其他用户名称.");
			return;
		}
		
		UserVo user = new UserVo();
		user.setUsername(userName);
		user.setPassword(txtPwd.getText().trim());
		user.setAge(Integer.parseInt(txtAge.getText().trim()));
		user.setSex(sSex[cbSex.getSelectedIndex()]);
		user.setCardno(txtCardno.getText().trim());
		user.setEmail(txtEmail.getText().trim());
		user.setQqcode(txtqqCode.getText().trim());
		user.setRemark(txtRemark.getText().trim());
		//与底层数据库类建立联系
		userdao.add(user);
		JOptionPane.showMessageDialog(this, "保存成功！！！");
		
		
	}
}
