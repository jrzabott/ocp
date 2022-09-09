package com.ocp.chapter7;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Concurrency08ReduceExamples {

    public static final int LOOP_COUNT = 1000000;

    public static void main(String[] args) {
        // Reduce examples
        System.out.println("Reduce examples");
        final int[] integers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(integers).reduce(0, Integer::sum));
        System.out.println(Arrays.asList('w', 'o', 'r', 'l', 'd').stream()
                .reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));

        final Set<Integer> objects = Collections.synchronizedSet(new HashSet<>());
        Instant start = Instant.now();
        for (int i = 0; i < LOOP_COUNT; i++) {
            objects.add(Arrays.asList(1, 2, 3, 4, 5).parallelStream().reduce(0, (a,b) -> (a-b))); // using a non associative accumulator
            if (i % (LOOP_COUNT/10) == 0) {
                Duration d = Duration.between(start, Instant.now());
                System.out.printf("%d: Set contains %d elements. It took %d ms, so far%n", i, objects.size(), d.toMillis());
            }
        }
        System.out.println(objects);
    }
}
