package T6;
/**
 * 特点：
 * 1.javabean必须要有默认的构造函数
 * 2.成员变量一般就属性;
 * 3.属性对应取值和获取值得get和set方法
 * */
public class Student {
	private int studid;
	private String studName;
	private String sex;
	private int age;
	private String className;
	private String[] hobit;
	private boolean marry;
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
	public boolean isMarry() {
		return marry;
	}
	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	
}
