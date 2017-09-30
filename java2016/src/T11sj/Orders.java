package T11sj;

public class Orders {
	private String orderId;
	private String OrderName;
	private double price;
	private String address;
	public Orders(){
		
	}
	public Orders(String OrderId,String OrderName,double price,String address){
		this.orderId=OrderId;
		this.OrderName=OrderName;
		this.price=price;
		this.address=address;
	}
	public String getOrderId(){
		return orderId;
	}
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	public String getOrderName(){
		return OrderName;
	}
	public void setOrderName(String orderName) {
		this.OrderName = orderName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString(){
		return "订单号："+this.orderId+";订单名称："+this.OrderName+";价格："+this.price+";产地："+this.address;
		
	}
}
