package com.gs.dao;

import com.gs.mapping.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 根据id获得account信息
     * @param id
     * @return
     */
    User getById(int id);

    /**
     * 根据name获得account信息
     * @param name
     * @return
     */
    User getByName(String name);
}
