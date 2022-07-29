package com.flower.test;

import com.flower.pojo.Cart;
import com.flower.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart = new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"firstcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(2,"secondcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(3,"thirdcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        System.out.println(cart);
        //        Map<Integer, CartItem> items = cart.getItems();
//        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
//            System.out.println(entry.getValue());
//        }
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"firstcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(2,"secondcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(3,"thirdcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"firstcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(2,"secondcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(3,"thirdcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"firstcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(2,"secondcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.addItem(new CartItem(3,"thirdcart",1,new BigDecimal(1999),new BigDecimal(1391),null));
        cart.updateCount(2,4);
        System.out.println(cart);
    }

}