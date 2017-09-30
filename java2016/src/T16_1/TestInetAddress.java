package T16_1;

import java.io.*;
import java.net.*;

public class TestInetAddress {
	public static void main(String[] args) {
		try{
			//通过域名获取IP地址
			InetAddress address = InetAddress.getByName("http://www.jxeea.cn/");
			System.out.println(address);
			//打印http://www.jxeea.cn/的IP地址组
			InetAddress allAddress[] = InetAddress.getAllByName("http://www.jxeea.cn/");
			for(int i=0;i<allAddress.length;i++){
				System.out.println(allAddress[i]);
			}
			
			//获得本机的IP地址
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
