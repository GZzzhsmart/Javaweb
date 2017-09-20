package base;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//连接池
public class DBPool {
	public static Connection getConnection(){
		Connection conn = null;
		try{
			//创建初始化上下文环境
			Context init = new InitialContext();
			//读取环境变量
			Context context = (Context)init.lookup("java:/comp/env");
			//读取连接池的参数名称,返回连接成功的数据源
			DataSource ds = (DataSource)context.lookup("jdbc/dbsample");
			conn = ds.getConnection();
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
