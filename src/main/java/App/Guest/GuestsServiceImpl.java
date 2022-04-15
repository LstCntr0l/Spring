package App.Guest;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestsServiceImpl implements GuestsService {
    private final GuestRepository guestRepository;

    public GuestsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;

        loadGuests();
    }

    @Override
    public List<Guest> listAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getGuestById(UUID id) {
        return guestRepository.getById(id);
    }

    @Override
    public Guest Add(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void delete(UUID id) {
        guestRepository.deleteById(id);
    }

    private void loadGuests() {
        Add(new Guest("Jan", "Kowalski"));
        Add(new Guest("Mateusz", "Nowak"));
        Add(new Guest("Anna", "Nowacka"));
    }
}
