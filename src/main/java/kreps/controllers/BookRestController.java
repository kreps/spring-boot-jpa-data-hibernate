package kreps.controllers;


import kreps.models.Book;
import kreps.repositories.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book")
@CrossOrigin
public class BookRestController {

    private Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private BookDao bookDao;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        return new ResponseEntity<Book>(bookDao.save(book), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public ResponseEntity<Book> read(@PathVariable("bookId") Long bookId) {
        logger.debug("Read all");
        return new ResponseEntity<Book>(bookDao.findOne(bookId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Book>> read() {
        return new ResponseEntity<Iterable<Book>>(bookDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{bookId}")
    public ResponseEntity<Book> update(@PathVariable("bookId") Long bookId, @RequestBody @Valid Book book) {
        Book updateBook = bookDao.findOne(bookId);
        updateBook.setName(book.getName());
        updateBook.setAuthor(book.getAuthor());
        return new ResponseEntity<Book>(bookDao.save(updateBook), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public ResponseEntity<?> delete(@PathVariable("bookId") Long bookId) {
        bookDao.delete(bookId);
        return new ResponseEntity<Object>(null, HttpStatus.ACCEPTED);
    }

}
