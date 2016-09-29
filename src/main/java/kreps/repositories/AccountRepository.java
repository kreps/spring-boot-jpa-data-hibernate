package kreps.repositories;

import kreps.models.Account;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by kkangro@gmail.com on 23.09.2016.
 */
@Transactional
public interface AccountRepository extends CrudRepository<Account, Long>{
    Account findByUsername(String username);
}
