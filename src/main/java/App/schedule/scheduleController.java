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
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
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
        Schedules value = getAllSchedules();
        model.addAttribute("schedules", value);
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
        List<Schedules.Schedule.Entry> updatedEntries = schedules.getGroups()
            .stream()
            .flatMap(it -> schedules.getGroups().stream())
            .flatMap(it -> it.getEntries().stream())
            .toList();

        Map<UUID, Schedule> existingEntires = updatedEntries.stream()
            .map(Schedules.Schedule.Entry::getId)
            .map(UUID::fromString)
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                scheduleRepository::findAllById
            ))
            .stream()
            .collect(Collectors.toMap(Schedule::getId, Function.identity()));

        List<Schedule> modifiedExistingEntries = updatedEntries.stream()
            .map(updatedEntry -> {
                Schedule existingEntry = Optional.ofNullable(existingEntires.get(UUID.fromString(updatedEntry.getId())))
                    .orElseThrow(() -> new IllegalStateException(String.format("Schedule entry with id %s does not exist!", updatedEntry.getId())));

                existingEntry.setDone(updatedEntry.getDone());

                return existingEntry;
            })
            .toList();

        scheduleRepository.saveAll(modifiedExistingEntries);

        model.addAttribute("schedules", getAllSchedules());

        return "schedule";
    }

    private Schedules getAllSchedules() {
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

        Schedules value = new Schedules(mappedSchedules);
        return value;
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

