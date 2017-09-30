package T2lianxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	public static void main(String[] args) {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
		String username = "sa";
		String password = "123456";
		try{
			//注册一个驱动
			Class.forName(driver);
			//连接数据库
			Connection conn = DriverManager.getConnection(url,username,password);
			//创建Statement对象,SQL语句的执行环境，相当于查询分析器的功能;
			Statement stmt = conn.createStatement();
			//返回执行结果
			String sql = "select * from Account";
			//ResultSet保存了执行的结果
			//通过陈述对象执行sql语句，并返回结果集ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			//处理该结果集
			while(rs.next()){
				rs.getInt(1);
//				System.out.println("id="+rs.getInt("id")+"\tusername="+rs.getString("username")+"\tpassword="+rs.getString(3));
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
