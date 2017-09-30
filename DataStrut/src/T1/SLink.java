package T1;

import java.util.Scanner;

public class SLink {

	SNode head;
	public SLink() {
		head = new SNode();
	}
	//添加节点
	public void addNode(Student s){
		SNode p = new SNode(s);
		SNode h = head;
		while(h.getNext() !=null){
			h=h.getNext();
		}
		h.setNext(p);
	}
	//将存储学生的链表设计为有序的，每次往链表中加学生时，按年龄排序
	public void addNode2(Student s){
		//新增节点
		SNode p = new SNode(s);
		SNode h = head;
		while(h.getNext() !=null){
			if(h.getNext().getStud().getAge()<=s.getAge()){
				h=h.getNext();
			}else{
				p.setNext(h.getNext());
				h.setNext(p);
				break;
			}
		}
		h.setNext(p);
	}
	//将学生链表改成双向链表，完成同样的功能
	public void addNode3(Student s){
		//新增节点
		SNode p = new SNode(s);
		SNode h = head;
		while(h.getNext() !=null){
			if(h.getNext().getStud().getAge()<=s.getAge()){
				h=h.getNext();
			}else{
				p.setNext(h.getNext());
				h.getNext().setPrior(p);
				h.setNext(p);
				p.setPrior(h);
				break;
			}
		}
		h.setNext(p);
		p.setPrior(h);
	}

	//遍历
	public void display(){
		SNode p = head;
		while(p.getNext() !=null){
			System.out.println(p.getNext().getStud());
			p= p.getNext();
		}
		System.out.println("-------------------------------");
		System.out.println(p.getStud());
		while(p.getPrior() !=null){
			System.out.println(p.getPrior().getStud());
			p= p.getPrior();
		}
	}

	//按学号查找
	public Student searchById(int studid){
		Student s = null;
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getStudid()==studid){
				s = p.getNext().getStud();
				break;
			}
			p= p.getNext();
		}
		return s;
	}
	//按姓名查找
	public Student searchByName(String name){
		Student s = null;
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getName().equals(name)){
				s = p.getNext().getStud();
				break;
			}
			p= p.getNext();
		}
		return s;
	}
	//按姓名查找
	public Student minAge(){
		Student s = null;
		SNode p = head;
		if(p.getNext()==null){
			return null;
		}
		//初始化
		int age=head.getNext().getStud().getAge();
		s = head.getNext().getStud();
		//查找最小年龄的学生信息
		while(p.getNext() !=null){
			if(p.getNext().getStud().getAge()<age){
				age = p.getNext().getStud().getAge();
				s = p.getNext().getStud();
			}
			p= p.getNext();
		}
		return s;
	}
	//按学号删除
	public void deleteById(int studid){
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getStudid()==studid){
				p.setNext(p.getNext().getNext());
				break;
			}
			p= p.getNext();
		}
	}
	//按姓名删除
	public void deleteByName(String name){
		SNode p = head;
		while(p.getNext() !=null){
			if(p.getNext().getStud().getName().equals(name)){
				p.setNext(p.getNext().getNext());
				break;
			}
			p= p.getNext();
		}
	}
	//交换函数
	public void swap(int studid1, int studid2){
		SNode t1,t2,t3,t4,t5;
		/*
		 * t1:头节点
		 * t2:p1
		 * t3:p2
		 * t4:p3
		 * */
		t1=t2=t3=t4=t5=null;
		SNode p = head;
		int cnt1=0,cnt2=0;
		while(p.getNext() !=null){
			cnt1++;
			if(p.getNext().getStud().getStudid()==studid1){
				t1=p;
				t2=p.getNext();
				break;
			}
			p=p.getNext();
		}
		p = head;
		while(p.getNext() !=null){
			cnt2++;
			if(p.getNext().getStud().getStudid()==studid2){
				t3=p;
				t4=p.getNext();
				break;
			}
			p=p.getNext();
		}
		System.out.println("cnt1="+cnt1+";cnt2="+cnt2);
		/*2个相邻
		 * t1是前面一个
		 * t2,t3是同一个
		 */
		
		if(cnt1+1==cnt2){
			t2.setNext(t4.getNext());
			t1.setNext(t4);
			t4.setNext(t2);
		}else if(cnt2+1==cnt1){
			//t3,t4,t1,t2
			t4.setNext(t2.getNext());
			t3.setNext(t2);
			t2.setNext(t4);
		}else{
			t1.setNext(t4);
			t5=t4.getNext();
			t4.setNext(t2.getNext());
			t2.setNext(t5);
			t3.setNext(t2);
		}
	}
	//不交换节点，只交换节点内的值
	public void swapValue(int studid1, int studid2){
		SNode t1,t2;
		t1=t2=null;
		SNode p = head;
		while(p.getNext()!=null){
			if(p.getNext().getStud().getStudid()==studid1){
				t1=p.getNext();
			}
			if(p.getNext().getStud().getStudid()==studid2){
				t2=p.getNext();
			}
			if(t1!=null && t2!=null)
				break;
			p = p.getNext();
		}
		//临时保存t1的学生资料
		Student s = t1.getStud();
		//把t2节点中的学生资料赋值给t1节点
		t1.setStud(t2.getStud());
		//把临时变量中的学生资料赋值给t2
		t2.setStud(s);
	}
	public static void main(String[] args) {
		SLink link = new SLink();
		Student s1 = new Student(1001,"小赖子",18,"宏图1601班");
		Student s2 = new Student(1002,"小智",20,"宏图1602班");
		Student s3 = new Student(1003,"小露",17,"宏图1603班");
		Student s4 = new Student(1004,"小芳",21,"宏图1604班");
		Student s5 = new Student(1005,"小美",22,"宏图1501班");
		link.addNode(s1);
		link.addNode(s2);
		link.addNode(s3);
		link.addNode(s4);
		link.addNode(s5);
		link.display();
		//可以按学号，名字查找学生
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要查询的学生姓名：");
//		int studid = input.nextInt();
		String name = input.next();
		Student t = link.searchByName(name);
		System.out.println("你查找的姓名为："+name+"的信息如下：");
		if(t==null){
			System.out.println("查无此人");
		}else{
			System.out.println(t);
		}
		*/
		//查出节点中年龄最小的学生
//		System.out.println("年龄最小的学生信息如下：");
//		System.out.println(link.minAge());
//		//可以按学号，名字删除节点
//		Scanner input = new Scanner(System.in);
//		System.out.println("请输入你要删除的学生姓名：");
////		int studid = input.nextInt();
////		link.deleteById(studid);
//		String name = input.next();
//		link.deleteByName(name);
//		link.display();
//		String name = input.next();
//		Student t = link.searchByName(name);
		
//		给定两个学生的学号，将他们的位置互换一下
		link.swap(1001, 1002);
		link.display();
		
	}
}