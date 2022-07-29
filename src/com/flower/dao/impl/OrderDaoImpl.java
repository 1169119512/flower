package com.flower.dao.impl;

import com.flower.dao.BaseDao;
import com.flower.dao.OrderDao;
import com.flower.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> querryOrderById(int userId) {
        String sql = "select order_id,create_time,price,status from t_order where user_id=?";
        return querrForList(Order.class,sql,userId);
    }

    @Override
    public int saveOrder(Order order) {
        String sql ="insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
    }

    @Override
    public int updateStatusById(String orderId){
        String sql = "update t_order set status=? where order_id=?";
        return update(sql,1,orderId);
    }

    @Override
    public List<Order> querryOrders() {
        String sql = "select order_id,create_time,price,status,user_id from t_order";
        return querrForList(Order.class,sql);
    }
}
