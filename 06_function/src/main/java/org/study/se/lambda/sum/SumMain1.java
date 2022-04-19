package org.study.se.lambda.sum;

import java.util.Arrays;
import java.util.List;

public class SumMain1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});

        int sum = list.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i * 10)
                .sum();
        System.out.println(sum);
    }
}
