package T5;

public class MyException3 extends Exception{
	static String msg;
	int flag;
	public MyException3(){
		super(msg);
		this.msg=msg;
		this.flag=flag;
		System.out.println(getMessage());
	}
	@Override
	public String getMessage(){
		switch(flag){
		case 1:
			msg="错误号为1,需要处理....";
			break;
		case 2:
			msg="错误号为2，需要处理....";
			break;
		}
		return msg;
	}
}
