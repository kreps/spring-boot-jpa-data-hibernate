package kreps.repositories;

import kreps.models.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookDao extends CrudRepository<Book, Long>{

}
