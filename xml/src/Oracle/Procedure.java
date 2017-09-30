package Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
/**
 * Java程序调用存储过程
 * */
@SuppressWarnings("unused")
public class Procedure {
	static String driver = "oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    static String username = "scott";
    static String password = "zzh1998";
    public static void main(String[] args) {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("连接成功");
			String sql = "{call pro_ClassAvgScore(?,?,?)}";
			CallableStatement pstm = conn.prepareCall(sql);
			pstm.setInt(1, 1);
			pstm.setInt(2, 1);
			pstm.registerOutParameter(3, Types.DOUBLE);
			pstm.executeQuery();
			double score = pstm.getDouble(3);
			System.out.println("1001班的平均分是："+score);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
