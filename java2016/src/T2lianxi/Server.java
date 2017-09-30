package T2lianxi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try{
			//创建服务器端
			ServerSocket serverSocket = new ServerSocket(8888,5);
			System.out.println("服务器启动成功："+serverSocket.toString());
			//等待客户连接
			Socket clientSocket = serverSocket.accept();
			System.out.println("等待连接....");
			//绑定输入流
			InputStream is = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//绑定输出流
			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			//接收数据
			System.out.println("服务器接收数据："+br.readLine());
			//发送数据
			String str = "欢迎连接到本服务器.";
			ps.println(str);
			//关闭socket通信
			clientSocket.close();
			serverSocket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
