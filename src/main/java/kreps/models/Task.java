package kreps.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(initialValue = 1, name = "taskgen", sequenceName = "task_seq")
public class Task {

    private long id;
    private String summary;
    private long accountId;
    private boolean isDone = false;

    public Task(String summary, long accountId, boolean isDone) {
        this.summary = summary;
        this.accountId = accountId;
        this.isDone = isDone;
    }

    public Task(String summary, long accountId) {
        this.summary = summary;
        this.accountId = accountId;
    }

    public Task() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskgen")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @NotNull
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
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
