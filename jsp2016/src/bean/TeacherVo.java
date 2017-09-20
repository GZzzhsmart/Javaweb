package bean;

import java.io.Serializable;

public class TeacherVo implements Serializable{
	private int teacherId;//教师id
	private String teacherMobile;//教师电话
	private String teacherPassword;//教师密码
	private String teacherName;//教师姓名
	private int sex;//性别
	private String homeAddress;//家庭住址
	private String email;//邮箱
	private String teacherIntroduce;//教师简介
	private String teacherSpecial;//教师特长
	private String teacherLength;//教龄
	private String education;//学历
	private String headpictureUrl;//头像上传地址
	private int bankId;//银行id
	private String accountNo;//银行账户
	private String accountName;//开户人
	private int gradeId;//教师分类
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherMobile() {
		return teacherMobile;
	}
	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTeacherIntroduce() {
		return teacherIntroduce;
	}
	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}
	public String getTeacherSpecial() {
		return teacherSpecial;
	}
	public void setTeacherSpecial(String teacherSpecial) {
		this.teacherSpecial = teacherSpecial;
	}
	public String getTeacherLength() {
		return teacherLength;
	}
	public void setTeacherLength(String teacherLength) {
		this.teacherLength = teacherLength;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getHeadpictureUrl() {
		return headpictureUrl;
	}
	public void setHeadpictureUrl(String headpictureUrl) {
		this.headpictureUrl = headpictureUrl;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
}
