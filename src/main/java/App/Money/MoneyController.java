package App.Money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public class MoneyController {
    private MoneyService moneyService;


@Autowired
    public void setMoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @RequestMapping("/Money")
    public String listOfMoney(Model model){
    model.addAttribute("Money", moneyService.ListAllMoney());
    return "Money";
    }

    @RequestMapping(value = "/cash", method = RequestMethod.POST)
    public String moneyADD(AddMoneyRequestDto request)
    {
        Money cash=new Money(
                request.nazwa,
                request.KwotaDoZapłaty,
                request.KwotaZapłacona
        );
        Money savedMoney=moneyService.Add(cash);
        return "redirect:/Money";
    }

    @RequestMapping("/Money/delete/{id}")
    public String delete(@PathVariable UUID id) {
        moneyService.delete(id);
        return "redirect:/Money";
    }
}

    class AddMoneyRequestDto {
    final String nazwa;
    final String KwotaDoZapłaty;
    final String KwotaZapłacona;

        AddMoneyRequestDto(String nazwa, String kwotaDoZapłaty, String kwotaZapłacona) {
            this.nazwa = nazwa;
            this.KwotaDoZapłaty = kwotaDoZapłaty;
            this.KwotaZapłacona = kwotaZapłacona;
        }
    }