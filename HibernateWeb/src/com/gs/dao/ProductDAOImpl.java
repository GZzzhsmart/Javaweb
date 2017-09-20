package com.gs.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gs.bean.Product;
import com.gs.common.bean.Pager4EasyUI;

public class ProductDAOImpl extends BaseDAO implements ProductDAO {
	
	@Override
	public Product add(Product product) {
		// 通过sessionFactory对象获取session数据库连接 
		Session session = sessionFactory.openSession(); // 开启事务处理
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit(); // 事务提交
		session.close();
		return null;
	}

	@Override
	public Product queryById(int id) {
		Session session = sessionFactory.openSession();
		Product p = (Product) session.get(Product.class, id); // get用于通过指定的主键来查询对象数据
		session.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager4EasyUI<Product> queryAll(Pager4EasyUI<Product> pager) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		query.setFirstResult(pager.getBeginIndex()); // 分页的第一个记录开始位置
		query.setMaxResults(pager.getPageSize()); // 查询多少个记录（每页多少个）
		List<Product> products = query.list();
		pager.setRows(products);
		session.close();
		return pager;
	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product); // 如果要删除某个object，则此object的主键字段的属性必须赋值
		transaction.commit();
		session.close();
	}
	
	@Override
	public int count() {
		Session session = sessionFactory.openSession();
		BigInteger count = (BigInteger) session.createSQLQuery("select count(id) from t_product1").uniqueResult();
		session.close();
		return count.intValue();
	}

}
