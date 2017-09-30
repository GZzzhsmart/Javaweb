package T15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
	static String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
	static String username="sa";
	static String password="123456";
	//连接数据库
	public static Connection openDB(){
		Connection conn = null;
		//注册一个驱动
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//连接数据库
		return conn;
	}
}
