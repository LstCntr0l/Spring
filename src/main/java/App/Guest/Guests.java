package App.Guest;


import java.util.UUID;

public class Guests {
    private String imie;
    private String nazwisko;
    private UUID id; // UUID wygląda tak: 3e365e38-9e94-45c0-8444-0c141c44d595
                     // nie-enumerowalny, unikalny identyfikator - możliwy do wygenerowania po stronie klienta

    public Guests() {
    }

    public Guests(UUID id, String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
