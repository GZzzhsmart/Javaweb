package Fuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConn {
	public static void main(String[] args) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
		String username = "sa";
		String password = "123456";
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "select * from Account";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				rs.getInt(1);
//				System.out.println("id="+rs.getInt("id")+"\tusername="+rs.getString("username")+"\tpassword="+rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
