package lesson22;

import lesson21.Hero;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeroServiceIntegrationTest {

    private final HeroService target = HeroFabric.createDummyService(List.of(
            Hero.builder().name("Kate1").build(),
            Hero.builder().name("Kate2").build()
    ));

    @Test
    void shouldReturnListOfHeroes() {
        var heroes = target.getHeroes();

        assertEquals(heroes.size(), 2);
    }
}