package ua.ithillel.lesson3.main.java.part5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FifthTask {
    public static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        String guessedWord = getWordToGuess();
        System.out.println(guessedWord);


        System.out.println(Arrays.toString(WORDS));
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("You should guess word from the list below. Please enter your word");
            String enteredWord = scanner.nextLine();
            String resultOfComparison = compareWord(enteredWord, guessedWord);
            System.out.println(resultOfComparison);
            if (resultOfComparison.equalsIgnoreCase("You guessed it! Congratulations!"))
                break;
        } while (true);
    }

    public static String getWordToGuess() {
        Random randomWord = new Random();
        return WORDS[randomWord.nextInt(WORDS.length)];
    }

    public static String compareWord(String enteredWord, String guessedWord) {
        String output = "";
        if (enteredWord.equalsIgnoreCase(guessedWord)) {
            output = "You guessed it! Congratulations!";
        } else {
            int minWordLenth = Math.min(guessedWord.length(), enteredWord.length());
            for (int j = 0; j < 15; j++) {
                if (j < minWordLenth && enteredWord.charAt(j) == guessedWord.charAt(j)) {
                    output = output.concat(String.valueOf(guessedWord.charAt(j)));

                } else {
                    output = output.concat("#");
                }
            }
        }
        return  output;
    }
}
