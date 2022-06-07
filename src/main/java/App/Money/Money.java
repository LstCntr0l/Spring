package App.Money;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Money {
    @Id
    @GeneratedValue
    UUID id;

    @NotBlank
    String nazwa;

    @NotBlank
    String KwotaDoZaplaty;

    @NotBlank
    String KwotaZaplacona;

    public Money(){
    }

    public Money(String nazwa, String kwotaDoZaplaty, String kwotaZaplacona) {
        this.nazwa = nazwa;
        this.KwotaDoZaplaty = kwotaDoZaplaty;
        this.KwotaZaplacona = kwotaZaplacona;
    }

    public UUID getId() { return id; }

    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getKwotaDoZaplaty() { return KwotaDoZaplaty; }
    public void setKwotaDoZaplaty(String kwotaDoZaplaty) { KwotaDoZaplaty = kwotaDoZaplaty; }

    public String getKwotaZaplacona() { return KwotaZaplacona; }
    public void setKwotaZaplacona(String kwotaZaplacona) { KwotaZaplacona = kwotaZaplacona; }
}