package com.ht.service;

import com.ht.bean.StudentVo;

public class StudentService {

	public String addStudent(StudentVo stud){
		System.out.println(stud);
		return "新增成功";
	}
}
