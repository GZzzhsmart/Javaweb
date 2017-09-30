package com.gs.dao;

import com.gs.mapping.Stu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StuDAO {

    //新增
    public void addStu(Stu stu);
    //删除
    public void delStu(String stuId);
    //修改
    public void updateStu(Stu stu);
    //通过id查询
    public Stu getStuById(String stuId);
    //分页
    public List<Stu> getStuList();
}
