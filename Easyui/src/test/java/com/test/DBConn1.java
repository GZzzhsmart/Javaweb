package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn1 {

	public static void main(String[] args){  
		 String driver = "com.mysql.jdbc.Driver";  
		 String url = "jdbc:mysql://127.0.0.1:3306/mysqlstudy?characterEncoding=utf8&useSSL=true";  
		 String username = "root";           
		 String password = "123456";  
		 String name;  
        try {               
	         Class.forName(driver);  
	         Connection conn = DriverManager.getConnection(url, username, password);  
	         if(!conn.isClosed())          
	         System.out.println("成功连接MySQL数据库");  
	         Statement statement = conn.createStatement();  
	         String sql = "select * from student";  
	         ResultSet rs = statement.executeQuery(sql);  
	         while(rs.next()){
				System.out.println("studid="+rs.getInt("studid")+"\tstudname="+rs.getString("studname")+"\tsex="+rs.getString("sex")+"\tage="+rs.getInt("age")+"\taddress="+rs.getString("address"));
			 }
	         rs.close();       
	         conn.close();  
        }catch(ClassNotFoundException e){  
			  System.out.println("连接MySQL数据库失败");              
			  e.printStackTrace();  
		 } catch(SQLException e) {  
			 e.printStackTrace();  
		 } catch(Exception e) {  
			 e.printStackTrace();  
		 }   
   }  
}
