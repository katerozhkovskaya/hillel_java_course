package bank.currency_config;

import bank.repository.currency.CurrencyApiCurrencyConverter;
import bank.repository.currency.CurrencyConverter;
import bank.repository.currency.DummyCurrencyConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyApiConfig {

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currencyapi")
    public static class CurrecyApiCurrencyConverterConfiguration {
        @Bean
        public CurrencyConverter currencyConverter(CurrencyProperties currencyProperties) {
            return new CurrencyApiCurrencyConverter(currencyProperties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "dummy")
    public static class DummyCurrencyConverterConfiguration {
        @Bean
        public CurrencyConverter currencyConverter() {
            return new DummyCurrencyConverter();
        }
    }
}
