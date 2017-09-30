package T11sj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo1 {
	public static void main(String[] args) {
		String strDate = "2016-9-26";// 定义日期字符串
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 定义日期格式
		Date date = null;
		try {
			date = format.parse(strDate);// 将字符串转换为日期
		} catch (ParseException e) {
			System.out.println("输入的日期格式不合理！");
		}
		System.out.println(strDate + "是：" + getWeek(date));
		System.out.println(strDate + "是一年的第" + getWeekOfYear(date) + "周");
		System.out.println(strDate + "是一年的" + (date.getMonth() + 1) + "月有:"
				+ getDaysOfMonth(date.getYear(), date.getMonth() + 1) + "天");

	}

	// 根据日期取得星期几
	private static String getWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
	}

	// 取得日期是某年的第几周
	private static int getWeekOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
		return week_of_year;
	}

	// 取得某个月有多少天
	private static int getDaysOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		int days_of_month = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days_of_month;
	}

}
