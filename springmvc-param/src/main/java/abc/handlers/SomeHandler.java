package abc.handlers;

import abc.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Component
 * @Service
 * @Respository
 * @Contreller
 */
@Controller
public class SomeHandler {

    //Map
    @RequestMapping("/first.do")
    public ModelAndView doFirst(Map<String,Object> map) throws Exception {
        //等价于request.setAttribute("message","处理方法的参数为Map");
        map.put("message","处理器方法的参数为Map");
        return new ModelAndView("WEB-INF/jsp/welcome.jsp");
    }

    //逐个接受请求参数，要求处理器方法的参数必须与请求参数名称相同
    @RequestMapping("/second.do")
    public ModelAndView doSecond(String name, int age, Map<String,Object> map) throws Exception {
        map.put("name",name);
        map.put("age",age);
        return new ModelAndView("WEB-INF/jsp/welcome.jsp");
    }

    //矫正请求参数
    @RequestMapping("/third.do")
    public ModelAndView doThird(@RequestParam("name") String pname,@RequestParam("age") int page, Map<String,Object> map) throws Exception {
        map.put("name",pname);
        map.put("age",page);
        return new ModelAndView("WEB-INF/jsp/welcome.jsp");
    }

    //使用Map对请求参数进行整体接收,但是接收的是String类型，不会进行类型的自动转换
    @RequestMapping("/forth.do")
    public ModelAndView doForth(@RequestParam Map<String,Object> map, HttpServletRequest request) throws Exception {
        String name = (String) map.get("name");
        String age = (String) map.get("age");
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        return new ModelAndView("WEB-INF/jsp/welcome.jsp");
    }

    //使用自定义类型对象对请求参数进行整体接收，系统会将对象自动放入request域，但是采用逐个接收方式，系统不会将请求参数自动放入request中
    @RequestMapping("/fifth.do")
    public ModelAndView doFifth(Student student) throws Exception {
        System.out.println(student);
        return new ModelAndView("WEB-INF/jsp/welcome.jsp");
    }

    @RequestMapping("/sixth.do")
    public ModelAndView doSixth(String name, int age, Map<String,Object> map) throws Exception {

        return new ModelAndView("WEB-INF/jsp/welcome.jsp");
    }
}
