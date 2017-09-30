package com.gs.controller;

import com.gs.mapping.Admin;
import com.gs.mapping.ControllerResult;
import com.gs.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;

    @GetMapping("reg_page")
    public String regPage() {
        return "admin/reg";
    }

    @PostMapping("reg")
    @ResponseBody
    public String reg(Admin admin){
        System.out.println(admin.getPhone()+","+admin.getPassword());
        return "{\"reg\":\"ok\"}";
    }

    @PostMapping("reg1")
    @ResponseBody
    public ControllerResult reg1(Admin admin){
        System.out.println(admin.getPhone()+","+admin.getPassword());
        adminService.save(admin);
        return ControllerResult.getSuccessResult("注册成功");
    }

    @GetMapping("phone/{phone}")
    @ResponseBody
    public Admin getByPhone(@PathVariable("phone") String phone) {
        return adminService.getByPhone(phone);
    }

    @GetMapping("updateByPhone")
    @ResponseBody
    public Admin updateByPhone(){
        String phone="18720865791";
        Admin admin = new Admin();
        admin.setPhone("18720865790");
        admin.setPassword("654321");
        adminService.updateByPhone(phone,admin);
        return admin;
    }

    @GetMapping("update")
    @ResponseBody
    public Admin update(){
        Admin admin = new Admin();
        admin.setId(1);
        admin.setPhone("18720865793");
        adminService.update(admin);
        return admin;
    }

    @GetMapping("del/{id}")
    @ResponseBody
    public int remove(@PathVariable("id") Integer id){
        adminService.removeById(id);
        return id;
    }

    @GetMapping("query")
    @ResponseBody
    public List<Admin> query(){
        logger.info("query admin");
        return adminService.queryByCriteria("18720865791",0,"江西");
    }



    /**
     * 初始化绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        /**
         * 注册自定义编辑器
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
