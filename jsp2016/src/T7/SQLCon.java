package T7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLCon {

	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
	private static String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t7";
	private static String username="sa";
	private static String password="123456";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
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
			System.out.println("数据库处于关闭状态");
		}
		return conn;
	}
	
}
