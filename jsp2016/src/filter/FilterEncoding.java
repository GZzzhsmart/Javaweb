package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEncoding implements Filter{
	
	String encoding = "";
	public void destroy() {
		
	}
	//过滤处理，运行该浏览器以后，之前页面和Servlet中所有的乱码处理语句都可以删除
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(!encoding.equals("")){
			request.setCharacterEncoding(this.encoding);
		}
		//该语句非常重要，如果没有该语句，整个系统不会有任何反应
		chain.doFilter(request, response);
	}
	//读取初始化参数
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

}
