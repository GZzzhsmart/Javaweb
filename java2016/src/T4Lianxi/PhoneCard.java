package T4Lianxi;
/* 帐号:cardNumber ；初始金额：initMoney 使用时间：time 
记费方式：minMoney
创建两个电话卡的子类——IP卡和201卡
他们记费方式不同（每分钟费用分别为0.3和0.45）；
给定一个时间time=5,和初始金额30，分别计算出剩余金额
 * */
import java.util.Scanner;
public class PhoneCard {
	int cardNumber;
	float initMoney;
	int time;
	float minMoney;
	public PhoneCard(){
		
	}
	public PhoneCard(int cardNUmber,float initMoney,int time,float minMoney){
		this.cardNumber=cardNUmber;
		this.initMoney=initMoney;
		this.time=time;
		this.minMoney=minMoney;
	}
	public void calc(){
		System.out.println("PhoneCard");
	}
}
