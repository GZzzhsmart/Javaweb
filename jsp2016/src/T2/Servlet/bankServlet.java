package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.ManagerVo;
import bean.PageObject1;
import bean.bankVo;

public class bankServlet extends HttpServlet {

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
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}else if(action.equals("add")){
			String bankName = request.getParameter("bankName");
			bankVo bank = new bankVo();
			bank.setBankName(bankName);
			base.bankAdd(bank);
			listPage(request, response);
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}else if(action.equals("del")){
			int bankId = Integer.parseInt(request.getParameter("bankId"));
			base.bankDel(bankId);
			listPage(request, response);
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String bankId = request.getParameter("bankId");
			bankVo bank = base.findbankById(bankId);
			request.setAttribute("bank", bank);
			request.getRequestDispatcher("/T11/bankUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			int bankId = Integer.parseInt(request.getParameter("bankId"));
			String bankName = request.getParameter("bankName");
			bankVo bank = new bankVo();
			bank.setBankId(bankId);
			bank.setBankName(bankName);
			base.bankUpdate(bank);
			listPage(request, response);
			request.getRequestDispatcher("/T11/bankList.jsp").forward(request, response);
		}
	}
	//查询所有的银行数据
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中的银行数据
		List<bankVo> bankList = base.bankList();
		//定义request变量，保存的是所有的银行数据
		request.setAttribute("bankList", bankList);
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from bank");
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
		List<bankVo> bankList = base.findbankByPage(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的银行数据
		request.setAttribute("bankList", bankList);
		request.setAttribute("pager", pager);
	}


}
