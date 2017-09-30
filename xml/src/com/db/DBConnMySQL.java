package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnMySQL {

	@SuppressWarnings("unused")
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
	         System.out.println("MySQL数据库连接成功");  
	         Statement statement = conn.createStatement();  
	         String sql = "select * from student";  
	         ResultSet rs = statement.executeQuery(sql);  
	         while(rs.next()){
				System.out.println("sno="+rs.getInt("sno")+"\tsname="+rs.getString("sname")+"\tsage="+rs.getInt("sage")+"\tssex="+rs.getString("ssex"));
			 }
	         rs.close();       
	         conn.close();  
         }catch(ClassNotFoundException e){  
			  System.out.println("MySQL数据库连接失败");              
			  e.printStackTrace();  
		 } catch(SQLException e) {  
			 e.printStackTrace();  
		 } catch(Exception e) {  
			 e.printStackTrace();  
		 }   
    }  
}
