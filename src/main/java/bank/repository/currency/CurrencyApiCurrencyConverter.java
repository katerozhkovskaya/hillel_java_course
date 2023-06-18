package bank.repository.currency;

import bank.currency_config.CurrencyProperties;
import bank.model.CurrencyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;
import java.util.Objects;

@Service
public class CurrencyApiCurrencyConverter implements CurrencyConverter {

    private final CurrencyProperties props;
    private WebClient webClient;

    public CurrencyApiCurrencyConverter(CurrencyProperties props) {
        this.props = props;
        this.webClient = WebClient.builder()
                .build();
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {
        var result = webClient.get()
                .uri(props.getUrl(), uri ->
                        uri.queryParam("apikey",
                                        props.getApikey())
                                .queryParam("base_currency", from.getCurrencyCode())
                                .queryParam("currencies", to.getCurrencyCode())
                                .build())
                .retrieve()
                .bodyToMono(CurrencyResponse.class)
                .block();

        return Objects.requireNonNull(result)
                .getData()
                .get(to.getCurrencyCode())
                .getValue() * amount;
    }
}
