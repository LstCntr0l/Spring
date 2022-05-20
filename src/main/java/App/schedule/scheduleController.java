package App.schedule;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class scheduleController {
    private ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public scheduleController(
        ScheduleService scheduleService,
        ScheduleRepository scheduleRepository
    ) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedule")
    public String harmonogram(Model model) {
        Map<String, List<Schedule>> groupedByTitle = scheduleService.listAllSchedules()
            .stream()
            .collect(Collectors.groupingBy(Schedule::getTittle));

        Map<String, String> titleIdToTitle = Map.of(
            "1", "18 - 12 miesięcy",
            "2", "18 - 12 miesięcy",
            "3", "18 - 12 miesięcy",
            "4", "18 - 12 miesięcy",
            "5", "18 - 12 miesięcy",
            "6", "18 - 12 miesięcy",
            "7", "18 - 12 miesięcy"
        );

        List<Schedules.Schedule> mappedSchedules = groupedByTitle.entrySet()
            .stream()
            .map(entry -> new Schedules.Schedule(
                titleIdToTitle.get(entry.getKey()),
                entry.getValue()
                    .stream()
                    .map(it -> new Schedules.Schedule.Entry(
                        it.id.toString(),
                        it.name,
                        it.done
                    ))
                    .collect(Collectors.toCollection(ArrayList::new)),
                UUID.randomUUID().toString()
            ))
            .collect(Collectors.toCollection(ArrayList::new));

        model.addAttribute("schedules", new Schedules(mappedSchedules));
        return "schedule";
    }


    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public String insertSchedule(AddScheduleRequestDto request) {
        Schedule schedule = new Schedule(
            request.tittle,
            request.name,
            request.done
        );
        Schedule savedSchedules = scheduleService.Add(schedule);
        return "redirect:/schedule";
    }

    @PostMapping("/schedule")
    public String edit(@ModelAttribute Schedules schedules, BindingResult bindingResult, Model model) {
        List<Schedules.Schedule.Entry> entries = schedules.getGroups()
            .stream()
            .flatMap(it -> schedules.getGroups().stream())
            .flatMap(it -> it.getEntries().stream())
            .toList();

        entries.forEach(entry -> {
            Schedule existingEntry = scheduleRepository.getById(UUID.fromString(entry.getId()));
            existingEntry.setDone(entry.getDone());
            scheduleRepository.save(existingEntry);
        });

        return "schedule";
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

