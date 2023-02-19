package lesson4.part1;


import static lesson4.part1.MainClass.MAX_ARRAY_LENGTH;

public class ArrayValueCalculator {

    public static int doCalc(String[][] inputArr) {
        int sum = 0;
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
                        try {
                            int number = Integer.parseInt(inputArr[i][j]);
                            sum = sum + number;
                        } catch (NumberFormatException e) {
                            throw new ArrayDataExeption("ArrayDataExeption in cell " + i + j);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArraySizeColumnException("Array size is too small - need more columns");
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArraySizeRowException("Array size is too small - need more rows");
            }
        }
        return sum;
    }
}
