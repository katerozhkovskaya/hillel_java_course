package main.java.lesson2.part2;

import main.java.lesson2.part2.animals.Cat;
import main.java.lesson2.part2.animals.Dog;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("Bobik");
        dog.run(12);
        dog.swim(13);

        Cat cat = new Cat("Murzik");
        cat.run(34);
        cat.swim(23);
    }
}
