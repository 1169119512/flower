package com.flower.dao;

import com.flower.pojo.Order;

import java.util.List;

public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> querryOrderById(int userId);
    public int updateStatusById(String orderId);

    public List<Order> querryOrders();
}
