package T16sj;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
//服务器端
public class QQSever {

	public static void main(String[] args) {
		try {
			//设置一个端口
			ServerSocket severt = new ServerSocket(9000);
			//定义一个向量来储存客户端
			Vector vector = new Vector();
			while (true) {
				//等待用户连接
				Socket socket = severt.accept();
				InputStream in = socket.getInputStream();
				vector.add(socket);
				//实例化服务器端口
				new SeverThread(in,vector).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
