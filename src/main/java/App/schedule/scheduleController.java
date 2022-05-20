package App.schedule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class scheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public scheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping("/schedule")
    public String harmonogram(Model model){
        model.addAttribute("schedule",scheduleService.listAllSchedules());
        return "schedule";
    }


    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public String insertSchedule(AddScheduleRequestDto request) {
        Schedule schedule= new Schedule(
                request.tittle,
                request.name,
                request.done
        );
        Schedule savedSchedules=scheduleService.Add(schedule);
        return "redirect:/schedules";
    }


}

class AddScheduleRequestDto {
    final String tittle;
    final String name;
    final Boolean done;

    public AddScheduleRequestDto(String tittle, String name, Boolean done) {
        this.tittle = tittle;
        this.name = name;
        this.done = done;
    }
}

