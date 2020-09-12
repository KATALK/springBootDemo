package com.bookcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author EdiMen
 * @Data 2020/9/12--17:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/downLoad.do")
public class FileDownloadController {
//C:\Users\ASUS\Desktop\2019090211073486270\fbc
// 6e6ae-0ed9-4b37-997d-ea668759126d\Spring Boot教材源程序及习题参考答案\Spring Boot教材源程序及习题参考答
// 案\Spring Boot教材源程序\ch75\1c5f661d9f3a4d7a31a643139840932.jpg
    @RequestMapping("/downloadfile")
    public String file(){
        return "/downloadfile";
    }

    @GetMapping("/testDownload")
    public void testDownload(HttpServletResponse response) {
        String path = "C:\\Users\\ASUS\\Desktop\\";
        String name = "1c5f661d9f3a4d7a31a643139840932.jpg";
        File file = new File(path+name);
        response.setHeader("content-type","application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+name);
        byte[] buff = new byte[1024];
        BufferedInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            inputStream = new BufferedInputStream(new FileInputStream(file));
            int i = inputStream.read(buff);
            while (i!=-1){
                outputStream.write(buff,0,buff.length);
                outputStream.flush();
                i = inputStream.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
