package T15;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserReg extends JFrame implements ActionListener{
	
	JLabel lblUserName,lblPassword,lblCfgPwd,lblAge,lblSex;
	JLabel lblQQ,lblEmail,lblRemark,lblCardno,lblTitle;
	
	JTextField txtUserName,txtAge,txtqqcode,txtEmail,txtCardno;
	JComboBox cbsex;
	JPasswordField txtpwd,txtcfgpwd;
	JTextArea txtRemark;
	String sSex[] = {"男","女"};
	JButton btnSave,btnExit;
	
	public UserReg(){
		super("用户注册");
		lblTitle = new JLabel("用户注册");
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(lblTitle);
		
		lblUserName = new JLabel("用户名称",JLabel.RIGHT);
		lblPassword = new JLabel("登录密码",JLabel.RIGHT);
		lblCfgPwd = new JLabel("确认密码",JLabel.RIGHT);
		lblAge = new JLabel("用户年龄",JLabel.RIGHT);
		lblSex = new JLabel("用户性别",JLabel.RIGHT);
		lblQQ = new JLabel("用户QQ",JLabel.RIGHT);
		lblEmail = new JLabel("邮箱地址",JLabel.RIGHT);
		lblRemark = new JLabel("个人说明",JLabel.RIGHT);
		lblCardno = new JLabel("身份证号",JLabel.RIGHT);
		txtUserName = new JTextField();
		txtAge = new JTextField();
		txtqqcode = new JTextField();
		txtEmail = new JTextField();
		txtCardno = new JTextField();
		cbsex = new JComboBox(sSex);
		txtpwd = new JPasswordField();
		txtcfgpwd = new JPasswordField();
		txtRemark = new JTextArea(5,40);
		JPanel centerPanel = new JPanel(new GridLayout(9,2,10,10));
		centerPanel.add(lblUserName);
		centerPanel.add(txtUserName);
		centerPanel.add(lblPassword);
		centerPanel.add(txtpwd);
		centerPanel.add(lblCfgPwd);
		centerPanel.add(txtcfgpwd);
		centerPanel.add(lblSex);
		centerPanel.add(cbsex);
		centerPanel.add(lblAge);
		centerPanel.add(txtAge);
		centerPanel.add(lblCardno);
		centerPanel.add(txtCardno);
		centerPanel.add(lblQQ);
		centerPanel.add(txtqqcode);
		centerPanel.add(lblEmail);
		centerPanel.add(txtEmail);
		centerPanel.add(lblRemark);
		centerPanel.add(txtRemark);
		
		//密码符号
		
		txtpwd.setEchoChar('#');
		txtcfgpwd.setEchoChar('@');
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnExit = new JButton("退出(X)");
		btnExit.setMnemonic('X');
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(btnSave);
		bottomPanel.add(btnExit);
		add(topPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		setSize(400,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new UserReg();
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnExit){
			System.exit(0);
		}else if(e.getSource()==btnSave){

			save2();
		}
	}
	
	//保存(用Statement对象实现新增用户资料的功能)
	public void save(){
		
		if(txtpwd.getText().equals("") || !txtpwd.getText().equals(txtcfgpwd.getText())){
			JOptionPane.showMessageDialog(this, "登录密码与确认密码不一致");
			return;
		}
		try{
			Integer.parseInt(txtAge.getText().trim());
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "年龄含有非法字符");
			return;
		}
		
		try{
			Connection conn = new DBConn().openDB();
			Statement stmt = conn.createStatement();
			String sql = "insert into QQUsers values";
			sql += txtUserName.getText().trim() +"','";
			sql += txtpwd.getText().trim() +"','";
			sql += sSex[cbsex.getSelectedIndex()] +"','";
			sql += txtAge.getText().trim() +"','";
			sql += txtCardno.getText().trim() + "','";
			sql += txtqqcode.getText().trim() + "','";
			sql += txtEmail.getText().trim() + "','";
			sql += txtRemark.getText().trim() + "','";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(this, "注册成功");
			stmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//用PreparedStatement实现新增用户资料的功能
	public void save2(){
		if(txtpwd.getText().equals("") || !txtpwd.getText().equals(txtcfgpwd.getText())){
			JOptionPane.showMessageDialog(this, "登录密码与确认密码不一致");
			return;
		}
		try{
			Integer.parseInt(txtAge.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "年龄含有非法字符");
			return;
		}
		
		try{
			Connection conn = new DBConn().openDB();
			String sql = "insert into QQUsers values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//给每个字段设值
			
			int index = 1;
			pstmt.setString(index++, txtUserName.getText().trim());
			pstmt.setString(index++, txtpwd.getText().trim());
			pstmt.setString(index++, sSex[cbsex.getSelectedIndex()]);
			pstmt.setInt(index++, Integer.parseInt(txtAge.getText().trim()));
			pstmt.setString(index++, txtCardno.getText().trim());
			pstmt.setString(index++, txtqqcode.getText().trim());
			pstmt.setString(index++, txtEmail.getText().trim());
			pstmt.setString(index++, txtRemark.getText().trim());
			
			//保存到数据库
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, "注册成功");
			pstmt.close();
			
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
