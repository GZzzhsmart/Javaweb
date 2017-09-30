package com.gs.controller;

import com.gs.dao.UserinfoDAO;
import com.gs.mapping.UserinfoPO;
import com.gs.service.UserinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/uc")
public class UserInfoController {

    @Resource
    private UserinfoService userinfoService;

    /**
     * 查询用户列表
     * */
    @RequestMapping("user")
    public String userList(HttpServletRequest request, UserinfoPO po){
        //调service里的方法
        List<UserinfoPO> ulist = userinfoService.getuserList(po);
        //把值存到request作用域里，传到页面上
        request.setAttribute("ulist", ulist);
        //跳转的mian.jsp页面
        return "user/main";
    }

    //新增
    @RequestMapping("add")
    public String add(){
        return "user/insert";
    }

    @RequestMapping("toadd")
    public String toaddUser(HttpServletRequest request,UserinfoPO po){
        System.out.println("......");
        System.out.println(po.getBirthday());
        String message = userinfoService.getaddUser(po);
        request.setAttribute("message",message);
        return "forward:/uc/user";
    }

    //修改
    @RequestMapping("uid")
    public String ulUid(HttpServletRequest request,UserinfoPO po){
        List<UserinfoPO> uid=userinfoService.getUserById(po);
        request.setAttribute("uid",uid);
        return "user/update";
    }

    @RequestMapping("update")//为方法设置访问路径
    public String update(HttpServletRequest request, UserinfoPO po){
        String updateUser = userinfoService.getUpdateUser(po);
        request.setAttribute("updateUser", updateUser);
        return "forward:/uc/user";
    }

    //删除
    @RequestMapping("delete/{userid}")
    public String delete(@PathVariable("userid") int userid){
        System.out.println(userid);
        userinfoService.getDeleteUser(userid);
        return "redirect:/uc/user";
    }

}
