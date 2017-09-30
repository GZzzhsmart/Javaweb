package T17;

import java.lang.reflect.*;

public class FieldApp {
	public FieldApp(){
		
	}
	public String getFields(Class c){
		StringBuffer buf = new StringBuffer ();
		Field[] fields = c.getDeclaredFields();
		//遍历属性，提取属性信息
		Field f = null;
		for(int i=0;i<fields.length;i++){
			f = fields[i];
			//获取属性的访问修饰符
			buf.append(Modifier.toString(f.getModifiers())).append(" ");
			//获取属性的类型
			Class type = f.getType();
            buf.append(type.getName()).append(" ");
            // 获取属性名
            buf.append(f.getName()).append(";\n");
		}
		return buf.toString();
		
	}
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("java.awt.Button");
		FieldApp field = new FieldApp();
		String str = field.getFields(c);
		System.out.println(str);
	}
}
