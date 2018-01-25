package top.zzh.common;

import java.io.Serializable;
import java.util.List;

public class PagingBean<T> implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//总记录数
	private long total;
	//每页显示记录数
	private int pageSize;
	//当前页数
	private int currentPage;
	private List<T> rows;
	public PagingBean() {
	}

	public PagingBean(int total, int pageSize, int currentPage, List<T> rows) {
		this.total = total;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.rows = rows;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getrows() {
		return rows;
	}

	public void setrows(List<T> rows) {
		this.rows = rows;
	}
	public int getStartIndex(){
		return (currentPage-1)*pageSize;
	}
}
