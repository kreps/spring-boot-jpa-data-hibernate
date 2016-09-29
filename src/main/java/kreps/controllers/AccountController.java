package kreps.controllers;

import kreps.models.Account;
import kreps.models.Task;
import kreps.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kkangro@gmail.com on 29.09.2016.
 */
@RestController
@RequestMapping("/api/accounts")
@CrossOrigin
public class AccountController {


    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Account> read(@PathVariable("id") Long id) {
        return new ResponseEntity<Account>(accountRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> read() {
        return new ResponseEntity<Iterable<Account>>(accountRepository.findAll(), HttpStatus.OK);
    }
}
