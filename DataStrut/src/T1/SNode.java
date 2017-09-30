package T1;

public class SNode {

	private Student stud;
	private SNode next;
	private SNode prior;
	public SNode getPrior() {
		return prior;
	}
	public void setPrior(SNode prior) {
		this.prior = prior;
	}
	public SNode() {
		stud=null;
		prior=null;
		next=null;
	}
	public SNode(Student stud) {
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
	public SNode getNext() {
		return next;
	}
	public void setNext(SNode next) {
		this.next = next;
	}
}
