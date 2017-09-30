package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import Test.BaseDAO;
import com.ht.base.PageObject;
import com.ht.bean.StudVo;

@SuppressWarnings({ "unused", "serial" })
public class StudentServlet extends HttpServlet {
	
	BaseDAO base = new BaseDAO();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(action.equals("add")){
			String studid = request.getParameter("studid");
			String studname = request.getParameter("studname");
			String cardid = request.getParameter("cardid");
			String classname = request.getParameter("classname");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			System.out.println("stud="+studid);
			StudVo s = new StudVo();
			s.setAge(Integer.parseInt(age));
			s.setCardid(cardid);
			s.setClassname(classname);
			s.setSex(sex);
			s.setStudid(Integer.parseInt(studid));
			s.setStudname(studname);
			base.add(s);
			//查询学生列表
			List<StudVo> studList=base.studList();
			String data=JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("list")){
			//查询学生列表
			List<StudVo> studList=base.studList();
			String data=JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("del")){
			String studid = request.getParameter("studid");
			base.del(studid);
			//查询学生列表
			List<StudVo> studList=base.studList();
			String data=JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("update")){
			String studid = request.getParameter("studid");
			StudVo stud = base.findStudById(studid);
			String data = JSON.toJSONString(stud);
			System.out.println(data);
			out.println(data);
		}else if(action.equals("updatesave")){
			String studid = request.getParameter("studid");
			String studname = request.getParameter("studname");
			System.out.println("studname="+studname);
			String cardid = request.getParameter("cardid");
			String classname = request.getParameter("classname");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			StudVo s = new StudVo();
			System.out.println("age="+age);
			s.setCardid(cardid);
			s.setAge(Integer.parseInt(age));
			s.setClassname(classname);
			s.setSex(sex);
			s.setStudid(Integer.parseInt(studid));
			s.setStudname(studname);
			base.update(s);
			//查询学生列表
			List<StudVo> studList=base.studList();
			String data=JSON.toJSONString(studList);
			System.out.println(data);
			out.println(data);
		}
		out.flush();
		out.close();
	}
	
	//分页
//	public void listpage(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out=response.getWriter();
//		String  currentPage =request.getParameter("currentPage");
//		String opr=request.getParameter("opr");
//		System.out.println("��ǰҳ��"+currentPage);
//		int cnt=base.getCount("select count(*) cnt from stud");
//		PageObject pager=new PageObject();
//		System.out.println("��ʼֵ"+ pager.getStartPos());
//		pager.setRecordCount(cnt);
//		if(currentPage== null || currentPage.equals("")){
//			pager.setCurrentPage(1);
//		}else{
//			pager.setCurrentPage(Integer.parseInt(currentPage));
//		}
//		if(opr==null || opr.equals("")){
//			pager.setOpr("first");
//		}else{
//			pager.setOpr(opr);
//		}
//		System.out.println("��ʼֵ"+ pager.getStartPos());
//		request.setAttribute("pagev",pager );
//		List stuList=base.studlist(pager.getPageSize(),pager.getStartPos());
//		stuList.add(pager);
//		String data=JSON.toJSONString(stuList);
//		out.print(data);
//		
//	}
}
