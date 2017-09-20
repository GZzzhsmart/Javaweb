package base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * jdbc-odbc桥的方式连接数据库
 * 了解如何创建DSN的步骤
 * 1.开始菜单-控制面板-系统和安全-管理工具-odbc数据源
 * 2.创建系统（用户）数据源-输入数据源名称（在Java程序中使用的名称）
 * */
public class DsnConn {
	private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver"; //驱动
	private static String url = "jdbc:odbc:Edu";
	private static String username="sa";
	private static String password="123456";
	private static Connection conn=null;
	//静态语句块，连接数据库
	static{
		try {
			//注册驱动
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//连接数据库
	public static Connection openDB(){
		try {
			//判断连接状态
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
