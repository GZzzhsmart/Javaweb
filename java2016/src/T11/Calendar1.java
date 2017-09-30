package T11;

import java.util.Date;


/**
 * 计算2009年1月1日距离今天有多少天，是星期几（30分钟）
 * 年份:传进去的值+1900，0代表1900年
 * 月份：0代表1月份
 * */
public class Calendar1 {
	public static void main(String[] args) {
		Date dd = new Date(109,0,1);
		System.out.println(dd.toLocaleString());
		Date dd2 = new Date();
		long diff = dd2.getTime()-dd.getTime();
		System.out.println("相差的毫秒数："+diff);
		System.out.println("相差的天数："+(diff/(24*60*60*1000)));
	}
}
