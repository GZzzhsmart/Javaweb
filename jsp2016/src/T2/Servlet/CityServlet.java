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
import bean.CityVo;
import bean.PageObject;
import bean.ProvinceVo;

public class CityServlet extends HttpServlet {

	IBaseDAO baseDao = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*action="list"代表执行查询的代码
		 * action="init"代表新增页面的初始化
		 * action="add"代表新增城市的代码
		 * action="update"代表获取需要更新的城市数据
		 * action="updateSave"代表更新数据
		 * action="del"代表执行删除数据
		 * 
		 * */
		//乱码处理
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action!=null){
			if(action.equals("init")){
				//获取省份的数据., 
				List<ProvinceVo> provList = baseDao.provinceList();
				request.setAttribute("provList", provList);
				//转向到cityList.jsp页面
				request.getRequestDispatcher("/T7/cityAdd.jsp").forward(request, response);
			}else if(action.equals("add")){
				String provinceId = request.getParameter("provinceId");
				String cityName = request.getParameter("cityName").trim();
				CityVo city = new CityVo();
				city.setProvinceId(Integer.parseInt(provinceId));
				city.setCityName(cityName);
				baseDao.cityAdd(city);
				//查询所有的数据，转向到列表页面
				listPage(request, response);
				//转向到cityList.jsp页面
				request.getRequestDispatcher("/T7/cityList.jsp").forward(request, response);
			}else if(action.equals("update")){
				//获取省份数据
				List<ProvinceVo> provList = baseDao.provinceList();
				request.setAttribute("provList",provList);
				//查找需要修改的城市数据
				String cityId = request.getParameter("cityId");
				CityVo city = baseDao.findCityById(cityId);
				request.setAttribute("city", city);
				//转向到cityList.jsp页面
				request.getRequestDispatcher("T7/cityUpdate.jsp").forward(request, response);
			}else if(action.equals("updateSave")){
				String provinceId = request.getParameter("provinceId");
				String cityId = request.getParameter("cityId");
				String cityName = request.getParameter("cityName");
				CityVo city = new CityVo();
				city.setProvinceId(Integer.parseInt(provinceId));
				city.setCityName(cityName);
				city.setCityId(Integer.parseInt(cityId));
				baseDao.cityUpdate(city);
				//查询所有的城市数据，并转向到列表页面
				listPage(request, response);
				//转向到cityList.jsp页面
				request.getRequestDispatcher("/T7/cityList.jsp").forward(request, response);
			}else if(action.equals("del")){
				String cityId = request.getParameter("cityId");
				baseDao.cityDel(Integer.parseInt(cityId));
				listPage(request, response);
				//转向到cityList.jsp页面
				request.getRequestDispatcher("T7/cityList.jsp").forward(request, response);
			}else if(action.equals("list")){
				//查询所有的数据，并转向到列表页面
				listPage(request, response);
				//转向到cityList.jsp页面
				request.getRequestDispatcher("/T7/cityList.jsp").forward(request, response);
			}
		}
	}
	//查询城市资料
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中所有的城市数据
		List<CityVo> cityList = baseDao.cityList();
		//定义request变量，保存的是所以的城市数据
		request.setAttribute("cityList", cityList);
	}
	//分页
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = baseDao.getCount("select count(*) cnt from city");
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
		//获取数据库中所有的城市数据
		List<CityVo> cityList = baseDao.cityList(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所有的城市数据
		request.setAttribute("cityList", cityList);
		request.setAttribute("pager", pager);
	}
}
