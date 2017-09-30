package com.gs.dao;


import com.gs.mapping.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDAO {
     void save(Admin admin);
     void update(Admin admin);
     List<Admin> queryByCriteria(@Param("phone") String phone, @Param("gender") Integer gender, @Param("address") String address);
     void removeById(Integer id);
     Admin getByPhone(String phone);
     void updateByPhone(@Param("phone") String phone,@Param("admin") Admin admin);
}
