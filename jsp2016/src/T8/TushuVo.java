package T8;

import java.io.Serializable;

public class TushuVo implements Serializable{
	
	private  int bookid;
	private  String bookzuozhe;
	private  String biaoti;
	private  String chuban;
	private  String shijian;
	private  float jiage;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookzuozhe() {
		return bookzuozhe;
	}
	public void setBookzuozhe(String bookzuozhe) {
		this.bookzuozhe = bookzuozhe;
	}
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getChuban() {
		return chuban;
	}
	public void setChuban(String chuban) {
		this.chuban = chuban;
	}
	public String getShijian() {
		return shijian;
	}
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	public float getJiage() {
		return jiage;
	}
	public void setJiage(float jiage) {
		this.jiage = jiage;
	}
	
	
}
