package pro.kensait.java.lesson6_1_1.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Japan", "France", "USA");
        Collections.sort(strList, new MyComparator());
        System.out.println(strList);
    }
}