package com.ht.base;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageBeen implements Serializable{

	private int pagesize;
	private int barsum;
	private int pagesum;
	private String handle;
	private int currentpage;
	private int startpage;
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getBarsum() {
		return barsum;
	}
	public void setBarsum(int barsum) {
		pagesum = (int)Math.ceil((float)barsum/(float)pagesize);
		this.barsum = barsum;
	}
	public int getPagesum() {
		return pagesum;
	}
	public void setPagesum(int pagesum) {
		this.pagesum = pagesum;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		//��ǰҳΪ��ҳ
		if(handle.equals("firstpage")){
			//����Ϊ��ҳ
			currentpage = 1;
			//��һҳ
		}else if (handle.equals("uppage")) {
			if(currentpage>1){
//				��һҳ�ƶ���ǰҳ��ָ��
				currentpage--;
			}else {
				//����Ϊ��һҳ
				currentpage = 1;
			}
		}else if (handle.equals("downpage")) {
			if(currentpage<pagesum){
				currentpage++;
			}else {
				currentpage = pagesum ;
			}
		}else if(handle.equals("lastpage")){
			currentpage = pagesum ;
		}else {
			currentpage = 1;
		}
		this.handle = handle;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getStartpage() {
		startpage = (currentpage-1)*pagesize;
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	
}

