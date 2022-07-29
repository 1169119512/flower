package com.flower.test;

import com.flower.dao.OrderDao;
import com.flower.dao.impl.OrderDaoImpl;
import com.flower.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {

    }

    @Test
    public void querryOrderById() {
        System.out.println(orderDao.querryOrderById(1));

    }

    @Test
    public void updateStatusById() {
        System.out.println(orderDao.updateStatusById("160810470903412"));

    }
}