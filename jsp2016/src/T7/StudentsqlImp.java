package T7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsqlImp implements Studentsql{

	//连接数据库
	Connection con = SQLCon.openDB();
	//查询所有的学员信息
	public List<StudentBean> list() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select studentname,studentcount from vote order by studentcount desc");
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setStudentinf(rs.getString("studentname"));
				bean.setStudentcount(rs.getInt("studentcount"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//新增学生票数
	public void addcount(StudentBean bean) {
		try {
			Statement st = con.createStatement();
			for(int j=0;j<bean.getStudentname().length;j++){
				String sql = "update vote set studentcount=(select studentcount from vote where studentname='"+bean.getStudentname(j)+"')+1 where studentname='"+bean.getStudentname(j)+"'";
				st.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询学生列表
	public List<StudentBean> studentlist() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from vote");
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setStudentinf(rs.getString("studentname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//新增学员
	public void addstudent(String studentname) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into vote values('"+studentname+"',0)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
