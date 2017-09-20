package com.ht.base;

import java.io.Serializable;

public class PagingBean implements Serializable{

	//��ҳ��
	private int sumpage;
	//ÿҳ�ļ�¼����
	private int pagebarsize=3;
	//��ǰҳ
	private int currentpage;
	//�ܼ�¼����
	private int pagebarsum;
	//��صĲ���
	private String handle;
	//��ʼ����λ��
	private int starlocal;
	public int getStarlocal() {
		starlocal = (currentpage-1)*pagebarsize;
		return starlocal;
	}
	public void setStarlocal(int starlocal) {
		this.starlocal = starlocal;
	}
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getPagebarsize() {
		return pagebarsize;
	}
	public void setPagebarsize(int pagebarsize) {
		this.pagebarsize = pagebarsize;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagebarsum() {
		return pagebarsum;
	}
	public void setPagebarsum(int pagebarsum) {
		//����ҳ������
		sumpage = (int)Math.ceil((float)pagebarsum/(float)pagebarsize);
		this.pagebarsum = pagebarsum;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		//���ѡ����ǵ�һҳ
		if(handle.equals("firstpage")){
			currentpage=1;
		}else if (handle.equals("uppage")) {
			//�����һҳ
			if(currentpage>1){
				currentpage--;
			}else {
				currentpage=1;
			}
		}else if (handle.equals("downpage")) {
			//�����һҳ
			if(currentpage<sumpage){
				currentpage++;
			}else {
				currentpage = sumpage;
			}
		}else if (handle.equals("lastpage")) {
			currentpage = sumpage;
		}else {
			currentpage=1;
		}
		this.handle = handle;
	} 
}
