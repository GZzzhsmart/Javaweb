package com.gs.service;

import com.gs.bean.User;
import com.gs.dao.UserDAO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/25.
 */
public interface UserService {
    User getByPhonePwd(String phone, String pwd);
}
