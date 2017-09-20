package com.ht.base;

import java.io.Serializable;

public class PageObject implements Serializable {
	/**
	 * 参数传递的顺序
	 * 1.设置pageCount的值；
	 * 2.设置currentPage的值
	 * 3.设置opr的值
	 * */
	
	//每页显示的记录数
	private int pageSize=4;
	//记录总数
	private int recordCount;
	//页数
	private int pageCount;
	//当前页
	private int currentPage;
	
	//操作
	private String opr;
	//起始位置
	private int startPos;
	public String getOpr() {
		return opr;
	}
	public void setOpr(String opr) {
		/*点击首页链接：first
		 *点击上一页链接：piror;
		 *点击下一页链接：next
		 *点击末页链接：last 
		 * 
		 * */
		this.opr = opr;
	}
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
		//计算页数
		pageCount=(int)Math.ceil((float)recordCount/(float)pageSize);
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartPos() {
		startPos = (currentPage-1)*pageSize;
		return startPos;
	}
}
