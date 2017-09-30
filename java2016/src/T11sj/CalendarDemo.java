package T11sj;

//使用Calendar类得到一年的所有星期二的日期

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("输入年：");
		Scanner s1 = null;
		int year = s.nextInt();
		Calendar c = Calendar.getInstance();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		c.set(year, 1, 1);

		while (true) {
			if (c.get(Calendar.YEAR) != year) {
				break;
			} else {
				if (c.get(Calendar.DAY_OF_WEEK) == 3) {
					System.out.println("星期二：" + f.format(c.getTime()));
				}
				c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
			}
		}

	}
}
