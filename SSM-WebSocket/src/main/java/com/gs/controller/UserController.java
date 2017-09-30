package com.gs.controller;

import com.gs.mapping.User;
import com.gs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tuser")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/log")
    private String log(){
        return "/login";
    }

    //通用用户功能
    @RequestMapping("/login")
    public String login(String name, String password, HttpSession session) {
        User user = userService.login(name,password);
        if ( user != null)
        {
            session.setAttribute("username", name);
            return "/index";
        }
        else
            return "/login";
    }
}
