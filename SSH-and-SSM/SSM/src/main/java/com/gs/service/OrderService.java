package com.gs.service;


import com.gs.mapping.Order;
import java.util.List;

public interface OrderService {

    List<Order> listByUserId(Integer userId);
    List<Order> listByOrderIds(List<Integer> orderIds);

}
