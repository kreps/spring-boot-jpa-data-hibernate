package kreps.controller;

import kreps.repositories.AccountRepository;
import kreps.repositories.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private AccountRepository accountRepository;


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String getTodoList(ModelMap model, Principal principal) {
        model.addAttribute("tasks", taskDao.findByAccountId(accountRepository.findByUsername(principal.getName()).getId()));
        model.addAttribute("page", "task/list");
        return "index";
    }
}
