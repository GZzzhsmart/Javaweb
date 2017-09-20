package T6;

import java.io.UnsupportedEncodingException;

public class TestBean {
	private String yourName;

	public String hello(){
		String str = "yourName:"+yourName;
		return str;
	}
	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		try{
			String str = new String(yourName.getBytes("iso-8859-1"),"utf-8");
			yourName=str;
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		this.yourName = yourName;
	}
	
}
