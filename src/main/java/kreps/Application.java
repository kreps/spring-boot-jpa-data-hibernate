package kreps;

import kreps.models.Account;
import kreps.models.Task;
import kreps.repositories.AccountRepository;
import kreps.repositories.TaskDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner init(final AccountRepository accountRepository, final TaskDao taskDao) {
        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {
                String password = "password";
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(password);

                System.out.println(hashedPassword);
                accountRepository.deleteAll();


                Account account = new Account("kreps", hashedPassword,"krepssound@gmail.com");
                Account a = accountRepository.save(account);
                taskDao.deleteAll();
                taskDao.save(new Task("Show task list", a.getId()));
                taskDao.save(new Task("Commit changes", a.getId()));
                taskDao.save(new Task("Add bootstrap with webjars", a.getId(),true));


                Account account2 = new Account("kreps2", hashedPassword, "kkangro78@gmail.com");
                Account a2 = accountRepository.save(account2);
                taskDao.save(new Task("Show task list 2", a2.getId()));
                taskDao.save(new Task("Commit changes 2", a2.getId()));
                taskDao.save(new Task("Add bootstrap with webjars 2", a2.getId(),true));

            }
        };
    }
}

