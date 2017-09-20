package com.ht.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ht.vo.EmployeeVo;
import com.ht.vo.StudentVo;

import Test.BaseDAO;

public class PageServiceImpl  implements PageService{
		BaseDAO baseDAO = new BaseDAO();
	    
	    /**
	     * pageSize为每页显示的记录数
	     * page为当前显示的网页
	     */
	    public PageBean getStudentVoPageBean(int pageSize, int page){
	        PageBean pageBean = new PageBean();
	        String hql = "from StudentVo";
	        int allRows = baseDAO.getAllRowCount(hql);
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        int currentPage = pageBean.getCurPage(page);
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        List list = baseDAO.queryByPage(hql, offset, pageSize);
	        pageBean.setList(list);
	        pageBean.setAllRows(allRows);
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalPage(totalPage);
	       
	        return pageBean;
	    }

		public PageBean getEmployeeVoPageBean(int pageSize, int page) {
			PageBean pageBean = new PageBean();
			EmployeeVo emp = new EmployeeVo();
	        String hql = "from EmployeeVo ";
	        int allRows = baseDAO.getAllRowCount(hql);
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        int currentPage = pageBean.getCurPage(page);
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        List list = baseDAO.queryByPage(hql, offset, pageSize);
	        pageBean.setList(list);
	        pageBean.setAllRows(allRows);
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalPage(totalPage);
	        return pageBean;
		}

		public PageBean getClassesVoPageBean(int pageSize, int page) {
			PageBean pageBean = new PageBean();
	        String hql = "from ClassesVo ";
	        int allRows = baseDAO.getAllRowCount(hql);
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        int currentPage = pageBean.getCurPage(page);
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        List list = baseDAO.queryByPage(hql, offset, pageSize);
	        pageBean.setList(list);
	        pageBean.setAllRows(allRows);
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalPage(totalPage);
	        return pageBean;
		}
	

}
