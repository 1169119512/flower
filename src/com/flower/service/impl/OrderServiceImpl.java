package com.flower.service.impl;

import com.flower.dao.FlowerDao;
import com.flower.dao.OrderDao;
import com.flower.dao.OrderItemDao;
import com.flower.dao.impl.FlowerDaoImpl;
import com.flower.dao.impl.OrderDaoImpl;
import com.flower.dao.impl.OrderItemDaoImpl;
import com.flower.pojo.*;
import com.flower.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private FlowerDao flowerDao = new FlowerDaoImpl();

    @Override
    public List<Order> watchOrdersById(Integer userId) {
        return orderDao.querryOrderById(userId);
    }

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //orderId要唯一：用时间戳
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);

        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem>entry: cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public void deliveryById(String orderId) {
        orderDao.updateStatusById(orderId);
    }

    @Override
    public List<Order> watchOrders() {
        return orderDao.querryOrders();
    }

    @Override
    public List<OrderItem> watchOrderDetail(String orderId) {
        return orderItemDao.querryOrderItemByOrderId(orderId);
    }
}
