package part3;


import part3.shapes.Circle;
import part3.shapes.Shape;
import part3.shapes.Square;
import part3.shapes.Triangle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5d);
        Square square = new Square(6d);
        Triangle triangle = new Triangle(3d, 12d);

        List<Shape> shapes = List.of(circle, square, triangle);

        Double areaOfShapes = shapes.stream().mapToDouble(shape -> shape.countShapeArea()).sum();

        System.out.println("Area of all shapes is " + areaOfShapes);
    }
}
