package T16_1;

import java.net.*;
//服务端程序
public class ServerUDP {
	public static void main(String[] args) {
		byte buf[] = new byte[5];
		try{
			DatagramSocket ds = new DatagramSocket (8000);
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			ds.receive(dp);
			for(int i=0;i<buf.length;i++){
				System.out.print((char) buf[i]);
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
