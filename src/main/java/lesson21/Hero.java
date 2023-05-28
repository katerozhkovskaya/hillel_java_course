package lesson21;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
    int id;
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    int height;
    String publisher;
    String skinColor;
    String alignment;
    int weight;
}

