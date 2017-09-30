package com.gs.controller;

import com.gs.mapping.Deal;
import com.gs.mapping.Hero;
import com.gs.mapping.Prop;
import com.gs.mapping.Users;
import com.gs.service.OrderService;
import com.gs.service.UsersService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list() {
        return "user/userList";
    }

    @RequestMapping(value = "adduser",method = RequestMethod.POST)
    public String add(@RequestParam("username") String username,
                      @RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("phone") String phone){
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setEmail(email);
        users.setPhone(phone);
        users.setHeroid(1);
        users.setPropid(1);
        usersService.addUsers(users);
        return "user/userList";
    }

    @RequestMapping(value="/delUser",method = RequestMethod.POST)
    public String delete(@RequestParam("userid") int userid){
        System.out.println("userid:"+userid);
        usersService.delUsers(userid);
        return "user/userList";
    }

    @RequestMapping(value = "updateuser",method = RequestMethod.POST)
    public String update(@RequestParam("username") String username,
                      @RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("heroid") int heroid,@RequestParam("propid") int propid){
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setEmail(email);
        users.setPhone(phone);
        users.setHeroid(heroid);
        users.setPropid(propid);
        usersService.updateUsers(users);
        return "user/userList";
    }

    @RequestMapping(value="/getuserInfo",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Users getUsersById(@RequestParam("userid") int userid){
        Users users = usersService.getStuById(userid);
        return users;
    }

    @RequestMapping(value = "/userList",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Users getUsersList(@RequestParam("current") int current, @RequestParam("rowCount") int rowCount, Hero hero, Prop prop, Deal deal) {
        int total = usersService.getStuNum();
        List<Users> list = usersService.getPageUsers(current,rowCount);
        Users users = new Users();
        users.setCurrent(current);
        users.setRowCount(rowCount);
        users.setRows(list);
        users.setTotal(total);
        return users;
    }

    //查询xml接口数据
    @RequestMapping(value="/userlistxml",produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public Users getstulistxml(@RequestParam("current") int current, @RequestParam("rowCount") int rowCount){
        int total = usersService.getStuNum();
        List<Users> list = usersService.getPageUsers(current,rowCount);
        Users users = new Users();
        users.setCurrent(current);
        users.setRowCount(rowCount);
        users.setRows(list);
        users.setTotal(total);
        return users;
    }

    //导出Excel表格数据
    @RequestMapping("/exportStu")
    public void export(HttpServletResponse response) throws Exception{
        InputStream is=usersService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is,output);
    }
}
