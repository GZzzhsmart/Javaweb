package com.gs.controller;

import com.gs.bean.Permission;
import com.gs.bean.Role;
import com.gs.bean.User;
import com.gs.service.PermissionService;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("auth_page")
    public String authPage(HttpSession session) {
        return "authority";
    }

    @GetMapping("login")
    @ResponseBody
    public String login(HttpSession session) {
        User user = userService.getByPhonePwd("18720865791", "123456");
        session.setAttribute("user", user);
        return "login success";
    }

    /**
     * 只有normal_user的角色才能访问此方法
     * @return
     */
    @GetMapping("menu1")
    @ResponseBody
    public String menu1(HttpSession session) {
        // 判断权限
        Object obj = session.getAttribute("user");
        if (obj != null) {
            // 需要判断用户有没有执行权限
            User user = (User) obj;
            List<Role> roleList = user.getRoleList();
            List<Integer> roleIds = new ArrayList<Integer>();
            for (Role role : roleList) {
                roleIds.add(role.getId());
            }
            Permission p = permissionService.getByPermissionRole(roleIds, UserController.class.getName() + ".menu1");
            if (p != null) {
                // TODO 需要做的事情
                return "execute success";
            } else {
                return "no permission";
            }
        } else {
            // 用户未登录
            return "not login";
        }
    }

    @GetMapping("menu2")
    @ResponseBody
    public String menu2(HttpSession session) {
        // 判断权限
        Object obj = session.getAttribute("user");
        if (obj != null) {
            // 需要判断用户有没有执行权限
            User user = (User) obj;
            List<Role> roleList = user.getRoleList();
            List<Integer> roleIds = new ArrayList<Integer>();
            for (Role role : roleList) {
                roleIds.add(role.getId());
            }
            permissionService.getByPermissionRole(roleIds, UserController.class.getName() + ".menu2");
            return "";
        } else {
            // 用户未登录
            return "not login";
        }
    }


}
