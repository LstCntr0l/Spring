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

    @PostMapping("/schedule")
    public String edit(@ModelAttribute Schedules schedules, BindingResult bindingResult, Model model) {

        List<Schedules.Schedule.Entry> updatedEntries = schedules.getGroups()
                .stream()
                .flatMap(it -> schedules.getGroups().stream())
                .flatMap(it -> it.getEntries().stream())
                .toList();

        Map<UUID, Schedule> existingEntires = updatedEntries.stream()
                .map(entry -> entry.getId())
                .map(UUID::fromString)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        (List<UUID> ids) -> scheduleRepository.findAllById(ids)
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
                "1", "18 - 12 miesięcy przed ślubem",
                "2", "11 - 7 miesięcy przed ślubem",
                "3", "6 - 4 miesięce przed ślubem",
                "4", "3 miesięce przed ślubem",
                "5", "2 - 1 miesięc przed ślubem",
                "6", "1 dzień przed ślubem ",
                "7", "Po ślubie"
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


