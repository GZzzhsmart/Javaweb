package com.ht.action;

import org.hibernate.Session;

import com.ht.base.HibernateSessionFactory;
import com.ht.vo.StudentVo;

public class UserAction {

	
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		StudentVo s = new StudentVo();
		s.setStudid(1008);
		s.setStudname("张六");
		s.setAge(21);
		s.setSex("男");
		s.setCardid("123456123456123456");
		s.setClassid(1);
		//保存
//		session.save(s);
		//删除
//		session.delete(s);
		//修改
		session.update(s);
		session.beginTransaction().commit();
		System.out.println("操作成功");
//		session.close();
	}
}
