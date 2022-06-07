package App.schedule;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.FALSE;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

        loadscheudles();
    }


    @Override
    public List<Schedule> listAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule Add(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    private void loadscheudles() {
        if (listAllSchedules().isEmpty()) {
            Add(new Schedule("1", "Ustalcie datę ślubu", FALSE));
            Add(new Schedule("1", "Ustalcie budżet", FALSE));
            Add(new Schedule("1", "Opracujcie wstępną listę gości", FALSE));
            Add(new Schedule("1", "Zarezerwujcie salę weselną", FALSE));
            Add(new Schedule("1", "Zarezerwujcie miejsce ślubu", FALSE));
            Add(new Schedule("1", "Zarezerwujcie fotografa/kamerzystę", FALSE));
            Add(new Schedule("1", "Zarezerwujcie zespół lub DJ", FALSE));

            Add(new Schedule("2", "Wybierzcie świadków", FALSE));
            Add(new Schedule("2", "Zamówcie atrakcje weselne", FALSE));
            Add(new Schedule("2", "Zapiszcie się na nauki przedmałżeńskie", FALSE));
            Add(new Schedule("2", "Rozpocznij poszukiwania sukni ślubnej/garnituru", FALSE));
            Add(new Schedule("2", "Wybierzcie fryzjera i wizażystę", FALSE));

            Add(new Schedule("3", "Złóżcie dokumenty w USC", FALSE));
            Add(new Schedule("3", "Wybierzcie ślubną papeterię", FALSE));
            Add(new Schedule("3", "Wybierzcie dekoracje kwiatowe", FALSE));
            Add(new Schedule("3", "Zarezerwujcie auto do ślubu", FALSE));
            Add(new Schedule("3", "Kupcie obrączki ślubne", FALSE));
            Add(new Schedule("3", "Zapiszcie się na kurs tańca", FALSE));

            Add(new Schedule("4", "Załatwiajcie formalności z księdzem", FALSE));
            Add(new Schedule("4", "Zróbcie ostateczną listę gości", FALSE));
            Add(new Schedule("4", "Zapraszajcie wszystkich gości z listy", FALSE));
            Add(new Schedule("4", "Zaplanujcie upominki dla rodziców/gości/świadków", FALSE));
            Add(new Schedule("4", "Kupcie alkohol", FALSE));

            Add(new Schedule("5", "Ustalcie przebieg ceremonii zaślubin", FALSE));
            Add(new Schedule("5", "Ustalcie menu weselne", FALSE));
            Add(new Schedule("5", "Ustalcie plan rozsadzenia gości", FALSE));
            Add(new Schedule("5", "Ustalcie szczegóły z fotografem/kamerzystą", FALSE));
            Add(new Schedule("5", "Ustalcie szczegóły z zespołem/DJ", FALSE));
            Add(new Schedule("5", "Zweryfikujcie potwierdzenia przybycia gości", FALSE));
            Add(new Schedule("5", "Odbierzcie suknię/garnitur z salonu", FALSE));

            Add(new Schedule("6", "Dostarczcie alkohol na salę", FALSE));
            Add(new Schedule("6", "Ułóżcie winietki", FALSE));
            Add(new Schedule("6", "Zapakujcie prezenty dla rodziców/gości/świadków", FALSE));
            Add(new Schedule("6", "Przygotujcie stroje i inne akcesoria", FALSE));

            Add(new Schedule("7", "Uregulujcie wszystkie należności", FALSE));
            Add(new Schedule("7", "Załatwcie formalności", FALSE));
        }
    }
}
