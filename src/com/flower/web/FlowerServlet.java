package com.flower.web;


import com.flower.pojo.Flower;
import com.flower.pojo.Page;
import com.flower.service.FlowerService;
import com.flower.service.OrderService;
import com.flower.service.impl.FlowerServiceImpl;
import com.flower.service.impl.OrderServiceImpl;
import com.flower.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class FlowerServlet extends BaseServlet{

    private FlowerService flowerService= new FlowerServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        Flower flower = WebUtils.copyPaeamToBean(req.getParameterMap(),new Flower());
        Flower flower = new Flower();
        if(ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                String flowerName = list.get(0).getString("UTF-8");
                String flowerKind = list.get(1).getString("UTF-8");
                String flowerLanguage = list.get(2).getString("UTF-8");
                String price = list.get(3).getString("UTF-8");
                String material = list.get(4).getString("UTF-8");
                String star = list.get(5).getString("UTF-8");
                String pack = list.get(6).getString("UTF-8");
                flower.setFlower_name(flowerName);
                flower.setFlower_kind(flowerKind);
                flower.setFlower_language(flowerLanguage);
                flower.setPrice(new BigDecimal(price));
                flower.setMaterial(material);
                flower.setStar(star);
                flower.setPack(pack);
                flowerService.addFlower(flower);
                Integer id = flowerService.querryFlowerIdByOthers(flower);
                flower.setId(id);
                String pathname = "C:/Users/Coder/Desktop/java web/Learning java web/flower/web/images/all_flower/flower_picture/"+flower.getId()+"/";
                int count = 0;
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){

                    }
                    else {
                        count++;
                        String imgName = ""+count;
                        WebUtils webUtils = new WebUtils();
                        webUtils.createFile(pathname);
                        fileItem.write(new File(pathname+imgName+".jpg"));
                    }
                }
                int Aslpathnamelength = "C:/Users/Coder/Desktop/java web/Learning java web/flower/web/".length();
                String relpathname = pathname.substring(Aslpathnamelength);
                flower.setImg_path(relpathname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        flowerService.addFlower(flower);
//        Integer id = flowerService.querryFlowerIdByOthers(flower);
//        flower.setId(id);
//        String pathname = "C:/Users/Coder/Desktop/java web/Learning java web/flower/web/images/all_flower/flower_picture/"+flower.getId()+"/";
//        if(ServletFileUpload.isMultipartContent(req)){
//            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//            try {
//                List<FileItem> list = servletFileUpload.parseRequest(req);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        flowerService.updateFlower(flower);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1)+1;
        resp.sendRedirect(req.getContextPath()+"/manager/flowerServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = WebUtils.parseInt(req.getParameter("id"),null);
        flowerService.deleteFlowerById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/flowerServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        Flower flower = WebUtils.copyPaeamToBean(req.getParameterMap(),new Flower());
        Flower flower =new Flower();
        String id = (String) req.getParameter("id");
        WebUtils webUtils = new WebUtils();
        String pathname = "C:/Users/Coder/Desktop/java web/Learning java web/flower/web/"+flower.getImg_path();
        if(pathname.equals("C:/Users/Coder/Desktop/java web/Learning java web/flower/web/images/all_flower/flower_default/")){
            pathname = "C:/Users/Coder/Desktop/java web/Learning java web/flower/web/"+"images/all_flower/flower_picture/"+id+"/";
        }
        File file = new File(pathname);
        webUtils.deleteFile(file);
        if(ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);

                String flowerName = list.get(0).getString("UTF-8");
                String flowerKind = list.get(1).getString("UTF-8");
                String flowerLanguage = list.get(2).getString("UTF-8");
                String price = list.get(3).getString("UTF-8");
                String material = list.get(4).getString("UTF-8");
                String star = list.get(5).getString("UTF-8");
                String pack = list.get(6).getString("UTF-8");
                flower.setFlower_name(flowerName);
                flower.setFlower_kind(flowerKind);
                flower.setFlower_language(flowerLanguage);
                flower.setPrice(new BigDecimal(price));
                flower.setMaterial(material);
                flower.setStar(star);
                flower.setPack(pack);
                flower.setId(WebUtils.parseInt(id,0));
                int count = 0;
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
                    }
                    else {
                        count++;
                        String imgName = ""+count;
                        webUtils.createFile(pathname);
                        fileItem.write(new File(pathname+imgName+".jpg"));
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int Aslpathlength = "C:/Users/Coder/Desktop/java web/Learning java web/flower/web/".length();
        String relpathname = pathname.substring(Aslpathlength);
        flower.setImg_path(relpathname);
        flowerService.updateFlower(flower);
        resp.sendRedirect(req.getContextPath()+"/manager/flowerServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Flower> flowers = flowerService.querryFlowers();
        req.setAttribute("flowers",flowers);
        req.getRequestDispatcher("/pages/manager/flower_manager.jsp").forward(req,resp);
    }

    protected void getFlower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Flower flower = flowerService.querryFlowerById(WebUtils.parseInt(req.getParameter("id"),null));
        req.setAttribute("flower",flower);
        req.getRequestDispatcher("/pages/manager/flower_edit.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Flower> page = flowerService.page(pageNo,pageSize);
        page.setUrl("manager/flowerServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/flower_manager.jsp").forward(req,resp);
    }

}
