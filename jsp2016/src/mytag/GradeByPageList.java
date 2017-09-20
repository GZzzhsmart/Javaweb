package mytag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import bean.PageObject1;
import bean.TeacherGradeVo;

public class GradeByPageList extends BodyTagSupport{

	private List<TeacherGradeVo> teacherList;
	private PageObject1 pager;
	private String updateUrl;
	
	public List<TeacherGradeVo> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<TeacherGradeVo> teacherList) {
		this.teacherList = teacherList;
	}
	public PageObject1 getPager() {
		return pager;
	}
	public void setPager(PageObject1 pager) {
		this.pager = pager;
	}
	public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<table border='1' style='min-width:500px;height:auto;background-color:#fff;'>");
			out.write("<caption style='background-color:#0ae;margin:0 auto;height:60px;line-height:60px;font-size:20px;color:#FFF' >讲师等级列表</caption>");
			out.write("<thead><th>讲师类别编号</th><th>讲师列表名称</th><th>提成比例</th><th>操作</th></thead>");
			int cnt = teacherList.size();
			TeacherGradeVo teacher = null;
			for(int i=0;i<cnt;i++){
				teacher = teacherList.get(i);
				out.write("<tr>");
				out.write("<td>"+teacher.getGradeId()+"</td>");
				out.write("<td>"+teacher.getGradeName()+"</td>");
				out.write("<td>"+teacher.getGradePercent()+"</td>");
				out.write("<td>");
				out.write("<a href='"+updateUrl+"?action=update&gradeId="+teacher.getGradeId()+"'>修改</a>");
				out.write("<a href='"+updateUrl+"?action=del&gradeId="+teacher.getGradeId()+"' onclick='javascript:if(confirm('删除确认')){return true;}else{return false;}'>删除</a>");
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
	
}
