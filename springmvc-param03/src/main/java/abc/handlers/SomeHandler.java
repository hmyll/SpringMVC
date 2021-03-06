package abc.handlers;

import abc.exceptions.AgeException;
import abc.exceptions.MyExceptionHandler;
import abc.exceptions.UsernameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Component
 * @Service
 * @Respository
 * @Contreller
 */
@Controller
//@RequestMapping("/test")
public class SomeHandler extends MyExceptionHandler {

    @RequestMapping("/first.do")
    public String doFifth() throws Exception {
        int a = 3/0;
        return "WEB-INF/jsp/welcome.jsp";
    }

    @RequestMapping("/second.do")
    public String doSecond(String name,int age) throws Exception {
        if(!"aynu".equals(name)){
            throw new UsernameException("用户名有误");
        }
        if(age<=0 || age>200){
            throw new AgeException("年龄有误");
        }
        int a = 3/0;
        return "WEB-INF/jsp/welcome.jsp";
    }



}
