package T1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import T1.DBConn;
import T1.StudentVo;;

public class IBaseDAOImpl implements IBaseDAO{

	public StudentVo findstudentById(String studid) {
		
		return null;
	}

	public void studentAdd(StudentVo student) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into student values(";
			sql += "'"+student.getStudid() +"',";
			sql += "'"+student.getStudname()+"',";
			sql += "'"+student.getAge()+"',";
			sql += "'"+student.getHobit()+"',";
			sql += "'"+student.getSex()+"',";
			sql += "'"+student.getClassname()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void studentDel(int studid) {
		
		
	}

	public List<StudentVo> studentList() {
		Connection conn = DBConn.openDB();
		List<StudentVo> list = new ArrayList<StudentVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				StudentVo student = new StudentVo();
				student.setStudid(rs.getInt("studid"));
				student.setStudname(rs.getString("studname").trim());
				student.setAge(rs.getInt("age"));
				student.setHobit(rs.getString("hobit").trim());
				student.setSex(rs.getString("sex").trim());
				student.setClassname(rs.getString("classname").trim());
				list.add(student);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<StudentVo> studentList(int pageSize, int startPos) {
		
		return null;
	}

	public void studentUpdate(StudentVo student) {
		// TODO Auto-generated method stub
		
	}

}
