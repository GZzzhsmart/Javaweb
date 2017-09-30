package T3;
public class User {
	String yonghuming;
	String kouling;
	public User(){
		kouling="天王盖地虎";
		yonghuming="孙悟空";
	}
	public void display(){
		
		System.out.println("用户名是:"+yonghuming+"\t"+"口令是:"+kouling);
	}
	public User(String yonghuming,String kouling){
		this.yonghuming=yonghuming;
		this.kouling=kouling;
		
	}
	public static void main(String[] args){
		User s1=new User();
		s1.display();
		User s2=new User("宝塔镇河妖","李靖");
		s2.display();
	}
}
