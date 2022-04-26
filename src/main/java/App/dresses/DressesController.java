package App.dresses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DressesController {


    @RequestMapping("/dresses")
    public String listOfDresses() {
        return "dresses";
    }
}
