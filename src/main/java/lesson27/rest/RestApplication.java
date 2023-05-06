package lesson27.rest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lesson21.HeroFactory;
import lesson21.HeroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public HeroService heroService() {
        return HeroFactory.createService(hikariDataSource());
    }

    private static DataSource hikariDataSource() {
        var config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("test");
        return new HikariDataSource(config);
    }
}

