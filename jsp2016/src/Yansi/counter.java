package Yansi;

import java.io.UnsupportedEncodingException;

public class counter {
	private String username;
	private int count;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCount() {
		
		count++;
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
