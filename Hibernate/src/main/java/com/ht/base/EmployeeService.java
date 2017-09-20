package com.ht.base;

import java.util.List;

public class EmployeeService implements IBase{

	public void add(Object obj) {
		System.out.println("EmployeeService add");
	}
	public void del(Object obj) {
		System.out.println("EmployeeService del");
	}
	public List list(PageObject pager) {
		System.out.println("EmployeeService list");
		return null;
	}
	public void update(Object obj) {
		System.out.println("EmployeeService update");
	}

}
