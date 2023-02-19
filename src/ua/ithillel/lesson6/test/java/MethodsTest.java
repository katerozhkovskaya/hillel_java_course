import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MethodsTest {
    private static final List<String> wordsList = List.of("one", "two", "three", "four", "five", "one",
            "two", "two", "two", "four", "one");
    private List<String> resultList = List.of(Map.of("name", "one", "occurrence" , "3").toString(),
            Map.of("name", "five", "occurrence" , "1").toString(),
            Map.of("name", "three", "occurrence" , "1").toString(),
            Map.of("name", "four", "occurrence" , "2").toString(),
            Map.of("name", "two", "occurrence" , "4").toString());


    @ParameterizedTest
    @MethodSource("dataToCheckCountOccurance")
    public void checkCountOccurance(String word, int result) {
        assertThat(MethodsClass.countOccurance(wordsList, word)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("dataToCheckToList")
    public void checkToList(Object[] array, List list) {
        assertThat(MethodsClass.toList(array)).isEqualTo(list);
    }

    @ParameterizedTest
    @MethodSource("dataToCheckFindUnique")
    public void checkFindUnique(List<Integer> list, List<Integer> expectedList) {
        assertThat(MethodsClass.findUnique(list)).isEqualTo(expectedList);
    }

    @ParameterizedTest
    @MethodSource("dataToCheckCalcOccurance")
    public void checkCalcOccurance(List<String> list, Map<String, Long> expectedMap) {
        assertThat(MethodsClass.calcOccurance(list)).isEqualTo(expectedMap);
    }

    @Test
    public void checkFindOccurance() {
        Assertions.assertThat(MethodsClass.findOccurance(wordsList)).hasSameElementsAs(resultList);
    }

    private static Stream<Arguments> dataToCheckCountOccurance() {
        return Stream.of(
                Arguments.of("one", 3),
                Arguments.of("two", 4),
                Arguments.of("rerere", 0),
                Arguments.of("five", 1));
    }

    private static Stream<Arguments> dataToCheckToList() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3"}, List.of("1", "2", "3")),
                Arguments.of(new Integer[]{1, 2, 3}, List.of(1, 2, 3)),
                Arguments.of(new String[]{"one", "two", "three"}, List.of("one", "two", "three")));
    }

    private static Stream<Arguments> dataToCheckFindUnique() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 1, 2, 3, 3), List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 1, 1, 2, 2, 2, 11, 11, 33, 2, 1, 2, 3, 3), List.of(1, 2, 11, 33, 3)));
    }

    private static Stream<Arguments> dataToCheckCalcOccurance() {
        return Stream.of(
                Arguments.of(List.of("one", "two", "three", "four", "five", "one", "two", "four", "one", "one", "two"),
                        Map.of("four", 2L, "one", 4L, "five", 1L, "two", 3L, "three", 1L)),
                Arguments.of(List.of("1", "2", "3", "1", "2", "3", "4", "4", "1", "4", "1"),
                        Map.of("1", 4L, "2", 2L, "3", 2L, "4", 3L)));
    }
}
