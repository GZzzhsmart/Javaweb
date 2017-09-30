package com.gs.service;

import java.io.InputStream;
import com.gs.mapping.Stu;
import java.util.List;

public interface StuService {

    public void addStu(Stu stu);
    public void delStu(String stuId);
    public void updateStu(Stu stu);
    public Stu getStuById(String stuId);
    public List<Stu> getPageStu(int pageNum, int pageSize);
    public int getStuNum();
    InputStream getInputStream() throws Exception;
}
