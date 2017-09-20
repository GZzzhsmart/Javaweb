package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Myfont extends TagSupport{

	private String bgcolor="#FFFFFF";//默认值为白色
	private String color="#000000";//字体默认为白色
	private String align="center";//默认居中
	private String fontSize="3";//字体大小为3
	private String border="0";//无边框
	private String width=null;//宽度为null
	private String bordercolor="#000000";//表格边框颜色默认为黑色
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	public String getBorder() {
		return border;
	}
	public void setBorder(String border) {
		this.border = border;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getBordercolor() {
		return bordercolor;
	}
	public void setBordercolor(String bordercolor) {
		
		this.bordercolor = bordercolor;
	}
	//开始标记
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("<table border="+border+" bordercolor="+bordercolor);
			if(width!=null){
				out.write("width=\""+width+"\">");
			}
			out.write("><td bgcolor="+bgcolor+">");
			out.write("<div align="+align+"><font size="+fontSize+" color="+color+">");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	//结束标记
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.write("</td></tr></table>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
