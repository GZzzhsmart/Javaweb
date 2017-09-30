package T3;

public class Stu {
	final double PI=3.14;
	String name;
	int age;
	float score;
	
	//把字符串转换为整形
	public int toInt(String str){
		//用整形的包装类Integer进行转换
		//valueOf,parseInt函数把字符串转换为整形;
		return Integer.valueOf(str);
//		return Integer.parseInt(str);
	}
	//把字符串转换为单精度类型(float)
	public float toFloat(String str){
		return Float.parseFloat(str);
	}
	//把字符串转换为boolean类型
	public boolean toBoolean(String str){
		return Boolean.parseBoolean(str);
	}
	public void display(){
		System.out.println("name="+name+";age="+age+";score="+score);
	}
	public static void main(String[] args) {
		/**特别注意：
		 * 1.如果要把字符串转换为整形，首先必须保证字符串是数字才能转换成功
		 * 2.如果要把字符串转换为布尔类型，首先必须保证字符串是（true,false）才能转换成功
			
		*/
		String str = "134.55";
		Stu s = new Stu();
		//把字符串转换为整形
		int a = s.toInt(str);
		float b = s.toFloat(str);
		float c = a+b;
		System.out.println("c="+c);
		String str1 = "false";
		boolean bb = s.toBoolean(str1);
		System.out.println(bb==false);
//		PI=6.28;错误：常量不能修改
	}
}
