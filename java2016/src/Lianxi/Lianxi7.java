package Lianxi;
/**
 * 增加了封锁控制之后的代码
 * */
public class Lianxi7 {
	private int idx=0;
	private char[] data = new char[6];
	public void push(char c){
		synchronized (this) {
			data[idx]=c;
			idx++;
		}
	}
	public char pop(){
		synchronized (this) {
			idx--;
			return data[idx];
		}
		
		
	}
}
