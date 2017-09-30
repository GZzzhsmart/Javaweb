package com.gs.common;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	public static String getReqMethod(HttpServletRequest req) {
		String uri = req.getRequestURI();
		return uri.substring(uri.lastIndexOf("/") + 1);
	}

}
