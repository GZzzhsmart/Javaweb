package T11;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		//格式化
		System.out.println(d.toLocaleString());
		Date d1 = new Date("2016/9/27 19:52:00");
		System.out.println(d1.toLocaleString());
		System.out.println("星期："+(d.getDay()+1));
		
		DateFormat df = DateFormat.getDateInstance();
		try{
			Date d2 = df.parse("2016-8-8");
			
			//设置格式
			String sdate = df.format(d2);
			System.out.println(sdate);
			
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
}
