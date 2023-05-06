package lesson22;

import lesson21.Hero;
import lesson21.HeroDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

class HeroServiceTest {
    private HeroService target;

    @Test
    void checkHeroService() {
        var mockHeroDao = Mockito.mock(HeroDao.class);
        var mockHeroMovieService = Mockito.mock(HeroMovieService.class);
        target = new HeroService(mockHeroDao, mockHeroMovieService);

        Mockito.when(mockHeroDao.findAll()).thenReturn(List.of(
                Hero.builder().name("Kate1").build(),
                Hero.builder().name("Kate2").build()
        ));

        assertEquals(target.getHeroes().size(), 2);
    }
}

