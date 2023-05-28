package lesson21;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        var dataSource = dataSource();
        var service = HeroFactory.createService(dataSource);

        service.delete(5);

        service.findAll().stream().limit(10).forEach(System.out::println);

        service.create(Hero.builder()
                .name("Kate Rozhkovska")
                .gender("Male")
                .eyeColor("blue")
                .race("Human")
                .hairColor("Black")
                .height(45)
                .publisher("DC Comics")
                .skinColor("white")
                .alignment("good")
                .weight(50)
                .build());

        System.out.println(service.findByName("Kate Rozhkovska"));
        service.update(Hero.builder().weight(55).name("Kate Rozhkovska").build(), 3);
    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("test");
        return ds;
    }
}

