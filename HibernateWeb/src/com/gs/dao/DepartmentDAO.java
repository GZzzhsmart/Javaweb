package com.gs.dao;

import com.gs.bean.Department;

public interface DepartmentDAO {
	
	public Department queryById(int id);
	
	public void add(Department dept);
	
	public void delete(Department dept);
	
	public Department queryByCriteria();

}
