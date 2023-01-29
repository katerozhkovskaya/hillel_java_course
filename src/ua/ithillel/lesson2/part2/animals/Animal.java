package part2.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Animal {
    private String name;

    public void run(int distance) {
        System.out.println("Animal can run");
    }

    public void swim(int distance) {
        System.out.println("Animal can swim");
    }
}
