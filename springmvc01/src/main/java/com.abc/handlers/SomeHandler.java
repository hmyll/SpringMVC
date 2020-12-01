package com.abc.handlers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    自定义处理器
 */
public class SomeHandler implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("message","Hello world SpringMVC");
        mv.addObject("message","Hello world SpringMVC");
        mv.setViewName("welcome");
        return mv;
    }
}
