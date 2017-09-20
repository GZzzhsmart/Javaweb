package com.ht.base;

public interface PageService {
	public PageBean getStudentVoPageBean(int pageSize, int page);
	public PageBean getEmployeeVoPageBean(int pageSize, int page);
	public PageBean getClassesVoPageBean(int pageSize, int page);
}
