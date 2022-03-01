package com.xyx.javaweb_study02.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/4/23 11:13
 * @description:TODO
 * @
 */
@WebServlet("/upload2")
public class UploadServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItemList = null;
        try {
            fileItemList = servletFileUpload.parseRequest(req);
            System.out.println(fileItemList);
            for (FileItem file : fileItemList) {
                if (file.isFormField()) {
                    //判断该表单项是否是普通类型
                    String fieldName = file.getFieldName();
                    String value = file.getString("utf-8");
                    System.out.println(fieldName + ":" + value);

                } else {
                    String fileName = file.getName();//获取文件名称
                    //System.out.println(fileName);
                    long fileSize = file.getSize();
                    System.out.println(fileName + ":" + fileSize + "Byte");

                    InputStream inputStream = file.getInputStream();//把文件变成输入流

                    /*String path = req.getServletContext().getRealPath(fileName);
                    System.out.println(path);*/
                    String path = "E:\\JavaCode\\workspace_idea\\javaweb-study02\\src\\main\\resources\\upload\\" + fileName;

                    FileOutputStream fileOutputStream = new FileOutputStream(path);
                    //输出流输出到指定路径

                    int temp = 0;
                    while ((temp = inputStream.read()) != -1) {
                        fileOutputStream.write(temp);
                    }

                    resp.getWriter().write("上传成功!");
                    fileOutputStream.close();
                    inputStream.close();
                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
