package mytag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import bean.CityVo;
import bean.PageObject;

public class CityByPageList extends BodyTagSupport{

	private List<CityVo> cityList;
	private PageObject pager;
	private String updateUrl;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<table border='1' style='min-width:500px;height:auto;background-color:#fff;'>");
			out.write("<caption style='background-color:#0ae;margin:0 auto;height:60px;line-height:60px;font-size:20px;color:#FFF' >城市资料列表</caption>");
			out.write("<thead><th>城市编号</th><th>省份名称</th><th>城市名称</th><th>操作</th></thead>");
			int cnt = cityList.size();
			CityVo city = null;
			for(int i=0;i<cnt;i++){
				city = cityList.get(i);
				out.write("<tr>");
				out.write("<td>"+city.getCityId()+"</td>");
				out.write("<td>"+city.getProvinceName()+"</td>");
				out.write("<td>"+city.getCityName()+"</td>");
				out.write("<td>");
				out.write("<a href='"+updateUrl+"?action=update&cityId="+city.getCityId()+"'>修改</a>");
				out.write("<a href='"+updateUrl+"?action=del&cityId="+city.getCityId()+"' onclick='javascript:if(confirm('删除确认')){return true;}else{return false;}'>删除</a>");
				out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
			
			out.write("<table border='0' cellpadding='1' cellspacing='1' width='500'>");
			out.write("<tr>");
			out.write("<td>总记录数:"+pager.getRecordCount()+"</td>");
			out.write("<td>总页数:"+pager.getPageCount()+"</td>");
			out.write("<td>当前页:"+pager.getCurrentPage()+"</td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage=1&opr=first>首页</a></td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage="+pager.getCurrentPage()+"&opr=piror>上一页</a></td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage="+pager.getCurrentPage()+"&opr=next>下一页</a></td>");
			out.write("<td><a href="+updateUrl+"?action=list&currentPage="+pager.getPageCount()+"&opr=last>末页</a></td>");
			out.write("</tr>");
			out.write("</table>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}
	
	
	public List<CityVo> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityVo> cityList) {
		this.cityList = cityList;
	}
	public PageObject getPager() {
		return pager;
	}
	public void setPager(PageObject pager) {
		this.pager = pager;
	}
	public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	
}
