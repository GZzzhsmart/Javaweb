package com.ht.base;

import java.util.List;

import com.ht.vo.ClassesVo;
import com.ht.vo.NationVo;
import com.ht.vo.SVo;


public interface SqlSentence {
	
	public abstract void addstud(SVo  student);
	public abstract List<SVo> studentlist();
	public abstract SVo findstudent(String sno);
	public abstract void delstudent(String sno);
	public abstract void updatestudent(SVo student);
	public abstract List<SVo> studentlist(int pagesize,int startpage);
	public abstract int sum(String sql);
	public abstract List<ClassesVo> classlist();
	public abstract List<NationVo> nationlist();
	
}
