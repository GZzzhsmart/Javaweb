package Yansi;

public class Student {

	private String username;//姓名
	private String phone;//电话号码
	private String sex;//性别
	private int age;//年龄
	private String education;//受教育程度
	private String[] hobit;//爱好
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String[] getHobit() {
		return hobit;
	}
	//带索引的函数
	public String getHobit(int index){
		
		return hobit[index];
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	//带索引的函数
	public void setHobit(int index,String value){
		this.hobit[index]=value;
	}
}
