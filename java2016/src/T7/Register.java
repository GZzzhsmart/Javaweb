package T7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Register extends JFrame {

	JPanel panelCenter, panelSouth;
	JLabel lblTitle;
	JButton btnReg, btnClose;

	JLabel lblusername, lblpassword, lblcfgpwd, lblage, lblsex, lblcardno;
	JLabel lblnation, lblhobit, lblRemark;

	// 文本框
	JTextField txtUserName, txtAge, txtCardno;
	// 密码框
	JPasswordField txtpwd, txtcfgpwd;
	// 单选框
	JRadioButton rbmale, rbremale;
	// 下拉列表框
	JComboBox cbNation;
	// 多选框
	JCheckBox cbBasketball, cbFootball, cbsing, cbNet, cbDance, cbBook, cbGame;
	// 文本区域框
	JTextArea txtRemark;
	// 单选分组按钮
	ButtonGroup bgsex;

	public Register() {
		super("用户注册");

		lblTitle = new JLabel("用户注册", JLabel.CENTER);
		lblTitle.setBackground(Color.RED);
		// 设置字体，黑体，粗体，32号字
		lblTitle.setFont(new Font("黑体", Font.BOLD, 32));
		lblTitle.setForeground(Color.RED);
		// 绝对布局(坐标)
		panelCenter = new JPanel(null);
		// 流布局，居中对齐
		panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSouth.setBackground(Color.PINK);
		panelCenter.setBackground(Color.CYAN);
		add(lblTitle, BorderLayout.NORTH);
		add(panelCenter);
		add(panelSouth, BorderLayout.SOUTH);
		btnReg = new JButton("注册");
		btnClose = new JButton("关闭");
		panelSouth.add(btnReg);
		panelSouth.add(btnClose);

		lblusername = new JLabel("用户名称：", JLabel.RIGHT);
		lblusername.setBounds(100, 30, 100, 30);
		txtUserName = new JTextField();
		txtUserName.setBounds(200, 30, 200, 30);
		panelCenter.add(lblusername);
		panelCenter.add(txtUserName);

		lblpassword = new JLabel("登录密码：", JLabel.RIGHT);
		lblpassword.setBounds(100, 70, 100, 30);
		txtpwd = new JPasswordField();
		txtpwd.setBounds(200, 70, 200, 30);
		panelCenter.add(lblpassword);
		panelCenter.add(txtpwd);

		lblcfgpwd = new JLabel("确认密码：", JLabel.RIGHT);
		lblcfgpwd.setBounds(100, 110, 100, 30);
		txtcfgpwd = new JPasswordField();
		txtcfgpwd.setBounds(200, 110, 200, 30);
		panelCenter.add(lblcfgpwd);
		panelCenter.add(txtcfgpwd);

		lblage = new JLabel("年龄：", JLabel.RIGHT);
		lblage.setBounds(100, 150, 100, 30);
		txtAge = new JTextField();
		txtAge.setBounds(200, 150, 200, 30);
		panelCenter.add(lblage);
		panelCenter.add(txtAge);

		lblsex = new JLabel("性别：", JLabel.RIGHT);
		lblsex.setBounds(100, 190, 100, 30);
		rbmale = new JRadioButton("男");
		// 默认选中
		rbmale.setSelected(true);
		rbmale.setBounds(200, 190, 50, 30);
		rbremale = new JRadioButton("女");
		rbremale.setBounds(250, 190, 50, 30);
		bgsex = new ButtonGroup();
		bgsex.add(rbmale);
		bgsex.add(rbremale);

		panelCenter.add(lblsex);
		panelCenter.add(rbmale);
		panelCenter.add(rbremale);

		lblcardno = new JLabel("身份证号码：", JLabel.RIGHT);
		lblcardno.setBounds(100, 230, 100, 30);
		txtCardno = new JTextField();
		txtCardno.setBounds(200, 230, 200, 30);
		panelCenter.add(lblcardno);
		panelCenter.add(txtCardno);

		lblnation = new JLabel("民族：", JLabel.RIGHT);
		lblnation.setBounds(100, 270, 100, 30);
		String[] snation = { "汉族", "壮族", "苗族", "侗族", "朝鲜族", "高山族", "维吾尔族",
				"其他民族" };
		cbNation = new JComboBox(snation);
		cbNation.setBounds(200, 270, 200, 30);
		panelCenter.add(lblnation);
		panelCenter.add(cbNation);

		lblhobit = new JLabel("兴趣爱好：", JLabel.RIGHT);
		lblhobit.setBounds(100, 310, 100, 30);
		cbBasketball = new JCheckBox("篮球");
		cbFootball = new JCheckBox("足球");
		cbsing = new JCheckBox("唱歌");
		cbNet = new JCheckBox("上网");
		cbDance = new JCheckBox("跳舞");
		cbBook = new JCheckBox("看书");
		cbGame = new JCheckBox("游戏");
		cbBasketball.setBounds(200, 310, 60, 30);
		cbFootball.setBounds(260, 310, 60, 30);
		cbsing.setBounds(320, 310, 60, 30);
		cbNet.setBounds(380, 310, 60, 30);
		cbDance.setBounds(200, 350, 60, 30);
		cbBook.setBounds(260, 350, 60, 30);
		cbGame.setBounds(320, 350, 60, 30);
		panelCenter.add(lblhobit);
		panelCenter.add(cbBasketball);
		panelCenter.add(cbFootball);
		panelCenter.add(cbsing);
		panelCenter.add(cbNet);
		panelCenter.add(cbDance);
		panelCenter.add(cbBook);
		panelCenter.add(cbGame);

		lblRemark = new JLabel("个人说明：", JLabel.RIGHT);
		lblRemark.setBounds(100, 390, 100, 30);
		txtRemark = new JTextArea();
		txtRemark.setBounds(200, 390, 200, 80);
		// 创建一个滚动面板
		JScrollPane jsp = new JScrollPane(txtRemark);
		jsp.setBounds(200, 390, 200, 80);
		panelCenter.add(lblRemark);
		panelCenter.add(jsp);

		ActionHandle handler = new ActionHandle();
		btnReg.addActionListener(handler);
		btnClose.addActionListener(handler);

		setSize(550, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Register();
	}

	class ActionHandle implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnReg) {
				// 用户名不能为空
				if (txtUserName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					// 获取焦点
					txtUserName.requestFocus();
					return;
				}
				// 密码不能为空
				if (txtpwd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					txtpwd.requestFocus();
					return;
				}
				if (!txtpwd.getText().equals(txtcfgpwd.getText())) {
					JOptionPane.showMessageDialog(null, "登录密码与确认密码不一致");
					txtcfgpwd.requestFocus();
					return;
				}
				if (txtAge.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入年龄");
					txtAge.requestFocus();
					return;
				}
				int age = 0;
				try {
					age = Integer.parseInt(txtAge.getText().trim());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "年龄必须在0~150之间的数字字符");
					txtAge.requestFocus();
					return;
				}
				if (age < 0 || age > 150) {
					JOptionPane.showMessageDialog(null, "年龄必须在0~150之间的数字字符");
					txtAge.requestFocus();
					return;
				}
				if (txtCardno.getText().trim().length() != 18) {
					JOptionPane.showMessageDialog(null, "身份证号码必须为18位");
					txtCardno.requestFocus();
					return;

				}
				JOptionPane.showMessageDialog(null, "恭喜你，注册成功！！！！");
			} else if (e.getSource() == btnClose) {
				System.exit(0);
			}

		}

	}
}
