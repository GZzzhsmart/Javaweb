package T4Lianxi;

public class CardIp extends PhoneCard{
	public CardIp(){
		
	}
	public CardIp(int cardNumber,float initMoney,int time){
		super(cardNumber,initMoney,time,0.3f);
	}
	public void calc(){
		initMoney = initMoney-time*minMoney;
		System.out.println("IP卡：每分钟价格是"+minMoney +";通话"+time+"分钟，账号余额是"+initMoney);
	}
}
