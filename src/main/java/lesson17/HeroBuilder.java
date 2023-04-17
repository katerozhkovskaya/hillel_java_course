package lesson17;

import lombok.*;

@Builder
@Getter
public class HeroBuilder {
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    double height;
    String publisher;
    String skinColor;
    String alignment;
    int weight;
}
