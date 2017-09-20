package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ht.base.DBConn;
import com.ht.base.HibernateSessionFactory;
import com.ht.base.HibernateUtil;
import com.ht.vo.StudentVo;

public class BaseDAO {

	Session session = null;
	//新增函数
	public void save(Object object){
		try{
			Session session = HibernateUtil.openSession();
			session.clear();
			Transaction tx = session.beginTransaction();
			session.save(object);
			tx.commit();
			session.close();
		}catch(Exception e){
			System.out.println("新增成功");
			e.printStackTrace();
		}
	}
	//学生列表
	public List<StudentVo> findAllStud(){
		session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from StudentVo");
		List<StudentVo> studentList = query.list();
		tx.commit();
		session.close();
		return studentList;
	}
	//删除学生
	public void delStud(int studid){
		session = HibernateUtil.openSession();
		StudentVo studentVo = (StudentVo)session.get(StudentVo.class,new Integer(studid));
		session.delete(studentVo);
		session.flush();
		session.close();
	}
	//修改学生信息
	public StudentVo StudUpdate(int studid){
		session = HibernateUtil.openSession();
		StudentVo studentVo = (StudentVo)session.get(StudentVo.class,new Integer(studid));
		session.close();
		return studentVo;
	}
	//保存修改信息
	public StudentVo studUpdateSave(StudentVo studentVo){
		session = HibernateUtil.openSession();
		session.update(studentVo);
		session.flush();
		session.close();
		return studentVo;
	}
	
	/**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	public int getAllRowCount(String hql){
        
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        session = sessionFactory.openSession();
        session = HibernateUtil.openSession();
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
        session = HibernateUtil.openSession();
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
    
    
    
    
    
    
    
    
    
    
    
  //老方法进行分页
	Connection conn = DBConn.openDB();
	public int sum(String sql) {
		int n = 0;
		try {
			Statement st = conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("分页出错");
			e.printStackTrace();
		}
		return n;
	}
	public List<StudentVo> studentlist(int pagesize, int startpage) {
		List<StudentVo> list = new ArrayList<StudentVo>();
		try { 
			Statement st = conn.createStatement();
			String sql = "select top "+pagesize+" * from stud where studid not in(select top "+startpage+" studid from stud)";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				StudentVo student = new StudentVo();
				student.setStudid(rs.getInt("studid"));
				student.setStudname(rs.getString("studname"));
				student.setSex(rs.getString("sex"));
				student.setCardid(rs.getString("cardid"));
				student.setClassid(rs.getInt("classid"));
				student.setAge(rs.getInt("age"));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("查询学生表分页出错");
			e.printStackTrace();
		}
		return list;
	}
	
}
