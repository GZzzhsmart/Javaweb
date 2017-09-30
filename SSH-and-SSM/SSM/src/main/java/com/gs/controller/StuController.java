package com.gs.controller;

import com.gs.mapping.Stu;
import com.gs.mapping.StuGrid;
import com.gs.service.StuService;
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
@RequestMapping("/stu")
public class StuController {

    @Resource
    private StuService stuService;

    //学生列表页面
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list() {
        return "user/stuList";
    }

    //新增学生资料
    @RequestMapping(value = "/addStu",method = RequestMethod.POST)
    public String add(@RequestParam("stuName") String stuName,
                      @RequestParam("stuAge") int stuAge,@RequestParam("stuMajor") String stuMajor,@RequestParam("birthday") String birthday){
        Stu stu = new Stu();
        stu.setStuName(stuName);
        stu.setStuAge(stuAge);
        stu.setStuMajor(stuMajor);
        stu.setBirthday(birthday);
        stuService.addStu(stu);
        return "user/stuList";
    }

    //删除学生信息
    @RequestMapping(value="/delStu",method = RequestMethod.POST)
    public String delete(@RequestParam("stuId") String stuId){
        System.out.println("stuId:"+stuId);
        stuService.delStu(stuId);
        return "user/stuList";
    }

    //修改学生信息
    @RequestMapping(value="/updateStu",method = RequestMethod.POST)
    public String update(@RequestParam("stuId") String stuId,@RequestParam("stuName") String stuName,
                         @RequestParam("stuAge") int stuAge,@RequestParam("stuMajor") String stuMajor,@RequestParam("birthday") String birthday){
        Stu stu = new Stu();
        stu.setStuId(stuId);
        stu.setStuName(stuName);
        stu.setStuAge(stuAge);
        stu.setStuMajor(stuMajor);
        stu.setBirthday(birthday);
        stuService.updateStu(stu);
        return "user/stuList";
    }

    //取值
    @RequestMapping(value="/getStuInfo",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Stu getStuById(@RequestParam("stuId") String stuId){
        Stu stu = stuService.getStuById(stuId);
        return stu;
    }

    //学生信息分页
    @RequestMapping(value = "/stuList",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public StuGrid getStuList(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount) {
        int total = stuService.getStuNum();
        List<Stu> list = stuService.getPageStu(current,rowCount);
        StuGrid stuGrid = new StuGrid();
        stuGrid.setCurrent(current);
        stuGrid.setRowCount(rowCount);
        stuGrid.setRows(list);
        stuGrid.setTotal(total);
        return stuGrid;
    }

    //查询xml接口数据
    @RequestMapping(value="/stulistxml",produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public StuGrid getstulistxml(@RequestParam("current") int current, @RequestParam("rowCount") int rowCount){
        int total = stuService.getStuNum();
        List<Stu>  list = stuService.getPageStu(current,rowCount);
        StuGrid stuGrid = new StuGrid();
        stuGrid.setCurrent(current);
        stuGrid.setRowCount(rowCount);
        stuGrid.setRows(list);
        stuGrid.setTotal(total);
        return stuGrid;
    }

    //导出Excel表格数据
    @RequestMapping("/exportStu")
    public void export(HttpServletResponse response) throws Exception{
        InputStream is=stuService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is,output);
    }

    @RequestMapping(value = "/head",method = RequestMethod.GET)
    public String cal() {
        return "head";
    }

}
