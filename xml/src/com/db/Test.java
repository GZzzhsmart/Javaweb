package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class Test {

public static void main(String[] args) {
		String username = "sys as sysdba";
	    String password = "a1234";
	    String driver = "oracle.jdbc.OracleDriver";
	    String url = "jdbc:oracle:thin:@192.168.1.19:1521:study";
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println("id="+rs.getInt("id")+"\tname="+rs.getString("name"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			System.out.println("oracle数据库连接成功");
		}
	}
}