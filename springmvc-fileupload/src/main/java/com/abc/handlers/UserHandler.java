package com.abc.handlers;

import com.abc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserHandler {

    @RequestMapping("/toLogin.do")
    public String toLogin(){
        return "/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping("/login.do")
    public String login(User user, Model model, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        if(username!=null &&  username.equals("zs") && password!=null && password.equals("123456")){
            session.setAttribute("user_session",user);
            //登录成功就重定向到主页面
            return "redirect:toMain.do";
        }
        model.addAttribute("msg","用户或者密码错误");
        return "/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping("/toMain.do")
    public String toMain(){
        return "/WEB-INF/jsp/main.jsp";
    }


}
