package com.flower.service.impl;

import com.flower.dao.FlowerDao;
import com.flower.dao.impl.FlowerDaoImpl;
import com.flower.pojo.Flower;
import com.flower.pojo.Page;
import com.flower.service.FlowerService;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {

    private FlowerDao flowerDao = new FlowerDaoImpl();


    @Override
    public Page<Flower> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Flower> page = new Page<Flower>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = flowerDao.querryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = 0;
        begin = (page.getPageNo()-1) * pageSize;
        List<Flower> items = flowerDao.querryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }


    @Override
    public void addFlower(Flower flower) {
        flowerDao.addFlower(flower);
    }

    @Override
    public void deleteFlowerById(Integer id) {
        flowerDao.deleteFlowerById(id);
    }

    @Override
    public Integer querryFlowerIdByOthers(Flower flower) {
        Flower flower1 = flowerDao.querryFlowerIdByOthers(flower);
        return flower1.getId();
    }

    @Override
    public void updateFlower(Flower flower) {
        flowerDao.updateFlower(flower);
    }

    @Override
    public List<Flower> querryNightFlowersByFlowerKind(String flowerKind) {
       return flowerDao.querryNightFlowersByFlowerKind(flowerKind);
    }

    @Override
    public Page<Flower> page(int pageNo, int pageSize) {
        Page<Flower> page = new Page<Flower>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = flowerDao.querryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = 0;
        begin = (page.getPageNo()-1) * pageSize;
        List<Flower> items = flowerDao.querryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Flower querryFlowerById(Integer id) {
        return flowerDao.querryFlowerById(id);
    }

    @Override
    public List<Flower> querryFlowers() {
        return flowerDao.querryFlowers();
    }
}

