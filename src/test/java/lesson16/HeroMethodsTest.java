package lesson16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lesson16.CSVReader.loadListOfHeroes;
import static lesson16.HeroMethods.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroMethodsTest {

    List<Hero> heroes = loadListOfHeroes();

    @Test
    void testGetAverageHeroHeight() {
        double expected = 186.88;
        double actual = getAverageHeroHeight(heroes);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetTallestHeroName() {
        String expected = "Fin Fang Foom";
        String actual = getTallestHeroName(heroes);
        assertEquals(expected, actual);
    }

    @Test
    void testGetHeaviestHeroName() {
        String expected = "Sasquatch";
        String actual = getHeaviestHeroName(heroes);
        assertEquals(expected, actual);
    }

    @Test
    void testCountGenderOfHeroes() {
        Map<String, Long> expected = Map.of("Female", 200L, "Male", 505L, "-", 28L);
        Map<String, Long> actual = countGenderOfHeroes(heroes);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMoralityCount() {
        Map<String, Long> expected = Map.of("bad", 206L, "neutral", 24L, "good", 496L, "-", 7L);
        Map<String, Long> actual = getMoralityCount(heroes);
        assertEquals(expected, actual);
    }

    @Test
    void testGetFivePopularPublishers() {
        List<String> expected = Arrays.asList("Marvel Comics", "DC Comics", "NBC - Heroes", "Dark Horse Comics", "George Lucas");
        List<String> actual = getFivePopularPublishers(heroes);
        assertEquals(expected, actual);
    }

    @Test
    void testGetThreePopularHairColors() {
        List<String> expected = Arrays.asList("Black", "Blond", "Brown");
        List<String> actual = getThreePopularHairColors(heroes);
        assertEquals(expected, actual);
    }

    @Test
    void testGetTheMostPopularEyeColor() {
        String expected = "blue";
        String actual = getTheMostPopularEyeColor(heroes);
        assertEquals(expected, actual);
    }
}
