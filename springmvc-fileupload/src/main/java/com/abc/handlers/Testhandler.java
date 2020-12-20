package com.abc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Testhandler {

    @RequestMapping("/first.do")
    public String doFirst(){
        System.out.println("执行处理器doFirst()方法");
        return "/welcome.jsp";
    }
}
