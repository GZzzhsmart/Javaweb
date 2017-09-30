package com.gs.serviceImpl;

import com.gs.dao.OrderDAO;
import com.gs.mapping.Order;
import com.gs.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDAO orderDAO;

    public List<Order> listByUserId(Integer userId) {
        return orderDAO.listByUserId(userId);
    }

    public List <Order> listByOrderIds(List <Integer> orderIds) {
        return orderDAO.listByOrderIds(orderIds);
    }



}
