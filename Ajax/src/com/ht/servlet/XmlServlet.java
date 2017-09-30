package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class XmlServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<?xml version='1.0' encoding='utf-8' ?>");
		out.print("<studentList>");
		out.print("<student><studid>1001</studid><studname>����</studname><age>20</age><sex>��</sex><classname>��ͼ1601��</classname></student>");
		out.print("<student><studid>1002</studid><studname>����</studname><age>23</age><sex>��</sex><classname>��ͼ1602��</classname></student>");
		out.print("<student><studid>1003</studid><studname>С��</studname><age>18</age><sex>Ů</sex><classname>��ͼ1603��</classname></student>");
		out.print("<student><studid>1004</studid><studname>����</studname><age>21</age><sex>��</sex><classname>��ͼ1604��</classname></student>");
		out.print("<student><studid>1005</studid><studname>С¶</studname><age>20</age><sex>Ů</sex><classname>��ͼ1501��</classname></student>");
		out.print("<student><studid>1006</studid><studname>����</studname><age>22</age><sex>��</sex><classname>��ͼ1502��</classname></student>");
		out.print("</studentList>");
		out.flush();
		out.close();
	}

}
