package transaction;

import java.sql.Connection;
import java.sql.Statement;

public class Test {

	//������
	public static void main(String[] args) {
		Connection con = DBConn.openDB();
		try {
			//��ʼ�����Զ��ύ����Ϊ��
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			String sql = "update salarymoney set salary=salary-1000 where moneyname='����'";
			st.executeUpdate(sql);
			int n = st.getUpdateCount();
			String sql1 = "update salarymoney set salary=salary+1000 where moneyname='����'";
			st.executeUpdate(sql1);
			int num = st.getUpdateCount();
			if(n!=0 && num!=0){
				System.out.println("���׳ɹ���");
				//�ύ����
				con.commit();
			}else {
				System.out.println("����ʧ�ܣ�");
				//�ع�����
				con.rollback();
			}
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("����ʧ��");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
