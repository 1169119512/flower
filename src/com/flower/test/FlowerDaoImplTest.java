package com.flower.test;

import com.flower.dao.FlowerDao;
import com.flower.dao.impl.FlowerDaoImpl;
import com.flower.pojo.Flower;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class FlowerDaoImplTest {

    private FlowerDao flowerDao = new FlowerDaoImpl();
    @Test
    public void querryForPageTotalCountByPrice() {
        System.out.println(flowerDao.querryForPageTotalCountByPrice(10,13));
    }

    @Test
    public void querryForPageItemsByPrice() {
        int begin = 0;
        int pagesize = 2;
        List<Flower> flowers = flowerDao.querryForPageItemsByPrice(begin, pagesize, 10, 15);
        System.out.println(flowers);
    }

    @Test
    public void querryForPageTotalCount() {
        System.out.println(flowerDao.querryForPageTotalCount());
    }

    @Test
    public void querryForPageItems() {
        System.out.println(flowerDao.querryForPageItems(0,10));
    }

    @Test
    public void addFlower() {
        flowerDao.addFlower(new Flower(null,"ddd","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));
        flowerDao.addFlower(new Flower(null,"ddd12","ddd33","ddd",new BigDecimal(100),"aaa","aaa","pack",null));
        flowerDao.addFlower(new Flower(null,"d2234dd","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));

        System.out.println(flowerDao.querryForPageItems(0,19));
    }

    @Test
    public void deleteFlowerById() {
        flowerDao.deleteFlowerById(4);
    }

    @Test
    public void updateFlower() {
        flowerDao.updateFlower(new Flower(3,"xiugaihou","ddd","ddd",new BigDecimal(100),"aaa","aaa","pack",null));
    }

    @Test
    public void querryFlowerById() {
        System.out.println(flowerDao.querryFlowerById(3));

    }

    @Test
    public void querryFlowers() {
        System.out.println(flowerDao.querryFlowers());
    }


    @Test
    public void querryNightFlowersByFlowerKind() {
        System.out.println(flowerDao.querryNightFlowersByFlowerKind("康乃馨"));

    }

    @Test
    public void querryIdByOthers() {

        System.out.println(flowerDao.querryFlowerIdByOthers(new Flower(null,"聆听你","康乃馨",
                "她曾总是对你唠叨，和她离别后，才发现那些废话是世界上最暖的牵挂！",new BigDecimal(498),
                "红色康乃馨19枝、粉色绣球1枝、多头白百合5枝、红玫瑰11枝、粉色洋桔梗4枝、红色朱蕉叶5枝、绿色朱蕉叶3枝，花束长达1.2m~1.3m",null,
                "黑色雪梨纸3张、绿色条纹纸12张、棕色丝带4米",null)));
    }
}