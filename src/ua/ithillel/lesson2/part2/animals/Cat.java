package part2.animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= 200)
            System.out.println("Cat " + this.getName() + " ran " + distance + " m");
        else
            System.out.println("Cat can't run distance more than 200 m");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can't swim");
    }
}
