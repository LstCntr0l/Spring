package App.Guest;

import java.util.List;
import java.util.UUID;

public interface GuestsService {
    List<Guest> listAllGuests();
    Guest getGuestById(UUID id);
    Guest Add(Guest guests);
    void delete(UUID id);
}
