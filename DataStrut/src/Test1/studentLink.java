package Test1;

import java.util.Scanner;

import Test1.Student;

/**
 * 1.实现链表的如下操作：
1.创建一个学生类；
2.创建节点类，把学生类当做节点的数据域
3.创建链表类；
4.实现新增节点功能；
5.删除节点功能；
6.遍历节点功能；
7.创建测试类，测试链表的功能；
 * 
 * */
public class studentLink {

	studentNode head;
	public studentLink(){
		//建表
		head = new studentNode();
	}
	//新增节点
	public void addNode(Student s){
		studentNode p = new studentNode(s);
		studentNode h = head;
		while(h.getNext()!=null){
			h = h.getNext();
		}
		h.setNext(p);
	}
	
	
	//删除节点
	//按学号删除
	public void deleteById(int studid){
		studentNode p = head;
		while(p.getNext()!=null){
			if(p.getNext().getStud().getStudid()==studid){
				p.setNext(p.getNext().getNext());
				break;
			}
			p = p.getNext();
		}
	}
	
	//按姓名删除
	public void deleteByName(String name){
		studentNode p = head;
		while(p.getNext()!=null){
			if(p.getNext().getStud().getName().equals(name)){
				p.setNext(p.getNext().getNext());
				break;
			}
			p = p.getNext();
		}
	}
	
	//遍历
	public void display(){
		studentNode p = head;
		while(p.getNext()!=null){
			System.out.println(p.getNext().getStud());
			p = p.getNext();
		}
		System.out.println("--------------------------");
		System.out.println(p.getStud());
		while(p.getPrior()!=null){
			System.out.println(p.getPrior().getStud());
			p = p.getPrior();
		}
	}
	
	public static void main(String[] args) {
		studentLink link = new studentLink();
		Student s1 = new Student(1001,"小赖子",18,"宏图1601班");
		Student s2 = new Student(1002,"小美",20,"宏图1602班");
		Student s3 = new Student(1003,"小智",20,"宏图1603班");
		Student s4 = new Student(1004,"小露",17,"宏图1604班");
		Student s5 = new Student(1005,"小芳",21,"宏图1501班");
		link.addNode(s1);
		link.addNode(s2);
		link.addNode(s3);
		link.addNode(s4);
		link.addNode(s5);
		link.display();
		//按学号删除
		Scanner input = new Scanner(System.in);
//		System.out.println("请输入你要删除的学生的学号:");
//		int studid = input.nextInt();
//		link.deleteById(studid);
//		link.display();
		//按姓名删除
		System.out.println("请输入你要删除的学生的姓名");
		String name = input.next();
		link.deleteByName(name);
		link.display();
	}
}
