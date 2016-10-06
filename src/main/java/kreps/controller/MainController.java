package kreps.controller;

import kreps.models.Account;
import kreps.repositories.AccountRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    AccountRepository accountRepository;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Task manager application");
        model.addAttribute("summary", "Info sisu ja muud asjad");
        model.addAttribute("page","info");
        return "index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(Model model){
        model.addAttribute("page","login");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLoginForm(Model model){
        model.addAttribute("page","task/list");
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogoutPage(Model model){
        model.addAttribute("page","logout");
        return "index";
    }


}