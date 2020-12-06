package abc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Component
 * @Service
 * @Respository
 * @Contreller
 */
@Controller
@RequestMapping("/test")//定义命名空间
public class SomeHandler {

    //多个URL对应一个处理器
    @RequestMapping({"/some.do","/first.do"})
    public ModelAndView doFirst(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("message","Hello world SpringMVC");
        mv.addObject("message","Hello world SpringMVC");
        mv.setViewName("WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    @RequestMapping("/second.do")
    public ModelAndView doSecond(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("message","Hello world SpringMVC");
        mv.addObject("message","执行doSecond()");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    //使用通配符
    @RequestMapping("/third*.do")//要求请求路径的资源名称以third开头
   // @RequestMapping("/*third.do")//要求请求路径的资源名称以third结尾
  //  @RequestMapping("/*/third.do")//要求请求路径的资源名称之间多了一级路径
    public ModelAndView doThird(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("message","Hello world SpringMVC");
        mv.addObject("message","doThird()");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    //对请求提交方式的定义
    @RequestMapping(value = "/forth.do",method = RequestMethod.POST)
    public ModelAndView doForth(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("message","Hello world SpringMVC");
        mv.addObject("message","执行doForth()");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }

    //对请求参数的定义
    //@RequestMapping(value = "/fifth.do",params = "name")// 请求必须携带name属性
    //@RequestMapping(value = "/fifth.do",params = {"name","age"})// 请求必须携带name与age属性
    //@RequestMapping(value = "/fifth.do",params = {"!name","age"})// 请求中不能携带name属性，但必须携带age属性
    @RequestMapping(value = "/fifth.do",params = {"name=zs","age"})// 请求中不能携带name属性，但必须携带age属性
    public ModelAndView doFifth(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("message","Hello world SpringMVC");
        mv.addObject("message","执行doFifth()");
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");
        return mv;
    }


}
