package com.gs.common.bean;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport implements IBaseDAO {
	private DriverManagerDataSource dmds;

	public DriverManagerDataSource getDmds() {
		return this.dmds;
	}

	public void setDmds(DriverManagerDataSource dmds) {
		this.dmds = dmds;
	}

	public boolean delete(Object obj) {
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			getHibernateTemplate().delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delAll(Collection conns) {
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			getHibernateTemplate().deleteAll(conns);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List findAllByHQL(String HQL) {
		List list = null;
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			list = getHibernateTemplate().find(HQL);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public List findByDetached(DetachedCriteria dc) {
		List list = null;
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			list = getHibernateTemplate().findByCriteria(dc);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public Integer getCount(DetachedCriteria dc) {
		Integer cnt = Integer.valueOf(0);
		try {
			cnt = (Integer) getHibernateTemplate().findByCriteria(dc).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cnt;
	}

	public boolean save(Object obj) {
		try {
			org.hibernate.Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.saveOrUpdate(obj);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean saveorUpdate(Object obj) {
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			getHibernateTemplate().saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Object obj) {
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			getHibernateTemplate().update(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List findAll(Object obj) {
		List list = null;
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			list = getHibernateTemplate().findByExample(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public Object findObjByID(Class clazz, Serializable id) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
		return getHibernateTemplate().get(clazz, id);
	}

	public boolean deleteAll(Collection coll) {
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			getHibernateTemplate().deleteAll(coll);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List findPageByDetached(DetachedCriteria dc, int firstResult, int maxResult) {
		List list = null;
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
			list = getHibernateTemplate().findByCriteria(dc, firstResult, maxResult);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	public List find(String sql) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
		List list = getHibernateTemplate().find(sql);
		return list;
	}

	public List findBySQL(String sql) {
		org.hibernate.Session session = getHibernateTemplate().getSessionFactory().openSession();

		Transaction tr = session.beginTransaction();
		List data = session.createSQLQuery(sql).list();
		tr.commit();
		session.close();
		return data;
	}

	public void saveStoredProcedure(String procname, String[] params) {
		try {
			Connection conn = this.dmds.getConnection();

			CallableStatement call = conn.prepareCall(procname);
			for (int i = 0; i < params.length; ++i) {
				call.setString(i + 1, params[i]);
			}
			call.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}