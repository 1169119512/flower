package com.flower.web;


import com.flower.pojo.Flower;
import com.flower.pojo.Cart;
import com.flower.pojo.CartItem;
import com.flower.service.FlowerService;
import com.flower.service.impl.FlowerServiceImpl;
import com.flower.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class CartServlet extends BaseServlet {
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("已添加到购物车 id="+req.getParameter("id"));
        String id=req.getParameter("id");
        FlowerService flowerService = new FlowerServiceImpl();
        Flower flower = flowerService.querryFlowerById(WebUtils.parseInt(id,null));
        CartItem cartItem = new CartItem(flower.getId(),flower.getFlower_name(),1,flower.getPrice(),flower.getPrice(),flower.getImg_path());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        resp.sendRedirect(req.getHeader("Referer"));
        req.getSession().setAttribute("lastname",cartItem.getName());
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            //修改商品数量
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }


    }
}
