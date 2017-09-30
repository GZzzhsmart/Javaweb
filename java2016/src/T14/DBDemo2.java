package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemo2 {

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
		//databasename=数据库名称，这种方式连接数据库不需要到控制面板创建数据源
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
			String sql = "select * from account";
			//ResultSet保存了执行的结果
			//通过陈述对象执行sql语句，并返回结果集ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			/**
			 * next函数：移动到下一条记录，返回boolean值
			 * first函数：移动第一条记录；
			 * previous:移动到上一条记录
			 * last：移动到最后一条记录
			 * absolute(100):绝对定位；
			 * 获取数据的函数，每种数据类型都有对应的函数get开头
			 * 获取整形数据:getInt,参数可以是整形，代表字段的索引，参数是字符串就代表字段名称
			 * 获取字符串：getString
			 * 获取长整形：getLong
			 * */
			//处理该结果集
			while(rs.next()){
				System.out.println("id="+rs.getInt("id")+"\tusername="+rs.getString("username")+"\tpassword="+rs.getString(3));
			}
			//关闭连接:后打开的先关闭，先打开的后关闭
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
