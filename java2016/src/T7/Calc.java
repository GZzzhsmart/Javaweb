package T7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener, KeyListener {

	JTextField txtResult;
	JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	JButton btnAdd, btnSub, btnTimes, btnDiv, btnEquals, btnDot;
	JButton btnClear, btnExit;
	JPanel centerPanel, southPanel;
	double num1 = 0, num2 = 0, result = 0;
	String opr = "+";

	public Calc() {
		setTitle("计算器2016");
		txtResult = new JTextField("0.0");
		// 只读
		// txtResult.setEditable(false);
		
		centerPanel = new JPanel(new GridLayout(4, 4, 5, 5));
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		add(txtResult, BorderLayout.NORTH);
		txtResult.addKeyListener(this);
		add(centerPanel);
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnTimes = new JButton("*");
		btnDiv = new JButton("/");
		btnDot = new JButton(".");
		btnEquals = new JButton("=");
		centerPanel.add(btn7);
		centerPanel.add(btn8);
		centerPanel.add(btn9);
		centerPanel.add(btnDiv);
		centerPanel.add(btn4);
		centerPanel.add(btn5);
		centerPanel.add(btn6);
		centerPanel.add(btnTimes);
		centerPanel.add(btn1);
		centerPanel.add(btn2);
		centerPanel.add(btn3);
		centerPanel.add(btnSub);
		centerPanel.add(btn0);
		centerPanel.add(btnDot);
		centerPanel.add(btnEquals);
		centerPanel.add(btnAdd);

		add(southPanel, BorderLayout.SOUTH);
		btnClear = new JButton("清除");
		btnExit = new JButton("关闭");
		southPanel.add(btnClear);
		southPanel.add(btnExit);

		// 监听
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnTimes.addActionListener(this);
		btnDiv.addActionListener(this);
		btnDot.addActionListener(this);
		btnEquals.addActionListener(this);
		btnClear.addActionListener(this);
		btnExit.addActionListener(this);

		setSize(300, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Calc();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			txtResult.setText("0");
		} else if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btn0) {
			setText("0");
		} else if (e.getSource() == btn1) {
			setText("1");
		} else if (e.getSource() == btn2) {
			setText("2");
		} else if (e.getSource() == btn3) {
			setText("3");
		} else if (e.getSource() == btn4) {
			setText("4");
		} else if (e.getSource() == btn5) {
			setText("5");
		} else if (e.getSource() == btn6) {
			setText("6");
		} else if (e.getSource() == btn7) {
			setText("7");
		} else if (e.getSource() == btn8) {
			setText("8");
		} else if (e.getSource() == btn9) {
			setText("9");
		} else if (e.getSource() == btnDot) {
			setText(".");
		} else if (e.getSource() == btnAdd) {
			opr = "+";
			operator();
			// 清空内容
			txtResult.setText("");
		} else if (e.getSource() == btnSub) {
			opr = "-";
			operator();
			// 清空内容
			txtResult.setText("");
		} else if (e.getSource() == btnTimes) {
			opr = "*";
			operator();
			// 清空内容
			txtResult.setText("");
		} else if (e.getSource() == btnDiv) {
			opr = "/";
			operator();
			// 清空内容
			txtResult.setText("");
		} else if (e.getSource() == btnEquals) {
			operator();
			txtResult.setText(result + "");
			num1 = num2 = result = 0;
		}

	}

	public void setText(String s) {
		// 获取文本框的值
		String str = txtResult.getText().trim();
		// 如果文本框里面的值是0，那么初始化为空值
		if (str.equals("") || Double.parseDouble(str) == 0) {
			str = "";
		}
		str += s;
		// 设置文本框的值
		txtResult.setText(str);
	}

	public void operator() {
		if (txtResult.getText().equals("")) {
			num1 = 0;
		} else {
			num1 = Double.parseDouble(txtResult.getText().trim());
		}
		System.out.println("num1=" + num1 + ";num2=" + num2);
		if (opr.equals("+")) {
			result = num1 + num2;
		} else if (opr.equals("-")) {
			result = num2 - num1;
		} else if (opr.equals("*")) {
			result = num1 * num2;
		} else if (opr.equals("/")) {
			result = num2 / num1;
		}
		num2 = num1;
	}

	String m_temp;

	public void keyPressed(KeyEvent e) {
		m_temp = txtResult.getText();

	}

	public void keyReleased(KeyEvent e) {
		try {
			Double.parseDouble(txtResult.getText());
		} catch (Exception ex) {
			txtResult.setText(m_temp);
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
