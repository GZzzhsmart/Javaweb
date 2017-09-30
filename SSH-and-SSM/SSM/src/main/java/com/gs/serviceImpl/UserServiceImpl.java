package com.gs.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.gs.common.WriteExcel;
import com.gs.dao.UsersDAO;
import com.gs.mapping.Users;
import com.gs.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    @Resource
    private UsersDAO usersDAO;

    public void addUsers(Users users) {
        usersDAO.addUser(users);
    }

    public void delUsers(int userid) {
        usersDAO.delUser(userid);
    }

    public void updateUsers(Users users) {
        usersDAO.updateUsers(users);
    }

    public Users getStuById(int userid) {
        Users users = usersDAO.getUsersById(userid);
        return users;
    }

    /**
     * 分页
     * @param pageNum 记录数
     * @param pageSize 分页条数
     * @return
     */
    public List<Users> getPageUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);//分页核心代码
        List<Users> list = usersDAO.getUsersList();
        return list;
    }

    public int getStuNum() {
        List<Users> list = usersDAO.getUsersList();
        return list.size();
    }

    /**
     * 导出Excel表格数据
     * @return
     * @throws Exception
     */
    public InputStream getInputStream() throws Exception {
        String[] title=new String[]{"userid","username","password","email","phone","heroid","propid"};
        List<Users> plist=usersDAO.getUsersList();
        List<Object[]>  dataList = new ArrayList<Object[]>();
        for(int i=0;i<plist.size();i++){
            Object[] obj=new Object[7];
            obj[0]=plist.get(i).getUserid();
            obj[1]=plist.get(i).getUsername();
            obj[2]=plist.get(i).getPassword();
            obj[3]=plist.get(i).getEmail();
            obj[4]=plist.get(i).getPhone();
            obj[5]=plist.get(i).getHeroid();
            obj[6]=plist.get(i).getPropid();
            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

    @Override
    public List <Users> listByUserId(int userid) {
        return usersDAO.listByUserId(userid);
    }
}
