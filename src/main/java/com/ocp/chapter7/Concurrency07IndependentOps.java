package com.ocp.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Concurrency07IndependentOps {
    public static void main(String[] args) {
        printStringsInParallel(); // notice the order of printing is not guaranteed
        printIntsOrderedAndUnordered();


    }

    private static void printIntsOrderedAndUnordered() {
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ForEach Ordered");
        integers.parallelStream()
                .map(i -> {
                    data.add(i); // AVOID STATEFUL OPERATIONS AT ALL COSTS
                    return i;
                })
                .forEachOrdered(i -> System.out.print(i + " "));

        System.out.println("\nForEach Unordered");
        integers.parallelStream()
                .map(i -> {
                    data.add(i); // AVOID STATEFUL OPERATIONS AT ALL COSTS
                    return i;
                })
                .forEach(i -> System.out.print(i + " "));
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
