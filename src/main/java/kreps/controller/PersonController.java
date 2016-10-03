package kreps.controller;

import kreps.models.Person;
import kreps.repositories.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        String userId = "";
        try {
            Person person = new Person(email, name);
            personDao.save(person);
            userId = String.valueOf(person.getId());
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "Person succesfully created with id = " + userId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Person person = new Person(id);
            personDao.delete(person);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "Person succesfully deleted!";
    }

    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId = "";
        try {
            Person person = personDao.findByEmail(email);
            userId = String.valueOf(person.getId());
        } catch (Exception ex) {
            return "Person not found";
        }
        return "The user id is: " + userId;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            Person person = personDao.findOne(id);
            person.setEmail(email);
            person.setUsername(name);
            personDao.save(person);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "Person succesfully updated!";
    }
}
