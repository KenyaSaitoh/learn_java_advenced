package pro.kensait.java.advanced.lesson6_2_1.basic;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 4, 1, 10, 4, 2, 5, 6, 9, 4);
        long count = list.stream()
                .filter(x -> x % 2 == 0)
                .distinct()
                .count();
        System.out.println(count);
    }
}