package com.ocp.chapter7;

import java.util.Arrays;
import java.util.List;

public class Concurrency07IndependentOps {
    public static void main(String[] args) {
        printStringsInParallel(); // notice the order of printing is not guaranteed

    }

    private static void printStringsInParallel() {
        final List<String> strings = Arrays.asList("jackal", "kangaroo", "platypus", "wombat");
        strings.parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
    }
}
