package lesson36;

import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
public class DummyCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(Currency from, Currency to, double amount) {
        return amount * 0.34d;
    }
}
