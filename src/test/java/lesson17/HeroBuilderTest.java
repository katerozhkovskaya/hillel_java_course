package lesson17;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HeroBuilderTest {

    @Test
    public void testHeroBuilder() {
        HeroBuilder heroBuilder = HeroBuilder.builder()
                .name("Superman")
                .gender("Male")
                .eyeColor("Blue")
                .race("Kryptonian")
                .hairColor("Black")
                .height(6.2)
                .publisher("DC Comics")
                .skinColor("White")
                .alignment("Good")
                .weight(225)
                .build();

        assertNotNull(heroBuilder);
        assertEquals("Superman", heroBuilder.getName());
        assertEquals("Male", heroBuilder.getGender());
        assertEquals("Blue", heroBuilder.getEyeColor());
        assertEquals("Kryptonian", heroBuilder.getRace());
        assertEquals("Black", heroBuilder.getHairColor());
        assertEquals(6.2, heroBuilder.getHeight(), 0.01);
        assertEquals("DC Comics", heroBuilder.getPublisher());
        assertEquals("White", heroBuilder.getSkinColor());
        assertEquals("Good", heroBuilder.getAlignment());
        assertEquals(225, heroBuilder.getWeight());
    }
}