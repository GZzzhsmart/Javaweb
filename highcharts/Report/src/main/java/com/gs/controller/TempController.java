package com.gs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gs.common.bean.HChart;

@WebServlet(name = "TempController", urlPatterns="/temp")
public class TempController extends HttpServlet {
	
	private static final long serialVersionUID = 3073602163573926708L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		resp.setContentType("text/json;charset=utf-8");
		if (action != null && action.equals("temp")) {
			List<HChart<Double>> temps = new ArrayList<HChart<Double>>();
			Random random = new Random();
			for (int i = 0; i < 3; i++) {
				HChart<Double> temp = new HChart<Double>();
				temp.setName("城市" + (i + 1));
				Double[] data = new Double[12];
				for (int j = 0; j < 12; j++) {
					data[j] = random.nextDouble();
				}
				temp.setData(data);
				temps.add(temp);
			}
			PrintWriter out = resp.getWriter();
			out.println(JSON.toJSONString(temps));
		}else if(action!=null && action.equals("day")){
			List<HChart<Double>> temps = new ArrayList<HChart<Double>>();
			Random random = new Random();
			for (int i = 0; i < 2; i++) {
				HChart<Double> temp = new HChart<Double>();
				temp.setName("城市" + (i + 1));
				Double[] data = new Double[12];
				for (int j = 0; j < 12; j++) {
					data[j] = (random.nextDouble())*20;
				}
				temp.setData(data);
				temps.add(temp);
			}
			PrintWriter out = resp.getWriter();
			out.println(JSON.toJSONString(temps));
		}
		
	}
	
}
