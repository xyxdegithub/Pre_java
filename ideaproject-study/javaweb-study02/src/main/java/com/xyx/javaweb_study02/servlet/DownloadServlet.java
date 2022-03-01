package com.xyx.javaweb_study02.servlet;

import sun.net.www.content.image.png;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author :xyx
 * @date :2021/4/23 18:59
 * @description:TODO
 * @
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        //设置响应方式
        resp.setContentType("application/x-msdownload");
        String fileName = "";
        switch (type) {
            case "png":
                fileName = "1.png";
                break;
            case "txt":
                fileName = "test.txt";
                break;
        }

        //设置下载的文件名
        resp.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        ServletOutputStream outputStream = resp.getOutputStream();//响应输出

        String path = "E:\\JavaCode\\workspace_idea\\javaweb-study02\\src\\main\\resources\\download\\" + fileName;

        InputStream fileInputStream = new FileInputStream(path);//输入
        int temp = 0;
        while ((temp = fileInputStream.read()) != -1) {
            outputStream.write(temp);
        }
        outputStream.close();
        fileInputStream.close();

    }
}
