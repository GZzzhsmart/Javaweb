package com.gs.common.bean;

import java.util.List;

/**
 * 分页对象，专门负责为EasyUI提供分页的功能
 * @author Administrator
 *
 */
public class Pager4EasyUI<T> {
	
	private int page; // 当前第几页
	private int pageSize; // 每一页多少项
	
	private int total; //总记录数
	private List<T> rows; // 每页的结果 
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getBeginIndex() {
		return (page - 1) * pageSize;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
