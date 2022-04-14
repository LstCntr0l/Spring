package App.Guest;

import java.util.List;
import java.util.UUID;

public interface GuestsService {
    List<Guests> listAllGuests();
    Guests getGuestById(UUID id);
    Guests Add(Guests guests);
    void delete(UUID id);
}
