package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo1 {
	/**
	 *连接不通数据库时的检查步骤：
	 *	1.有没有安装;
	 *	2.服务有没有启动；
	 *	3.安全性设置是否为混合模式；
	 *	4.驱动的字符串写错了； 
	 *	5.url错误
	 * 
	 * 
	 * */
	
	/**
	 * 数据库操作的步骤：
	 * 1.调用驱动
	 * 2.连接Connection对象
	 * 	1.URL：连接字符串
	 * 	2.USERNAME:登录的用户名称;
	 * 	3.PASSWORD:登录密码
	 * */
	public static void main(String[] args) {
		/**
		 * 	JDBC-ODBC桥连接数据库
		 * 	1.到控制面板-》DSN创建一个数据源；
		 * 	2.选择需要连接的数据库（默认是master数据库）
		 * 	3.url中使用的是数据源的名称，不是数据库的名称
		 * */
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:Test"; //TestDB是控制面板中设置的数据源的名称，不是数据库的名称
		String username = "sa";
		String password = "123456";
		try {
			//1.调用驱动(JDBC-ODBC桥的连接方式)
			Class.forName(driver);
			Connection conn =DriverManager.getConnection(url,username,password);
			if(!conn.isClosed()){
				System.out.println("数据库连接成功！");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
