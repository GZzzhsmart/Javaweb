package transaction;

import java.sql.CallableStatement;
import java.sql.Connection;

public class Test1 {

	public static void main(String[] args) {
		Connection conn = DBConn.openDB();
		try{
			//���ô洢���CallableStatement����
			String sql = "{call up_orderid2(?)}";
			CallableStatement call = conn.prepareCall(sql);
			//�������ֵ
//			call.setString(1,"xxx");//�������
			//������
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			//ִ�д洢���
			call.executeUpdate();
			String orderid = call.getString(1);
			System.out.println("�����ţ�"+orderid);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
