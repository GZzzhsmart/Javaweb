package com.ht.action;

import com.ht.base.IBaseDAO;
import com.ht.base.WebApplicationContextUtil;
import com.ht.vo.CourseVo;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		IBaseDAO baseDAO = (IBaseDAO)WebApplicationContextUtil.createService("baseDAO");
		CourseVo c = new CourseVo();
		c.setCoursename("Spring");
		baseDAO.save(c);
		return SUCCESS;
	}

}
