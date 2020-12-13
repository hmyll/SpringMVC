package abc.exceptions;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义异常解析器
public class MyHanderExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e.getMessage());
        mv.setViewName("/errors.jsp");
        if (e instanceof UsernameException){
            mv.setViewName("/usernameException.jsp");
        }
        if (e instanceof AgeException){
            mv.setViewName("/ageException.jsp");
        }
        return mv;
    }
}
