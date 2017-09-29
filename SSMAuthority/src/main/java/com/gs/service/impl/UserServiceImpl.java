package com.gs.service.impl;

import com.gs.bean.User;
import com.gs.dao.UserDAO;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User getByPhonePwd(String phone, String pwd) {
        return userDAO.getByPhonePwd(phone, pwd);
    }
}
