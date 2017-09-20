package bean;

import java.io.Serializable;

public class PageObject implements Serializable{
	//每页显示的总记录数
	private int pageSize=15;
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
		//具体操作
		if(opr.equals("first")){//首页
			currentPage=1;
		}else if(opr.equals("last")){//末页
			currentPage=pageCount;
		}else if(opr.equals("piror")){//上一页
			if(currentPage>1){
				currentPage--;
			}else{
				currentPage=1;
			}
		}else if(opr.equals("next")){//下一页
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
