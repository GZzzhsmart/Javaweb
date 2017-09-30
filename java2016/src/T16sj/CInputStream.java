package T16sj;

import java.io.*;
import java.net.*;

public class CInputStream extends Thread{
	InputStream in;
    public CInputStream(InputStream in){
        this.in=in;
    }
    public void run(){
    	 BufferedReader buff=new BufferedReader(new InputStreamReader(in));
         while(true){
             String s = null;
             try {
                 s = buff.readLine();
                 System.out.println(s);
             } catch (IOException ex) {
             }
             String sd=s.substring(s.indexOf("=")+1);
             System.out.println(sd+"aaaaaaaaaaaaaaaaa");
             String ss=sd.substring(0,sd.indexOf(":"));
             System.out.println(ss+"bbbbbbbbbbbbb");
             if(ss.equals("SOneLogin")){
                 String sss=s.substring(0,s.indexOf("="));
                 System.out.println(sss+"=============");
                 QQClient.f.setTitle(sss);
                 System.out.println(sss);
                 QQClient.f.list.add(sss+"登录成功");
             }
             if(ss.equals("SAllLogin")){
                 String zaixian=sd.substring(sd.indexOf(":")+1);
                 System.out.println(zaixian+"-------------");
                 String title=QQClient.f.getTitle();
                 System.out.println("title"+title);
               if(!zaixian.equals(title)){
                     QQClient.f.jComboBox1.addItem(zaixian);
                     QQClient.f.list.add(zaixian+"已登录");
                 }
             }
             if(ss.equals("ZaiXian")){
                 String xian=sd.substring(sd.indexOf(":")+1);
                 String tmp[]=xian.split(";");
                 for(int i=0;i<tmp.length;i++){
                     if(!tmp[i].equals(QQClient.f.getTitle())){
                         QQClient.f.jComboBox1.addItem(tmp[i]);
                         QQClient.f.list.add(tmp[i]+"已登录");
                      }
                 }
             }

             if(ss.equals("SOne")){
                 String xiaoxi=s.substring(s.indexOf(":")+1);
                 System.out.println("Sone"+xiaoxi);
                 String s0=xiaoxi.substring(0,xiaoxi.indexOf(">"));
                 String str=s.substring(s.indexOf(">")+1);
                 QQClient.f.list.add(s0+"对您说"+":"+str);
             }
             if(ss.equals("SAll")){
                 String xiaoxi=s.substring(s.indexOf(":")+1);
                 String str=s.substring(s.indexOf(">")+1);
                 String s1=xiaoxi.substring(0,xiaoxi.indexOf(">"));
                 QQClient.f.list.add(s1+"对所有人说"+"===="+str);

             }
         }
     }

 }


