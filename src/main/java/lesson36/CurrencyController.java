package lesson36;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyApiCurrencyConverter currencyConverter;

    @GetMapping()
    public Double convert(@RequestParam("fromCurrency") String fromCurrencyCode,
                          @RequestParam("toCurrency") String toCurrencyCode,
                          @RequestParam("amount") double amount) {
        Currency fromCurrency = Currency.getInstance(fromCurrencyCode);
        Currency toCurrency = Currency.getInstance(toCurrencyCode);
        return currencyConverter.convert(fromCurrency, toCurrency, amount);
    }
}
