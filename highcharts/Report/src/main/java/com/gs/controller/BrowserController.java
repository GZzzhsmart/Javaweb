package com.gs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gs.common.bean.HChartPie;
import com.gs.common.bean.Pie;

@WebServlet(name = "BrowserController", urlPatterns = "/pie")
public class BrowserController extends HttpServlet {

	private static final long serialVersionUID = -7305137286766086847L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("bro")) {
			List<HChartPie<Double>> hChartPies = new ArrayList<HChartPie<Double>>();
			HChartPie<Double> hChartPie = new HChartPie<Double>();
			hChartPie.setType("pie");
			hChartPie.setName("浏览器市场份额");
			Pie<Double>[] data = new Pie[5];
			for (int i = 0; i < 5; i++) {
				Pie<Double> pie = new Pie<Double>();
				pie.setName("浏览器" + (i + 1));
				pie.setY(20.0);
				if (i == 2) {
					pie.setSelected(true);
					pie.setSliced(true);
				}
				data[i] = pie;
			}
			hChartPie.setData(data);
			hChartPies.add(hChartPie);
			resp.setContentType("text/json;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(JSON.toJSONString(hChartPies));
		}
	}

}
