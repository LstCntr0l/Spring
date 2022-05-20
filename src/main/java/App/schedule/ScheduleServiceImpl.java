package App.schedule;

import org.springframework.stereotype.Service;

import java.util.List;
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



}
