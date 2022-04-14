package App.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GuestsController {
    private GuestsService guestsService;

    @Autowired
    public void setGuestsController(GuestsService guestsService) {
        this.guestsService = guestsService;
    }

    @RequestMapping("/guests")
    public String listOfGuests(Model model) {
        model.addAttribute("guests", guestsService.listAllGuests());
        return "guests";
    }

    @RequestMapping("/guest/add")
    public String newGuest(Model model) {
        model.addAttribute("guest", new Guests());
        return "add";
    }


    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public String guestADD(Guests guests) {
        Guests savedGuests = guestsService.Add(guests);
        return "redirect:/guests";
    }

    @RequestMapping("/guest/delete/{id}")
    public String delete(@PathVariable Integer id) {
        guestsService.delete(id);
        return "redirect:/guests";
    }
}