package Test1;

import Test1.Student;
import Test1.studentNode;

public class studentNode {

	private Student stud;
	private studentNode next;
	private studentNode prior;
	
	public studentNode() {
		stud=null;
		prior=null;
		next=null;
	}
	public studentNode(Student stud) {
		this.stud=stud;
		next=null;
		prior=null;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	public studentNode getNext() {
		return next;
	}
	public void setNext(studentNode next) {
		this.next = next;
	}
	public studentNode getPrior() {
		return prior;
	}
	public void setPrior(studentNode prior) {
		this.prior = prior;
	}
	
	
}
