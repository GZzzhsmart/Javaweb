package com.gs.service;

import com.gs.mapping.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/config/spring-context.xml",
        "classpath:/config/spring-mybatis.xml"})
public class PlayerServiceTest {

    @Resource
    private PlayerService playerService;

    @Test
    public void testGetByName(){
        Player player = playerService.getByName("陈飞龙");
        System.out.println(player);
    }

}
