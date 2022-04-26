package App.Money;



import java.util.List;
import java.util.UUID;

public interface MoneyService {
    List<Money>ListAllMoney();
    Money Add(Money cash);
    void delete(UUID id);
}