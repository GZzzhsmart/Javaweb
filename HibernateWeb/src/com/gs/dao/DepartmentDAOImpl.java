package com.gs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.gs.bean.Department;

public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO {

	@Override
	public Department queryById(int id) {
		Session session = sessionFactory.openSession();
		Department dept = (Department) session.get(Department.class, id);
		//session.close(); 
		return dept;
	}

	@Override
	public void add(Department dept) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dept);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Department dept) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(dept);
		transaction.commit();
		session.close();
	}

	@Override
	public Department queryByCriteria() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		// criteria.setFetchMode("employees", FetchMode.JOIN);
		// criteria.setProjection(Projections.max("name")); // 取指定属性的最大值   min最小值
		// criteria.setProjection(Projections.avg("id")); // 指定属性的平均值
		// criteria.setProjection(Projections.rowCount()); // 计数 count(*)
		// criteria.setProjection(Projections.count("id")); // 按指定的属性来计数  count(id)
		// criteria.setProjection(Projections.countDistinct("id")); // 先按属性排除重复的行再计数
		// criteria.setProjection(Projections.id()); // 返回主键字段的值  
		// criteria.setProjection(Projections.groupProperty("name")); // 按指定属性进行分组 group by
		// criteria.setProjection(Projections.sum("id")); // 求和 sum(id);
		// criteria.setProjection(Projections.property("name")); // 指定查询某个字段
		criteria.add(Restrictions.like("name", "%4%"));
		criteria.add(Restrictions.eq("name", "研发部"));
		// session.close();
		List<Department> depts = criteria.list();
		for (Department dept : depts) {
			System.out.println(dept.getName());
		}
		return null;
	}
	
	

}
