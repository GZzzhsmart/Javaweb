package T7;

/**
 * 完善计算机的功能，能让计算机实现基本的计算功能
 * 
 * */
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class OperaterPro extends Frame implements ActionListener {
	boolean start = true;
	String op = "=";
	double arg = 0;
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	Panel p4 = new Panel();
	Panel p5 = new Panel();
	TextField num = new TextField(18);
	Button qingkong = new Button("清空");
	Button exit = new Button("退出");

	public OperaterPro() {
		super("计算机窗体");
		this.setLayout(new BorderLayout());
		p1.add(num);
		p2.setLayout(new GridLayout(4, 4));
		String Buttons = "789/456*123-0.=+";
		for (int i = 0; i < Buttons.length(); i++) {
			this.addButton(p2, Buttons.substring(i, i + 1));
		}
		qingkong.addActionListener(this);
		exit.addActionListener(this);
		p3.add(qingkong);
		p3.add(exit);

		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		this.add(p4, BorderLayout.EAST);
		this.add(p5, BorderLayout.WEST);
		this.setSize(190, 170);
		this.setVisible(true);
	}

	private void addButton(Container c, String S) {
		Button b = new Button(S);
		c.add(b);
		b.addActionListener(this);
	}

	public static void main(String[] args) {
		new OperaterPro();
	}

	public void actionPerformed(ActionEvent e) {
		String S = e.getActionCommand();
		System.out.println(S + "");
		if ('0' < S.charAt(0) && S.charAt(0) <= '9') {
			if (start) {
				num.setText(S);
			} else
				num.setText(num.getText() + S);
			start = false;
		} else if (S.equals(".")) {
			if (start) {
				num.setText("0" + S);
			}
			start = false;
		} else {
			if (start) {
				if (S.equals("-")) {
					num.setText(S);
					start = false;
				} else
					op = S;
			} else {
				double x = Double.parseDouble(num.getText());
				Operation(x);
				op = S;
				start = true;
			}
		}
		if (S.equals("清空")) {
			num.setText("0");
			start = true;
		}
		if (S.equals("退出")) {
			System.exit(1);
		}
	}

	private void Operation(double n) {
		if (op.equals("+"))
			arg += n;
		else if (op.equals("-"))
			arg -= n;
		else if (op.equals("*"))
			arg *= n;
		else if (op.equals("/"))
			arg /= n;
		else if (op.equals("="))
			arg = n;
		num.setText("" + arg);

	}

}
