package com.gs.service;

import com.gs.dao.UserinfoDAO;
import com.gs.mapping.UserinfoPO;

import java.util.List;
public interface UserinfoService {


    //用户列表
    public List<UserinfoPO> getuserList(UserinfoPO userinfoPO);
    //新增
    public String getaddUser(UserinfoPO po);
    //修改
    public String getUpdateUser(UserinfoPO po);
    //删除
    public int  getDeleteUser(int userid);
    //查找用户通过Id
    public List<UserinfoPO> getUserById(UserinfoPO po);

}
