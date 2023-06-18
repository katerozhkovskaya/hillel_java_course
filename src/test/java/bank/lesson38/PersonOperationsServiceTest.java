package bank.lesson38;

import bank.repository.currency.CurrencyConverter;
import bank.service.PersonOperationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonOperationsServiceTest {
    @Mock
    private CurrencyConverter currencyConverter;

    @Test
    public void testConvert() throws ExecutionException, InterruptedException {
        Currency fromCurrency = Currency.getInstance("USD");
        Currency toCurrency = Currency.getInstance("EUR");
        double amount = 100.0;
        double conversionRate = 0.85;

        when(currencyConverter.convert(fromCurrency, toCurrency, amount))
                .thenReturn(amount * conversionRate);

        PersonOperationsService personOperationsService = new PersonOperationsService(currencyConverter);
        CompletableFuture<Double> conversionResult = personOperationsService.convert(fromCurrency, toCurrency, amount);

        double result = conversionResult.get();

        assertEquals(amount * conversionRate, result);
    }
}
