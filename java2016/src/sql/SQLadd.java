package sql;

import java.sql.Connection;
import java.sql.Statement;

public class SQLadd {

	public static void main(String[] args) {
		Connection conn = DBConn.openDB();
		try {
			Statement st = conn.createStatement();
			for (int i = 100000; i < 500000; i++) {
				String sql = "insert into grade values('宏图1601班','胡歌"+i+"','男',20)";
				System.out.println(sql);
				st.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加记录出错!");
		}
	}
}
