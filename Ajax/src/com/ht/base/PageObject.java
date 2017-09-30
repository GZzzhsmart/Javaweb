package com.ht.base;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageObject implements Serializable{
	private int pageSize=3;
	private int recordCount;
	private int pageCount;
	private int currentPage;
	private String opr;
	private int startPos;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		pageCount = (int)Math.ceil((float)recordCount/(float)pageSize);
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getOpr() {
		return opr;
	}
	public void setOpr(String opr) {
		if(opr.equals("first")){
			currentPage=1;
		}else if(opr.equals("last")){
			currentPage=pageCount;
		}else if(opr.equals("piror")){
			if(currentPage>1){
				currentPage--;
			}else{
				currentPage=1;
			}
		}else if(opr.equals("next")){
			if(currentPage<pageCount){
				currentPage++;
			}else{
				currentPage=pageCount;
			}
		}else{
			currentPage=1;
		}
		this.opr = opr;
	}
	public int getStartPos() {
		startPos = (currentPage-1)*pageSize;
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
}
