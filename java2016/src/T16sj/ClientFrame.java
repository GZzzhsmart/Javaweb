package T16sj;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientFrame extends Frame implements ActionListener{

	Button lianjie,fasong;
	List list;
	Label tishi;
	TextField xinxi,maincom;
	Socket socket;
	Panel p1,p2,p3;
	
	public ClientFrame() {
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		lianjie = new Button("连接");
		fasong = new Button("发送");
		lianjie.addActionListener(this);
		fasong.addActionListener(this);
		list = new List();
		socket = new Socket();
		xinxi = new TextField(50);
		maincom = new TextField(20);
		tishi = new Label("请输入服务器名称");
		p1.add(tishi);
		p1.add(maincom);
		p1.add(lianjie);
		
		p2.add(xinxi);
		p2.add(fasong);
		
		p3.setLayout(new BorderLayout());
		p3.add("South",p2);
		p3.add(list);
		this.add("South",p1);
		add(p3);
		setSize(500, 500);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==lianjie) {
			try {
				socket = new Socket(maincom.getText(),9000);
				lianjie.setEnabled(false);
				JOptionPane.showMessageDialog(this, "连接成功了！聊天吧！！1");
				//new ClinerThread(socket.getInputStream(),list).start();
				new ClinerThread(socket.getInputStream(),list).start();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "连接失败！");
				e1.printStackTrace();
			} 
		}else {
			try {
				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(out,true);
				pw.println(xinxi.getText());
				xinxi.setText("");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	
}
