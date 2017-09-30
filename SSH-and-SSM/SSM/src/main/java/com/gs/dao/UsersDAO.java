package com.gs.dao;

import com.gs.mapping.Order;
import com.gs.mapping.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDAO {

    //新增
    public void addUser(Users users);
    //删除
    public void delUser(int users);
    //修改
    public void updateUsers(Users users);
    //通过id查询
    public Users getUsersById(int userid);
    //分页
    public List<Users> getUsersList();

    List<Users> listByUserId(int userid);
}
