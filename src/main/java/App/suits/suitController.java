package App.suits;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class suitController {
    @RequestMapping("/suits")
    public String listOfSuits() {
        return "suits";
    }
}
