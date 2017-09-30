package test;

import javax.swing.text.Element;


public class TableElement {
	
	private javax.swing.text.Element element;
	private boolean isCross;
	private int wordNum;
	
	public TableElement(){
		isCross = true;
	}
	
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public boolean isCross() {
		return isCross;
	}
	public void setCross(boolean isCross) {
		this.isCross = isCross;
	}
	public int getWordNum() {
		return wordNum;
	}
	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}

}