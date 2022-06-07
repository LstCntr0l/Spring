package App.Guest;

import java.util.List;
import java.util.UUID;

public interface GuestsService {
    List<Guest> listAllGuests();
    Guest Add(Guest guests);
    void delete(UUID id);
}
