package T7;
import java.sql.*;
public class ContactBean {
	private Connection conn;
	/**
	 * 初始化连接
	 * */
	public ContactBean(){
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=QQ2016";
  		String username = "sa";
  		String password = "123456";
  		try{
  			Class.forName(driver);
  			conn=DriverManager.getConnection(url, username, password);
  		}catch(Exception e){
  			e.printStackTrace();
  		}
	}
	/**
	 * 查询数据库
	 * */
	public ResultSet getResult(String sql){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
