package lesson36.config;

import lesson36.CurrencyApiCurrencyConverter;
import lesson36.CurrencyConverter;
import lesson36.DummyCurrencyConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyApiConfig {

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currecyapi")
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
