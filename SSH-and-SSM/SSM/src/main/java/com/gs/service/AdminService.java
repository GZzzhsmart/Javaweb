package com.gs.service;


import com.gs.mapping.Admin;

import java.util.List;

public interface AdminService {
     void save(Admin admin);

     Admin getByPhone(String phone);

     void update(Admin admin);

     void updateByPhone(String phone, Admin admin);

     void removeById(Integer id);

     List<Admin> queryByCriteria(String phone, Integer gender, String address);
}
