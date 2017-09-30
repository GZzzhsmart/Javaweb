package T16sj;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	//服务器端程序
	public Server(){
		
	}
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		try{
			ServerSocket ss = new ServerSocket(9000);
			int num=0;
			while(true){
				 Socket s=ss.accept();
                 String username=""+num;
                 num++;
                 ht.put(username,s);
                 new ServerInputThread(s.getInputStream(),username,ht).start();
                 System.out.println(username+"已登陆");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
//服务器输入流线程
class ServerInputThread extends Thread{
	InputStream in;
	String ren;
	
	public ServerInputThread(InputStream in,String tmpusername,Hashtable ht){
        this.in = in;
        this.ren = tmpusername;
        Ssend.send=new send(ht);
    }
	
	public void run(){
		 BufferedReader bf=new BufferedReader(new InputStreamReader(in));
	        try{
	            while(true){
	               	String str=bf.readLine();
	                System.out.println(str);
	                String cxiaoxi=str.substring(0,str.indexOf(":"));
	                System.out.println(cxiaoxi);
	                if(cxiaoxi.equals("CLogin")){
	                     Ssend.send.sendOne(ren,"SOneLogin:");
	                     System.out.println("------------------");
	                     Ssend.send.sendAll("SAllLogin:"+ren);
	                     String zaixian=Ssend.send.Zaixian();
	                     Ssend.send.sendOne(ren,"ZaiXian:"+zaixian);
	                     System.out.println("++++++++++++"+zaixian);
	                }
	                if(cxiaoxi.equals("COne")){
	                     String s1=str.substring(str.indexOf(":")+1);
	                     String s2=s1.substring(0,s1.indexOf("="));
	                     String s3=s1.substring(s1.indexOf("=")+1);
	                     String s4=s2.substring(0,s2.indexOf("-"));
	                     String s5=s2.substring(s2.indexOf("-")+1);
	                     Ssend.send.sendOne(s5,"SOne:"+s4+">"+s3);
	                 }
	                 if(cxiaoxi.equals("CAll")){
	                     String s1=str.substring(str.indexOf(":")+1);
	                     String s2=s1.substring(0,s1.indexOf("="));
	                     String s3=s1.substring(s1.indexOf("=")+1);
	                     String s4=s2.substring(0,s2.indexOf("-"));
	                     String s5=s2.substring(s2.indexOf("-")+1);
	                     Ssend.send.sendAll("SAll:"+s4+">"+s3);
	                 }
	             }

	         }catch(Exception e){System.out.println(e);}
	    }

	}
	class send{
	    Hashtable ht;
	    public send(Hashtable ht){
	        this.ht=ht;
	    }

	    public void sendOne(String username,String message){
	        Socket s=(Socket)ht.get(username);
	        if(s==null){
	             System.out.println("socket为空");
	        }
	        else
	        {
	            try{
	                  PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
	                  pw.println(username+"="+message);
	                   System.out.println(username+"="+message);
	            }catch(Exception e){System.out.println(e);}

	         }

	     }
	     public void sendAll(String message){
	         Enumeration em=ht.keys();
	         try{
	             while(em.hasMoreElements()){
	             String name=(String)em.nextElement();
	             //System.out.println(name+"name");
	                   Socket socket=(Socket)ht.get(name);
	                   PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
	                   pw.println("="+message);

	              }
	          }catch(Exception e){System.out.println(e);}
	  	}
	  	public String Zaixian(){
	         Enumeration em=ht.keys();

	         String zaixian="";
	         while(em.hasMoreElements()){
	                String name=(String)em.nextElement();
	                zaixian=zaixian+name+";";
	          }
	                return zaixian;
	     }
	}
	class Ssend{
	    public static send send;
	}
