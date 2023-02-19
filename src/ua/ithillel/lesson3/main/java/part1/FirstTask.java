package ua.ithillel.lesson3.main.java.part1;

import java.util.Scanner;

public class FirstTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any string");
        String line = scanner.nextLine();
        System.out.println("Please enter any char");
        char symbol = scanner.next().charAt(0);
        int symbolAmount = findSymbolOccurance(line, symbol);
        System.out.println(String.format("String %s contains %d char %s", line, symbolAmount, symbol));
    }

    public static int findSymbolOccurance(String line, char symbol) {
        return (int) line.chars().filter(ch -> ch == symbol).count();
    }
}
