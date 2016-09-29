package kreps.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String summary;

    @NotNull
    private long accountId;

    public Task() {

    }

    public Task(String summary, Long accountId) {

        this.summary = summary;
        this.accountId = accountId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
