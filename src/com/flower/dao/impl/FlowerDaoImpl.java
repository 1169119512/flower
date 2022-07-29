package com.flower.dao.impl;


import com.flower.dao.BaseDao;
import com.flower.dao.FlowerDao;
import com.flower.pojo.Flower;

import java.util.List;

public class FlowerDaoImpl extends BaseDao implements FlowerDao {
        @Override
        public Integer querryForPageTotalCountByPrice(int min, int max) {
            String sql = "SELECT COUNT(*) FROM t_flower WHERE price >= ? AND price <=?";
            Number count = (Number) querryForSigngleLeValue(sql,min,max);
            return count.intValue();
        }

        @Override
        public List<Flower> querryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
            String sql = "select id,flower_name,flower_kind,flower_language,price,material,star,pack,img_path from t_flower WHERE price >= ? AND price <= ? order by price limit ?,?";
            return querrForList(Flower.class,sql,min,max,begin,pageSize);
        }

        @Override
        public Integer querryForPageTotalCount() {
            String sql = "SELECT COUNT(*) FROM t_flower";
            Number count = (Number) querryForSigngleLeValue(sql);
            return count.intValue();
        }

        @Override
        public List<Flower> querryForPageItems(int begin, int pageSize) {
            String sql = "select id,flower_name,flower_kind,flower_language,price,material,star,pack,img_path from t_flower limit ?,?";

            return querrForList(Flower.class,sql,begin,pageSize);
        }

        @Override
        public int addFlower(Flower flower) {
            String sql="insert into t_flower(flower_name,flower_kind,flower_language,price,material,star,pack,img_path) values(?,?,?,?,?,?,?,?)";
            return update(sql,flower.getFlower_name(),flower.getFlower_kind(),flower.getFlower_language(),flower.getPrice(),flower.getMaterial(),flower.getStar(),flower.getPack(),flower.getImg_path());
        }

        @Override
        public int deleteFlowerById(Integer id) {
            String sql = "delete from t_flower where id = ?";
            return update(sql,id);
        }

    @Override
    public Flower querryFlowerIdByOthers(Flower flower) {
        String sql="select * from t_flower where flower_name=? and flower_kind=? and flower_language=? and price=? and material=? and star=? and pack=?";
        return querryForOne(Flower.class,sql,flower.getFlower_name(),flower.getFlower_kind(),flower.getFlower_language(),flower.getPrice(),flower.getMaterial(),flower.getStar(),flower.getPack());
        }

    @Override
    public List<Flower> querryNightFlowersByFlowerKind(String flowerKind) {
        String sql = "select id,flower_name,flower_kind,flower_language,price,material,star,pack,img_path from t_flower WHERE flower_kind=? limit 0,9";
        return querrForList(Flower.class,sql,flowerKind);
    }

    @Override
        public int updateFlower(Flower flower) {
            String sql = "update t_flower set flower_name=?,flower_kind=?,flower_language=?,price=?,material=?,star=?,pack=?,img_path=?where id=?";
            return update(sql,flower.getFlower_name(),flower.getFlower_kind(),flower.getFlower_language(),flower.getPrice(),flower.getMaterial(),flower.getStar(),flower.getPack(),flower.getImg_path(),flower.getId());
        }

    @Override
    public Integer querryForPageTotalCountByFlowerKind(String flowerKind) {
        String sql = "SELECT COUNT(*) FROM t_flower WHERE flower_Kind=?";
        Number count = (Number) querryForSigngleLeValue(sql,flowerKind);
        return count.intValue();
    }

    @Override
        public Flower querryFlowerById(Integer id) {
            String sql = "select id,flower_name,flower_kind,flower_language,price,material,star,pack,img_path from t_flower where id=?";
            return querryForOne(Flower.class,sql,id);
        }

        @Override
        public List<Flower> querryFlowers() {
            String sql = "select id,flower_name,flower_kind,flower_language,price,material,star,pack,img_path from t_flower";
            return querrForList(Flower.class,sql);
        }
        
    }
