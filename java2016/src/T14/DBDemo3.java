package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBDemo3 {

	/**
	 * 连接步骤
	 * 	1.选中项目名称，右键点击Build Path->Configure Build Path，
	 * 		点击Libraries标签->点击Add Extened Jars按钮，选中需要导入的包
	 * 	2.
	 * 	
	 * */
	public static void main(String[] args) {
		
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
		//连接字符串
//		String url = "jdbc:sqlserver://localhost:1433;databasename=HouseSale";
		//databasename=数据库名称，这种方式连接数据库不需要到控制面板创建数据源
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
		String username="sa";
		String password="123456";
		try{
			//1.注册一个驱动
			Class.forName(driver);
			//2.连接数据库
			Connection conn = DriverManager.getConnection(url,username,password);
			//3.创建Statement对象,SQL语句的执行环境，相当于查询分析器的功能;
			Statement stmt = conn.createStatement();
			//返回执行结果
//			String sql = "insert into account values(9,'张三','1234')";
//			String sql = "update account set username='小张三' where id=9";
			//String sql = "insert into account values(5,'李莉','1234')";
			//在当前数据库中添加一条新的记录
			//stmt.execute("insert into account values (6,'rt李莉','1234')");
			//stmt.execute("insert into account values(6,'小芳','1234')");
			//删除一条记录
			String sq1 = "delete QQUsers where userid = 32";
			//ResultSet保存了执行的结果
			//4.通过陈述对象执行sql语句，更新数据
			//返回值就是更新成功的记录数
			int cnt=stmt.executeUpdate(sq1); //可以做新增，修改，删除
			System.out.println("cnt="+cnt);
			//5.关闭连接:后打开的先关闭，先打开的后关闭
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
