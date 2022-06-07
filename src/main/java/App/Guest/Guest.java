package App.Guest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Guest {
    @Id
    @GeneratedValue
    UUID id;

    @NotBlank
    String imie;

    @NotBlank
    String nazwisko;

    Boolean osobaTow;

    public Guest() {
    }

    public Guest(String imie, String nazwisko, Boolean osobaTow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.osobaTow=osobaTow;
    }

    public Boolean getOsobaTow() {
        return osobaTow;
    }
    public void setOsobaTow(Boolean osobaTow) {
        this.osobaTow = osobaTow;
    }

    public UUID getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
