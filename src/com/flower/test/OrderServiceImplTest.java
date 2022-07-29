package com.flower.test;

import com.flower.pojo.Cart;
import com.flower.pojo.CartItem;
import com.flower.service.OrderService;
import com.flower.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"firstcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(2,"secondcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(3,"thirdcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        System.out.println("订单号是"+orderService.createOrder(cart,1));
    }
}