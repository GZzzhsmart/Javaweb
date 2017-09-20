package mytag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoginTag extends BodyTagSupport{
	private String action;
	private String userName;
	private String password;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			//javascript合法性验证
			out.write("<script type='text/javascript'>");
			out.write("function check(){");
			out.write("var user = document.getElementById('userName').value;");
			out.write("var pass = document.getElementById('password').value;");
			out.write("if(user.length==0){");
			out.write("alert('用户名称不能为空！');");
			out.write("return false;");
			out.write("}");
			out.write("if(pass.length==0){");
			out.write("alert('登录密码不能为空！');");
			out.write("return false;");
			out.write("}");
			out.write("if(isNaN(pass)){");
			out.write("alert('请输入0~9之间的数字');");
			out.write("return false;");
			out.write("}");
			out.write("return true;");
			out.write("}");
			out.write("</script>");
			
			out.write("<form name='form1' action='"+action+"' method='post' onsubmit='return check();'>");
			out.write("<table align='center' border='1' style='min-width:500px;height:260px;background-color:#fff;'>");
			out.write("<tr style='background-color:#0ae;margin:0 auto;height:60px;line-height:60px;font-size:20px;color:#FFF' ><td colspan='2' align='center'>系统登录</td></tr>");
			out.write("<tr height='40px'><td align='right' style='width:200px;margin-left:20px' >用户名称：</td><td ><input type='text' id='userName' name='"+userName+"' style='width:298px;height:24px;border:1px solid #0ae;font-size:16px;'></td></tr>");
			out.write("<tr height='40px'><td align='right'style='width:200px;margin-left:20px' >登录密码：</td><td><input type='password' id='password' name='"+password+"' style='width:298px;height:24px;border:1px solid #0ae;font-size:16px;'></td></tr>");
			out.write("<tr height='50px'><td colspan='2' align='center'><input type='submit' value='登录' style='width:300px;height:40px;border:1;background-color:#0ae;font-size:16px;color:#FFF;cursor:pointer;'></td></tr>");
			out.write("</table>");
			out.write("</form>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
