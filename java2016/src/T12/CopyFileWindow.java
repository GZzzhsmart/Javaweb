package T12;

import java.util.EventListener;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sun.misc.JavaLangAccess;

public class CopyFileWindow extends JFrame implements ActionListener {
	JTextField srctext = new JTextField(20);
	JButton srcButton = new JButton("...");
	JTextField totext = new JTextField(20);
	JButton toButton = new JButton("...");
	JButton copyButton = new JButton("复制");

	public CopyFileWindow() {
		JPanel srcpanel = new JPanel();
		srcpanel.add(new JLabel("请选择要复制的文件："));
		srcpanel.add(srctext);
		srcpanel.add(srcButton);

		JPanel topanel = new JPanel();
		topanel.add(new JLabel("请选择文件存放目录："));
		topanel.add(totext);
		topanel.add(toButton);

		JPanel copypanel = new JPanel();
		copypanel.add(copyButton);

		srcButton.addActionListener(this);
		toButton.addActionListener(this);
		copyButton.addActionListener(this);

		this.setLayout(new GridLayout(3, 1));
		this.add(srcpanel);
		this.add(topanel);
		this.add(copypanel);
		this.setLocation(300, 300);
		this.setResizable(false); // 禁止最大化按钮
		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new CopyFileWindow().show();
	}

	public void actionPerformed(ActionEvent e) {
		// 当点击选择原文件按钮时候
		if (e.getSource() == srcButton) {
			JFileChooser chooser = new JFileChooser(" ");
			chooser.setDialogType(JFileChooser.OPEN_DIALOG);
			// 设置只能选择文件
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setDialogTitle("请选择要复制的文件");
			// 打开对话框并判断是否打开成功
			if (chooser.showOpenDialog(this) == chooser.APPROVE_OPTION) {
				srctext.setText(chooser.getSelectedFile().getAbsolutePath());
			}
		}

		// 当点击选择文件存放按钮的时候
		if (e.getSource() == toButton) {
			JFileChooser chooser = new JFileChooser(" ");
			chooser.setDialogType(JFileChooser.OPEN_DIALOG);
			// 设置只能选择目录
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setDialogTitle("请选择文件存放目录");
			// 打开对话框并判断是否成功
			if (chooser.showOpenDialog(this) == chooser.APPROVE_OPTION) {
				totext.setText(chooser.getSelectedFile().getAbsolutePath());
			}
		}
		// 当选择复制按钮的时候
		if (e.getSource() == copyButton) {
			if (srctext.getText().equals("") || totext.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请选择源文件或目标目录");
			} else {
				File srcfile = new File(srctext.getText());
				String filename = srcfile.getName();
				this.copyFile(srctext.getText(), totext.getText() + "/"
						+ filename);
			}
		}
	}

	// 复制文件的办法
	public void copyFile(String srcfile, String tofile) {
		try {
			FileInputStream fin = new FileInputStream(srcfile);
			FileOutputStream fos = new FileOutputStream(tofile);
			byte[] b = new byte[1024];
			int a;
			// 每次以1024个字节读入
			while ((a = fin.read(b)) > 0) {
				fos.write(b, 0, a);
			}
			System.out.println("拷贝成功！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
