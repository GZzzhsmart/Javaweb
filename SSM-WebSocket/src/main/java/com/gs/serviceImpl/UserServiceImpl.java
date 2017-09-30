package com.gs.serviceImpl;


import com.gs.dao.UserDao;
import com.gs.mapping.User;
import com.gs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public User login(String name, String password) {
        User tUser = userDao.getByName(name);
        if(tUser.getPassword().equals(password)){
            return tUser;
        }
        return null;
    }
}
