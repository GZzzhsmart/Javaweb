package T2;

public class test2 {
	public static void changeStr(String str){
		str = "welcome";
	}
	public static void main(String[] args) {
		String str = "1234";
		changeStr(str);
		System.out.println(str);
	}
}
