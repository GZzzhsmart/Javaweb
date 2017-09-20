package com.base;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


public class BaseDAO {

	Session session = null;
	//新增的函数
	public void save(Object object){
		try{
			//获取hibernate的session对象
			Session session = HibernateSessionFactory.getSession();
			//清空session的缓存
			session.clear();
			//开始事务
			Transaction tx = session.beginTransaction();
			//保存任意对象(做了合法的hbm配置的对象)
			session.save(object);
			//提交事务
			tx.commit();
			//关闭session
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//修改函数
	public void update(Object object){
		try{
			//获取hibernate的session对象
			Session session = HibernateSessionFactory.getSession();
			//清空session的缓存
			session.clear();
			//开始事务
			Transaction tx = session.beginTransaction();
			//保存任意对象(做了合法的hbm配置的对象)
			session.update(object);
			//提交事务
			tx.commit();
			//关闭session
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//删除函数
	public void del(Object object){
		try{
			//获取hibernate的session对象
			Session session = HibernateSessionFactory.getSession();
			//清空session的缓存
			session.clear();
			//开始事务
			Transaction tx = session.beginTransaction();
			//保存任意对象(做了合法的hbm配置的对象)
			session.delete(object);
			//提交事务
			tx.commit();
			//关闭session
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//新增或者修改
	public void saveOrUpdate(Object object){
		try{
			//获取hibernate的session对象
			Session session = HibernateSessionFactory.getSession();
			//清空session的缓存
			session.clear();
			//开始事务
			Transaction tx = session.beginTransaction();
			//保存任意对象(做了合法的hbm配置的对象)
			session.saveOrUpdate(object);
			//提交事务
			tx.commit();
			//关闭session
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//获取一条记录
	public Object get(Class clzss,Serializable id){
		Object obj=null;
		try{
			//获取hibernate的session对象
			Session session = HibernateSessionFactory.getSession();
			//清空session的缓存
			session.clear();
			//根据主键获取一条记录,主键的类型要定义为Serializable类型（即可以是任意一种主键类型）
			obj=session.get(clzss,id);
			//关闭session
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
	
	//查询
	public List find(final String sql){
		List list = new ArrayList();
		try{
			Session session = HibernateSessionFactory.getSession();
			session.clear();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			list = query.list();
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	public int getAllRowCount(String hql){
		Session session = HibernateSessionFactory.getSession();
        Transaction tx = null;
        int allRows = 0;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            allRows = query.list().size();
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally{
            HibernateUtil.closeSession(session);
        }
        return allRows;
    }
    @SuppressWarnings("unchecked")
    public List queryByPage(String hql, int offset, int pageSize){
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = null;
        List list = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
            list = query.list();
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally{
            HibernateUtil.closeSession(session);
        }
        return list;
    }
    
}
