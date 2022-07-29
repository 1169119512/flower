package com.flower.web;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        if(ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);

                for (FileItem fileItem : list) {

                    if(fileItem.isFormField()){
                        System.out.println("表单项属性值"+fileItem.getFieldName());
                        System.out.println("表单项Value属性值"+fileItem.getString("UTF-8"));
                    }
                    else {
                        System.out.println("表单项属性值"+fileItem.getFieldName());
                        System.out.println("上传文件名"+fileItem.getName());

                        fileItem.write(new File("C:\\Users\\Coder\\Desktop\\output1\\"+fileItem.getName()));

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
}