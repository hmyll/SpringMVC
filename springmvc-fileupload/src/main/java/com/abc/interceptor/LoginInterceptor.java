package com.abc.interceptor;

import com.abc.beans.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //除了toLogin.do和login.do可以公开访问，其他都被拦截
        String uri = request.getRequestURI();
        if(uri.indexOf("/toLogin.do")>=0 ||uri.indexOf("/login.do")>=0){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_session");
        if(user!=null){
            return true;
        }
        request.setAttribute("msg","你还没用登录，请登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
