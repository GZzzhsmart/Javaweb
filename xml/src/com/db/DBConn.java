package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static String driver = "oracle.jdbc.OracleDriver"; 
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String username="sys as sysdba";
	private static String password="zzh1998";
	private static Connection conn=null;
	
	static{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("oracle数据库连接成功");
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
		new DBConn();
	}
}
