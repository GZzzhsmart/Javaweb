package com.gs.mapping;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private Date orderTime;

    private User user;
    private List<OrderItem> orderItemList;

    public List <OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List <OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
