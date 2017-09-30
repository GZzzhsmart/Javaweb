package com.gs.serviceImpl;

import com.gs.mapping.Admin;
import com.gs.dao.AdminDAO;
import com.gs.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    /**
     * @Resource此注解默认按照名称注入，如果没有名称，再按照类型注入
     *
     * @Autowired注解默认按类型注入
     *
     * 如果把注解放在属性上，则破坏了类的封装性，因为使用了Java反射，没有用set方法
     */
    @Resource
    private AdminDAO adminDAO;

    public void save(Admin admin) {
        adminDAO.save(admin);
    }

    public Admin getByPhone(String phone){
        return adminDAO.getByPhone(phone);
    }

    @Override
    public void update(Admin admin) {
        adminDAO.update(admin);
    }

    @Override
    public void updateByPhone(String phone, Admin admin) {
        adminDAO.updateByPhone(phone,admin);
    }

    @Override
    public void removeById(Integer id) {
        adminDAO.removeById(id);
    }

    @Override
    public List<Admin> queryByCriteria(String phone, Integer gender, String address) {
        return adminDAO.queryByCriteria(phone,gender,address);
    }
}
