package T16_1;
import java.net.*;
//客户端程序
public class ClientUDP {
	public static void main(String[] args) {
		byte buf[]={'h','e','l','l','o'};
		try{
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("localhost"),8000);
			ds.send(dp);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
