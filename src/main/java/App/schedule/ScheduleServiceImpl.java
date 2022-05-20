package App.schedule;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

    }

    @Override
    public List<Schedule> listAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule Add(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getScheduleById(UUID id) {
        return scheduleRepository.getById(id);
    }


}
