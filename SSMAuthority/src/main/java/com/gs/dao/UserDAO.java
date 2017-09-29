package com.gs.dao;

import com.gs.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/25.
 */
@Repository
public interface UserDAO {

    User getByPhonePwd(@Param("phone") String phone, @Param("pwd") String pwd);

}
