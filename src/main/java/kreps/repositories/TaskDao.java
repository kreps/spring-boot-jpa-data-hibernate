package kreps.repositories;

import kreps.models.Task;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface TaskDao extends CrudRepository<Task, Long> {

    Iterable<Task> findByAccountId(long accountId);

}
