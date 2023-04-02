package lesson17;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroValueTest {

    @Test
    public void testHeroValue() {
        HeroValue hero = new HeroValue("Spider-Man", "Male", "Hazel", "Human",
                "Brown", 5.10, "Marvel Comics", "Fair", "Good", 165);

        assertEquals("Spider-Man", hero.getName());
        assertEquals("Male", hero.getGender());
        assertEquals("Hazel", hero.getEyeColor());
        assertEquals("Human", hero.getRace());
        assertEquals("Brown", hero.getHairColor());
        assertEquals(5.10, hero.getHeight(),0.01);
        assertEquals("Marvel Comics", hero.getPublisher());
        assertEquals("Fair", hero.getSkinColor());
        assertEquals("Good", hero.getAlignment());
        assertEquals(165, hero.getWeight());
    }
}
