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
    String KwotaDoZapłaty;

    @NotBlank
    String KwotaZapłacona;

    @Version
    Long version;

    public Money(){
    }

    public Money( String nazwa,  String kwotaDoZapłaty,  String kwotaZapłacona) {
        this.nazwa = nazwa;
        this.KwotaDoZapłaty = kwotaDoZapłaty;
        this.KwotaZapłacona = kwotaZapłacona;
    }

    public UUID getId() { return id; }

    public String getNazwa() { return nazwa; }

    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getKwotaDoZapłaty() { return KwotaDoZapłaty; }

    public void setKwotaDoZapłaty(String kwotaDoZapłaty) { KwotaDoZapłaty = kwotaDoZapłaty; }

    public String getKwotaZapłacona() { return KwotaZapłacona; }

    public void setKwotaZapłacona(String kwotaZapłacona) { KwotaZapłacona = kwotaZapłacona; }
}