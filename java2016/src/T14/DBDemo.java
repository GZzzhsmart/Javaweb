package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBDemo {
	public static void main(String[] args) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
		String username="sa";
		String password="123456";
		try{
			//注册一个驱动
			Class.forName(driver);
			//连接数据库
			Connection conn = DriverManager.getConnection(url,username,password);
			//创建Statement对象,SQL语句的执行环境，相当于查询分析器的功能;
			Statement stmt = conn.createStatement();
			//返回执行结果
			//在当前数据表中添加一条数据
			stmt.execute("insert into account values(6,'小芳','1234')");
			//删除一条记录
			String sq1 = "delete account where id = 6";
			String sql = null;
			//ResultSet保存了执行的结果
			//通过陈述对象执行sql语句，更新数据
			//返回值就是更新成功的记录数
			int cnt = stmt.executeUpdate(sql);
			System.out.println("cnt="+cnt);
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
