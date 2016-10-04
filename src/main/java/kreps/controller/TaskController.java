package kreps.controller;

import kreps.repositories.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;



    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String getTodoList(ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username: " + auth.getName());

        model.addAttribute("tasks", taskDao.findAll());
        model.addAttribute("page","task/list");
        return "index";
    }
}
