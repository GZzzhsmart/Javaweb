package com.gs.service;

import com.gs.mapping.Order;
import com.gs.mapping.OrderItem;
import com.gs.mapping.Product;
import com.gs.mapping.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/config/spring-context.xml","classpath:/config/spring-mybatis.xml"})
public class OrderServiceTest {
    @Resource
    private OrderService orderService;

    @Test
    public void testListByUserId(){
        List<Order> orderList = orderService.listByUserId(1);
        for (Order order:orderList) {
            System.out.println(order.getOrderTime());
            User user = order.getUser();
            System.out.println(user.getName());
            List<OrderItem> orderItemList = order.getOrderItemList();
            for (OrderItem item:orderItemList) {
                System.out.println(item.getId()+","+item.getTotalCost().toString());
                Product p = item.getProduct();
                System.out.println(p.getTitle());
            }
        }
    }


    @Test
    public void testListByOrderIds(){
        List<Integer> orderIds = new ArrayList <Integer>();
        orderIds.add(1);
        List<Order> orderList = orderService.listByOrderIds(orderIds);
        for (Order order:orderList) {
            System.out.println(order.getOrderTime());
        }
    }


}
