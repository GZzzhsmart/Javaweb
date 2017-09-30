package T9sj;
import java.awt.JobAttributes;

import javax.swing.*;
public class InputDialog {
	public static void main(String[] args) {
		String name=JOptionPane.showInputDialog("你叫什么名字");
		String age=JOptionPane.showInputDialog("你多大了？");
		System.out.println("hello,"+name+"你的年龄是"+age);
		//程序退出
		System.exit(0);
	}
}
