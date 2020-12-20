package com.abc.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
//@RequestMapping("/test")
public class  SomeHandler  {

    @RequestMapping("/upload.do")
    public String doUpload(MultipartFile pic, HttpServletRequest request) throws IOException {
        if(!pic.isEmpty()){
            String path = request.getServletContext().getRealPath("/images");
            System.out.println(path);
            String filename = System.currentTimeMillis()+pic.getOriginalFilename();
            if(filename.endsWith(".jpg")||filename.endsWith(".png")){
                File file = new File(path,filename);
                pic.transferTo(file);
                return "/welcome.jsp";
            }
        }
        return "/message.jsp";
    }

    @RequestMapping("/upload2.do")
    public String doUpload(MultipartFile[] pics, HttpServletRequest request) throws IOException {
        boolean flag = false;
        for (int i = 0; i < pics.length; i++) {
            if(!pics[i].isEmpty()){
                String path = request.getServletContext().getRealPath("/images");
                System.out.println(path);
                String filename = System.currentTimeMillis()+pics[i].getOriginalFilename();
                if(filename.endsWith(".jpg")||filename.endsWith(".png")){
                    File file = new File(path,filename);
                    pics[i].transferTo(file);
                    flag = true;
                }
            }
        }
        if(flag) {
            return "/welcome.jsp";
        }
        else return "/message.jsp";
    }
}
