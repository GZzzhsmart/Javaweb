package com.ht.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.vo.ClassesVo;
import com.ht.vo.NationVo;
import com.ht.vo.SVo;

public class SqlSentenceimp implements SqlSentence{

	Connection conn = DBConn.openDB();
	//新增学生
	public void addstud(SVo student) {
		try {
			Statement st = conn.createStatement();
			String sql = "insert into student values(";
			sql+="'"+student.getSno()+"',";
			sql+="'"+student.getStudentname()+"',";
			sql+="'"+student.getSsex()+"',";
			sql+="'"+student.getSage()+"',";
			sql+="'"+student.getShobit()+"',";
			sql+="'"+student.getSzhuanye()+"',";
			sql+="'"+student.getClassid()+"',";
			sql+="'"+student.getNationid()+"')";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("新增学生出错");
			e.printStackTrace();
		}
		
	}
	//班级列表
	public List<ClassesVo> classlist() {
		List<ClassesVo> classlist = new ArrayList<ClassesVo>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from class";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ClassesVo classvo = new ClassesVo();
				classvo.setClassid(rs.getInt("classid"));
				classvo.setClassname(rs.getString("classname"));
				classlist.add(classvo);
			}
		} catch (Exception e) {
			System.out.println("查询班级列表出错?");
			e.printStackTrace();
		}
		return classlist;
	}
	//删除学生
	public void delstudent(String sno) {
		try {
			Statement st = conn.createStatement();
			String sql = "delete student where sno='"+sno+"'";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("删除学生出错");
			e.printStackTrace();
		}
		
	}
	//查找学生
	public SVo findstudent(String sno) {
		SVo student = new SVo();
		try { 
			Statement st = conn.createStatement();
			String sql = "select s.*,c.classid,n.nationid from student  s ,class c,nation n where s.classid=c.classid and s.nationid=n.nationid and sno='"+sno+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				student.setSzhuanye(rs.getString("szhuanye"));
				student.setShobit(rs.getString("shobit"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				student.setClassid(rs.getInt("classid"));
				student.setNationid(rs.getInt("nationid"));
			}
		} catch (Exception e) {
			System.out.println("查找学生出错");
			e.printStackTrace();
		}
		return student;
	}
	//民族列表
	public List<NationVo> nationlist() {
		List<NationVo> nationlist = new ArrayList<NationVo>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from nation";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				NationVo nationvo = new NationVo();
				nationvo.setNationid(rs.getInt("nationid"));
				nationvo.setNationName(rs.getString("nationname"));
				nationlist.add(nationvo);
			}
		} catch (Exception e) {
			System.out.println("查询民族列表出错?");
			e.printStackTrace();
		}
		return nationlist;
	}
	//学生列表
	public List<SVo> studentlist() {
		List<SVo> list = new ArrayList<SVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select s.*,c.classname,n.nationname from student  s ,class c,nation n where s.classid=c.classid and s.nationid=n.nationid";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				SVo student = new SVo();
				student.setSzhuanye(rs.getString("Szhuanye"));
				student.setShobit(rs.getString("shobit"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				student.setClassname(rs.getString("classname"));
				student.setNationname(rs.getString("nationname"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("查询学生列表出错");
			e.printStackTrace();
		}
		return list;
	}
	//分页
	public List<SVo> studentlist(int pagesize, int startpage) {
		List<SVo> list = new ArrayList<SVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select top("+pagesize+") s.*,c.classname,n.nationname from  student  s ,class c,nation n where s.classid=c.classid and s.nationid=n.nationid and sno not in(select top("+startpage+") sno from student )";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				SVo student = new SVo();
				student.setShobit(rs.getString("shobit"));
				student.setSzhuanye(rs.getString("szhuanye"));
				student.setSage(rs.getInt("sage"));
				student.setStudentname(rs.getString("studentname"));
				student.setSno(rs.getInt("sno"));
				student.setSsex(rs.getString("ssex"));
				student.setClassname(rs.getString("classname"));
				student.setNationname(rs.getString("nationname"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("查询分页出错");
			e.printStackTrace();
		}
		return list;
	}
	
	public int sum(String sql) {
		int n = 0;
		try {
			Statement st = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("分页出错?");
			e.printStackTrace();
		}
		return n;
	}
	//修改学生
	public void updatestudent(SVo student) {
		try {
			Statement st = conn.createStatement();
			String sql="update student set ";
			sql+="studentname='"+student.getStudentname()+"',";
			sql+="sage='"+student.getSage()+"',";
			sql+="shobit='"+student.getShobit()+"',";
			sql+="ssex='"+student.getSsex()+"',";
			sql+="szhuanye='"+student.getSzhuanye()+"',";
			sql+="classid="+student.getClassid()+",";
			sql+="nationid="+student.getNationid()+"  where sno='"+student.getSno()+"'";
			System.err.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("修改学生信息出错");
			e.printStackTrace();
		}
		
	}

}
