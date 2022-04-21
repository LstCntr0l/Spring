package App.Money;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MoneyServiceImpl implements MoneyService{
    private final MoneyRepository moneyRepository;

    public MoneyServiceImpl(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    @Override
    public List<Money> ListAllMoney() {
        return moneyRepository.findAll();
    }

    @Override
    public Money Add(Money cash) {
        return moneyRepository.save(cash);
    }

    @Override
    public void delete(UUID id) { moneyRepository.deleteById(id);

    }
}