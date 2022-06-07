package App.schedule;

import java.util.List;


public interface ScheduleService {
    List<Schedule> listAllSchedules();
    Schedule Add(Schedule schedule);
}
