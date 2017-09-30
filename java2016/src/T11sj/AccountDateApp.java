package T11sj;
//计算2009年1月1日距离今天有多少天，是星期几
import java.util.*;

import T5Sj.interfaceDemo;
public class AccountDateApp {
	Date date = new Date();
	public AccountDateApp(){
		this.accountDays(109,1,1);
		int week = this.getWeek(2009,1,1);
	}
	
	public int accountDays(int year, int month, int day) {
		Date endDate = new Date(year,month - 1,day,this.date.getHours(),this.date.getMinutes());
		long time1 = this.date.getTime();
		long time2 = endDate.getTime();
		long diffdays = (time2-time1)/(24*60*60*1000)+1;
		System.out.println((1900+year) + "年" + month +"月"+day+"日"+"距离现在还有"+diffdays+"天");
		
		return (int)diffdays;
		
	}
	public int getWeek(int year, int month, int day) {
		Calendar calendar = new GregorianCalendar(year,month-1,day-1);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println((year)+"年"+month+"月"+day+"日是星期"+week);
		return week;
	}
	public static void main(String[] args) {
		new AccountDateApp();
	}
}
