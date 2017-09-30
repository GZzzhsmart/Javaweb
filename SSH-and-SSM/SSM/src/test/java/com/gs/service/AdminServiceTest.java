package com.gs.service;

import com.gs.mapping.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 使用Spring与Junit集成的测试，此测试框架可以导入spring的配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/config/spring-context.xml","classpath:/config/spring-mybatis.xml"})
public class AdminServiceTest {

    @Resource
    private AdminService adminService;

    @Test
    public void testSave() {
        Admin admin = new Admin();
        admin.setPhone("18888888888");
        admin.setPassword("123456");
        adminService.save(admin);
    }
}
