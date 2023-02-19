package ua.ithillel.lesson2.part3.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Circle implements Shape {
    private Double radius;

    @Override
    public Double countShapeArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
