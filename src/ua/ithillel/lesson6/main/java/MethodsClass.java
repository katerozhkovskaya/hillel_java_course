import java.util.*;
import java.util.stream.Collectors;

public class MethodsClass {
    public static int countOccurance(List<String> wordsList, String word) {
        return (int) wordsList.stream().filter(el -> el.equals(word)).count();
    }

    public static List toList(Object[] array) {
        return Arrays.asList(array);
    }

    public static List<Integer> findUnique(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static Map<String, Long> calcOccurance(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public static List<String> findOccurance(List<String> list) {
        List<String> resultList = new ArrayList<>();
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            resultList.add(Map.of("name",
                    entry.getKey(),
                    "occurrence" ,
                    entry.getValue()).toString());
        }
        return resultList;
    }
}
