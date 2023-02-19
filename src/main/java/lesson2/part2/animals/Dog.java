package main.java.lesson2.part2.animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= 500)
            System.out.println("Dog " + this.getName() + " ran " + distance + " m");
        else
            System.out.println("Dog can't run distance more than 500 m");
    }

    @Override
    public void swim(int distance) {
        if (distance < 10)
            System.out.println("Dog " + this.getName() + " swam " + distance + " m");
        else
            System.out.println("Dog can't swim distance more than 10 m");
    }
}
