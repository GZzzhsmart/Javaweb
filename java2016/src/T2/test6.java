package T2;

import java.util.Scanner;

public class test6 {
	String str=new String("good"); 
    char[] ch = {'a','b','c'}; 
    public static void main(String[] args) {
    	 test6 ex=new test6(); 
         ex.change(ex.str,ex.ch); 
         System.out.print(ex.str+" and "); 
         System.out.print(ex.ch); 
	}
    public void change(String str,char ch[]){ 
        str="test ok"; 
        ch[0]='g'; 
    }
    
    
}
