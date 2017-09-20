package com.base;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static org.hibernate.SessionFactory sessionFactory;  
    static{  
        sessionFactory = new Configuration().configure().buildSessionFactory();  
    }  
      
    public static Session openSession(){  
        Session session = sessionFactory.openSession();  
        return session;  
    }  
      
    public static void closeSession(Session session){  
        if(session != null){  
            session.close();  
        }  
    }  
}