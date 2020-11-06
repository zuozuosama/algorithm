package algorithm.lamaba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流式编程
 */
public class Lam1 {
    public static void main(String[] args) {
        //filter
        List<String> strData = Arrays.asList("22", "23", "34", "26");
        strData.stream()
                .filter(it -> it.startsWith("2"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //map
        List<String> strData1 = Arrays.asList("a", "b", "a");
        strData1.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        //distinct
        long count = strData1.stream()
                .distinct()
                .count();
        strData1.stream().distinct().forEach(System.out::println);
        strData1.stream().distinct().limit(1).collect(Collectors.toSet()).forEach(System.out::println);
        String collect = strData1.stream().distinct().collect(Collectors.joining(","));
        System.out.println(collect);


        //concat
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Integer[] ints = {4, 5};
        Stream<Integer> ints1 = Stream.of(ints);
        Stream.concat(integerStream, ints1).forEach(System.out::println);
    }
}
