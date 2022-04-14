package App.Guest;

import java.util.List;

public interface GuestsService {
    List<Guests> listAllGuests();
    Guests getGuestById(Integer id);
    Guests Add(Guests guests);
    void delete(Integer id);
}
