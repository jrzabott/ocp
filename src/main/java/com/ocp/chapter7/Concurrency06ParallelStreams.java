package com.ocp.chapter7;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Concurrency06ParallelStreams {

    protected static final List<Integer> LIST = IntStream.range(0, 1000000).boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        performParallelCalculation(LIST);
        performSequentialCalculation(LIST);
    }

    private static void performSequentialCalculation(List<Integer> aList) {
        Duration timeElapsed;
        Instant start;
        System.out.println("\n==============================");
        start = Instant.now();
        final long[] sumSequential = new long[1];
        System.out.println("Sequential Stream");
        sumSequential[0] = aList.stream().reduce(0, (a, b) -> {a += b; return a;} );
        timeElapsed = Duration.between(start, Instant.now());
        System.out.println("\nTime elapsed: " + timeElapsed.toMillis() + " ms" + "\nSum: " + sumSequential[0]);
    }

    private static void performParallelCalculation(List<Integer> aList) {
        Instant start = Instant.now();
        final long[] sumParallel = new long[1];
        System.out.println("Parallel Stream");
        sumParallel[0] = aList.parallelStream().reduce(0, (a, b) -> {a += b; return a;} );
        Duration timeElapsed = Duration.between(start, Instant.now());
        System.out.println("\nTime elapsed: " + timeElapsed.toMillis() + " ms" + "\nSum: " + sumParallel[0]);
    }


}
