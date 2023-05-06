package lesson22;

import lesson21.Hero;
import lesson21.HeroDao;
import lesson21.HeroDaoImpl;

import javax.sql.DataSource;
import java.util.List;

public class HeroFabric {

    public static HeroService createService(DataSource dataSource) {
        return new HeroService(createDao(dataSource), createMovieService());
    }

    private static HeroDao createDao(DataSource dataSource) {
        return new HeroDaoImpl(dataSource);
    }

    private static HeroMovieService createMovieService() {
        return new HeroMovieService();
    }

    public static HeroService createDummyService(List<Hero> heroes) {
        return new HeroService(new DummyHeroDao(heroes), createMovieService());
    }

}
