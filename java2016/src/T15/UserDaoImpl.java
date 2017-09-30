package T15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class UserDaoImpl implements IUserDAO{

	
	public void add(UserVo user) {
		Connection conn = DBConn.openDB();
		String sql = "insert into QQUsers values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int index=1;
			pstmt.setString(index++, user.getUsername());
			pstmt.setString(index++, user.getPassword().trim());
			pstmt.setString(index++, user.getSex().trim());
			pstmt.setInt(index++, user.getAge());
			pstmt.setString(index++, user.getCardno().trim());
			pstmt.setString(index++, user.getQqcode().trim());
			pstmt.setString(index++, user.getEmail().trim());
			pstmt.setString(index++, user.getRemark().trim());
			//保存到数据库
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//判断用户名称是否存在的函数
	public boolean isExists(String userName){
		
		boolean isOK = false;
		String sql ="select * from qqusers where userName='"+userName +"'";
		
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isOK=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isOK;
	}
	
	public void delete(UserVo user) {
		Connection conn = DBConn.openDB();
	}

	//根据查询条件，查找用户信息
	public Vector find(String userName,String sex,String qqCode) {
		String sql = "select * from qqusers where 1=1";
		
		if(!userName.equals("")){
			sql += " and username like '%"+ userName +"%'";
		}
		if(!sex.equals("")){
			sql += " and sex='"+sex +"'";
		}
		if(!qqCode.equals("")){
			sql += " and qqcode='"+qqCode + "'";
		}
		sql += " order by username";
		
		System.out.println(sql);
		
		Connection conn = DBConn.openDB();
		Statement stmt;
		//保存所有用户的记录
		Vector rowData = new Vector();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				//保存一条记录
				Vector row = new Vector();
				row.addElement(rs.getInt("userid"));
				row.addElement(rs.getString("userName").trim());
				row.addElement(rs.getString("password").trim());
				row.addElement(rs.getString("sex").trim());
				row.addElement(rs.getInt("age"));
				row.addElement(rs.getString("cardno").trim());
				row.addElement(rs.getString("qqcode").trim());
				row.addElement(rs.getString("email").trim());
				row.addElement(rs.getString("remark").trim());
				rowData.addElement(row);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}

	public void update(UserVo user) {
		Connection conn = DBConn.openDB();
	}


	public List<UserVo> find() {
	
		return null;
	}
	

}
