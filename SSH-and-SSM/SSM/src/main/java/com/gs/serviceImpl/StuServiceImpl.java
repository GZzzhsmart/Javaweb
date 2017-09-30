package com.gs.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.gs.common.WriteExcel;
import com.gs.dao.StuDAO;
import com.gs.mapping.Stu;
import com.gs.service.StuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuDAO stuDAO;

    @Override
    public void addStu(Stu stu) {
        stuDAO.addStu(stu);
    }

    @Override
    public void delStu(String stuId) {
        stuDAO.delStu(stuId);
    }

    @Override
    public void updateStu(Stu stu) {
        stuDAO.updateStu(stu);
    }

    @Override
    public Stu getStuById(String stuId) {
        Stu stu = stuDAO.getStuById(stuId);
        return stu;
    }

    @Override
    public List<Stu> getPageStu(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);//分页核心代码
        List<Stu> list = stuDAO.getStuList();
        return list;
    }

    @Override
    public int getStuNum() {
        List<Stu> list = stuDAO.getStuList();
        return list.size();
    }

    @Override
    public InputStream getInputStream() throws Exception {
        String[] title=new String[]{"stuId","stuName","stuAge","stuMajor","birthday"};
        List<Stu> plist=stuDAO.getStuList();
        List<Object[]>  dataList = new ArrayList<Object[]>();
        for(int i=0;i<plist.size();i++){
            Object[] obj=new Object[5];
            obj[0]=plist.get(i).getStuId();
            obj[1]=plist.get(i).getStuName();
            obj[2]=plist.get(i).getStuAge();
            obj[3]=plist.get(i).getStuMajor();
            obj[4]=plist.get(i).getBirthday();
            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

}
