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
import bean.CityVo;
import bean.ManagerVo;
import bean.PageObject1;

public class ManagerServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//定义变量
		String action = request.getParameter("action");
		if(action.equals("add")){
			ManagerVo manager = new ManagerVo();
			manager.setManagerAccount(request.getParameter("managerAccount").trim());
			String pwd = request.getParameter("managerPassword").trim();
			//对密码进行加密处理
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			manager.setManagerPassword(pwd);
			manager.setManagerName(request.getParameter("managerName").trim());
			manager.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			manager.setContact(request.getParameter("contact").trim());
			manager.setStatus(1);//有效
			base.managerAdd(manager);
			//获取所有数据并转向到列表页面
			listPage(request,response);
			//转向到managerList.jsp
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("list")){
			//查询所有的数据并转向到列表页面
			listPage(request,response);
			//重定向到managerList.jsp目标页面
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("del")){
			//获取参数
			String managerId = request.getParameter("managerId");
			base.managerDel(Integer.parseInt(managerId));
			listPage(request, response);
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String managerId = request.getParameter("managerId");
			ManagerVo manager = base.findmanagerById(managerId);
			request.setAttribute("manager", manager);
			request.getRequestDispatcher("/T11/managerUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			ManagerVo manager = new ManagerVo();
			manager.setManagerId(Integer.parseInt(request.getParameter("managerId")));
			manager.setManagerAccount(request.getParameter("managerAccount").trim());
			manager.setManagerName(request.getParameter("managerName").trim());
			manager.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			manager.setContact(request.getParameter("contact").trim());
			base.managerUpdate(manager);
			listPage(request, response);
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("modifyPwd")){//修改密码
			String managerId = request.getParameter("managerId");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String managerPassword = AesUtils.encryptStr(request.getParameter("managerPassword"),AesUtils.SECRETKEY);
			if(base.checkPwd(managerId, oldpwd)){
				//修改密码
				base.modifyPwd(managerId, managerPassword);
				//从modifyPwd.jsp页面取值
				request.setAttribute("msg", "恭喜你，密码修改成功，请妥善保管");
			}else{
				request.setAttribute("msg", "旧密码输入错误，请重新输入");
			}
			//转向
			request.getRequestDispatcher("/T11/modifyPwd.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			//初始化密码
			String managerId = request.getParameter("managerId");
			base.modifyPwd(managerId, AesUtils.encryptStr("88888888", AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","初始化密码成功，初始密码为：88888888");
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}else if(action.equals("status")){//更改状态
			String managerId = request.getParameter("managerId");
			int status = Integer.parseInt(request.getParameter("status"));
			base.updateStatus(managerId, status);
			listPage(request, response);
			request.getRequestDispatcher("/T11/managerList.jsp").forward(request, response);
		}
	}
	//查询所有的管理员数据
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中的管理员数据
		List<ManagerVo> managerList = base.managerList();
		//定义request变量，保存的是所有的管理员数据
		request.setAttribute("managerList", managerList);
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from manager");
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
		//获取数据库中所有的管理员数据
		List<ManagerVo> managerList = base.findManagerByPage(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的管理员数据
		request.setAttribute("managerList", managerList);
		request.setAttribute("pager", pager);
	}

}
