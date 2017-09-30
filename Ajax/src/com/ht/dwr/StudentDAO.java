package com.ht.dwr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ht.dwr.DBConn;
import com.ht.dwr.StudentVo;


@SuppressWarnings("unused")
public class StudentDAO {

	public void addStudent(StudentVo student){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into student values('"+student.getStuName()+"','"+student.getStuNo()+"','"+student.getTeamId()+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delStudent(int studentId){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete from student where id ="+studentId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudent(StudentVo student){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update student set stuName='" + student.getStuName() +"',stuNo="+student.getStuNo()+",teamId="+student.getTeamId()+" where id="+student.getId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findAllStudent(){
		List list = new ArrayList();
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				StudentVo student = new StudentVo();
				student.setId(rs.getInt("id"));
				student.setStuName(rs.getString("studName").trim());
				student.setStuNo(rs.getString("studNo"));
				student.setTeamId(rs.getInt("teamId"));
				list.add(student);
			}
			rs.close();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findStudentByTeamId(int teamid){
		List list = new ArrayList();
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from student where teamid="+teamid;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				StudentVo student = new StudentVo();
				student.setId(rs.getInt("id"));
				student.setStuName(rs.getString("studName").trim());
				student.setStuNo(rs.getString("studNo"));
				student.setTeamId(rs.getInt("teamId"));
				list.add(student);
			}
			rs.close();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentVo findStudentById(int stuid){
		List list = new ArrayList();
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from student where id="+stuid;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				StudentVo student = new StudentVo();
				student.setId(rs.getInt("id"));
				student.setStuName(rs.getString("studName").trim());
				student.setStuNo(rs.getString("studNo"));
				student.setTeamId(rs.getInt("teamId"));
				list.add(student);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {e.printStackTrace();}
		
		return null;
	}
	
	public static void main(String args[]){
		StudentDAO dao = new StudentDAO();
		StudentVo stu = dao.findStudentById(16);
		System.out.println(stu);
		
	}

}
