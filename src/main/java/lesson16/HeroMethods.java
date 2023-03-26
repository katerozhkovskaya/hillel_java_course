package lesson16;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroMethods {

    public static double getAverageHeroHeight(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> hero.getHeight() > 0)
                .mapToDouble(Hero::getHeight)
                .average()
                .orElse(0);
    }

    public static String getTallestHeroName(List<Hero> heroes) {
        return heroes.stream()
                .max(Comparator.comparing(Hero::getHeight))
                .map(Hero::getName)
                .orElse("No Hero");
    }

    public static String getHeaviestHeroName(List<Hero> heroes) {
        return heroes.stream()
                .max(Comparator.comparing(Hero::getWeight))
                .map(Hero::getName)
                .orElse("No Hero");
    }

    public static Map<String, Long> countGenderOfHeroes(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getGender, Collectors.counting()));
    }

    public static Map<String, Long> getMoralityCount(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getAlignment, Collectors.counting()));
    }

    public static List<String> getFivePopularPublishers(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getPublisher, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<String> getThreePopularHairColors(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> !"-".equals(hero.getHairColor()))
                .collect(Collectors.groupingBy(Hero::getHairColor, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static String getTheMostPopularEyeColor(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getEyeColor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
