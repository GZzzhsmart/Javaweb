package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //��
	private static String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=Test";
	private static String username="sa";
	private static String password="123456";
	private static Connection conn=null;
	//��̬���飬l����ݿ�
	static{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("��ݿ�l�ӳɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//l����ݿ�
	public static Connection openDB(){
		try {
			//�ж�l��״̬
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
