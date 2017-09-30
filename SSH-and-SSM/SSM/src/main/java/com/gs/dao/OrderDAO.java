package com.gs.dao;


import com.gs.mapping.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDAO {

    List<Order> listByUserId(Integer userId);
    List<Order> listByOrderIds(List<Integer> orderIds);

}
