package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSupportDemo extends TagSupport{

	//标签开始调用该函数
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<font face='华文行楷' size='4' color='red'>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	//标签结束时调用该函数
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("</font>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
