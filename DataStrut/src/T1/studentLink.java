package T1;


public class studentLink {
	//定义头节点
	studentNode head;
	//初始化
	public studentLink() {
		//建表
		head=new studentNode();
		head.next=null;
		head.prior=null;
	}
	
	//新增
	public void addNode(String xuehao,String name,int age,String banji){
		studentNode p=head;
		while(p.next!=null){
			p=p.next;
		}
		//需要新增的节点
		studentNode temp=new studentNode( xuehao, name, age, banji);
		p.next=temp;
		temp.prior=p;
	}
	//遍历
	public void display(){
		studentNode p=head;
		System.out.println("从头到尾-------------------------");
		while(p.next!=null){
			System.out.print(p.next.xuehao+"   ");
			System.out.print(p.next.name+"   ");
			System.out.print(p.next.age+"   ");
			System.out.println(p.next.banji);
			p=p.next;
		}
		
		//从尾到头
		System.out.println("从尾到头-------------------------");
		while(p.prior!=head){
			
			System.out.print(p.xuehao+"   ");
			System.out.print(p.name+"   ");
			System.out.print(p.age+"   ");
			System.out.println(p.banji);
		
			p=p.prior;
		}
		System.out.print(p.xuehao+"   ");
		System.out.print(p.name+"   ");
		System.out.print(p.age+"   ");
		System.out.println(p.banji);
		
	}
	//查找
	public void findNode(String xuehao,String name){
		
		studentNode  p=head;
		while(p.next!=null){
			if(p.next.name.equals(xuehao)){
				System.out.println(p.next.xuehao+"    ");
				break;
			}else if(p.next.name.equals(name)){
				System.out.println(p.next.name);
				break;
			}else{
				p=p.next;
			}
		}
	}
	
	public void MinAge(){
		System.out.println("年龄最小的学生：");
		studentNode p=head;
		while(p.next!=null){
			if(p.next.age<=p.next.next.age){
				System.out.println(p.next.name);
				break;
			}else{
				p=p.next;
			}
			
		}
	}
	///删除
	public void DelNOde(String xuehao,String name){
		studentNode p=head;
		while(p.next!=null){
			if(p.next.xuehao.equals(xuehao)){
				p.next.next.prior=p.next.prior;
				p.next=p.next.next;
				break;
			}else if(p.next.name.equals(name)){
				p.next.next.prior=p.next.prior;
				p.next=p.next.next;
				break;
			}else{
				p=p.next;
			}
		}
		
	}
	
	//5.给定两个学生的学号，将他们的位置互换一下
	public void Huan(String xuehao1,String xuehao2){
		studentNode p=head;
		while(p.next!=null){
			if(p.next.name.equals(xuehao1)){
				boolean t=p.next.name.equals(xuehao2);
				
			}
		}
		
	}
	
	//新增
	public void addNode2(String xuehao,String name,int age,String banji){
		studentNode p=head;
		while(p.next!=null){
			p=p.next;
		}
		//需要新增的节点
		studentNode temp=new studentNode( xuehao, name, age, banji);
		while(p.next!=null){
			if(age<=p.next.age){
				p.next=temp;
			}
		}
	}
	
	//链表大小
	public int size(){
		int n=0;
		studentNode p=head;
		while(p.next!=null){
			p=p.next;
			n++;
		}
		return n; 
	}
	
	public static void main(String[] args) {
		studentLink link=new studentLink();
		link.addNode("HT001", "小赖子", 21, "高级程序班");
		link.addNode("HT002", "小智", 19, "高级程序班");
		link.addNode("HT003", "小芳", 20, "学前专业");
		link.addNode("HT004", "小露", 12, "生化工程班");
		
		link.display();
		System.out.println("size="+link.size());
		System.out.println("-----------------------------------");
		link.findNode("HT002", "小智");
		link.findNode("HT004", "小露");
		System.out.println("-----------------------------------");
		link.MinAge();
		System.out.println("------------删除了两个人------------");
	
		link.DelNOde("HT002", "");
		link.DelNOde("", "小芳");
		link.display();
		System.out.println("size="+link.size());
		System.out.println("---------------**--------------------");
	}
}
