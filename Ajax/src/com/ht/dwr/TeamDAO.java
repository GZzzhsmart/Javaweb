package com.ht.dwr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.dwr.DBConn;
import com.ht.dwr.TeamVo;


@SuppressWarnings("unused")
public class TeamDAO {

	public void addTeam(TeamVo team){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into team values('"+team.getTeamName()+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findAllTeam(){
		List list = new ArrayList();
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from team";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeamVo team = new TeamVo();
				team.setId(rs.getInt("id"));
				team.setTeamName(rs.getString("teamName").trim());
				list.add(team);
			}
			rs.close();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
