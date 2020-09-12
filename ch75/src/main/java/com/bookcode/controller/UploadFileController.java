package com.bookcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @Author EdiMen
 * @Data 2020/9/12--14:52
 * @Version 1.0
 */
@Controller
@RequestMapping("/upload.do")
public class UploadFileController {

    @GetMapping("/toFileUploadPage")
    public String toFileUploadPage(){
        return "file";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
        if (!file.isEmpty()){
            try {
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
                        new File(file.getOriginalFilename())
                ));
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败，"+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败，"+e.getMessage();
            }
            return "上传成功！";
        }else {
            return "上传失败，因为文件是空的！";
        }
    }

    @GetMapping("/multifile")
    public String multifile(){
        return "/multifile";
    }

    @PostMapping("/batch/upload")
    @ResponseBody
    public  String handFile(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        BufferedOutputStream outputStream = null;
        MultipartFile file = null;
        int count = 0;
        for (int i = 0; i<files.size();i++){
            file = files.get(i);
            if (!file.isEmpty()){
                try {
                    outputStream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())
                    ));
                    outputStream.write(file.getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    outputStream = null;
                    return "YOU failed to upload"+i+"=>"+e.getMessage();
                }
            }else {
                count++;
            }
        }
        if (count>0){
            return "上传成功"+(files.size()-count)+"个文件"+"有"+count+"个文件为空";
        }else {
            return "success";
        }
    }
}
