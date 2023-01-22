package ithillel.lesson2.part3.shapes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle implements Shape {
    private Double radius;

    @Override
    public Double countShapeArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
