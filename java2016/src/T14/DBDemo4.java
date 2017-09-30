package T14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBDemo4 {

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
			System.out.println("数据库是否关闭："+conn.isClosed());
			System.out.println("是否为只读数据库:"+conn.isReadOnly());
			//3.创建Statement对象,SQL语句的执行环境，相当于查询分析器的功能;
			
			//execute函数的功能与executeUpdate的函数基本相同
			//execute函数返回成功或者失败
			//executeUpdate函数返回值是成功的记录数，整形
			/**
			 * ResultSet.TYPE_FORWARD_ONLY:只能前进，不能后退（默认值)
			 * ResultSet.TYPE_SCROLL_INSENSITIVE:前后滚动
			 * 读写属性：
			 * ResultSet.CONCUR_READ_ONLY:只读
			 * ResultSet.CONCUR_UPDATABLE:可读写
			 * */
			Statement stmt = conn.createStatement();
			//返回执行结果
			String sql = "select * from account";
			//ResultSet保存了执行的结果
			//4.通过陈述对象执行sql语句，并返回结果集ResultSet
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
			
			//得到结果集元数据ResultSetMetaData
			
			ResultSetMetaData metaData=rs.getMetaData();
			System.out.println("数据表的列数："+metaData.getColumnCount());
			for(int i=1;i<=3;i++){
				System.out.println(metaData.getColumnDisplaySize(i));
				System.out.println(metaData.getColumnLabel(i));
				System.out.println(metaData.getColumnName(i));
				System.out.println(metaData.getColumnTypeName(i));
			}
			//5.处理该结果集
			while(rs.next()){
				System.out.println("id="+rs.getInt("id")+"\tusername="+rs.getString("username")+"\tpassword="+rs.getString(3));
			}
			//6.关闭连接:后打开的先关闭，先打开的后关闭
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
