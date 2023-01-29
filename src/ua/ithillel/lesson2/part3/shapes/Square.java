package ithillel.lesson2.part3.shapes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Square implements Shape {
    private Double side;

    @Override
    public Double countShapeArea() {
        return Math.pow(this.side, 2);
    }
}
