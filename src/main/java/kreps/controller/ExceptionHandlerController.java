package kreps.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;



@ControllerAdvice//Apply to all controllers
public class ExceptionHandlerController {

//    public static final String DEFAULT_ERROR_VIEW = "index";

    private Log logger = LogFactory.getLog(ExceptionHandlerController.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView handleError(HttpServletRequest request, Exception e) {
        logger.error("Request: " + request.getRequestURL() + " raised exception.",e);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("page","error/error");
        mav.addObject("message",e.getMessage());
        return mav;
    }
}