package App.Guest;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GuestsServiceImpl implements GuestsService {
    // ConcurrentHashMap
    private final Map<UUID, Guests> guests = new ConcurrentHashMap<>();

    public GuestsServiceImpl() {
        loadGuests();
    }

    @Override
    public List<Guests> listAllGuests() {
        return new ArrayList<>(guests.values());
    }

    @Override
    public Guests getGuestById(UUID id) {
        return guests.get(id);
    }

    @Override
    public Guests Add(Guests guests) {
        this.guests.put(guests.getId(), guests);

        return guests;
    }

    @Override
    public void delete(UUID id) {
        guests.remove(id);
    }

    private void loadGuests() {
        Add(new Guests(UUID.randomUUID(), "Jan", "Kowalski"));
        Add(new Guests(UUID.randomUUID(), "Mateusz", "Nowak"));
        Add(new Guests(UUID.randomUUID(), "Anna", "Nowacka"));
    }
}
