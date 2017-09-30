package T11sj;

/**
 * 结合前面GUI编程知识，实现一个简单的订单管理系统，
 *  只需要实现添加，查找（根据订单id查找）的功能即可
 * */
import java.awt.color.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ArrayListSearch extends JFrame implements ActionListener,
		KeyListener {
	JLabel lblOrderid, lblOrderName, lblPrice, lblAddr;
	JTextField txtOrderId, txtOrderName, txtPrice, txtAddr;
	JButton btnAdd, btnSearch;
	ArrayList<Orders> OrderList;

	public ArrayListSearch() {
		super("订单管理");
		Container c = getContentPane();
		c.setLayout(new GridLayout(5, 2, 5, 5));
		c.setBackground(Color.pink);

		lblOrderid = new JLabel("订单号：", JLabel.RIGHT);
		lblOrderName = new JLabel("订单名称：", JLabel.RIGHT);
		lblPrice = new JLabel("订单价格：", JLabel.RIGHT);
		lblAddr = new JLabel("订单地址：", JLabel.RIGHT);
		txtOrderId = new JTextField();
		txtOrderName = new JTextField();
		txtPrice = new JTextField();
		txtAddr = new JTextField();
		btnAdd = new JButton("保存(S)");
		btnAdd.setMnemonic('S');
		btnSearch = new JButton("查找(F)");
		btnSearch.setMnemonic('F');
		btnAdd.addActionListener(this);
		btnSearch.addActionListener(this);
		txtOrderId.addKeyListener(this);

		c.add(lblOrderid);
		c.add(txtOrderId);
		c.add(lblOrderName);
		c.add(txtOrderName);
		c.add(lblPrice);
		c.add(txtPrice);
		c.add(lblAddr);
		c.add(txtAddr);
		c.add(btnAdd);
		c.add(btnSearch);

		OrderList = new ArrayList<Orders>();

		setSize(300, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new ArrayListSearch();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			// Orders ord = new
			// Orders(txtOrderId.getText(),txtOrderName.getText(),Double.parseDouble(txtPrice.getText()),txtAddr.getText());
			Orders ord = new Orders();
			ord.setOrderId(txtOrderId.getText());
			ord.setOrderName(txtOrderName.getText());
			ord.setPrice(Double.parseDouble(txtPrice.getText()));
			ord.setAddress(txtAddr.getText());
			OrderList.add(ord);
			String str = "编号为" + ord.getOrderId() + "的订单信息如下:\n";
			str += "订单名称:" + ord.getOrderName() + "\n";
			str += "订单价格:" + ord.getPrice() + "\n";
			str += "订单地址:" + ord.getAddress();
			JOptionPane.showMessageDialog(this, str, "订单信息",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getSource() == btnSearch) {
			String orderid = txtOrderId.getText();// 获取订单号
			for (Orders order : OrderList) {
				if (order.getOrderId().equals(orderid)) {
					String str = "编号为" + order.getOrderId() + "的订单信息如下:\n";
					str += "订单名称:" + order.getOrderName() + "\n";
					str += "订单价格:" + order.getPrice() + "\n";
					str += "订单地址:" + order.getAddress();
					JOptionPane.showMessageDialog(this, str, "订单信息",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

		if (e.getSource() == txtOrderId) {
			// 10表示回车键
			if (e.getKeyCode() != 10)
				return;

			String orderid = txtOrderId.getText();// 获取订单号
			for (Orders order : OrderList) {
				if (order.getOrderId().equals(orderid)) {
					txtOrderName.setText(order.getOrderName());
					txtPrice.setText(order.getPrice() + "");
					txtAddr.setText(order.getAddress());
					break;
				}
			}
		}

	}

	public void keyTyped(KeyEvent e) {

	}
}
