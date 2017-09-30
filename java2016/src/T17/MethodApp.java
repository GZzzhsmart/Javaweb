package T17;

import java.lang.reflect.*;

public class MethodApp {
	public MethodApp(){
		
	}
	public String getMethods(Class c){
		StringBuffer  buf = new StringBuffer ();
		// 获得类的所有方法， 注意，不能获得私有方法
		Method[] methods = c.getMethods();
		// 遍历所有方法
        Method method = null;
        for(int i=0;i<methods.length;i++){
        	method=methods[i];
        	//获取方法的访问修饰符
        	 buf.append(Modifier.toString(method.getModifiers())).append(" ");
             // 获取方法的返回类型
             Class returnType = method.getReturnType();
             buf.append(returnType.getName()).append(" ");
             // 获取方法名
             buf.append(method.getName()).append("(");

             // 获取方法的参数类型
             Class[] paramTypes = method.getParameterTypes();
             for (int j = 0; j < paramTypes.length; j++) {
                 if (j == paramTypes.length - 1) {
                     buf.append(paramTypes[j].getName());
                 } else {
                     buf.append(paramTypes[j].getName()).append(", ");
                 }
             }
             buf.append(")");
             // 获取方法声明的异常
             Class[] excepTypes = method.getExceptionTypes();
             for (int j = 0; j < excepTypes.length; j++) {
                 if (j == 0) {
                     buf.append(" throws ");
                 }
                 if (j == excepTypes.length - 1) {
                     buf.append(excepTypes[j].getName());
                 } else {
                     buf.append(excepTypes[j].getName()).append(", ");
                 }
             }
             buf.append("\n");
         }
         return buf.toString();
     }

     public static void main(String args[]) throws Exception {
         Class c = Class.forName("java.util.Map");
         MethodApp method = new MethodApp();
         String str = method.getMethods(c);
         System.out.println(str);
     }
 }
