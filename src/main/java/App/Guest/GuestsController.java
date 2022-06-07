package App.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public String guestADD(AddGuestRequestDto request) {
        Guest guest = new Guest(
                request.imie,
                request.nazwisko,
                request.osobaTow
        );

        Guest savedGuests = guestsService.Add(guest);
        return "redirect:/guests";
    }

    @RequestMapping("/guests/delete/{id}")
    public String delete(@PathVariable UUID id) {
        guestsService.delete(id);
        return "redirect:/guests";
    }
}

class AddGuestRequestDto {
    final String imie;
    final String nazwisko;
    final Boolean osobaTow;

    AddGuestRequestDto(String imie, String nazwisko, Boolean osobaTow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.osobaTow=osobaTow;
    }
}