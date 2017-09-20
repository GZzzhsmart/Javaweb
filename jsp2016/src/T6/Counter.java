package T6;

import java.io.UnsupportedEncodingException;

public class Counter {

	private String username;
	private int count;
	public String getUsername() {
		return username;
	}
	//当页面提交数据时用的是get方式提交的中文，则必须用该方法进行乱码处理
	public void setUsername(String username) {
		
		try {
			//把iso-8859-1的字符编码转换成utf-8的编码
			String str = new String(username.getBytes("iso-8859-1"),"utf-8");
			username = str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.username = username;
	}
	public int getCount() {
		count++;
		return count;
	}
//	public void setCount(int count) {
//		this.count = count;
//	}
}
