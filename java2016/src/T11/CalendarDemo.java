package T11;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class CalendarDemo {
	public static void main(String[] args) {
		Date d = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		//星期是从星期天开始的
		System.out.println("获取星期："+cal.get(Calendar.DAY_OF_WEEK));
		cal.set(Calendar. MONTH,11);
		//月份是从0开始的，0=1月份，以此类推
		System.out.println("获取月份："+(cal.get(Calendar.MONTH)+1));
		
	}
	
}
