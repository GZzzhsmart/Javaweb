package T6_1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class contact extends JFrame implements ActionListener{

	JTable dataTable;
	JLabel lblUsername;
	JTextField txtUsername;
	JButton btnFind;
	//表头的数组
	String head[]={"姓名","电话号码"};
	String data[][];
	public contact() {
		super("家家乐通讯录管理系统");
		//读数据文件到data数组中
		readFile();
		dataTable = new JTable(data,head);
		dataTable.setRowHeight(40);
		add(new JScrollPane(dataTable));
		lblUsername = new JLabel("姓名：");
		txtUsername = new JTextField(20);
		btnFind = new JButton("查找");
		btnFind.addActionListener(this);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(lblUsername);
		bottomPanel.add(txtUsername);
		bottomPanel.add(btnFind);
		add(bottomPanel,BorderLayout.SOUTH);
		setSize(400,450);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//读通讯录文件
	public void readFile(){
		File file= new File("contact.txt");
		if(!file.exists()){
			JOptionPane.showMessageDialog(this, "文件不存在");
			System.exit(0);
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String strLine="";
			String str="";
			while((strLine=br.readLine())!=null){
				str += strLine +";";
			}
			String arr[] = str.split(";");
			int size=arr.length;
			data = new String[size][2];
			for (int i=0;i<size;i++) {
				data[i]=arr[i].split("@");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnFind){
			//读取文本框的内容
			String username = txtUsername.getText().trim();
			int index = -1;
			for(int i=0;i<data.length;i++){
				if(username.equals(data[i][0])){
					index = i;
					break;
				}
			}
			if(index<0){
				JOptionPane.showMessageDialog(this, "没有找到你查找的用户资料");
				return;
			}else{
				//把查找到的用户资料设置为选中状态
				dataTable.setRowSelectionInterval(index, index);
			}
		}
	}
	public static void main(String[] args) {
		new contact();
	}
}
