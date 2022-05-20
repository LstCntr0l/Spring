package App.schedule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    UUID id;

    @NotBlank
    String tittle;

    @NotBlank
    String name;

    Boolean done;

    public Schedule() {
    }

    public Schedule(@NotBlank String tittle, @NotBlank String name, Boolean done) {
        this.tittle = tittle;
        this.name = name;
        this.done = done;
    }

    public UUID getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
