package kreps.repositories;

import kreps.models.Person;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PersonDao extends CrudRepository<Person, Long> {
    Person findByEmail(String email);
}
