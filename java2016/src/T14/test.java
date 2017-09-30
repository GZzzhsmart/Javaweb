package T14;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
public static void main(String[] args) {
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=access";
		String username="sa";
		String password="123456";
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
			e.printStackTrace();
		}
	}
}
