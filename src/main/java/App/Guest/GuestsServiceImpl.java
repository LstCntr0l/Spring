package App.Guest;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GuestsServiceImpl implements GuestsService {
    // Nie powinniśmy reużywać identyfikatorów - lepiej utworzyć
    // sekwencję, która będzie przydzielać co raz większe identyfikatory.
    //
    // Użyty typ AtomicInteger rozwiązuje problemy ze współbieżnym dostępem z
    // wielu wątków jednocześnie (klasa GuestsServiceImpl to tzw. singleton, czyli
    // istnieje jedna jej instancja, która będzie używana przez wiele wątków)
    private final AtomicInteger guestsPrimaryKeyIndexSequence = new AtomicInteger(1);

    // GuestServiceImpl to klasa współdzielona (singleton) przechwoująca stan (guests oraz sekwencja)
    // dlatego musi być tzw. thread-safe - ;epiej korzystać z typów, które gwarantują synchronizację
    // podczas próby modyfikacji/dostępu z wielu wątków
    private final Map<Integer, Guests> guests = new ConcurrentHashMap<>();

    public GuestsServiceImpl() {
        loadGuests();
    }

    @Override
    public List<Guests> listAllGuests() {
        return new ArrayList<>(guests.values());
    }

    @Override
    public Guests getGuestById(Integer id) {
        return guests.get(id);
    }

    @Override
    public Guests Add(NewGuest newGuest) {
        Objects.requireNonNull(newGuest);

        int indexForNewGuest = guestsPrimaryKeyIndexSequence.getAndIncrement();

        Guests createdGuest = new Guests(
                newGuest.imie,
                newGuest.nazwisko,
                indexForNewGuest
        );

        this.guests.put(createdGuest.getId(), createdGuest);

        return createdGuest;
    }

    @Override
    public void delete(Integer id) {
        guests.remove(id);
    }

    private void loadGuests() {
        Add(new NewGuest("Jan", "Kowalski"));
        Add(new NewGuest("Mateusz", "Nowak"));
        Add(new NewGuest("Anna", "Nowacka"));
    }
}
