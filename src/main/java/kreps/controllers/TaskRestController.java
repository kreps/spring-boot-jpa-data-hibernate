package kreps.controllers;


import kreps.models.Task;
import kreps.repositories.TaskDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskRestController {

    private Logger logger = LoggerFactory.getLogger(TaskRestController.class);

    @Autowired
    private TaskDao taskDao;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> create(@RequestBody @Valid Task task) {
        return new ResponseEntity<Task>(taskDao.save(task), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{taskId}")
    public ResponseEntity<Task> read(@PathVariable("taskId") Long taskId) {
        logger.debug("Read all");
        return new ResponseEntity<Task>(taskDao.findOne(taskId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Task>> read() {
        return new ResponseEntity<Iterable<Task>>(taskDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{taskId}")
    public ResponseEntity<Task> update(@PathVariable("taskId") Long taskId, @RequestBody @Valid Task task) {
        Task updateTask = taskDao.findOne(taskId);
        updateTask.setSummary(task.getSummary());
        updateTask.setAccountId(task.getAccountId());
        return new ResponseEntity<Task>(taskDao.save(updateTask), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{taskId}")
    public ResponseEntity<?> delete(@PathVariable("taskId") Long taskId) {
        taskDao.delete(taskId);
        return new ResponseEntity<Object>(null, HttpStatus.ACCEPTED);
    }

}
