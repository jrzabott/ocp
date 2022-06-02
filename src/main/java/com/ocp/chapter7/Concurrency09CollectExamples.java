package com.ocp.chapter7;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concurrency09CollectExamples {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set); // NOTICE OUTPUT ORDER. Since we are using a ConcurrentSkipListSet we have an ordered set.

        Stream<String> anotherStream = Stream.of("w", "o", "l", "f").parallel();
        Set<String> anotherSet = anotherStream.collect(Collectors.toSet());
        System.out.println(anotherSet); // Unordered set.
    }
}
