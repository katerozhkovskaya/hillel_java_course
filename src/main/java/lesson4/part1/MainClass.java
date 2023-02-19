package lesson4.part1;

import java.util.Random;

import static lesson4.part1.ArrayValueCalculator.doCalc;
import static lesson4.part1.ArrayValueFiller.doFill;


public class MainClass {
    public final static int MAX_ARRAY_LENGTH = 4;

    // if you want to get ArraySizeColumnException or ArraySizeRowException you should change array's size manually
    static String[][] inputArr = new String[4][5];
    private static final int FAULT_OR_NOT = new Random().nextInt(2);

    public static void main(String[] args) {
        try {
            doFill(inputArr, FAULT_OR_NOT);
            System.out.println(String.format("Sum of array's cells is %s", doCalc(inputArr)));
        } catch (ArraySizeColumnException | ArrayDataExeption | ArraySizeRowException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
