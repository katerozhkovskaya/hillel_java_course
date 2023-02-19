package ua.ithillel.lesson4.main.java.part1;


import org.apache.commons.lang3.RandomStringUtils;

import static ua.ithillel.lesson4.main.java.part1.MainClass.MAX_ARRAY_LENGTH;

public class ArrayValueFiller {
    public final static int AMOUNT_OF_RANDOM_SYMBOL = 1;

    public static void doFill(String[][] inputArr, int faultOrNot) {
        if (inputArr.length > MAX_ARRAY_LENGTH) {
            throw new ArraySizeRowException("Array size is big - many rows");
        }
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            try {
                if (inputArr[i].length > MAX_ARRAY_LENGTH) {
                    throw new ArraySizeColumnException("Array size is big - many columns");
                }
                for (int j = 0; j < MAX_ARRAY_LENGTH; j++) {
                    try {
                        switch (faultOrNot) {
                            case 1 -> inputArr[i][j] = RandomStringUtils.randomNumeric(AMOUNT_OF_RANDOM_SYMBOL);
                            case 0 -> {
                                if (j < i)
                                    inputArr[i][j] = RandomStringUtils.randomAlphanumeric(AMOUNT_OF_RANDOM_SYMBOL);
                                else
                                    inputArr[i][j] = RandomStringUtils.randomNumeric(AMOUNT_OF_RANDOM_SYMBOL);
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        throw new ArraySizeColumnException("Array size is too small  - need more columns");
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new ArraySizeRowException("Array size is too small  - need more rows");
            }
        }
    }
}
