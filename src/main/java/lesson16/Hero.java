package lesson16;

import lombok.*;

import java.io.IOException;
import java.util.List;

import static lesson16.CSVReader.loadListOfHeroes;
import static lesson16.HeroMethods.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Hero {
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weight;

    public static void main(String[] args) throws IOException {
        List<Hero> heroes = loadListOfHeroes();
        System.out.println("Heroes average height: " + getAverageHeroHeight(heroes));
        System.out.println("The tallest hero is : " + getTallestHeroName(heroes));
        System.out.println("The heaviest hero is: " + getHeaviestHeroName(heroes));
        System.out.println("Amount of heroes in each morality group : " + getMoralityCount(heroes));
        System.out.println("Amount of heroes in each gender group : " + countGenderOfHeroes(heroes));
        System.out.println("The most 5 popular publisher is : " + getFivePopularPublishers(heroes));
        System.out.println("The most 3 popular hair color is : " + getThreePopularHairColors(heroes));
        System.out.println("The most popular eye color is : " + getTheMostPopularEyeColor(heroes));
    }
}

