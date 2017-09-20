package com.cn.hnust.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.pojo.UserinfoPO;
import com.cn.hnust.service.UserInfoInterface;

@Controller  //标注这是一个控制类，类名不能和注解名一样
@RequestMapping("/uc")   //设置访问路径
public class UserinfoController {
	
	@Autowired
	UserInfoInterface uservice;
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String ulogin(HttpServletRequest request){	
		//接收页面的值
		String loginname = request.getParameter("loginname");
		String loginpass = request.getParameter("loginpass");
		UserinfoPO po = new UserinfoPO();
		//把接收到的值放入po里
		po.setLoginname(loginname);
		po.setLoginpass(loginpass);
		//调service方法去数据库验证
		UserinfoPO pojo = uservice.getlogin(po);
		if(pojo!=null){
			return "/uc/user";
		}else{			
			return "/success";
		}		
	}
	/**
	 * 查询用户列表
	 */
	@RequestMapping("/user")//为方法设置访问路径
	public String userList(HttpServletRequest request, UserinfoPO po){
		//调service里的方法
		List<UserinfoPO> ulist = uservice.getuserList(po);
		//把值存到request作用域里，传到页面上
		request.setAttribute("ulist", ulist);
		//跳转的mian.jsp页面
		return "/main";
	}
	/**
	 * 新增
	 */
	 @RequestMapping("add")
    public String add(){
        return "/insert";
    }
	 
	@RequestMapping("/toadd")
	public String toaddUser(HttpServletRequest request,UserinfoPO po){
		System.out.println("....");
		String message = uservice.getaddUser(po);
		request.setAttribute("message", message);
		return "/insert";
	} 
	
	/**
	 * 修改
	 */
	@RequestMapping("/uid")
	public String ulUid(HttpServletRequest request,UserinfoPO po){
		List<UserinfoPO> uid=uservice.getUserById(po);
		request.setAttribute("uid",uid);
		return "update";
	}
	
	
	@RequestMapping(value="/update")//为方法设置访问路径
	public String update(HttpServletRequest request, UserinfoPO po){		
		String updateUser = uservice.getUpdateUser(po);		
		request.setAttribute("updateUser", updateUser);
		return "forward:/uc/uid";		
	}
	
	/**
	 * 删除
	 */
    @RequestMapping("delete/{userid}")
    public String delete(@PathVariable("userid") int userid){
        System.out.println(userid);
       uservice.getDeleteUser(userid);
        return "redirect:/uc/user";
    }

}
