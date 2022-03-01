package com.xyx.javaweb_study02.servlet;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author :xyx
 * @date :2021/4/22 19:13
 * @description:TODO
 * @
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //字节流
        InputStream stream = req.getInputStream();
        /*int temp = 0;
        while ((temp = stream.read()) != -1) {
            System.out.println(temp);
        }*/
        //把字节流转成字符流,设置读的编码
        InputStreamReader StreamReader = new InputStreamReader(stream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(StreamReader);

        String path = req.getServletContext().getRealPath("upload.txt");
        //看看这个路径在哪
        System.out.println("输出文件的路径:"+path);
        //要输出的东西放在哪里
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        Writer writer = new OutputStreamWriter(fileOutputStream);

        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
            bufferedWriter.write(str);
        }
        bufferedWriter.close();
        writer.close();
        fileOutputStream.close();
        bufferedReader.close();
        StreamReader.close();
        stream.close();
    }
}
