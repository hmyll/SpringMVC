package abc.handlers;

import abc.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Component
 * @Service
 * @Respository
 * @Contreller
 */
@Controller
//@RequestMapping("/test")
public class SomeHandler {

    @RequestMapping("/first.do")
    public String doFifth(Student student) throws Exception {
        //返回物理视图名
        return "WEB-INF/jsp/welcome.jsp";
    }

    @RequestMapping("/second.do")
    public String doSecond() throws Exception {
        //返回逻辑视图名
        return "welcome";
    }

    @RequestMapping("/third.do")
    public String  doThird() throws Exception {
        return "aynu";
    }

    @RequestMapping("/forth.do")
    public void  doForth(HttpServletRequest request, HttpServletResponse response) throws Exception {
       //请求转发
        request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp").forward(request,response);
    }

    @RequestMapping("/myAjax1.do")
    public void  doAjax1(@RequestBody List<Student> students, HttpServletResponse response) throws Exception {
        System.out.println(students);
        response.setContentType("text/html");
        response.getWriter().print("receive success");
    }

    @RequestMapping("/myAjax2.do")
    public void  doAjax2(Student student, HttpServletResponse response) throws Exception {
        System.out.println("student"+student);
        response.setContentType("text/html");
        response.getWriter().print("receive success");
    }

    @RequestMapping("/myAjax3.do")
    @ResponseBody
    public double doAjax3() throws Exception {
        return 123.45;
    }

    @RequestMapping(value = "/myAjax4.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String doAjax4() throws Exception {
        return "aynu安阳师院";
    }

	@RequestMapping(value = "/myAjax5.do")
    @ResponseBody
    public Student doAjax5() throws Exception {
        return new Student("王五",23);
    }
}
