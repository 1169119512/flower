package com.flower.test;

import com.flower.pojo.Flower;
import com.flower.service.FlowerService;
import com.flower.service.impl.FlowerServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FlowerServiceImplTest {
    FlowerService flowerService = new FlowerServiceImpl();
    @Test
    public void pageByPrice() {
        System.out.println(flowerService.pageByPrice(1,2,1,222));


    }

    @Test
    public void addFlower() {
        flowerService.addFlower(new Flower(null,"xiuga11ihou","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));
        flowerService.addFlower(new Flower(null,"xiuga11ihou22","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));
        flowerService.addFlower(new Flower(null,"xiuga11ihou33","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));

    }

    @Test
    public void deleteFlowerById() {
        flowerService.deleteFlowerById(5);
    }

    @Test
    public void updateFlower() {
        flowerService.updateFlower(new Flower(6,"xiuga11ihou3333","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));
    }

    @Test
    public void page() {
        System.out.println(flowerService.page(1,2));

    }

    @Test
    public void querryFlowerById() {
        System.out.println(flowerService.querryFlowerById(1));

    }

    @Test
    public void querryFlowers() {
        System.out.println(flowerService.querryFlowers());
    }
}