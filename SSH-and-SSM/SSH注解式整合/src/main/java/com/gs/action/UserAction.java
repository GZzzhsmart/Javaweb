package com.gs.action;

import com.gs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Component
@Namespace("/user")
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;

    @Action(value="all", results = {@Result(name="success", location="/index.jsp")})
    public String allUser() {
        userService.queryAll();
        return SUCCESS;
    }
}
