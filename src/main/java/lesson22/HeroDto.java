package lesson22;

public record HeroDto(
        String name,
        String gender,
        String eyeColor,
        String race,
        String hairColor,
        double height,
        String publisher,
        String skinColor,
        String alignment,
        int weight) {

    static HeroDto from(Hero hero) {
        return new HeroDto(hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(), hero.getHairColor(),
                hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(), hero.getWeight());
    }
}

