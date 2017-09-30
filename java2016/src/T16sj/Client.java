package T16sj;

import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.io.*;
import javax.swing.JComboBox;
import java.net.*;
import java.awt.event.ItemListener;
//客户端程序
public class Client extends Frame implements ActionListener,ItemListener{

	//窗体应该有发送按钮、文本框用来输入东西、List列表用来显示信息
	Button connectbutton=new Button("连接");
    Button sendbutton=new Button("发送");
    
    List list =new List();
    TextField content=new TextField(20);
    TextField servername=new TextField(20);
    Label label=new Label("输入服务器名字：");
    JComboBox jComboBox1 = new JComboBox();


    Socket socket;
	String ren="";
    public Client(){
        
        sendbutton.addActionListener(this);
        connectbutton.addActionListener(this);
        jComboBox1.addItemListener(this);
        Panel p1=new Panel();
        p1.add(label);
        p1.add(servername);
        p1.add(connectbutton);
        
        Panel p2=new Panel();
        p2.add(jComboBox1);
        p2.add(content);
        p2.add(sendbutton);
        
        
        Panel p3=new Panel();
        p3.setLayout(new BorderLayout());
       
        p3.add("South",p2);
        p3.add(list);
        
        this.add("South",p1);
        this.add("Center",p3);
        
        this.setSize(400,400);
        this.jComboBox1.addItem("所有人");

    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connectbutton){
            if(!servername.getText().equals("")){
                try {
                    String fuwuqi=servername.getText();
                    socket = new Socket(fuwuqi,9000);
                    new CInputStream(socket.getInputStream()).start();
                    PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
                    pw.println("CLogin:");
                    this.connectbutton.setEnabled(false);
                    this.servername.setText("");
                }catch (IOException ex2)
                {
                	ex2.printStackTrace();
                }
            }
            else
            {

                javax.swing.JOptionPane.showMessageDialog(null,"请输入要连接的服务器名称");
            }

        }
        else
        {
            try{
                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
                String shuo=content.getText();
               
                System.out.println("ren"+ren);
                if(ren.equals("所有人")){
                    pw.println("CAll:"+this.getTitle()+"-"+ren+"="+shuo);

                    this.list.add("你对"+ren+"说"+shuo);
                    System.out.println("CAll:"+this.getTitle()+"-"+ren+"="+shuo);
                }
                else
                {
                    pw.println("COne:"+this.getTitle()+"-"+ren+"="+shuo);
                    this.list.add("你对"+ren+"说:"+shuo);
                    System.out.println("Cone"+"__________________________________");
                }
            }catch (IOException ex) {
                ex.printStackTrace();   
            }
        }
    }


	public void itemStateChanged(ItemEvent e) {
	 	ren=(String)jComboBox1.getSelectedItem();
	}
	
	public static void main(String[] args) {
        
        Client c=new Client();
        QQClient.f=c;
        c.show();
    }
}
 class QQClient{
	public static Client f;
}