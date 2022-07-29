package com.flower.dao.impl;

import com.flower.dao.BaseDao;
import com.flower.dao.OrderItemDao;
import com.flower.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql ="insert into t_order_item(id,name,count,price,total_price,order_id) values(?,?,?,?,?,?)";
        return update(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotal_price(),orderItem.getOrder_id());
    }

    @Override
    public List<OrderItem> querryOrderItemByOrderId(String orderId) {
        String sql = "SELECT id,name,count,price,total_price FROM t_order_item where order_id=?";
        return querrForList(OrderItem.class,sql,orderId);
    }
}
