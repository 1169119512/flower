package com.flower.dao;

import com.flower.pojo.Flower;
import com.flower.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> querryOrderItemByOrderId(String orderId);
}
