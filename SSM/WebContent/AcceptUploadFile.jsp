<%@ page contentType="text/html; charset=gb2312" language="java" import="java.io.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>接收上传文件</title>
    
 <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">    
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 <meta http-equiv="description" content="This is my page">
 <!--
 <link rel="stylesheet" type="text/css" href="styles.css">
 -->

  </head>
  
  <body>
   <%
    String tempFileName=new String("tempFile1");
    File tempFile1=new File("D://Youxun",tempFileName);
    FileOutputStream outputFile=new FileOutputStream(tempFile1);
    InputStream fileSource=request.getInputStream();
    byte b[]=new byte[1000];
    int n;
    while((n=fileSource.read(b))!=-1)
         outputFile.write(b,0,n);
    outputFile.close();
    fileSource.close();
    
     
    RandomAccessFile randomFile1=new RandomAccessFile(tempFile1,"r");
    randomFile1.readLine();
    String FilePath=randomFile1.readLine();
    int position=FilePath.lastIndexOf('\\');
    String filename=FilePath.substring(position+1,FilePath.length()-1);
    filename=new String(filename.getBytes("iso-8859-1"),"GBK");
    
    randomFile1.readLine();
    randomFile1.readLine();
    long forthEnterPosition= randomFile1.getFilePointer();
    
    
    File FileUploadDir=new File("D:/Youxun/","Upload");
    FileUploadDir.mkdir();
    File saveFile1=new File("D:/Youxun",filename); 
    RandomAccessFile randomFile2=new RandomAccessFile(saveFile1,"rw");
  
    long endPosition=randomFile1.length();
    int j=1;
    while((endPosition>=0)&&(j<=4))
       {
        endPosition--;
        randomFile1.seek(endPosition);
        if(randomFile1.readByte()=='\n')
            j++;
       }
    randomFile1.seek(forthEnterPosition);   
    long startPoint=randomFile1.getFilePointer();   
    while(startPoint<endPosition-1)   
            {   
               randomFile2.write(randomFile1.readByte());   
               startPoint=randomFile1.getFilePointer();   
            }   
    
    randomFile1.close();
    randomFile2.close();
    tempFile1.delete();
    %>
 
  </body>
</html>