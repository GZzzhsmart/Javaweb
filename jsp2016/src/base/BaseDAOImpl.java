package base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.CityVo;
import bean.ManagerVo;
import bean.ProvinceVo;
import bean.StudentVo;
import bean.UsersVo;
import bean.TeacherGradeVo;
import bean.TeacherVo;
import bean.bankVo;

public class BaseDAOImpl implements IBaseDAO{
	//新增城市数据
	public void cityAdd(CityVo city){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into city values('" + city.getCityName() +"',"+city.getProvinceId()+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除城市数据
	public void cityDel(int cityId){
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql ="delete city where cityId="+cityId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//查询所有城市的资料
	public List<CityVo> cityList(){
		Connection conn = DBConn.openDB();
		List<CityVo> list = new ArrayList<CityVo>();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select c.*,p.provinceName from city c inner join Province p on c.provinceId=p.provinceId order by c.provinceId,c.cityId";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityVo city = new CityVo();
				city.setCityId(rs.getInt("CityId"));
				city.setCityName(rs.getString("CityName").trim());
				city.setProvinceId(rs.getInt("ProvinceId"));
				city.setProvinceName(rs.getString("ProvinceName").trim());
				list.add(city);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	//通过城市id来查找城市数据
	public CityVo findCityById(String cityId) {
		Connection conn = DBConn.openDB();
		CityVo city = null;
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from city where cityId="+cityId;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				city = new CityVo();
				city.setCityId(rs.getInt("cityId"));
				city.setCityName(rs.getString("cityName").trim());
				city.setProvinceId(rs.getInt("provinceId"));
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return city;
	}
	//修改城市的资料
	public void cityUpdate(CityVo city){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update city set cityName='" + city.getCityName() +"',provinceId="+city.getProvinceId()+" where cityId="+city.getCityId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//获取所有省份的资料
	public List<ProvinceVo> provinceList() {
		Connection conn = DBConn.openDB();
		List<ProvinceVo> list = new ArrayList<ProvinceVo>();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from province";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ProvinceVo prov = new ProvinceVo();
				prov.setProvinceId(rs.getInt("provinceId"));
				prov.setProvinceName(rs.getString("provinceName").trim());
				list.add(prov);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	//通过查找讲师的id来查找讲师的数据
	public TeacherGradeVo findgradeById(String gradeId) {
		Connection conn = DBPool.getConnection();
		TeacherGradeVo grade = new TeacherGradeVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from teacherGrade where grade_id="+gradeId;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				grade.setGradeId(rs.getInt("grade_id"));
				grade.setGradeName(rs.getString("grade_name").trim());
				grade.setGradePercent(rs.getFloat("grade_percent"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}
	//新增讲师数据
	public void gradeAdd(TeacherGradeVo grade) {
		Connection conn = DBPool.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into teacherGrade values('" + grade.getGradeName() +"',"+grade.getGradePercent()+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除讲师数据
	public void gradeDel(int gradeId) {
		//使用连接池来连接数据库
		Connection conn = DBPool.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete teacherGrade where grade_id=" + gradeId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//获取所有的讲师资料
	public List<TeacherGradeVo> gradeList() {
		//用连接池创建数据库连接
		Connection conn = DBPool.getConnection();
		List<TeacherGradeVo> list = new ArrayList<TeacherGradeVo>();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from teacherGrade ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeacherGradeVo grade = new TeacherGradeVo();
				grade.setGradeId(rs.getInt("grade_id"));
				grade.setGradeName(rs.getString("grade_name").trim());
				grade.setGradePercent(rs.getFloat("grade_percent"));
				list.add(grade);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	//修改讲师资料
	public void gradeUpdate(TeacherGradeVo grade) {
		//使用连接池来连接数据库
		Connection conn = DBPool.getConnection();
		try{
			Statement stmt = conn.createStatement();
			String sql = "update teacherGrade set grade_name='"+grade.getGradeName()+"',grade_percent="+grade.getGradePercent()+" where grade_id=" + grade.getGradeId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//城市列表分页
	public int getCityCount(String sql) {
	
		Connection conn = DBConn.openDB();
		int cnt=0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//查询所有城市的资料
	public List<CityVo> cityList(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<CityVo> list = new ArrayList<CityVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" c.*,p.provinceName from city c inner join Province p on c.provinceId=p.provinceId ";
			sql += " where cityid not in(select top "+startPos+" cityid from city order by provinceId,cityId)  order by c.provinceId,c.cityId";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityVo city = new CityVo();
				city.setCityId(rs.getInt("cityId"));
				city.setCityName(rs.getString("cityName").trim());
				city.setProvinceId(rs.getInt("provinceId"));
				city.setProvinceName(rs.getString("provinceName").trim());
				list.add(city);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//讲师列表分页
	public int getCount(String sql) {
		Connection conn = DBPool.getConnection();
		int cnt = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//查询所有讲师的资料
	public List<TeacherGradeVo> teacherList(int pageSize, int startPos) {
		Connection conn = DBPool.getConnection();
		List<TeacherGradeVo> list = new ArrayList<TeacherGradeVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from teacherGrade where grade_id not in(select top "+startPos+" grade_id from teacherGrade)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeacherGradeVo teacher = new TeacherGradeVo();
				teacher.setGradeId(rs.getInt("grade_id"));
				teacher.setGradeName(rs.getString("grade_name"));
				teacher.setGradePercent(rs.getFloat("grade_percent"));
				list.add(teacher);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//分页
	public List<ManagerVo> findManagerByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<ManagerVo> list = new ArrayList<ManagerVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from manager where manager_id not in(select top "+startPos+" manager_id from manager)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ManagerVo manager = new ManagerVo();
				manager.setManagerId(rs.getInt("manager_Id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_Password"));
				manager.setManagerName(rs.getString("manager_Name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//通过id来查找管理员资料
	public ManagerVo findmanagerById(String managerId) {
		Connection conn = DBConn.openDB();
		ManagerVo manager= new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where manager_id="+managerId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				manager.setManagerId(rs.getInt("manager_Id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_Password"));
				manager.setManagerName(rs.getString("manager_Name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}
	//新增管理员资料
	public void managerAdd(ManagerVo manager) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into manager values(";
			sql += "'"+manager.getManagerAccount() +"',";
			sql += "'"+manager.getManagerPassword()+"',";
			sql += "'"+manager.getManagerName()+"',";
			sql += "'"+manager.getSex()+"',";
			sql += "'"+manager.getContact()+"',";
			sql += "'"+manager.getStatus()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除管理员数据
	public void managerDel(int managerId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete manager where manager_id="+managerId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询所有管理员数据
	public List<ManagerVo> managerList() {
		Connection conn = DBConn.openDB();
		List<ManagerVo> list = new ArrayList<ManagerVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ManagerVo manager = new ManagerVo();
				manager.setManagerId(rs.getInt("manager_id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_password"));
				manager.setManagerName(rs.getString("manager_name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改管理员资料
	public void managerUpdate(ManagerVo manager) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update manager set manager_account='";
			sql += manager.getManagerAccount() +"',manager_name='";
			sql += manager.getManagerName()+"',sex='";
			sql += manager.getSex()+"',contact='";
			sql += manager.getContact()+"' ";
			sql += " where manager_id="+manager.getManagerId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//检查旧密码
	public boolean checkPwd(String managerId, String oldpassword) {
		boolean isok = false;
		Connection conn = DBConn.openDB();
		ManagerVo manager = new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where manager_id="+managerId+"and manager_password='"+oldpassword+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isok;
	}
	//修改密码
	public void modifyPwd(String managerId, String newpassword) {
		Connection conn = DBConn.openDB();
		ManagerVo manager = new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update manager set manager_password='"+newpassword+"' where manager_id="+managerId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//更改状态(禁用，启用)
	public void updateStatus(String managerId, int status) {
		Connection conn = DBConn.openDB();
		ManagerVo manager = new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update manager set status='"+status+"'where manager_id="+managerId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//增加数据
	public void bankAdd(bankVo bank) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into bank values('" + bank.getBankName() +"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除银行数据
	public void bankDel(int bankId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete bank where bank_id=" + bankId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查找银行数据
	public List<bankVo> bankList() {
		Connection conn = DBConn.openDB();
		List<bankVo> list = new ArrayList<bankVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from bank";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				bankVo bank = new bankVo();
				bank.setBankId(rs.getInt("bankId"));
				bank.setBankName(rs.getString("bankName"));
				list.add(bank);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改银行数据
	public void bankUpdate(bankVo bank) {
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "update bank set bank_name='"+bank.getBankName()+"'where bank_id=" + bank.getbankId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//通过id来查找银行数据
	public bankVo findbankById(String bankId) {
		Connection conn = DBConn.openDB();
		bankVo bank= new bankVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from bank where bank_id="+bankId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				bank.setBankId(rs.getInt("bank_id"));
				bank.setBankName(rs.getString("bank_name").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bank;
	}
	//分页
	public List<bankVo> findbankByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<bankVo> list = new ArrayList<bankVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from bank where bank_id not in(select top "+startPos+" bank_id from bank)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				bankVo bank = new bankVo();
				bank.setBankId(rs.getInt("bank_id"));
				bank.setBankName(rs.getString("bank_name").trim());
				list.add(bank);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//检查旧密码
	public boolean checkpwd2(String studentId, String oldpassword) {
		boolean isok = false;
		Connection conn = DBConn.openDB();
		StudentVo student = new StudentVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from student where userid="+studentId+"and password='"+oldpassword+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isok;
	}
	//查找学生
	public StudentVo findstudentById(String studentId) {
		StudentVo stu=null;
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from  student where userid="+studentId;
			ResultSet dd=stm.executeQuery(sql);
			if(dd.next()){
				stu=new StudentVo();
				stu.setUserId(dd.getInt(1));
				stu.setMobile(dd.getString(2));
				stu.setPassword(dd.getString(3));
				stu.setUsername(dd.getString(4));
				stu.setSex(dd.getInt(5));
				stu.setHomeaddress(dd.getString(6));
				stu.setEmail(dd.getString(7));
				stu.setRegisterdate(dd.getString(8));
				stu.setProvinceId(dd.getInt(9));
				stu.setCityId(dd.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}
	//分页
	public List<StudentVo> findstudentByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<StudentVo> list = new ArrayList<StudentVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from student where userid not in(select top "+startPos+" userid from student)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				StudentVo student = new StudentVo();
				student.setUserId(rs.getInt("userid"));
				student.setMobile(rs.getString("mobile").trim());
				student.setPassword(rs.getString("password").trim());
				student.setUsername(rs.getString("user_name").trim());
				student.setSex(rs.getInt("sex"));
				student.setHomeaddress(rs.getString("home_address").trim());
				student.setEmail(rs.getString("email").trim());
				student.setRegisterdate(rs.getString("register_date").trim());
				student.setProvinceId(rs.getInt("provinceId"));
				student.setCityId(rs.getInt("cityId"));
				list.add(student);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改密码
	public void modifypwd2(String studentId, String newpassword) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update student set password='"+newpassword+"' where userid="+studentId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//新增学生
	public void studentAdd(StudentVo student) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="insert into student values('"+student.getMobile()+"'" +
			",'"+student.getPassword()+"','"+student.getUsername()+
			"',"+student.getSex()+",'"+student.getHomeaddress()+
			"','"+student.getEmail()+"','"+new Date().toLocaleString()+
			"',"+student.getProvinceId()+","+student.getCityId()+")";
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除学生
	public void studentDel(int studentId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete student where userid="+studentId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询学生列表
	public List<StudentVo> studentList() {
		Connection conn=DBConn.openDB();
		List<StudentVo> list=new ArrayList<StudentVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from student";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				StudentVo student=new StudentVo();
				student.setUserId(rs.getInt(1));
				student.setMobile(rs.getString(2));
				student.setPassword(rs.getString(3));
				student.setUsername(rs.getString(4));
				student.setSex(rs.getInt(5));
				student.setHomeaddress(rs.getString(6));
				student.setEmail(rs.getString(7));
				student.setRegisterdate(rs.getString(8));
				student.setProvinceId(rs.getInt(9));
				student.setCityId(rs.getInt(10));
				list.add(student);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改学生
	public void studentUpdate(StudentVo student) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update student set  mobile='"+student.getMobile()
			+"',password='"+student.getPassword()+
			"',user_name='"+student.getUsername()+
			"',sex="+student.getSex()+
			",home_address='"+student.getHomeaddress()+
			"',email='"+student.getEmail()+
			"',register_date='"+new Date().toLocaleString()+
			"',provinceId="+student.getProvinceId()+
			",cityId="+student.getCityId()+" where userId="+student.getUserId();
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//检查旧密码
	public boolean checkpwd1(String teacherId, String oldpassword) {
		boolean isok = false;
		Connection conn = DBConn.openDB();
		TeacherVo teacher = new TeacherVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from teacher where teacher_id="+teacherId+"and teacher_password='"+oldpassword+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isok;
	}
	//查找教师资料
	public TeacherVo findteacherById(String teacherId) {
		Connection conn = DBConn.openDB();
		TeacherVo teacher= new TeacherVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from teacher where teacher_id="+teacherId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherMobile(rs.getString("teacher_mobile").trim());
				teacher.setTeacherPassword(rs.getString("teacher_password").trim());
				teacher.setTeacherName(rs.getString("teacher_name").trim());
				teacher.setSex(rs.getInt("sex"));
				teacher.setHomeAddress(rs.getString("home_address").trim());
				teacher.setEmail(rs.getString("email").trim());
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special").trim());
				teacher.setTeacherLength(rs.getString("teacher_length").trim());
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url").trim());
				teacher.setBankId(rs.getInt("bank_id"));
				teacher.setAccountNo(rs.getString("accountNo").trim());
				teacher.setAccountName(rs.getString("accountName").trim());
				teacher.setGradeId(rs.getInt("grade_id"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	//分页
	public List<TeacherVo> findteacherByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<TeacherVo> list = new ArrayList<TeacherVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from teacher where teacher_id not in(select top "+startPos+" teacher_id from teacher)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeacherVo teacher = new TeacherVo();
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherMobile(rs.getString("teacher_mobile").trim());
				teacher.setTeacherPassword(rs.getString("teacher_password").trim());
				teacher.setTeacherName(rs.getString("teacher_name").trim());
				teacher.setSex(rs.getInt("sex"));
				teacher.setHomeAddress(rs.getString("home_address").trim());
				teacher.setEmail(rs.getString("email").trim());
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special").trim());
				teacher.setTeacherLength(rs.getString("teacher_length").trim());
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url").trim());
				teacher.setBankId(rs.getInt("bank_id"));
				teacher.setAccountNo(rs.getString("accountNo").trim());
				teacher.setAccountName(rs.getString("accountName").trim());
				teacher.setGradeId(rs.getInt("grade_id"));
				list.add(teacher);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改密码
	public void modifypwd1(String teacherId, String newpassword) {
		Connection conn = DBConn.openDB();
		TeacherVo teacher = new TeacherVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update teacher set teacher_password='"+newpassword+"' where teacher_id="+teacherId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//新增教师
	public void teacherAdd(TeacherVo teacher) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into teacher values(";
			sql += "'"+teacher.getTeacherMobile() +"',";
			sql += "'"+teacher.getTeacherPassword()+"',";
			sql += "'"+teacher.getTeacherName()+"',";
			sql += "'"+teacher.getSex()+"',";
			sql += "'"+teacher.getHomeAddress()+"',";
			sql += "'"+teacher.getEmail()+"',";
			sql += "'"+teacher.getTeacherIntroduce()+"',";
			sql += "'"+teacher.getTeacherSpecial()+"',";
			sql += "'"+teacher.getTeacherLength()+"',";
			sql += "'"+teacher.getEducation()+"',";
			sql += "'"+teacher.getHeadpictureUrl()+"',";
			sql += "'"+teacher.getBankId()+"',";
			sql += "'"+teacher.getAccountNo()+"',";
			sql += "'"+teacher.getAccountName()+"',";
			sql += "'"+teacher.getGradeId()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除讲师
	public void teacherDel(int teacherId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete teacher where teacher_id="+teacherId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询老师列表数据
	public List<TeacherVo> teacherList() {
		Connection conn=DBConn.openDB();
		List<TeacherVo> list=new ArrayList<TeacherVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from teacher";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				TeacherVo teacher=new TeacherVo();
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherMobile(rs.getString("teacher_mobile").trim());
				teacher.setTeacherPassword(rs.getString("teacher_password").trim());
				teacher.setTeacherName(rs.getString("teacher_name").trim());
				teacher.setSex(rs.getInt("sex"));
				teacher.setHomeAddress(rs.getString("home_address").trim());
				teacher.setEmail(rs.getString("email").trim());
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special").trim());
				teacher.setTeacherLength(rs.getString("teacher_length").trim());
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url").trim());
				teacher.setBankId(rs.getInt("bank_id"));
				teacher.setAccountNo(rs.getString("accountNo").trim());
				teacher.setAccountName(rs.getString("accountName").trim());
				teacher.setGradeId(rs.getInt("grade_id"));
				list.add(teacher);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改讲师资料
	public void teacherUpdate(TeacherVo teacher) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update teacher set  teacher_mobile='"+teacher.getTeacherMobile()+
			"',teacher_name='"+teacher.getTeacherName()+
			"',sex='"+teacher.getSex()+
			"',home_address='"+teacher.getHomeAddress()+
			"',email='"+teacher.getEmail()+
			"',teacher_introduce='"+teacher.getTeacherIntroduce()+
			"',teacher_special='"+teacher.getTeacherSpecial()+
			"',teacher_length='"+teacher.getTeacherLength()+
			"',education='"+teacher.getEducation()+
			"',head_picture_url='"+teacher.getHeadpictureUrl()+
			"',bank_id='"+teacher.getBankId()+
			"',accountNo='"+teacher.getAccountNo()+
			"',accountName='"+teacher.getAccountName()+
			"',grade_id='"+teacher.getGradeId()+"' where teacher_id="+teacher.getTeacherId();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询省份数据
	public List<CityVo> CityList(int provinceId) {
		Connection conn = DBConn.openDB();
		List<CityVo> list = new ArrayList<CityVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from city where provinceId="+provinceId;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityVo city= new CityVo();
				city.setCityId(rs.getInt("cityId"));
				city.setCityName(rs.getString("cityName").trim());
				city.setProvinceId(rs.getInt("provinceId"));
				list.add(city);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//检查旧密码
	public boolean checkpwd(String userid, String oldpassword) {
		boolean isok = false;
		Connection conn = DBConn.openDB();
		UsersVo user = new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from users where userid="+userid+"and password='"+oldpassword+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isok;
	}
	//修改密码
	public void modifypwd3(String userid, String newpassword) {
		Connection conn = DBConn.openDB();
		UsersVo user = new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update users set password='"+newpassword+"' where userid="+userid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//分页
	public List<UsersVo> finduserByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<UsersVo> list = new ArrayList<UsersVo>();
		try {
			//select userid,mobile,user_name,sex,home_address,email,register_date,user_type,isnull(p.provinceName,'未知') provinceName,isnull(c.cityName,'未知') cityName from users u left join province p on u.provinceid=p.provinceid left join city c on u.cityid=c.cityid;
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" userid,mobile,user_name,sex,home_address,email,register_date,user_type,isnull(p.provinceName,'未知') provinceName,isnull(c.cityName,'未知') cityName from users u left join province p on u.provinceid=p.provinceid left join city c on u.cityid=c.cityid ";
			sql += " where userid not in(select top "+startPos +" userid from users) order by userid";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				UsersVo user= new UsersVo();
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setUserName(rs.getString("user_name"));
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email"));
				user.setRegisterDate(rs.getDate("register_date"));
				user.setUserType(rs.getInt("user_type"));
				user.setProvinceName(rs.getString("provinceName"));
				user.setCityName(rs.getString("cityName"));
				list.add(user);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//新增用户
	public void userAdd(UsersVo user) throws Exception {
		Connection conn = DBConn.openDB();
		Statement stmt = conn.createStatement();
		String sql = "insert into users values(";
		sql += "'"+user.getMobile() +"',";
		sql += "'"+user.getPassword()+"',";
		sql += "'"+user.getUserName()+"',";
		sql += "'"+user.getSex()+"',";
		sql += "'"+user.getHomeAddress()+"',";
		sql += "'"+user.getEmail()+"',getdate(),";
		sql += "'"+user.getProvinceId()+"',";
		sql += "'"+user.getCityId()+"',";
		sql += "'"+user.getUserType()+"'";
		sql += ")";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
		
	}
	
	//删除用户
	public void userDel(int userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete teacher where userid="+userid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//修改用户
	public void userUpdate(UsersVo user) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update users set  mobile='"+user.getMobile()+
			"',user_name='"+user.getUserName()+
			"',sex='"+user.getSex()+
			"',home_address='"+user.getHomeAddress()+
			"',email='"+user.getEmail()+
			"',register_date='"+user.getRegisterDate()+
			"',provinceId='"+user.getProvinceId()+
			"',cityId='"+user.getCityId()+"' where userid="+user.getUserid();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询用户列表信息
	public List<UsersVo> userList() {
		Connection conn=DBConn.openDB();
		List<UsersVo> list=new ArrayList<UsersVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from users";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				UsersVo user=new UsersVo();
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				list.add(user);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//查找用户资料
	public UsersVo finduserById(String userid) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from users where userid="+userid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
