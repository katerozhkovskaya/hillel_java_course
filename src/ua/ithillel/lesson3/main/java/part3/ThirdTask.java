package part3;

import java.util.Scanner;

public class ThirdTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any string");
        String line = scanner.nextLine();
        String reverseLine = stringReverse(line);
        System.out.println(String.format("Reverse string of %s is %s", line, reverseLine));
    }

    public static String stringReverse(String line) {
        return new StringBuilder(line).reverse().toString();
    }
}
