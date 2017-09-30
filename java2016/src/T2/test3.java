package T2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 查询出当前这个星期的星期六是几号。
 * */
public class test3 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		c.set(Calendar.DAY_OF_WEEK,7);
		System.out.println("星期六:"+f.format(c.getTime()));
	}
}
