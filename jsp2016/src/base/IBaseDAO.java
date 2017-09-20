package base;
import java.util.List;
import bean.CityVo;
import bean.ManagerVo;
import bean.ProvinceVo;
import bean.StudentVo;
import bean.UsersVo;
import bean.TeacherVo;
import bean.bankVo;

import bean.TeacherGradeVo;
public interface IBaseDAO {
	public abstract void cityAdd(CityVo city);
	public abstract void cityUpdate(CityVo city);
	public abstract void cityDel(int cityId);
	CityVo findCityById(String cityId);
	public abstract List<CityVo> cityList();
	public abstract List<ProvinceVo> provinceList();
	
	public abstract void gradeAdd(TeacherGradeVo grade);
	public abstract void gradeUpdate(TeacherGradeVo grade);
	public abstract void gradeDel(int gradeId);
	TeacherGradeVo findgradeById(String gradeId);
	public abstract List<TeacherGradeVo> gradeList();
	
	//城市列表
	public abstract int getCount(String sql);
	public abstract List<CityVo> cityList(int pageSize,int startPos);
	
	//讲师列表
	public abstract List<TeacherGradeVo> teacherList(int pageSize,int startPos);
	//管理员列表
	public abstract void managerAdd(ManagerVo manager);
	public abstract void managerUpdate(ManagerVo manager);
	public abstract void managerDel(int managerId);
	public abstract ManagerVo findmanagerById(String managerId);
	public abstract List<ManagerVo> findManagerByPage(int pageSize,int startPos);
	public abstract List<ManagerVo> managerList();
	public abstract boolean checkPwd(String managerId,String oldpassword);
	public abstract void modifyPwd(String managerId,String newpassword);
	public abstract void updateStatus(String managerId,int status);
	
	//银行表
	public abstract void bankAdd(bankVo bank);
	public abstract void bankDel(int bankId);
	public abstract void bankUpdate(bankVo bank);
	public abstract bankVo findbankById(String bankId);
	public abstract List<bankVo> bankList();
	public abstract List<bankVo> findbankByPage(int pageSize,int startPos);
	
	//用户表
	public abstract List<CityVo> CityList(int provinceId);
	public abstract void userAdd(UsersVo user) throws Exception;
	public abstract void userDel(int userid);
	public abstract void userUpdate(UsersVo user);
	public abstract List<UsersVo> userList();
	public abstract UsersVo finduserById(String userid);
	public abstract List<UsersVo> finduserByPage(int pageSize,int startPos);
	public abstract boolean checkpwd(String userid,String oldpassword);
	public abstract void modifypwd3(String userid,String newpassword);
	
	//学生表
	public abstract void studentAdd(StudentVo student);
	public abstract void studentUpdate(StudentVo student);
	public abstract void studentDel(int studentId);
	public abstract StudentVo findstudentById(String studentId);
	public abstract List<StudentVo> studentList();
	public abstract List<StudentVo> findstudentByPage(int pageSize,int startPos);
	public abstract boolean checkpwd2(String studentId,String oldpassword);
	public abstract void modifypwd2(String studentId,String newpassword);
	
	//教师表
	public abstract void teacherAdd(TeacherVo teacher);
	public abstract void teacherUpdate(TeacherVo teacher);
	public abstract void teacherDel(int teacherId);
	public abstract TeacherVo findteacherById(String teacherId);
	public abstract List<TeacherVo> teacherList();
	public abstract List<TeacherVo> findteacherByPage(int pageSize,int startPos);
	public abstract boolean checkpwd1(String teacherId,String oldpassword);
	public abstract void modifypwd1(String teacherId,String newpassword);
	
}
