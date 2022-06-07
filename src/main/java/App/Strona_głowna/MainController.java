package App.Strona_głowna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/index")
    public String stronaGlowna() {
        return "index";
    }
}
