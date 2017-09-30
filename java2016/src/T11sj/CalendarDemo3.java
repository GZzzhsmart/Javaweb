package T11sj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import T3.Car;

public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		c.set(Calendar.DAY_OF_WEEK,7);
		System.out.println("星期六："+f.format(c.getTime()));
	}
}
