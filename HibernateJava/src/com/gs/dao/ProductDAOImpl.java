package com.gs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gs.bean.Product;
import com.gs.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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

	@SuppressWarnings("unchecked")
	@Override
	public Product queryById(int id) {
		Session session = sessionFactory.openSession();
		// Product p = (Product) session.get(Product.class, id); // get用于通过指定的主键来查询对象数据
		// Query query = session.createQuery("from Product p where p.id = ?");
		// query.setInteger(0, id); // 参数从索引0开始 
		Query query = session.createQuery("from Product p where p.id =:pid");
		query.setParameter("pid", id);
		// List<Product> products = query.list(); // 如果是多行记录，则使用list方法
		Product p = (Product) query.uniqueResult(); // 如果确定查询出的结果只有一行记录，则直接使用uniqueResult方法 
		session.close();
		// return products.size() == 1 ? products.get(0) : null;
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> queryAll() {
		Session session = sessionFactory.openSession();
		List<Product> products = session.createQuery("from Product").list();
		session.close();
		return products;
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

}
