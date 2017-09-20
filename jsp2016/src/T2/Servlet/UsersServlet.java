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
import bean.PageObject;
import bean.ProvinceVo;
import bean.UsersVo;

public class UsersServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("init")){
			String provinceId = request.getParameter("provinceId");
			//查询所有省份数据
			List<ProvinceVo> provList = base.provinceList();
			//有没有省份资料
			List<CityVo> cityList = null;
			if(provinceId!=null){//在新增页面改变了省份时有值
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			getServletContext().getRequestDispatcher("/T11/userAdd.jsp").forward(request, response);
		}else if(action.equals("add")){
			UsersVo user = new UsersVo();
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId").trim()));
			user.setCityId(Integer.parseInt(request.getParameter("cityId").trim()));
			user.setMobile(request.getParameter("mobile").trim());
			String pwd = request.getParameter("password").trim();
			//对密码进行加密处理
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			user.setPassword(pwd);
			user.setUserName(request.getParameter("userName").trim());
			user.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setUserType(1);//学生
			try{
				base.userAdd(user);
			}catch(Exception e){
				request.setAttribute("msg", "该手机号码已经注册过了，请输入其他手机号码");
				String provinceId = request.getParameter("provinceId");
				//查询所有省份数据
				List<ProvinceVo> provList = base.provinceList();
				//有没有省份资料
				List<CityVo> cityList = null;
				if(provinceId!=null){//在新增页面改变了省份时有值
					cityList = base.CityList(Integer.parseInt(provinceId));
				}else if(provList.size()>0){
					ProvinceVo p = provList.get(0);
					cityList = base.CityList(p.getProvinceId());
				}
				request.setAttribute("provList",provList);
				request.setAttribute("cityList",cityList);
				request.setAttribute("provinceId",provinceId);
				getServletContext().getRequestDispatcher("/T11/userAdd.jsp").forward(request, response);
			}
			listPage(request,response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request, response);
		}else if(action.equals("list")){
			listPage(request,response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String provinceId = request.getParameter("provinceId");
			String tel = request.getParameter("mobile");
			String name = request.getParameter("userName");
			String home = request.getParameter("homeAddress");
			String em = request.getParameter("email");
			//查询所有省份数据
			List<ProvinceVo> provList = base.provinceList();
			//有没有省份资料
			List<CityVo> cityList = null;
			if(provinceId!=null){//在新增页面改变了省份时有值
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			request.setAttribute("tel",tel);
			request.setAttribute("name",name);
			request.setAttribute("home",home);
			request.setAttribute("em",em);
			String userid = request.getParameter("userid");
			UsersVo user = base.finduserById(userid);
			request.setAttribute("user",user);
			request.getRequestDispatcher("/T11/userUpdate.jsp").forward(request,response);
		}else if(action.equals("updateSave")){
			UsersVo user = new UsersVo();
			user.setUserid(Integer.parseInt(request.getParameter("userid")));
			user.setMobile(request.getParameter("mobile").trim());
			user.setUserName(request.getParameter("userName"));
			user.setSex(Integer.parseInt(request.getParameter("sex")));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId")));
			user.setCityId(Integer.parseInt(request.getParameter("cityId")));
			user.setProvinceName(request.getParameter("provinceName"));
			user.setCityName(request.getParameter("cityName"));
			base.userUpdate(user);
			listPage(request, response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request,response);
		}else if(action.equals("del")){
			String userid = request.getParameter("userid");
			base.userDel(Integer.parseInt("userid"));
			listPage(request, response);
			request.getRequestDispatcher("/T11/userList.jsp").forward(request,response);
		}else if(action.equals("modifyPwd3")){
			String userid = request.getParameter("userid");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String newPassword = AesUtils.encryptStr(request.getParameter("newPassword"),AesUtils.SECRETKEY);
			if(base.checkPwd(userid, oldpwd)){
				//修改密码
				base.modifypwd3(userid, newPassword);
				//从modifyPwd.jsp页面取值
				request.setAttribute("msg", "恭喜你，密码修改成功，请妥善保管");
			}else{
				request.setAttribute("msg", "旧密码输入错误，请重新输入");
			}
			//转向
			request.getRequestDispatcher("/T11/modifyPwd3.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			//初始化密码
			String userid = request.getParameter("userid");
			base.modifypwd3(userid, AesUtils.encryptStr("8888",AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","初始化密码成功，初始密码为：8888");
			request.getRequestDispatcher("/T11/userList.jsp").forward(request, response);
		}
	}
	//查询所有的用户数据
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中的用户数据
		List<UsersVo > userList = base.userList();
		//定义request变量，保存的是所有的用户数据
		request.setAttribute("userList", userList);
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from users");
		PageObject pager = new PageObject();
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
		//获取数据库中所有的用户数据
		List<UsersVo> userList = base.finduserByPage(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的用户数据
		request.setAttribute("userList", userList);
		request.setAttribute("pager", pager);
		
	}

}
