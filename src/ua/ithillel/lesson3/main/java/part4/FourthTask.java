package ua.ithillel.lesson3.main.java.part4;

import java.util.Scanner;

public class FourthTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any string");
        String line = scanner.nextLine();
        Boolean isPalindrome = isPalindrome(line);
        System.out.println(String.format("String %s is palindrome - %b", line, isPalindrome));
    }

    public static Boolean isPalindrome(String line) {
        return line.equalsIgnoreCase(new StringBuilder(line).reverse().toString());
    }
}
