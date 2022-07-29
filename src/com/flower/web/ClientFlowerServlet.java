package com.flower.web;

import com.flower.pojo.Flower;
import com.flower.pojo.Page;
import com.flower.service.FlowerService;
import com.flower.service.impl.FlowerServiceImpl;
import com.flower.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientFlowerServlet extends BaseServlet {
    FlowerService flowerService = new FlowerServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Flower> page = flowerService.page(pageNo, pageSize);
        page.setUrl("client/flowerServlet?action=page&url=/pages/client/index.jsp");
        req.setAttribute("page", page);
        Object url = req.getParameter("url");
        req.getRequestDispatcher((String) url).forward(req, resp);

    }

    protected void querryFlowerById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Flower flower = flowerService.querryFlowerById(id);
        req.setAttribute("flower", flower);
        Object url = req.getParameter("url");
        req.getRequestDispatcher((String) url).forward(req, resp);
    }

    protected void querryFlowers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> flowers = flowerService.querryFlowers();
        req.setAttribute("flowers", flowers);
        Object url = req.getParameter("url");
        req.getRequestDispatcher((String) url).forward(req, resp);

    }

    protected void pageByFlowerKind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> flowerRose = flowerService.querryNightFlowersByFlowerKind("玫瑰");
        List<Flower> flowerLilium = flowerService.querryNightFlowersByFlowerKind("百合");
        List<Flower> flowerCarnation = flowerService.querryNightFlowersByFlowerKind("康乃馨");
        req.setAttribute("flowerRose", flowerRose);
        req.setAttribute("flowerLilium",flowerLilium);
        req.setAttribute("flowerCarnation",flowerCarnation);
        Object url = req.getParameter("url");
        req.getRequestDispatcher((String) url).forward(req, resp);

    }
    protected void querryNightFlowersByFlowerKind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> flowerRose = flowerService.querryNightFlowersByFlowerKind("玫瑰");
        List<Flower> flowerLilium = flowerService.querryNightFlowersByFlowerKind("百合");
        List<Flower> flowerCarnation = flowerService.querryNightFlowersByFlowerKind("康乃馨");
        req.setAttribute("flowerRose", flowerRose);
        req.setAttribute("flowerLilium",flowerLilium);
        req.setAttribute("flowerCarnation",flowerCarnation);
        Object url = req.getParameter("url");
        req.getRequestDispatcher((String) url).forward(req, resp);

    }
}
