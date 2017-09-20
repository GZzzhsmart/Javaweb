package com.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;

public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {

	public List<User> queryByPager(int page, int pageSize) {
		getConn();
		int beginIndex = (page - 1) * pageSize;
		String sql = "select * from student limit ?, ?";
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, beginIndex);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return users;
	}
	
	public int count() {
		getConn();
		String sql = "select count(id) from student";
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return count;
	}
}
