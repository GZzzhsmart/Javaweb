package Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
/**
 * Java程序调用函数
 * */
public class Function {
    static String driver = "oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    static String username = "scott";
    static String password = "zzh1998";
    public static void main(String[] args) {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("连接成功");
			String sql = "{?= call fun_staticsScore(?)}";
			CallableStatement pstm = conn.prepareCall(sql);
			pstm.registerOutParameter(1, Types.DOUBLE);
			pstm.setString(2, "1001");
			pstm.executeQuery();
			double score = pstm.getDouble(1);
			System.out.println("1001的总分是："+score);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
