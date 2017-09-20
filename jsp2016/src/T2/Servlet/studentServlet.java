package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.AesUtils;
import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.PageObject1;
import bean.StudentVo;
import bean.bankVo;

public class studentServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("list")){
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("add")){
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentAdd.jsp").forward(request, response);
		}else if(action.equals("addSave")){
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String username=request.getParameter("username");
			String sex=request.getParameter("sex");
			String homeaddr=request.getParameter("homeaddr");
			String email=request.getParameter("email");
			String date=request.getParameter("date");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			StudentVo student = new StudentVo();
			String pwd = request.getParameter("password").trim();
			//对密码进行加密
			pwd = AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			student.setMobile(phone);
			student.setPassword(pwd);
			student.setUsername(username);
			student.setSex(Integer.parseInt(sex));
			student.setHomeaddress(homeaddr);
			student.setEmail(email);
			student.setProvinceId(Integer.parseInt(province));
			student.setCityId(Integer.parseInt(city));
			base.studentAdd(student);
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("del")){
			String studentID=request.getParameter("studentID");
			base.studentDel(Integer.parseInt(studentID));
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String studentID=request.getParameter("studentID");
			StudentVo  studentVo=base.findstudentById(studentID);
			request.setAttribute("studentVo", studentVo);
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			String studentid=request.getParameter("studentid");
			String phone=request.getParameter("phone");
			String username=request.getParameter("username");
			String sex=request.getParameter("sex");
			String homeaddr=request.getParameter("homeaddr");
			String email=request.getParameter("email");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			StudentVo dd=new StudentVo();
			dd.setUserId(Integer.parseInt(studentid));
			dd.setMobile(phone);
			dd.setUsername(username);
			dd.setSex(Integer.parseInt(sex));
			dd.setHomeaddress(homeaddr);
			dd.setEmail(email);
			dd.setProvinceId(Integer.parseInt(province));
			dd.setCityId(Integer.parseInt(city));
			base.studentUpdate(dd);
			listPage(request, response);
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}else if(action.equals("modifypwd")){
			String studentId = request.getParameter("studentId");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String newPassword = AesUtils.encryptStr(request.getParameter("newPassword"),AesUtils.SECRETKEY);
			if(base.checkpwd(studentId, oldpwd)){
				base.modifypwd2(studentId, newPassword);
				request.setAttribute("msg", "恭喜你，密码修改成功，请妥善保管");
			}else{
				request.setAttribute("msg", "旧密码输入错误，请重新输入");
			}
			request.getRequestDispatcher("/T11/modifypwd1.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			String studentId = request.getParameter("studentId");
			base.modifypwd2(studentId, AesUtils.encryptStr("8888", AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","初始化密码成功，初始密码为：8888");
			request.getRequestDispatcher("/T11/studentList.jsp").forward(request, response);
		}
	}
	//查询所有的学生资料
	protected void list(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		List<StudentVo>  studentList=base.studentList();
		req.setAttribute("studentList", studentList);
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from student");
		PageObject1 pager = new PageObject1();
		//设置第一个参数
		pager.setRecordCount(cnt);
		//设置第二个参数
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//设置第三个参数
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//获取当前页
		int currPage = pager.getCurrentPage();
		//获取数据库中所有的银行数据
		List<StudentVo> studentList = base.findstudentByPage(pager.getPageSize(), pager.getStartPos());
		//定义request变量，保存的是所以的银行数据
		request.setAttribute("studentList", studentList);
		request.setAttribute("pager", pager);
	}



}
