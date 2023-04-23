package lesson21;

import javax.sql.DataSource;

public class HeroFactory {

    public static HeroService createService(DataSource dataSource) {
        return new HeroService(createDao(dataSource));
    }

    private static HeroDao createDao(DataSource dataSource) {
        return new HeroDaoImpl(dataSource);
    }
}
