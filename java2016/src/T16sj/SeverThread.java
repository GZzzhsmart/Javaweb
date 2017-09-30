package T16sj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

//服务器类，继承线程类
public class SeverThread extends Thread{

	//输入流
	InputStream in;
	//保存所有的客户端
	Vector allsocket;
	public SeverThread(InputStream in,Vector allsocket) {
		this.in = in;
		this.allsocket=allsocket;
	}
	@Override
	public void run() {
		//读出用户的信息
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			//死循环
			while (true) {
				//一行一行的读取内容，谨记打印语句只能够ln否则无法读取
				String str = br.readLine();
				System.out.println("服务器收到信息："+str);
				//得到一个客户端
				for (int i = 0; i < allsocket.size(); i++) {
					Object obj = allsocket.get(i);
					//强制转化成客户端
					Socket socket = (Socket)obj;
					//得到一个输出流socket
					PrintWriter pw = new PrintWriter(socket.getOutputStream());
					//打印内容
					pw.println(str);
					//刷新界面
					pw.flush();
				}
				System.out.println("消息发送完毕！！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
