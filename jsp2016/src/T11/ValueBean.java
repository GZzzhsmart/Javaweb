package T11;

import java.io.Serializable;

public class ValueBean implements Serializable{
	private int value;//随机整数值
	private int count;//猜对用的次数
	
	public ValueBean(){
		reset();
	}
	public int getValue() {
		random();
		return value;
	}
	public void setValue(int value) {
		random();
	}
	private void random(){
		if(value==-1){
			double n = Math.random()*100;
			value = (int)Math.round(n);
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public void inc(){
		count++;
	}
	public void reset(){
		value=-1;
		count=0;
	}
}
