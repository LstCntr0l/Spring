package App.Guest;

import java.util.List;

public interface GuestsService {
    List<Guests> listAllGuests();
    Guests getGuestById(Integer id);
    Guests Add(NewGuest newGuest); // Jeżeli jako identyfiaktor wykorzystujemy sekwencję, to lepiej
                                   // by było, gdyby klient nie mógł samodzielnie nadawać identyfikatora.
                                   // Dlatego lepiej tutaj wprowadzić typ, który pozwoli na określenie jakie pola
                                   // mogą zostać przez klienta nadane (jedynie imię i nazwisko)
    void delete(Integer id);
}
