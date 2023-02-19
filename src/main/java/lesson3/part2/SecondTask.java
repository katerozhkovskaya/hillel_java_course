package lesson3.part2;

import java.util.Scanner;

public class SecondTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter source string");
        String source = scanner.nextLine();
        System.out.println("Please enter target string");
        String target = scanner.nextLine();

        int indexOfWordPosition = findWordPosition(source, target);

        if (indexOfWordPosition == -1) {
            System.out.println(String.format("String %s doesn't contain %s ", source, target));
        } else {
            System.out.println(String.format("String %s contains %s ", source, target));
            System.out.println(String.format("Index of %s in %s is %d", target, source, indexOfWordPosition));
        }
    }

    public static int findWordPosition(String source, String target) {
        if (source.contains(target)) {
            return source.indexOf(target);
        }
        return -1;
    }
}
