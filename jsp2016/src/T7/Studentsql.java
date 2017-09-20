package T7;

import java.util.List;

public interface Studentsql {

	public List<StudentBean> list();
	public void addcount(StudentBean bean);
	public List<StudentBean> studentlist();
	public void addstudent(String studentname);
}
