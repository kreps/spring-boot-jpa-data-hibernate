package kreps.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String email;

    @NotNull
    private String username;

    public Person(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person(long id) {
        this.id = id;
    }
}
