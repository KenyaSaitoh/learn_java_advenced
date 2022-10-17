package pro.kensait.java.advanced.lesson6_2_3.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "USA", "France");
        strList.stream()
                .flatMap(str -> Stream.of(str.toLowerCase(), str.toUpperCase()))
                .forEach(System.out::println);
    }
}
