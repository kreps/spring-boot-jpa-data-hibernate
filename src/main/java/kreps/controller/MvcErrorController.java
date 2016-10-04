package kreps.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kkangro@gmail.com on 03.10.2016.
 */
@Controller
public class MvcErrorController implements ErrorController {


    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping( value = PATH)
    public String error(Model model) {
        model.addAttribute("page","error/error");
        return "index";
    }
}
