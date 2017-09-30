package com.gs.dao;

import com.gs.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDAO extends BaseDAO<User, String> {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {

    }

    @Override
    public List<User> queryAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        for (User u : users) {
            System.out.println(u.getId());
            System.out.println(u.getName());
        }
//        Query query = session.createSQLQuery("select * from t_user");
//        List<Object[]> results = query.list();
//        for (Object[] u : results) {
//            User user = new User();
//            user.setId(u[0].toString());
//            user.setName(u[1].toString());
//            System.out.println(user.getId());
//            System.out.println(user.getName());
//        }
        return null;
    }

    @Override
    public User query(String s) {
        return null;
    }
}
