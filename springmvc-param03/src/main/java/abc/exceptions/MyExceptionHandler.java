package abc.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler {

    @ExceptionHandler
    public ModelAndView handeException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e.getMessage());
        mv.setViewName("/errors.jsp");
        return mv;
    }

    @ExceptionHandler(UsernameException.class)
    public ModelAndView handleUsernameException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e.getMessage());
        mv.setViewName("/usernameException.jsp");
        return mv;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView handeAgeException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e.getMessage());
        mv.setViewName("/ageException.jsp");
        return mv;
    }
}
