package com.gs.service;

import com.gs.mapping.Users;

import java.io.InputStream;
import java.util.List;


public interface UsersService {

    public void addUsers(Users users);
    public void delUsers(int userid);
    public void updateUsers(Users users);
    public Users getStuById(int userid);
    public List<Users> getPageUsers(int pageNum, int pageSize);
    public int getStuNum();
    InputStream getInputStream() throws Exception;
    List<Users> listByUserId(int userid);
}
