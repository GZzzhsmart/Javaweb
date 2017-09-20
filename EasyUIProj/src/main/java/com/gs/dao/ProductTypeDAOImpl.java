package com.gs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.ProductType;
import com.gs.common.bean.Pager4EasyUI;

public class ProductTypeDAOImpl extends AbstractBaseDAO implements ProductTypeDAO {

	@Override
	public ProductType queryById(Integer id) {
		getConn();
		String sql = "select * from t_product_type where id = ?";
		ProductType productType = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				productType = new ProductType();
				productType.setId(id);
				productType.setName(rs.getString("name"));
				productType.setDes(rs.getString("des"));
				productType.setValid(rs.getString("valid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return productType;
	}

	@Override
	public Pager4EasyUI<ProductType> queryByPager(Pager4EasyUI<ProductType> pager) {
		getConn();
		String sql = "select * from t_product_type limit ?, ?";
		List<ProductType> productTypes = new ArrayList<ProductType>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pager.getBeginIndex());
			ps.setInt(2, pager.getPageSize());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductType productType = new ProductType();
				productType.setId(rs.getInt("id"));
				productType.setName(rs.getString("name"));
				productType.setDes(rs.getString("des"));
				productType.setValid(rs.getString("valid"));
				productTypes.add(productType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		pager.setRows(productTypes);
		return pager;
	}

	@Override
	public void update(ProductType t) {
		getConn();
		String sql = "update t_product_type set name = ?, des = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getDes());
			ps.setInt(3, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}

	
	@Override
	public void add(ProductType t) {
		getConn();
		String sql = "insert into t_product_type(name, des) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getDes());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}
	

	@Override
	public void validById(Integer id, String valid) {
		getConn();
		String sql = "update t_product_type set valid = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, valid);
			ps.setInt(2, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}

	@Override
	public int count() {
		getConn();
		String sql = "select count(id) from t_product_type";
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
