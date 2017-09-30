package T3;
public class Student {
	String user;
	String name;
	String sex;
	String birthday;
	public Student(){
		user="天猫";
		name="胡歌";
		sex="男";
		birthday="1980-8-8";
	}
	public void display(){
		System.out.println("姓名是"+name+"\t"+"用户名是"+user+"\t"+"性别是"+sex+"\t"+"生日是"+birthday);
	}
	public static void main(String[] args){
		Student s1=new Student();
		s1.display();
		
	}
}
