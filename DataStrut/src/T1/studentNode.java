package T1;

public class studentNode {

	String xuehao;
	String name;
	int age;
	String banji;
	studentNode next;
	studentNode prior;
	public studentNode() {
		
	}
	public studentNode(String xuehao,String name,int age,String banji){
		this.xuehao=xuehao;
		this.name=name;
		this.age=age;
		this.banji=banji;
		next=null;
		prior=null;
	}
}
