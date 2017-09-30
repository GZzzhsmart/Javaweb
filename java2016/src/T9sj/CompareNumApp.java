package T9sj;
//	通过swing的窗口对话框接收两个数字，比较大小
import java.awt.*;
import javax.swing.*;

import T5Sj.interfaceDemo;
public class CompareNumApp extends JFrame{
	int firstNum;
	int secondNum;
	public CompareNumApp(){
		super("比较两个数的大小");
		this.setSize(180,160);
		this.compartNum();
		this.setVisible(true);
		
	}
	private void compartNum() {
		String first = 
			JOptionPane.showInputDialog(this,"请输入第一个数字");
		firstNum = Integer.parseInt(first);
		String second = 
			JOptionPane.showInputDialog(this,"请输入第二个数字");
		secondNum = Integer.parseInt(second);
		if(firstNum>secondNum){
			JOptionPane.showConfirmDialog(this, firstNum+">"+secondNum);
		}else if(firstNum<secondNum){
			JOptionPane.showConfirmDialog(this, firstNum+"<"+secondNum);
		}else{
			JOptionPane.showConfirmDialog(this, firstNum+"="+secondNum);
		}
	}
	public static void main(String[] args) {
		new CompareNumApp();
	}
}
