package com.gs.service;

import com.gs.mapping.Deal;
import com.gs.mapping.Hero;
import com.gs.mapping.Prop;
import com.gs.mapping.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/config/spring-context.xml","classpath:/config/spring-mybatis.xml"})
public class UserServiceTest {

    @Resource
    private UsersService usersService;

    @Test
    public void testListByUserId(){
        List<Users> usersList = usersService.listByUserId(1);
        for (Users users:usersList) {
            System.out.println(users.getUsername());
            Hero hero = users.getHero();
            Prop prop = users.getProp();
            System.out.println(prop.getPropname());
            System.out.println(hero.getHeroname());
            List<Deal> dealList = users.getDealList();
            for (Deal deal: dealList) {
                System.out.println(deal.getDealid()+","+deal.getUserid()+","+deal.getCreated_time());
            }
        }
    }
}
