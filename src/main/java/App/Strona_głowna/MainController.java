package App.Strona_głowna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private MainService mainService;

    @Autowired
    public void setMainController(MainService mainService) {
        this.mainService = mainService;
    }


    @RequestMapping("/index")
    public String stronaGlowna(Model model) {
        model.addAttribute("opcje", mainService.listAllOptions());
        return "index";
    }
}
