package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConn1 {

	private static String driver = "com.mysql.jdbc.Driver"; 
	private static String url = "jdbc:mysql://192.168.0.168:3306/realestate?characterEncoding=utf8&useSSL=true";
	private static String username="root";
	private static String password="zhanglei";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("MySQL数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection openDB(){
		try {
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		new DBConn1();
	}
}
