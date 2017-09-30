package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class DBConnOracle {

		public static void main(String[] args) {
		String username = "sys as sysdba";
	    String password = "123456";
	    String driver = "oracle.jdbc.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:study";
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println("sno="+rs.getString("sno")+"\tsname="+rs.getString("sname")+"\tsage="+rs.getString("sage")+"\tssex="+rs.getString("ssex"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			System.out.println("oracle数据库连接成功");
		}
	}
}