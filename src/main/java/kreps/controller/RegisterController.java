package kreps.controller;

import kreps.models.Account;
import kreps.repositories.AccountRepository;
import kreps.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@CrossOrigin
public class RegisterController {


//    @Autowired
//    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

//    @RequestMapping(method = RequestMethod.GET, value = "/api/accounts/{id}")
//    public ResponseEntity<Account> read(@PathVariable("id") Long id) {
//        return new ResponseEntity<Account>(accountRepository.findOne(id), HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/api/accounts")
//    public ResponseEntity<Iterable<Account>> read() {
//        return new ResponseEntity<Iterable<Account>>(accountRepository.findAll(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("page", "register");
        model.addAttribute("account", new Account("user1", "password", "email1@dot.com"));
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Account account, Model model) {
        accountService.registerNewAccount(account);
        model.addAttribute("page", "login");
        return "index";
    }
}
