package lesson22;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
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

