package com.ocp.chapter3;

import java.util.Arrays;
import java.util.List;

public class LoopingThroughACollection {
    public static void main(String[] args) {
        String[] words = {"Hello", "World"};
        for (String word : words) {
            System.out.println(word);
        }
        List<String> list = Arrays.asList(words);
        list.forEach( e -> System.out.println(e));
        list.forEach(System.out::println);

    }
}
