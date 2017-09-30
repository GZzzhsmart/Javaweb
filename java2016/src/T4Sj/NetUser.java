package T4Sj;
/**
 * 定义一个网络用户类，要处理的信息有用户ID、用户密码、email地址。
 * 在建立类的实例时，把以上三个信息都作为构造函数的参数输入，
 * 其中用户ID和用户密码时必须的，
 * 缺省的email地址是用户ID加上字符串"@gameschool.com"  
 * 
 * */
import java.util.Scanner;
public class NetUser {
	private String ID;
	private String key;
	private String emailDress;
	
	public NetUser(String ID,String key){
		this.ID=ID;
		this.key=key;
		this.emailDress=ID+"@gameschool.com";
	}
	public void output(){
		System.out.println("ID:"+ID+"\n 用户密码"+key+"\n 用户地址"+emailDress);
	}
	public static void main(String[] args){
		NetUser user = new NetUser("5566","yan");
		user.output();
	}
}
