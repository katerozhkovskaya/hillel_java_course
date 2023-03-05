package lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lesson3.part1.FirstTask.findSymbolOccurance;
import static lesson3.part2.SecondTask.findWordPosition;
import static lesson3.part3.ThirdTask.stringReverse;
import static lesson3.part4.FourthTask.isPalindrome;
import static lesson3.part5.FifthTask.compareWord;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MyLessonThreeTest {
    @ParameterizedTest
    @MethodSource("dataForFindSymbol")
    public void checkFindSymbolOccurance(String line, char symbol, int expectedCount) {
        assertEquals(expectedCount, findSymbolOccurance(line,symbol));
    }

    @ParameterizedTest
    @MethodSource("dataForReverseString")
    public void checkFindSymbolOccurance(String line, String reverseLine) {
        assertEquals(reverseLine, stringReverse(line));
    }

    @ParameterizedTest
    @MethodSource("dataForfindWordPosition")
    public void checkfindWordPosition(String source, String target, int index) {
        assertEquals(index, findWordPosition(source, target));
    }

    @ParameterizedTest
    @MethodSource("dataForIsPalindrome")
    public void checkIsPalindrome(String string, Boolean expected) {
        assertEquals(expected, isPalindrome(string));
    }

    @ParameterizedTest
    @MethodSource("dataForCompareWord")
    public void checkCompareWord(String enteredWord, String guessedWord, String expected) {
        assertEquals(expected, compareWord(enteredWord,guessedWord));
    }

    private static Stream<Arguments> dataForFindSymbol() {
        return Stream.of(
                Arguments.of("ueujdskdjhrenjd", 'j', 3),
                Arguments.of("fijhfwjjwesoiskdjeieiidjkdjeuic",'i', 6),
                Arguments.of("trurkaaesaskajspwjskasakewukaakk",'a', 8),
                Arguments.of("kkktrykkeoekkk678kk", 'k', 10)
        );
    }

    private static Stream<Arguments> dataForReverseString() {
        return Stream.of(
                Arguments.of("ueujdskdjhrenjd", "djnerhjdksdjueu"),
                Arguments.of("fijhfwjjwesoiskdjeieiidjkdjeuic", "ciuejdkjdiieiejdksiosewjjwfhjif"),
                Arguments.of("kkktrykkeoekkk678kk", "kk876kkkeoekkyrtkkk")
        );
    }

    private static Stream<Arguments> dataForfindWordPosition() {
        return Stream.of(
                Arguments.of("kateryna", "ry",4),
                Arguments.of("kateryna", "tery", 2),
                Arguments.of("kateryna", "ro",-1)
        );
    }
    private static Stream<Arguments> dataForIsPalindrome() {
        return Stream.of(
                Arguments.of("ELLE", true),
                Arguments.of("Allo", false),
                Arguments.of("Otto", true),
                Arguments.of("Karate", false)
                );
    }

    private static Stream<Arguments> dataForCompareWord() {
        return Stream.of(
                Arguments.of("apple", "apple", "You guessed it! Congratulations!"),
                Arguments.of("pepper", "peanut", "pe#############")
        );
    }
}
