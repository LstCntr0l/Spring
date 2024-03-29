package App.Guest;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestsServiceImpl implements GuestsService {
    private final GuestRepository guestRepository;

    public GuestsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> listAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest Add(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void delete(UUID id) {
        guestRepository.deleteById(id);
    }

}
