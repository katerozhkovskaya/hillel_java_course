package lesson2.part3.shapes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle implements Shape {
    private Double base;
    private Double height;

    @Override
    public Double countShapeArea() {
        return 1 / 2 * this.base * this.height;
    }
}
