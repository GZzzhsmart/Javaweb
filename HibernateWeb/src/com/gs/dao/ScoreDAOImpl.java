package com.gs.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import com.gs.bean.Score;

public class ScoreDAOImpl extends BaseDAO implements ScoreDAO {

	@Override
	public Score query(int stuId, int courseId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Score where stuId =:stuId and courseId =:cId");
		query.setParameter("stuId", stuId);
		query.setParameter("cId", courseId);
		Score s = (Score) query.uniqueResult();
		session.close();
		return s;
	}

}
