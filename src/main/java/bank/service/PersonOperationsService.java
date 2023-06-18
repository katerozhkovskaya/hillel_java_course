package bank.service;

import bank.repository.currency.CurrencyConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;

@Service
public class PersonOperationsService {
    private final CurrencyConverter currencyConverter;

    public PersonOperationsService(@Qualifier("currencyApiCurrencyConverter") CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public CompletableFuture<Double> convert(Currency from, Currency to, double amount) {
        return CompletableFuture.supplyAsync(() -> currencyConverter.convert(from, to, amount));
    }
}
