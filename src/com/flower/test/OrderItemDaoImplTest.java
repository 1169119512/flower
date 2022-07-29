package com.flower.test;

import com.flower.dao.OrderItemDao;
import com.flower.dao.impl.OrderItemDaoImpl;
import com.flower.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(1,"AA",100,new BigDecimal(1999),new BigDecimal(199900),"1"));
    }

    @Test
    public void querryOrderById() {
        System.out.println(orderItemDao.querryOrderItemByOrderId("1"));
    }
}