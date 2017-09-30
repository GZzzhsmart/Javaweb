package T2;
/**
 * 写一个方法，实现字符串的反转，如：输入abc，输出cba
 * */
public class test1 {
	public static void main(String[] args) {
		String s = "abc";
		s = new StringBuffer(s).reverse().toString();
		System.out.println(s);
	}
}
