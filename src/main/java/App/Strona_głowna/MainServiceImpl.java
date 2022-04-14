package App.Strona_głowna;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService {

    private Map<Integer, Opt> opcje;

    public MainServiceImpl() {
        loadOptions();
    }


    @Override
    public List<Opt> listAllOptions() {
        return new ArrayList<>(opcje.values());
    }


    private void loadOptions() {
        opcje= new HashMap<>();
        Opt opcja1= new Opt();
        opcja1.setId(1);
        opcja1.setOpcja("Obrączki");
        opcje.put(1,opcja1);

        Opt opcja2= new Opt();
        opcja2.setId(2);
        opcja2.setOpcja("Goście");
        opcje.put(2,opcja2);

        Opt opcja3= new Opt();
        opcja3.setId(3);
        opcja3.setOpcja("Stoły");
        opcje.put(3,opcja3);

        Opt opcja4= new Opt();
        opcja4.setId(4);
        opcja4.setOpcja("Muzyka");
        opcje.put(4,opcja4);

        Opt opcja5= new Opt();
        opcja5.setId(5);
        opcja5.setOpcja("Strój");
        opcje.put(5,opcja5);
    }
}
