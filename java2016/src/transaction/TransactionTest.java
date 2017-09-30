package transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {

	public static void main(String[] args) {
		Connection conn = DBConn.openDB();
		try{
			//��ʼ�����Զ���������Ϊ��
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			String sql = "insert into stud values(1007,'������','��','1234567890123456789',4,17)";
			stmt.executeUpdate(sql);
			sql="insert into stud values(1008,'С��','Ů','1234567890123456780',4,18)";
			stmt.executeUpdate(sql);
			//�ύ����
			conn.commit();
			System.out.println("����ɹ�");
		}catch(Exception e){
			try {
				//�ع�����
				conn.rollback();
				System.out.println("����ʧ��");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
