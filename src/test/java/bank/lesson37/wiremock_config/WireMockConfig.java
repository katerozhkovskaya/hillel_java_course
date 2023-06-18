package bank.lesson37.wiremock_config;

import com.github.tomakehurst.wiremock.WireMockServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockConfig {

    private final static WireMockServer wireMockServer = new WireMockServer(8089);

    @Bean
    public WireMockServer wireMockServer() {
        return wireMockServer;
    }

    @PostConstruct
    public void startWireMockServer() {
        wireMockServer.start();
    }

    @PreDestroy
    public void stopWireMockServer() {
        wireMockServer.stop();
    }
}
