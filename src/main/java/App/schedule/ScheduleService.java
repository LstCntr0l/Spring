package App.schedule;

import java.util.List;
import java.util.UUID;

public interface ScheduleService {
    List<Schedule> listAllSchedules();
    Schedule Add(Schedule schedule);
    Schedule getScheduleById(UUID id);
}
