package T4Lianxi;

public class Card201 extends PhoneCard{
public Card201(){
		
	}
	public Card201(int cardNumber,float initMoney,int time){
		super(cardNumber,initMoney,time,0.3f);
	}
	public void calc(){
		initMoney = initMoney-time*minMoney;
		System.out.println("201卡：每分钟价格是"+minMoney +";通话"+time+"分钟，账号余额是"+initMoney);
	}
}
