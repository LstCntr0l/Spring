package App.schedule;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class scheduleController {


    @RequestMapping("/schedule")
    public String harmonogram(){
        return "schedule";
    }

}

