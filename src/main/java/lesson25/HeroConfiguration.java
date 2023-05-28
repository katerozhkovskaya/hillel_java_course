package lesson25;

import lesson21.HeroDaoImpl;
import lesson22.HeroMovieService;
import lesson22.HeroService;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

import static lesson22.HeroFabric.createService;


@Configuration
@ComponentScan("lesson25")
@PropertySource("classpath:application.properties")
public class HeroConfiguration {

    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HeroService heroService(DataSource dataSource) {
        return createService(dataSource);
    }

    @Bean
    public HeroDaoImpl heroDao(DataSource dataSource) {
        return new HeroDaoImpl(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("postgres");
        ds.setUser(userName);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public HeroMovieService heroMovieService() {
        return new HeroMovieService();
    }
}
