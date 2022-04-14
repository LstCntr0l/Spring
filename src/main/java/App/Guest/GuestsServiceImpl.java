package App.Guest;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestsServiceImpl implements GuestsService {
    private Map<Integer, Guests> guests;

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
    public Guests Add(Guests guests) {
        if(guests !=null){
            if(guests.getId()==null){
                guests.setId(getNextId());
            }
            this.guests.put(guests.getId(), guests);
            return guests;
        }else{
            throw new RuntimeException("Nie");
        }
    }

    @Override
    public void delete(Integer id) {
        guests.remove(id);
    }

    private Integer getNextId() {
        return Collections.max(guests.keySet())+1;
    }

    private void loadGuests() {
        guests = new HashMap<>();
        Guests guests1 = new Guests();
        guests1.setId(1);
        guests1.setImie("Jan");
        guests1.setNazwisko("Kowalski");
        guests.put(1, guests1);

        Guests guests2 = new Guests();
        guests2.setId(2);
        guests2.setImie("Mateusz");
        guests2.setNazwisko("Nowak");
        guests.put(2, guests2);

        Guests guests3 = new Guests();
        guests3.setId(3);
        guests3.setImie("Anna");
        guests3.setNazwisko("Nowacka");
        guests.put(3, guests3);
    }
}
