package T1;

import java.util.List;

import T1.StudentVo;

public interface IBaseDAO {

	public abstract void studentAdd(StudentVo student);
	public abstract void studentDel(int studid);
	public abstract void studentUpdate(StudentVo student);
	public abstract List<StudentVo> studentList();
	public abstract StudentVo findstudentById(String studid);
	public abstract List<StudentVo> studentList(int pageSize,int startPos);
}
