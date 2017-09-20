package com.ht.base;

import java.util.List;

public class StudentService implements IBase{

	public void add(Object obj) {
		System.out.println("StudentService add");
	}

	public void del(Object obj) {
		System.out.println("StudentService del");
	}

	public List list(PageObject pager) {
		System.out.println("StudentService list");
		return null;
	}

	public void update(Object obj) {
		System.out.println("StudentService update");
	}

}
