package lesson17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HeroLombokTest {

    @Test
    public void testGetterAndSetter() {
        HeroLombok hero = new HeroLombok();
        hero.setName("Batman");
        hero.setGender("Male");
        hero.setEyeColor("Blue");
        hero.setRace("Human");
        hero.setHairColor("Black");
        hero.setHeight(6.0);
        hero.setPublisher("DC Comics");
        hero.setSkinColor("White");
        hero.setAlignment("Good");
        hero.setWeight(210);

        assertEquals("Batman", hero.getName());
        assertEquals("Male", hero.getGender());
        assertEquals("Blue", hero.getEyeColor());
        assertEquals("Human", hero.getRace());
        assertEquals("Black", hero.getHairColor());
        assertEquals(6.0, hero.getHeight());
        assertEquals("DC Comics", hero.getPublisher());
        assertEquals("White", hero.getSkinColor());
        assertEquals("Good", hero.getAlignment());
        assertEquals(210, hero.getWeight());
    }

    @Test
    public void testNoArgsConstructor() {
        HeroLombok hero = new HeroLombok();
        assertNull(hero.getName());
        assertNull(hero.getGender());
        assertNull(hero.getEyeColor());
        assertNull(hero.getRace());
        assertNull(hero.getHairColor());
        assertEquals(0.0, hero.getHeight());
        assertNull(hero.getPublisher());
        assertNull(hero.getSkinColor());
        assertNull(hero.getAlignment());
        assertEquals(0, hero.getWeight());
    }

    @Test
    public void testAllArgsConstructor() {
        HeroLombok hero = new HeroLombok("Wonder Woman", "Female", "Blue", "Amazon",
                "Black", 6.0, "DC Comics", "Tan", "Good", 150);

        assertEquals("Wonder Woman", hero.getName());
        assertEquals("Female", hero.getGender());
        assertEquals("Blue", hero.getEyeColor());
        assertEquals("Amazon", hero.getRace());
        assertEquals("Black", hero.getHairColor());
        assertEquals(6.0, hero.getHeight());
        assertEquals("DC Comics", hero.getPublisher());
        assertEquals("Tan", hero.getSkinColor());
        assertEquals("Good", hero.getAlignment());
        assertEquals(150, hero.getWeight());
    }
}
